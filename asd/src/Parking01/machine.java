package Parking01;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;

import raechan.settlement_1;

public class machine {
	
	//1.�޼ҵ�
////���ؿ���Ʈ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//�������
	public static void �������(String ������ȣ, int ������ġ, ZonedDateTime now) { 
		tower e = new tower(������ȣ, ������ġ, now);
		main.tow.add(e);
		if(main.park[������ġ] == "[ ]") {
			main.park[������ġ] = "["+������ȣ+"]";
		}
		
	}//������� end
	
	//��������
	public static void ��������(String ������ȣ) {
		int i = 0;
		for(tower temp : main.tow) {
			if(temp.get����ȣ().equals(������ȣ)) {
				main.park[temp.get������ġ()] = "[ ]";
				main.tow.remove(i);			
			}
			i++;
		}
	}// �������� end
/////��α���Ʈ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//��ݰ��
	public static int ��ݰ��(String ������ȣ, ZonedDateTime endnow) throws IOException {
		for(tower temp : main.tow) {
			if(temp.get����ȣ().equals(������ȣ)) {
				int �� = (int) temp.get��¥().until(endnow, ChronoUnit.DAYS); 		// �����ð� - �����ð� (��)	
				int �� = (int) temp.get��¥().until(endnow, ChronoUnit.HOURS);		// �����ð� - �����ð� (�ð�)
				int �� = (int) temp.get��¥().until(endnow , ChronoUnit.MINUTES);	// �����ð� - �����ð� (��)
				int �ð��� = �� * 60; // �����ð� - �����ð� �ؼ� ���� �ð��� ������ ����
				int �������ð� = �ð��� + ��; // �������ð��� ������ ����
				int count = 0;
				//int[] AllDayPay = new int[100]; // �Ϸ絿�� ���� �������
				//���
				if( �� == 0 ) { // Day�� ���� 0�̸�
					�������ð� -= 30; // ù �����ð� 30���� ����
					while (true) {
						if(�������ð� > 10) {
							�������ð� -= 10;
							count++;
						}else {	
							break;
						}
					}
				}else if( �� > 0 ) { // �����ð��� �Ϸ縦 �Ѱ�����
					��������ó��(endnow,�� * 50000);
					return 1 * 50000;
				}
				��������ó��(endnow,count * 1000);
				return count * 1000;
			}// ���ٸ� ifend
		}// ã�°� for end
		return -1;
	}// �޼ҵ� end
/////�ڷ�����Ʈ	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//����Ȯ��
	static void ��������ó��(ZonedDateTime endnow,int ���) throws IOException{
		//��������
		FileOutputStream out = new FileOutputStream("C:/Users/gks01/����.txt", true);
		String storage = Integer.toString(endnow.getYear())+","+Integer.toString(endnow.getMonthValue())+","+Integer.toString(endnow.getDayOfMonth())+":"+Integer.toString(���)+"\n";
		out.write(storage.getBytes());				
	}// ����Ȯ�� end
	public static int ����Ȯ��(int year, int month , int day) throws IOException {
		
		int �Ϻ����� = 0;
		FileInputStream input = new FileInputStream("C:/Users/gks01/����.txt");
		byte[] bytes = new byte[1024]; // ����Ʈ�迭��
		input.read(bytes);				// ����Ʈ �б�
		String str = new String(bytes); // �Ͼ�°� ����
		String[] ȸ����� = str.split("\n"); //1ȸ ���⸶�� �ڸ���
		for(int i = 0; i < ȸ�����.length ; i++) {	// ȸ�������̸�ŭ �ݺ�
			if(ȸ�����[i] != null && ȸ�����[i].contains(Integer.toString(year) +","+ Integer.toString(month)+","+Integer.toString(day))) {// year,month,day �� �Ȱ�����
				String[] �Ϻ�����1 = ȸ�����[i].split(":"); // :���� �ݾ��ڸ���
				int ���� = Integer.parseInt(�Ϻ�����1[1]);	// int �� ��ȯ
				�Ϻ����� += ����;	// �Ϻ����� ��� �÷���
			}
		}
		return �Ϻ�����; //�Ϻ����� ����
	
		
	}
}