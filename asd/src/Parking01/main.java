package Parking01;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Scanner;

import raechan.settlement_1;

public class main {
	static String[] park = {"[ ]","[ ]","[ ]","[ ]",
							"[ ]","[ ]","[ ]","[ ]",
							"[ ]","[ ]","[ ]","[ ]"}; // ������
	static ArrayList<tower> tow = new ArrayList<tower>(); // ������ ��ü ����
	static ArrayList<Integer> allDayPay = new ArrayList<Integer>(); // ���� ����Ʈ;
	public static void main(String[] args) {
		
		while(true) {
			Scanner sc = new Scanner(System.in);
			try {
				System.out.println("-------------------- ���� ���α׷� [��Ȳ]---------------");
				int i = 0;
				for(String tmep : park) {//���
					System.out.print(tmep);
					if(i % 4 == 3) {// �ٹٲ�
						System.out.println();
					}
					i++;
				}	
				
				System.out.println("----------------------------------------------------");
				System.out.println("1.������� 2.���� 3.����Ȯ��"); int ch = sc.nextInt();// ���� �Է¹ޱ�
				
				if(ch == 1) {// �������
					System.out.println("***�������***");
					System.out.println("������ȣ: "); String ������ȣ = sc.next();
					System.out.println("������ġ: "); int ������ġ = sc.nextInt();
					ZonedDateTime now = ZonedDateTime.now();
					machine.�������(������ȣ, ������ġ, now);										
				}else if(ch == 2) {	// ��������
					System.out.println("������ȣ: "); String ������ȣ = sc.next();
					boolean pass = false;
					for(tower temp : tow) {
						if(temp.get����ȣ().equals(������ȣ)) {
							pass = true;
							break;
						}
					}
					if(pass) {
						ZonedDateTime endnow = ZonedDateTime.now();
						//��ݰ��
						int ��� = machine.��ݰ��(������ȣ, endnow);
						if(��� < 0) {
							System.out.println("������");
						}else {
							System.out.println("�������: " + ���);
						}
						System.out.println("�Ա�: "); int �� = sc.nextInt();
						//�������
						if(��� <= ��) {
							machine.��������(������ȣ);
							allDayPay.add(���);
							System.out.println("�Ž�����: " + (�� - ���));
							System.out.println("�����մϴ� ��ſ� �Ϸ�Ǽ���");
						}else {
							System.out.println("�� ����");
						}					
					}		
				}else if(ch == 3) { // ����Ȯ��
					settlement_1.dayPay();
									
				}else { // �׿�
					System.out.println("����)) �˼����� �ൿ");
				}
			}catch(Exception e) {
				System.out.println("����)) ������ ȣ�� ���" + e);
			}//���ܹ� ����
		}// while�� ����
		
		}
	
}
