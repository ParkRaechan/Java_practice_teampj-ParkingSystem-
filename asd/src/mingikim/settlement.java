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

		
		int 날 = (int) parkStart.until(parkEnd, ChronoUnit.DAYS); 		// 출차시간 - 입차시간 (일)	
		int 시 = (int) parkStart.until(parkEnd, ChronoUnit.HOURS);		// 출차시간 - 입차시간 (시간)
		int 분 = (int) parkStart.until(parkEnd , ChronoUnit.MINUTES);	// 출차시간 - 입차시간 (분)
		int 시간값 = 시 * 60; // 출차시간 - 입차시간 해서 나온 시간을 분으로 변경
		int 총주차시간 = 시간값 + 분; // 총주차시간을 분으로 변경
		int count = 0;
		int[] AllDayPay = new int[100]; // 하루동안 받은 주차비용
		
		
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
		
		//?????????????
		
		
		
		
		
		
		
		
		
		
		
		
		
	} // m e
} // c e
