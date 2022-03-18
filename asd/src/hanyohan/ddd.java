package hanyohan;

import java.util.ArrayList;
import java.util.Scanner;

public class ddd {
	
		
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
			
		while(true) {
			try {
				System.out.println("-------------------- 주차 프로그램 [현황]---------------");
				System.out.println(/*주차공간 출력*/);
				System.out.println("----------------------------------------------------");
				System.out.println("1.주차등록 2.출차 3.매출확인"); int ch = sc.nextInt();
				
				if(ch == 1) {
					
				}else if(ch == 2) {
					
				}else if(ch == 3) {
					
				}else {
					System.out.println("에러)) 알수없는 행동");
				}
			}catch(Exception e) {
				System.out.println("에러)) 관리자 호출 요망" + e);
			}//예외문 종료
		}// while문 종료
		
	}// me	
}// cs
