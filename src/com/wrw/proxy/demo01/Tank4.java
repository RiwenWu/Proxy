package com.wrw.proxy.demo01;

/*
 * Q����ô֪�����������˶೤ʱ��
 * A3���ۺϣ����ֺ� ��� �� �ۺϣ�
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
	
	//���������ɶ������
//	Tank t;
	moveable t;
	
	public void move(){
		System.out.println("��ʼ��");
		t.move();
		System.out.println("������");
	}
}
