package Parking01;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;

import raechan.settlement_1;

public class machine {
	
	//1.메소드
	
	//주차등록
	public static void 주차등록(String 주차번호, int 주차위치, ZonedDateTime now) { 
		tower e = new tower(주차번호, 주차위치, now);
		main.tow.add(e);
		if(main.park[주차위치] == "[ ]") {
			main.park[주차위치] = "["+주차번호+"]";
		}
		
	}//주차등록 end
	
	//주차삭제
	public static void 주차삭제(String 차량번호) {
		int i = 0;
		for(tower temp : main.tow) {
			if(temp.get차번호().equals(차량번호)) {
				main.park[temp.get주차위치()] = "[ ]";
				main.tow.remove(i);			
			}
			i++;
		}
	}// 주차삭제 end
	
	//요금계산
	public static int 요금계산(String 차량번호, ZonedDateTime endnow) throws IOException {
		for(tower temp : main.tow) {
			if(temp.get차번호().equals(차량번호)) {
				int 날 = (int) temp.get날짜().until(endnow, ChronoUnit.DAYS); 		// 출차시간 - 입차시간 (일)	
				int 시 = (int) temp.get날짜().until(endnow, ChronoUnit.HOURS);		// 출차시간 - 입차시간 (시간)
				int 분 = (int) temp.get날짜().until(endnow , ChronoUnit.MINUTES);	// 출차시간 - 입차시간 (분)
				int 시간값 = 시 * 60; // 출차시간 - 입차시간 해서 나온 시간을 분으로 변경
				int 총주차시간 = 시간값 + 분; // 총주차시간을 분으로 변경
				int count = 0;
				//int[] AllDayPay = new int[100]; // 하루동안 받은 주차비용
				//계산
				if( 날 == 0 ) { // Day의 차가 0이면
					총주차시간 -= 30; // 첫 주차시간 30분은 무료
					while (true) {
						if(총주차시간 > 10) {
							총주차시간 -= 10;
							count++;
						}else {	
							break;
						}
					}
				}else if( 날 > 0 ) { // 주차시간이 하루를 넘겼을때
					매출파일처리(endnow,날 * 50000);
					return 날 * 50000;
				}
				매출파일처리(endnow,count * 1000);
				return count * 1000;
			}// 같다면 ifend
		}// 찾는거 for end
		return -1;
	}// 메소드 end
	
	//매출확인
//	static void 매출파일처리(ZonedDateTime endnow,int 요금) throws IOException{
//		//매출저장
//		FileOutputStream out = new FileOutputStream("C:/Users/gks01/매출.txt", true);
//		String storage = Integer.toString(endnow.getYear())+","+Integer.toString(endnow.getMonthValue())+","+Integer.toString(endnow.getDayOfMonth())+":"+Integer.toString(요금)+"\n";
//		out.write(storage.getBytes());				
//	}// 매출확인 end
//	static int 매출확인(int year, int month , int day) throws IOException {
//		
//		int 일별매출 = 0;
//		FileInputStream input = new FileInputStream("C:/Users/gks01/매출.txt");
//		byte[] bytes = new byte[1024]; // 바이트배열선
//		input.read(bytes);				// 바이트 읽기
//		String str = new String(bytes); // 일어온거 저장
//		String[] 회당매출 = str.split("\n");
//		for(int i = 0; i < 회당매출.length ; i++) {
//			if(회당매출[i] != null && 회당매출[i].contains(Integer.toString(year) +","+ Integer.toString(month)+","+Integer.toString(day))) {
//				String[] 일별매출1 = 회당매출[i].split(":");
//				int 매출 = 일별매출[1];
//			}
//		}
	
		
	}
}