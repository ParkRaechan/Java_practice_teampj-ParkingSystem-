package raechan;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class settlement_1 {
	
	
	//***************************************************************************
	//////1�Ϻ��� ��µǴ� �޼ҵ��̱⶧���� �������� 1�� ��ƾ��Ѵ�!!!
	//////�������� 1�� �ƴ϶�� ������������ 0�� ����� ��!!!
	//***************************************************************************
	
	
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

			//��̸���Ʈ�Է�
			ArrayList<Integer> allDayPay = new ArrayList<Integer>();	//�ӽþ�̹迭
			allDayPay.add(1000); //�׽�Ʈ ���� 1����
			allDayPay.add(5000); //�׽�Ʈ ���� 2����
			allDayPay.add(10000); //�׽�Ʈ ���� 3����
			allDayPay.add(500000); //�׽�Ʈ ���� 4����
			allDayPay.add(99000); //�׽�Ʈ ���� 5����
			allDayPay.add(23000); //�׽�Ʈ ���� 6����
			allDayPay.add(3000000); //�׽�Ʈ ���� 7����
			allDayPay.add(9999); //�׽�Ʈ ���� 8����
			allDayPay.add(54000); //�׽�Ʈ ���� 9����
			allDayPay.set(17, 50000);

					
			
			
			//���� ���Ͽ� �Է�
			try {
				FileOutputStream outputStream = new FileOutputStream("C:/Users/gks01/����1.txt");
				for(int i = 0 ; i<1000 ;i++) {
					if(allDayPay.get(i)!=null) {
						String �������� = allDayPay.get(i)+"\n"; 
						outputStream.write( ��������.getBytes() );
					}
				}
				
			}catch( Exception e ) { // ����[����] ó��[���] : Exception Ŭ����
			}
			
			
			//���Ϻҷ�����
					//���Ͼ�����
			FileInputStream inputStream = new FileInputStream("C:/Users/gks01/����1.txt");
			byte[] bytes = new byte[1024];
			inputStream.read( bytes );
			String ���ϳ��� = new String( bytes );
			String[] ������ = ���ϳ���.split("\n");
		
				//���� ���Ͽ� �����ϱ�
			int h=0;
			int vh = 0;
			for( String temp : ������ ) {
			 
				if(temp==null) {
					break;
				}
				String r = (������[h]) ;
				//int ���� = Integer.parseInt(r);   //Bytes�� ����� ������ ������ String���� �ٲٰ� int�� ��ȯ�������� String���ε� ������� ��µ�
				//allDayPay.add(����);             //Ȥ�ø� ����
				h++;
				vh=h;
			}
			
			
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
				
				if(i<=vh-2) {
					Integer a = allDayPay.get(i);
					if(a!= null) {
						if(a>=1000) {
							int j = i+1;
							System.out.print(j+"��)"+a+"��\t");  // i = �ϼ� ���
						}
						else {
							int j = i+1;
							System.out.print(j+"��)"+a+"��\t\t");  // i = �ϼ� ���
						}
						
						
					}
				}
				else {
					int hk = i+1;
					System.out.print(hk +"��)����"+"\t\t");
				}
				
				
				if( sweek % 7 == 0 ) System.out.println(); // ����ϸ��� �ٹٲ�ó�� [ �����=7 ] ������ 7�������
				sweek++;  // �Ϸ羿 ���� ���� 
				
			}
					
					
		}
		
			
	}
	
	
}
