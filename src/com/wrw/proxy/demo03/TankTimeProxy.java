package com.wrw.proxy.demo03;
public class TankTimeProxy implements Serializable{
	public TankTimeProxy(moveable t) {
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