package com.wrw.proxy.demo03;

import java.util.Date;
import java.util.Random;

/*
 * Q：怎么知道方法运行了多长时间
 * A1：用System.currentTimeMillis()
 */
public class Tank implements moveable{
	

	@Override
	public void move() {
//		Long start = System.currentTimeMillis();
		
		System.out.println("moving");
		try {
			//随机产生10 S 以内的时间
			Thread.sleep(new Random().nextInt(10000));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
//		Long end = System.currentTimeMillis();
//		System.out.println("time: " + (end - start));
	}
}
