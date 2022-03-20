package Parking01;

import java.time.ZonedDateTime;

public class tower {
	//1. 필드
	private String 차번호;
	private int 주차위치;
	private  ZonedDateTime 날짜;
	
	//2.생성자
	public tower() {
	}
	public tower(String 차번호, int 주차위치2, ZonedDateTime 날짜) {
		super();
		this.차번호 = 차번호;
		this.주차위치 = 주차위치2;
		this.날짜 = 날짜;
	}
	
	//메소드
	public String get차번호() {
		return 차번호;
	}
	public void set차번호(String 차번호) {
		this.차번호 = 차번호;
	}
	public int get주차위치() {
		return 주차위치;
	}
	public void set주차위치(int 주차위치) {
		this.주차위치 = 주차위치;
	}
	public ZonedDateTime get날짜() {
		return 날짜;
	}
	public void set날짜(ZonedDateTime 날짜) {
		this.날짜 = 날짜;
	}	
	
}


