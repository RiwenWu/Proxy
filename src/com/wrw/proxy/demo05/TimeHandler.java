package com.wrw.proxy.demo05;

import java.lang.reflect.Method;

public class TimeHandler implements InvocationHandler{
	
	private Object target;
	
	public TimeHandler(Object target) {
		super();
		this.target = target;
	}

	public void invoke(Object o, Method m) {
		System.out.println("开始计时");
		Long start = System.currentTimeMillis();
		try {
			m.invoke(target);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Long end = System.currentTimeMillis();
		System.out.println("计时结束");
		System.out.println("time: " + (end - start));
	}

}
