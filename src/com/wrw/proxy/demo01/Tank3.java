package com.wrw.proxy.demo01;

/*
 * Q：怎么知道方法运行了多长时间
 * A3：聚合（区分好 组合 和 聚合）
 * !!!!!!聚合比继承更灵活!!!!!!
 */
public class Tank3 implements moveable{	
	/*
	public Tank3(Tank t) {
		super();
		this.t = t;
	}
	*/
	
	public Tank3(moveable t) {
		super();
		this.t = t;
	}
	
	//换成下面变成多个代理
//	Tank t;
	moveable t;
	
	public void move(){
		Long start = System.currentTimeMillis();
		t.move();
		Long end = System.currentTimeMillis();
		System.out.println("time: " + (end - start));
	}
}
