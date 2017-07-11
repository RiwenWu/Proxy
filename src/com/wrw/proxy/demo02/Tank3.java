package com.wrw.proxy.demo02;

public class Tank3 implements moveable{	
	
	public Tank3(moveable t) {
		super();
		this.t = t;
	}
	
	moveable t;
	
	public void move(){
		Long start = System.currentTimeMillis();
		t.move();
		Long end = System.currentTimeMillis();
		System.out.println("time: " + (end - start));
	}
}
