package com.wrw.proxy.demo01;

/*
 * Q����ô֪�����������˶೤ʱ��
 * A2���̳�
 */
public class Tank2 extends Tank{
	
	public void move(){
		Long start = System.currentTimeMillis();
		super.move();
		Long end = System.currentTimeMillis();
		System.out.println("time: " + (end - start));
	}
}
