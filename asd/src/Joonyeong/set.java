package Joonyeong;

import java.time.temporal.ChronoUnit;

public class set extends tower{

	public static void main(String[] args) {
		
		int �� = (int) parkStart.until(parkEnd, ChronoUnit.DAYS); 		// �����ð� - �����ð� (��)	
		int �� = (int) parkStart.until(parkEnd, ChronoUnit.HOURS);		// �����ð� - �����ð� (�ð�)
		int �� = (int) parkStart.until(parkEnd , ChronoUnit.MINUTES);	// �����ð� - �����ð� (��)
		int �ð��� = �� * 60; // �����ð� - �����ð� �ؼ� ���� �ð��� ������ ����
		int �������ð� = �ð��� + ��; // �������ð��� ������ ����
		int count = 0;
		int[] AllDayPay = new int[100]; // �Ϸ絿�� ���� �������
		
		
		if( �� == 0 ) { // Day�� ���� 0�̸�
			�������ð� -= 30; // ù �����ð� 30���� ����
			while(true) {
			if( �������ð� >= 10 ) { // �������ð��� 10�� ���϶��
				�������ð� -= 10;		// 10�и��� ī��Ʈ
				count++;
			}else {
				break;
			}
		}	int ������� = count*1000;	// ī��Ʈ * 1000���� �������
			
				if( ������� > ������ ) { // ��������� ���������� ���ٸ� ���� �����ϴ�
					return -1;
				}
				else if(������� < ������) { // ��������� ������ ���� ������ �Ž����� �ֱ�
					int �Ž����� = ������-�������;
					return �Ž�����;
				}			
	}
		
		else if( �� > 0 ) { // �����ð��� �Ϸ縦 �Ѱ�����
			 int ������� = �� * 50000;
			 if( ������� > ������ ) { // ��������� ���������� ���ٸ� ���� �����ϴ�
				 return -1;
			 }
			 else if( ������� < ������ ) { // ��������� ������ ���� ������ �Ž����� �ֱ�
				 int �Ž����� = ������-�������;
				 return �Ž�����;
			 }
		}
				
		
		
		
	}

}
