package Parking01;

import java.io.FileOutputStream;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class tower {
	
	 String carnum; // ��ȣ
	 int parklo;	// ������ġ
// ������ ���� "[o]" ��� "[ ]"

	public int getParklo() {
		return parklo;
	}

	public void setParklo(String carnum, int parklo) {
		this.carnum = carnum;
		this.parklo = parklo;
	}

	//���� �ð�
	private ZonedDateTime parkStart = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));
	//���� �ð�
	private ZonedDateTime parkEnd = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));

	public ZonedDateTime getParkStart() {
		return parkStart;
	}

	public ZonedDateTime getParkEnd() {
		return parkEnd;
	}
	//�޼ҵ�
	
	public void �������(String carNumber, int index) { // ������� s
		carnum = carNumber; // ����ȣ ���ڷ� �޾ �ʵ��� ����
		parklo = index;		// ��ġ�޾Ƽ� �ʵ忡 ����
		main.park[index] = "[" + carNumber + "]"; 
		carSave();
	} // ������� e

	public void ��������(String carNumber) { // �������� s
		for(int i=0; i<12; i++) { // for s
			if(main.park[i].equals("[" + carNumber + "]")) {
				main.park[i] = "[ ]"; 
				carSave();
				return;
			}
		} // for e
	} // �������� e
	
	public boolean carSave(){// �������� ���� ����
		FileOutputStream fileOutputStream;
		try {
			fileOutputStream = new FileOutputStream("C:/Users/Public/������Ȳ.txt");
		String parkOutput = null;
		for(int i = 0; i<12; i++) {
		parkOutput = main.park[i]+","; // ��ǥ�� ����
		fileOutputStream.write(parkOutput.getBytes()); 
		}
		fileOutputStream.close();
		return true; // ���� ����
	}catch (Exception e) {
				e.printStackTrace();
	 return false;
	} // �������� ���� e
}
}

