package chap11.ex13;

import java.text.SimpleDateFormat;
import java.util.Date;

// 2024년 05월 08일 화요일 10시 30분
// SimpleDateFormat 사용, 위와 같이 오늘의 날짜 출력 
public class DataPrintExample {

	public static void main(String[] args) {
			
		Date now=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy년 MM월 dd일 E요일 KK시 mm분");
		System.out.println(sdf.format(now));
	}

}
