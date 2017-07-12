package com.wrw.proxy.demo05;

import static org.junit.Assert.*;

import java.lang.reflect.Method;

import org.junit.Test;

import com.wrw.proxy.demo05.Proxy;
import com.wrw.proxy.demo05.moveable;

public class test {

	@Test
	public void test() throws Exception {
		Tank t = new Tank();
		TimeHandler h = new TimeHandler(t);
		moveable m = (moveable)Proxy.newProxyInstance(moveable.class, h);
		m.move();
	}
}
