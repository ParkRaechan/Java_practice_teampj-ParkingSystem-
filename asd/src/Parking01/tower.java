package Parking01;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class tower {
	
	 String carnum; // 번호
	 int parklo;	// 주차위치
// 차량이 차면 "[o]" 비면 "[ ]"

	public int getParklo() {
		return parklo;
	}

	public void setParklo(String carnum, int parklo) {
		this.carnum = carnum;
		this.parklo = parklo;
	}

	//입차 시간
	private ZonedDateTime parkStart = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));
	//출차 시간
	private ZonedDateTime parkEnd = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));

	public ZonedDateTime getParkStart() {
		return parkStart;
	}

	public ZonedDateTime getParkEnd() {
		return parkEnd;
	}
	//메소드
	
	public void 차량등록(String carNumber, int index) { // 차량등록 s
		carnum = carNumber; // 차번호 인자로 받어서 필드의 저장
		parklo = index;		// 위치받아서 필드에 저장
		main.park[index] = "[" + carNumber + "]"; 
	} // 차량등록 e

	public void 차량삭제(String carNumber) { // 차량삭제 s
		for(int i=0; i<12; i++) { // for s
			if(parkSpace[i][2].equals(carNumber)) { // 차량번호 일치하면
				parkSpace[i] = "[ ]"; return;
			}
		} // for e
	} // 차량삭제 e
}

