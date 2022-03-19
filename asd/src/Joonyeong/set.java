package Joonyeong;

import java.time.temporal.ChronoUnit;

public class set extends tower{

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
				
		
		
		
	}

}
