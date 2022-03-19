package Joonyeong;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class tower { // c s

	static String[] parkSpace = {  "[ ]" , "[ ]" , "[ ]" , "[ ]" , 
							"[ ]" , "[ ]" , "[ ]" , "[ ]" ,
							"[ ]" , "[ ]" , "[ ]" , "[ ]" , };
		// 차량이 차면 "[o]" 비면 "[ ]"
	//입차 시간
	static ZonedDateTime parkStart = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));
	//출차 시간
	static ZonedDateTime parkEnd = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));
	
	public String[] getParkSpace() {
		return parkSpace;
	}
	public void setParkspace(String[] parkSpace) {
		this.parkSpace = parkSpace;
	}
	public ZonedDateTime getParkStart() {
		return parkStart;
	}
	public  ZonedDateTime getParkEnd() {
		return parkEnd;
	}
	
	public static String[] 차량등록(carNumber) { // 차량등록 s
		for(int i = 0; i<12; i++) { // for s
			if(parkSpace[i].equals("[ ]")) { // 주차공간 있으면
				parkSpace[i] = {"[o]", parkStart, carNumber}; // 배열 안에 배열
				return parkSpace[i];
			} // 차량 채우고 입차시간 배열 중첩으로 넣기										
		} // for e
		return null;
	} // 차량등록 e
	
	public static void 차량삭제(carNumber) { // 차량삭제 s
		for(int i=0; i<12; i++) { // for s
			if(parkSpace[i][2].equals(carNumber)) { // 차량번호 일치하면
				parkSpace[i] = "[ ]"; return;
			}
		} // for e
	} // 차량삭제 e
} // c s
