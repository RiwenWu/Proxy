package com.wrw.proxy.demo04;

import java.lang.reflect.Method;

public class TimeHandler implements InvocationHandler{

	public void invoke(Object o, Method m) {
		Long start = System.currentTimeMillis();
		try {
			m.invoke(o, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Long end = System.currentTimeMillis();
		System.out.println("time: " + (end - start));
	}

}
