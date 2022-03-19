package mingikim;

import java.io.ObjectInputStream.GetField;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

import Joonyeong.tower;
import Parking01.main;

public class settlement extends tower{ // c s
	
//	* 타워 주차 프로그램 [ 주차관리인 만 사용O  일반고객X ] 
//			조건1 : 3층 짜리 주차타워일 경우 층별 4개씩 주차 가능 
//				1층 [ ] [ ] [ ] [ ]
//				2층 [ ] [ ] [ ] [ ]
//				3층 [ ] [ ] [ ] [ ]
//
//			조건2 : 메뉴 : 1.입차 2.출차 3.매출확인
//				입차시 : 차량번호[4자리] 입력받아 주차타워에 자리가 있을경우 주차 
//				출차시 : 차량번호[4자리] 를 입력받아 출차시 금액계산
//					* 금액표 
//						1 .최초 30분 무료 
//						2. 30분 이후부터 10분당 1000원
//						3. 하루 최대 5만원 부과
//						4. 1일당 5만원
//
//				매출확인시 : 연도 , 월 입력받아 해당 월의 일별 매출 출력 / 매출이 없는 경우 없다 .
//
//			조건3 : 클래스 , 파일처리 , Arraylist , 예외처리 필수 사용 [ 그외 선택 사항 ] 

			
			// 조 별 각자 본인 작성한 메소드[코드]
				// 김현수 : 입차메소드 
				// 유재석 : 출차메소드
				//  
			// git 저장소 새로 만들어서 각 조별 팀 초대

			// 주차타워에서 입력받은 입차시간과 출차시간을 빼서 총 주차시간 구한뒤 금액표에 따라 금액계산 후
			// 계산하기 후 오늘받은 총 금액
			// 총 금액(alldaypay)을 계산해서 인수로 보내주기
			// 날짜객체1.untill( 날짜객체2 , ChronoUnit.시간단위 )  :  두 날짜간 단위기준으로 차이
			// 뒤에서 앞을뺀다
	public static void main(String[] args) {
			
		//zonedDateTime.until(getParkEnd(), ChronoUnit.DAYS);
//		int 시 = parkStart.untill(parkEnd , ChronoUnit
//		int 분 parkStart.untill(parkEnd , ChronoUnit
		
//		int count = 0;
//						
//	if(Day == 0) {	// Day의 차가 0이면 하루가 안지난것	 
//			분 -= 30;
//			while(true) {
//				if( 분 > 10) {
//					분 -= 10;
//					count++;
//				}else {
//					break;
//				} 
//			} 	int 주차비용 = count * 1000;
//		if( 주차비용 > 받을돈 ) { // 주차비용이 받은돈 보다 적다면 돈이 부족하다
//			
//			return -1;	 
//		 } 
//		else if(주차비용 < 받을돈) { // 주차비용이 받은돈 보다 많으면 거스름돈 주기
//			int 거스름돈 = 받을돈-주차비용;
//			return 거스름돈
//		}
//	
//	 else if(Day > 0) { // 추
//			 int 주차비용 = Day * 50000;
//			 if()
//		 }
//	}
//	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	} // m e
} // c e
