package com.wrw.proxy.demo03;

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
 * 
 */
public class Proxy {
	public static Object newProxyInstance(Class interFace) throws Exception{
		System.out.println(interFace.getName());
		System.out.println(interFace.getSimpleName());
		//����
				String rt = "\r\n";
				String src = 
						"package com.wrw.proxy.demo03;" + rt +

						"public class TankTimeProxy implements " + interFace.getSimpleName() + "{" + rt +
							
						"	public TankTimeProxy(moveable t) {" + rt +
						"		super();" + rt +
						"		this.t = t;" + rt +
						"	}" + rt +
							
						"	moveable t;" + rt +
							
						"	public void move(){" + rt +
						"		Long start = System.currentTimeMillis();" + rt +
						"		t.move();" + rt +
						"		Long end = System.currentTimeMillis();" + rt +
						"		System.out.println(\"time: \" + (end - start));" + rt +
						"	}" + rt +
						"}";
				
				//�ļ���ַ
				String fileName = System.getProperty("user.dir") 
						+ "/src/com/wrw/proxy/demo03/TankTimeProxy.java";
				//д����ʱ�ļ�
				File f = new File(fileName);
				FileWriter fw = new FileWriter(f);
				fw.write(src);
				fw.flush();
				fw.close();
				
				//���б���
				JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
				System.out.println(compiler.getClass().getName());
				//�ļ�����
				StandardJavaFileManager fileMgr = compiler.getStandardFileManager(null, null, null);
				Iterable units = fileMgr.getJavaFileObjects(fileName);
				//��������
				CompilationTask t = compiler.getTask(null, fileMgr, null, null, null, units);
				t.call();
				fileMgr.close();
				
				//װ�ص��ڴ�
				URL[] urls = new URL[] {
						new URL("file:/" + System.getProperty("user.dir") + "/src")
				};
				URLClassLoader ul = new URLClassLoader(urls);
				Class c = ul.loadClass("com.wrw.proxy.demo03.TankTimeProxy");
				System.out.println(c);
				
				//��ȡ���췽��
				Constructor ctr = c.getConstructor(moveable.class);
				moveable m = (moveable)ctr.newInstance(new Tank());
				m.move();
				
		return null ;
		
	}
}
