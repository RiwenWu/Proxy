package com.wrw.proxy.demo01;

/*
 * Q����ô֪�����������˶೤ʱ��
 * A3���ۺϣ����ֺ� ��� �� �ۺϣ�
 * !!!!!!�ۺϱȼ̳и����!!!!!!
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
	
	//���������ɶ������
//	Tank t;
	moveable t;
	
	public void move(){
		Long start = System.currentTimeMillis();
		t.move();
		Long end = System.currentTimeMillis();
		System.out.println("time: " + (end - start));
	}
}
