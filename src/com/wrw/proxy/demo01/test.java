package com.wrw.proxy.demo01;

import static org.junit.Assert.*;

import org.junit.Test;

public class test {

	@Test
	public void test() {
//		moveable m  = new Tank();
//		moveable m  = new Tank2();
		Tank t = new Tank();
		moveable m  = new Tank3(t);
		m.move();
	}
	
	@Test
	public void testProxyTank() {
		Tank t = new Tank();
		Tank3 t3 = new Tank3(t);
		Tank4 t4 = new Tank4(t3);
		moveable m  = t4;
		m.move();
	}
	
	@Test
	public void testTank() {
		Tank t = new Tank();
		t.move();
	}
	
	@Test
	public void testTank2() {
		Tank2 t2 = new Tank2();
		t2.move();
	}

	@Test
	public void testTank3() {
		Tank t = new Tank();
		Tank3 t3 = new Tank3(t);
		t3.move();
	}
	
}
