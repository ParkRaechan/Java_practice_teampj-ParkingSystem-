package Parking01;

import java.time.ZonedDateTime;

public class tower {
	//1. �ʵ�
	private String ����ȣ;
	private int ������ġ;
	private  ZonedDateTime ��¥;
	
	//2.������
	public tower() {
	}
	public tower(String ����ȣ, int ������ġ2, ZonedDateTime ��¥) {
		super();
		this.����ȣ = ����ȣ;
		this.������ġ = ������ġ2;
		this.��¥ = ��¥;
	}
	
	//�޼ҵ�
	public String get����ȣ() {
		return ����ȣ;
	}
	public void set����ȣ(String ����ȣ) {
		this.����ȣ = ����ȣ;
	}
	public int get������ġ() {
		return ������ġ;
	}
	public void set������ġ(int ������ġ) {
		this.������ġ = ������ġ;
	}
	public ZonedDateTime get��¥() {
		return ��¥;
	}
	public void set��¥(ZonedDateTime ��¥) {
		this.��¥ = ��¥;
	}	
	
}


