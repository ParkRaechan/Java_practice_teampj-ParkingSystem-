package Parking01;
import java.io.IOException;
import java.util.Calendar;
import java.util.Scanner;

public class settlement_1 {
	
	
	//일별 매출 메소드
	public static void dayPay() throws IOException {
		//날짜 받기
		Scanner scanner = new Scanner( System.in);
		System.out.print(" 연도 :"); int year = scanner.nextInt();
		System.out.print(" 월 :");	int month = scanner.nextInt();
		if(month<1||month>12) {
			System.err.println("오류]](달의 번호를 제대로 입력해주세요.) 재시작 바람");
			settlement_1 again = new settlement_1();
			again.dayPay();
		}
		else {

			
			//날짜대입
			Calendar calendar = Calendar.getInstance();
			calendar.set( year , month-1 , 1 ); 
			
			
			
			//달력출력
			int sweek = calendar.get( Calendar.DAY_OF_WEEK ); 
			int eday = calendar.getActualMaximum( Calendar.DAY_OF_MONTH );
			System.out.println("\n\n********************** "+year+"년" + month+"월 ******************");
			System.out.println("일\t\t월\t\t화\t\t수\t\t목\t\t금\t\t토");
			for( int i = 1 ; i < sweek ; i++ ) { // 3월1일 = 화 = 3 
				System.out.print("\t\t"); // 공백출력
			}
			for( int i = 0 ; i<eday ; i++ ) {
				
				//매출불러오기
				Integer a = machine.매출확인(year,month,i+1);
				if(a!= 0) {
					if(a>=1000) {
						int j = i+1;
						System.out.print(j+"일)"+a+"원\t");  // i = 일수 출력
					}
					else {
						int j = i+1;
						System.out.print(j+"일)"+a+"원\t\t");  // i = 일수 출력
					}
				}
				
				else {
					int hk = i+1;
					System.out.print(hk +"일)없음"+"\t\t");
				}
				
			
				
				
				if( sweek % 7 == 0 ) System.out.println(); // 토요일마다 줄바꿈처리 [ 토요일=7 ] 요일이 7배수마다
				sweek++;  // 하루씩 요일 증가 
				
			}
					
			System.out.println();
					
		}
		
			
	}
	
	
}