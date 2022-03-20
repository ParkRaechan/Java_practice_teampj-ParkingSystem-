package Parking01;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class main {
	static String park[] = {"[ ]","[ ]","[ ]","[ ]",
							"[ ]","[ ]","[ ]","[ ]",
							"[ ]","[ ]","[ ]","[ ]"};
	static ArrayList<tower> tow = new ArrayList<tower>();
	public static void main(String[] args) {
			
		while(true) {
			Scanner sc = new Scanner(System.in);
			try {
				System.out.println("-------------------- 주차 프로그램 [현황]---------------");
				//주차 현황 출력
				FileInputStream input = new FileInputStream("C:/Users/Public/주차현황.txt");
				byte[] readBuffer = new byte[1024]; // 바이트배열선
				input.read(readBuffer); // 바이트를 바이트배열의 저장
				String file = new String(readBuffer); // 
				String[] afile = file.split(",");
			
				for(int i = 0; i < 12; i++) {
					System.out.print(afile[i]);
					if(i % 4 == 3) {
						System.out.println();
					}
				}
							
				System.out.println("----------------------------------------------------");
				System.out.println("1.주차등록 2.출차 3.매출확인"); int ch = sc.nextInt();// 선택 입력받기
				
				if(ch == 1) {// 주차등록
					System.out.println("차량번호: "); String carNumber = sc.next();// 차번호 입력받기
					System.out.println("주차한 위치: "); int index = sc.nextInt();	// 주차위치 입력받기
					if(park[index] == "[ ]") { // 빈인덱스가 있으면;
						tower e = new tower(); 
						e.차량등록(carNumber, index);
						tow.add(e);
					}else {//아니면
						System.out.println("이미주차되어 있습니다");
					}
										
				}else if(ch == 2) {	// 출자등록
					System.out.println("차량번호"); String carnum = sc.next();
					for(tower temp : tow) {
						if(temp.carnum == carnum) {
							temp.차량삭제(carnum);
							break;
						}
					}
				}else if(ch == 3) { // 매출확인
					
				}else { // 그외
					System.out.println("에러)) 알수없는 행동");
				}
			}catch(Exception e) {
				System.out.println("에러)) 관리자 호출 요망" + e);
			}//예외문 종료
		}// while문 종료
		
		}
	
}
