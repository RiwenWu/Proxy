package com.wrw.proxy.demo04;

import static org.junit.Assert.*;

import java.lang.reflect.Method;

import org.junit.Test;

import com.wrw.proxy.demo04.Proxy;
import com.wrw.proxy.demo04.moveable;

public class test {

	@Test
	public void test() throws Exception{
		
		Method[] methods = com.wrw.proxy.demo04.moveable.class.getMethods();
		for (Method m : methods) {
			System.out.println(m.getName());
		}
	}
	
	@Test
	public void test1() throws Exception{
		
		moveable m = (moveable)Proxy.newProxyInstance(moveable.class, null);
		
		m.move();
	}
	
}
