package Joonyeong;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class tower { // c s

	static String[] parkSpace = {  "[ ]" , "[ ]" , "[ ]" , "[ ]" , 
							"[ ]" , "[ ]" , "[ ]" , "[ ]" ,
							"[ ]" , "[ ]" , "[ ]" , "[ ]" , };
		// ������ ���� "[o]" ��� "[ ]"
	//���� �ð�
	static ZonedDateTime parkStart = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));
	//���� �ð�
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
	
	public static String[] �������(carNumber) { // ������� s
		for(int i = 0; i<12; i++) { // for s
			if(parkSpace[i].equals("[ ]")) { // �������� ������
				parkSpace[i] = {"[o]", parkStart, carNumber}; // �迭 �ȿ� �迭
				return parkSpace[i];
			} // ���� ä��� �����ð� �迭 ��ø���� �ֱ�										
		} // for e
		return null;
	} // ������� e
	
	public static void ��������(carNumber) { // �������� s
		for(int i=0; i<12; i++) { // for s
			if(parkSpace[i][2].equals(carNumber)) { // ������ȣ ��ġ�ϸ�
				parkSpace[i] = "[ ]"; return;
			}
		} // for e
	} // �������� e
} // c s
