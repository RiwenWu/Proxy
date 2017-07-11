package com.wrw.proxy.demo03;

/*
 * Q：怎么知道方法运行了多长时间
 * A3：聚合（区分好 组合 和 聚合）
 */
public class Tank4 implements moveable{	
	/*
	public Tank4(Tank t) {
		super();
		this.t = t;
	}
	*/
	
	public Tank4(moveable t) {
		super();
		this.t = t;
	}
	
	//换成下面变成多个代理
//	Tank t;
	moveable t;
	
	public void move(){
		System.out.println("开始了");
		t.move();
		System.out.println("结束了");
	}
}
