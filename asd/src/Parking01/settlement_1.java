package Parking01;
import java.io.IOException;
import java.util.Calendar;
import java.util.Scanner;

public class settlement_1 {
	
	
	//�Ϻ� ���� �޼ҵ�
	public static void dayPay() throws IOException {
		//��¥ �ޱ�
		Scanner scanner = new Scanner( System.in);
		System.out.print(" ���� :"); int year = scanner.nextInt();
		System.out.print(" �� :");	int month = scanner.nextInt();
		if(month<1||month>12) {
			System.err.println("����]](���� ��ȣ�� ����� �Է����ּ���.) ����� �ٶ�");
			settlement_1 again = new settlement_1();
			again.dayPay();
		}
		else {

			
			//��¥����
			Calendar calendar = Calendar.getInstance();
			calendar.set( year , month-1 , 1 ); 
			
			
			
			//�޷����
			int sweek = calendar.get( Calendar.DAY_OF_WEEK ); 
			int eday = calendar.getActualMaximum( Calendar.DAY_OF_MONTH );
			System.out.println("\n\n********************** "+year+"��" + month+"�� ******************");
			System.out.println("��\t\t��\t\tȭ\t\t��\t\t��\t\t��\t\t��");
			for( int i = 1 ; i < sweek ; i++ ) { // 3��1�� = ȭ = 3 
				System.out.print("\t\t"); // �������
			}
			for( int i = 0 ; i<eday ; i++ ) {
				
				//����ҷ�����
				Integer a = machine.����Ȯ��(year,month,i+1);
				if(a!= 0) {
					if(a>=1000) {
						int j = i+1;
						System.out.print(j+"��)"+a+"��\t");  // i = �ϼ� ���
					}
					else {
						int j = i+1;
						System.out.print(j+"��)"+a+"��\t\t");  // i = �ϼ� ���
					}
				}
				
				else {
					int hk = i+1;
					System.out.print(hk +"��)����"+"\t\t");
				}
				
			
				
				
				if( sweek % 7 == 0 ) System.out.println(); // ����ϸ��� �ٹٲ�ó�� [ �����=7 ] ������ 7�������
				sweek++;  // �Ϸ羿 ���� ���� 
				
			}
					
			System.out.println();
					
		}
		
			
	}
	
	
}