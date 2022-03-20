package Parking01;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

import raechan.settlement_1;

public class machine {

	int 날 = (int) parkStart.until(parkEnd, ChronoUnit.DAYS); 		// 출차시간 - 입차시간 (일)	
	int 시 = (int) parkStart.until(parkEnd, ChronoUnit.HOURS);		// 출차시간 - 입차시간 (시간)
	int 분 = (int) parkStart.until(parkEnd , ChronoUnit.MINUTES);	// 출차시간 - 입차시간 (분)
	int 시간값 = 시 * 60; // 출차시간 - 입차시간 해서 나온 시간을 분으로 변경
	int 총주차시간 = 시간값 + 분; // 총주차시간을 분으로 변경
	int count = 0;
	int[] AllDayPay = new int[100]; // 하루동안 받은 주차비용
	
	public machine() {
		// TODO Auto-generated constructor stub
	}

	public machine(int 날, int 시, int 분, int 시간값, int 총주차시간, int count, int[] allDayPay) {
		super();
		this.날 = 날;
		this.시 = 시;
		this.분 = 분;
		this.시간값 = 시간값;
		this.총주차시간 = 총주차시간;
		this.count = count;
		AllDayPay = allDayPay;
	}
	
	public int 요금정산(int 받을돈) {
		if( 날 == 0 ) { // Day의 차가 0이면
			총주차시간 -= 30; // 첫 주차시간 30분은 무료
			while(true) {
			if( 총주차시간 >= 10 ) { // 총주차시간이 10분 이하라면
				총주차시간 -= 10;		// 10분마다 카운트
				count++;
			}else {
				break;
			}
		}	int 주차비용 = count*1000;	// 카운트 * 1000원이 주차비용
			
				if( 주차비용 > 받을돈 ) { // 주차비용이 받을돈보다 많다면 돈이 부족하다
					return -1;
				}
				else if(주차비용 < 받을돈) { // 주차비용이 받은돈 보다 많으면 거스름돈 주기
					int 거스름돈 = 받을돈-주차비용;
					return 거스름돈;
				}			
	}
		
		else if( 날 > 0 ) { // 주차시간이 하루를 넘겼을때
			 int 주차비용 = 날 * 50000;
			 if( 주차비용 > 받을돈 ) { // 주차비용이 받을돈보다 많다면 돈이 부족하다
				 return -1;
			 }
			 else if( 주차비용 < 받을돈 ) { // 주차비용이 받은돈 보다 많으면 거스름돈 주기
				 int 거스름돈 = 받을돈-주차비용;
				 return 거스름돈;
			 }
		}	
	}
	
	
	//일별 매출출력
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
			allDayPay.add(1000); //테스트 매출 1일차
			allDayPay.add(5000); //테스트 매출 2일차
			allDayPay.add(10000); //테스트 매출 3일차
			allDayPay.add(500000); //테스트 매출 4일차
			allDayPay.add(99000); //테스트 매출 5일차
			allDayPay.add(23000); //테스트 매출 6일차
			allDayPay.add(3000000); //테스트 매출 7일차
			allDayPay.add(9999); //테스트 매출 8일차
			allDayPay.add(54000); //테스트 매출 9일차		
			
			//매출 파일에 입력
			try {
				FileOutputStream outputStream = new FileOutputStream("D:/java/팀프1.txt");
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
			FileInputStream inputStream = new FileInputStream("D:/java/팀프1.txt");
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
					Integer a = allDayPay.get(i);
					if(a!= null) {
						if(a>=1000) {
							int j = i+1;
							System.out.print(j+"일)"+a+"원\t");  // i = 일수 출력
						}
						else {
							int j = i+1;
							System.out.print(j+"일)"+a+"원\t\t");  // i = 일수 출력
						}
						
						
					}
				}
				else {
					int hk = i+1;
					System.out.print(hk +"일)미정"+"\t\t");
				}
				
				
				if( sweek % 7 == 0 ) System.out.println(); // 토요일마다 줄바꿈처리 [ 토요일=7 ] 요일이 7배수마다
				sweek++;  // 하루씩 요일 증가 
				
			}
					
					
		}
		
			
	}
	
}
