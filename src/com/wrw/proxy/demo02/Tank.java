package com.wrw.proxy.demo02;

import java.util.Date;
import java.util.Random;

/*
 * Q����ô֪�����������˶೤ʱ��
 * A1����System.currentTimeMillis()
 */
public class Tank implements moveable{
	

	@Override
	public void move() {
//		Long start = System.currentTimeMillis();
		
		System.out.println("moving");
		try {
			//�������10 S ���ڵ�ʱ��
			Thread.sleep(new Random().nextInt(10000));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
//		Long end = System.currentTimeMillis();
//		System.out.println("time: " + (end - start));
	}
}
