package Parking01;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class main {
	static String park[] = {"[ ]","[ ]","[ ]","[ ]",
							"[ ]","[ ]","[ ]","[ ]",
							"[ ]","[ ]","[ ]","[ ]"};
	static ArrayList<tower> tow = new ArrayList<tower>();
	public static void main(String[] args) {
			
		while(true) {
			Scanner sc = new Scanner(System.in);
			try {
				System.out.println("-------------------- ���� ���α׷� [��Ȳ]---------------");
				//���� ��Ȳ ���
				FileInputStream input = new FileInputStream("C:/Users/Public/������Ȳ.txt");
				byte[] readBuffer = new byte[1024]; // ����Ʈ�迭��
				input.read(readBuffer); // ����Ʈ�� ����Ʈ�迭�� ����
				String file = new String(readBuffer); // 
				String[] afile = file.split(",");
			
				for(int i = 0; i < 12; i++) {
					System.out.print(afile[i]);
					if(i % 4 == 3) {
						System.out.println();
					}
				}
							
				System.out.println("----------------------------------------------------");
				System.out.println("1.������� 2.���� 3.����Ȯ��"); int ch = sc.nextInt();// ���� �Է¹ޱ�
				
				if(ch == 1) {// �������
					System.out.println("������ȣ: "); String carNumber = sc.next();// ����ȣ �Է¹ޱ�
					System.out.println("������ ��ġ: "); int index = sc.nextInt();	// ������ġ �Է¹ޱ�
					if(park[index] == "[ ]") { // ���ε����� ������;
						tower e = new tower(); 
						e.�������(carNumber, index);
						tow.add(e);
					}else {//�ƴϸ�
						System.out.println("�̹������Ǿ� �ֽ��ϴ�");
					}
										
				}else if(ch == 2) {	// ���ڵ��
					System.out.println("������ȣ: "); String carnum = sc.next();
					System.out.println("������: ");
					for(tower temp : tow) {
						if(temp.carnum.equals(carnum)) {
							temp.��������(carnum);
							break;
						}
					}
					// ������� ȣ��
					for(tower temp : tow) {
						if(temp.carnum.equals(carnum)) {
							
						}
					}
				}else if(ch == 3) { // ����Ȯ��
					
				}else { // �׿�
					System.out.println("����)) �˼����� �ൿ");
				}
			}catch(Exception e) {
				System.out.println("����)) ������ ȣ�� ���" + e);
			}//���ܹ� ����
		}// while�� ����
		
		}
	
}
