package raechan;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;
import Parking01.machine;

public class settlement_1 {
	
	
	//***************************************************************************
	//////1일부터 출력되는 메소드이기때문에 시작일을 1로 잡아야한다!!!
	//////시작일이 1이 아니라면 시작일전까지 0원 파일에 입력할 것!!!
	//***************************************************************************
	
	
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

			//어레이리스트입력
			ArrayList<Integer> allDayPay = new ArrayList<Integer>();	//임시어레이배열


					
			
			
			//매출 파일에 입력
			try {
				FileOutputStream outputStream = new FileOutputStream("C:/Users/박래찬/Desktop/코딩/java/팀프1.txt");
				for(int i = 0 ; i<1000 ;i++) {
					if(allDayPay.get(i)!=null) {
						String 내보내기 = allDayPay.get(i)+"\n"; 
						outputStream.write( 내보내기.getBytes() );
					}
				}
				
			}catch( Exception e ) { // 예외[오류] 처리[잡기] : Exception 클래스
			}
			
			
			//파일불러오기
					//파일얻어오기
			FileInputStream inputStream = new FileInputStream("C:/Users/박래찬/Desktop/코딩/java/팀프1.txt");
			byte[] bytes = new byte[1024];
			inputStream.read( bytes );
			String 파일내용 = new String( bytes );
			String[] 매출목록 = 파일내용.split("\n");
		
				//매출 파일에 저장하기
			int h=0;
			int vh = 0;
			for( String temp : 매출목록 ) {
			 
				if(temp==null) {
					break;
				}
				String r = (매출목록[h]) ;
				//int 매출 = Integer.parseInt(r);   //Bytes로 저장된 파일의 내용을 String으로 바꾸고 int로 전환할했으나 String으로도 산관없이 출력됨
				//allDayPay.add(매출);             //혹시모를 오류
				h++;
				vh=h;
			}
			
			
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
				
				
				if(i<=vh-2) {
					Integer a = machine.매출확인(year,month-1,i+1);
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
				}
			
				else {
					int hk = i+1;
					System.out.print(hk +"일)없음"+"\t\t");
				}
				
				if( sweek % 7 == 0 ) System.out.println(); // 토요일마다 줄바꿈처리 [ 토요일=7 ] 요일이 7배수마다
				sweek++;  // 하루씩 요일 증가 
				
			}
					
					
		}
		
			
	}
	
	
}