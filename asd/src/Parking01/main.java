package Parking01;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Scanner;

import raechan.settlement_1;

public class main {
	static String[] park = {"[ ]","[ ]","[ ]","[ ]",
							"[ ]","[ ]","[ ]","[ ]",
							"[ ]","[ ]","[ ]","[ ]"}; // 주차장
	static ArrayList<tower> tow = new ArrayList<tower>(); // 주차한 객체 저장
	static ArrayList<Integer> allDayPay = new ArrayList<Integer>(); // 매출 리스트;
	public static void main(String[] args) {
		
		while(true) {
			Scanner sc = new Scanner(System.in);
			try {
				System.out.println("-------------------- 주차 프로그램 [현황]---------------");
				int i = 0;
				for(String tmep : park) {//출력
					System.out.print(tmep);
					if(i % 4 == 3) {// 줄바꿈
						System.out.println();
					}
					i++;
				}	
				
				System.out.println("----------------------------------------------------");
				System.out.println("1.주차등록 2.출차 3.매출확인"); int ch = sc.nextInt();// 선택 입력받기
				
				if(ch == 1) {// 주차등록
					System.out.println("***주차등록***");
					System.out.println("차량번호: "); String 차량번호 = sc.next();
					System.out.println("주차위치: "); int 주차위치 = sc.nextInt();
					ZonedDateTime now = ZonedDateTime.now();
					machine.주차등록(차량번호, 주차위치, now);										
				}else if(ch == 2) {	// 주차삭제
					System.out.println("차량번호: "); String 차량번호 = sc.next();
					boolean pass = false;
					for(tower temp : tow) {
						if(temp.get차번호().equals(차량번호)) {
							pass = true;
							break;
						}
					}
					if(pass) {
						ZonedDateTime endnow = ZonedDateTime.now();
						//요금계산
						int 요금 = machine.요금계산(차량번호, endnow);
						if(요금 < 0) {
							System.out.println("계산실패");
						}else {
							System.out.println("주차요금: " + 요금);
						}
						System.out.println("입금: "); int 돈 = sc.nextInt();
						//요금정산
						if(요금 <= 돈) {
							machine.주차삭제(차량번호);
							allDayPay.add(요금);
							System.out.println("거스름돈: " + (돈 - 요금));
							System.out.println("감사합니다 즐거운 하루되세요");
						}else {
							System.out.println("돈 부족");
						}					
					}		
				}else if(ch == 3) { // 매출확인
					settlement_1.dayPay();
									
				}else { // 그외
					System.out.println("에러)) 알수없는 행동");
				}
			}catch(Exception e) {
				System.out.println("에러)) 관리자 호출 요망" + e);
			}//예외문 종료
		}// while문 종료
		
		}
	
}
