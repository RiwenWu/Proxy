package com.wrw.proxy.demo01;

/*
 * Q：怎么知道方法运行了多长时间
 * A2：继承
 */
public class Tank2 extends Tank{
	
	public void move(){
		Long start = System.currentTimeMillis();
		super.move();
		Long end = System.currentTimeMillis();
		System.out.println("time: " + (end - start));
	}
}
