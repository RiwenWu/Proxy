package com.wrw.proxy.demo05;

import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import javax.tools.JavaCompiler.CompilationTask;
/*
 * 实现动态生成接口
 * 传入接口
 * @interFace
 */
public class Proxy {
	public static Object newProxyInstance(Class interFace, InvocationHandler handler) throws Exception{

		//换行
		String rt = "\r\n";
		//方法体
		String methodStr = "";
		
		//加载所有方法
		Method[] methods = interFace.getMethods();
		for(Method m : methods) {
			methodStr += "@Override" + rt + 
						 "public void " + m.getName() + "() {" + rt +
						 "    try {" + rt +
						 "    Method md = " + interFace.getName() + ".class.getMethod(\"" + m.getName() + "\");" + rt +
						 "    h.invoke(this, md);" + rt +
						 "    }catch(Exception e) {e.printStackTrace();}" + rt +
						
						 "}";
		}
		
		String src = 
		"package com.wrw.proxy.demo05;" + rt +

		"import java.lang.reflect.Method;" + rt +
							
		"public class MyCreate implements " + interFace.getName() + "{" + rt +
		"    com.wrw.proxy.demo05.InvocationHandler h;" + rt +
		"    public MyCreate(InvocationHandler h) {" + rt +
		"        this.h = h;" + rt +
		"    }" + rt +
			
		methodStr					
		 + rt +
		"}";
				
		//文件地址
		String fileName = System.getProperty("user.dir") 
				+ "/src/com/wrw/proxy/demo05/MyCreate.java";
		//写入临时文件
		File f = new File(fileName);
		FileWriter fw = new FileWriter(f);
		fw.write(src);
		fw.flush();
		fw.close();
				
				//进行编译
				JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
				//System.out.println(compiler.getClass().getName());
				//文件管理
				StandardJavaFileManager fileMgr = compiler.getStandardFileManager(null, null, null);
				Iterable units = fileMgr.getJavaFileObjects(fileName);
				//编译任务
				CompilationTask t = compiler.getTask(null, fileMgr, null, null, null, units);
				t.call();
				fileMgr.close();
				
				//装载到内存
				URL[] urls = new URL[] {
						new URL("file:/" + System.getProperty("user.dir") + "/src")
				};
				URLClassLoader ul = new URLClassLoader(urls);
				Class c = ul.loadClass("com.wrw.proxy.demo05.MyCreate");
				//System.out.println(c);
				
				//获取构造方法
				Constructor ctr = c.getConstructor(InvocationHandler.class);
				Object m = ctr.newInstance(handler);
				
						
				
		return m ;
		
	}
}
