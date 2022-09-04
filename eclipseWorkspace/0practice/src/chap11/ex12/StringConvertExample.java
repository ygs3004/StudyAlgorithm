package chap11.ex12;

// 문자열 200을 정수로 변환, 숫자 150을 문자열로 변환
public class StringConvertExample {

	public static void main(String[] args) {
		String strData1="200";
		int intData1=Integer.parseInt(strData1); //작성
		//int intData1=Integer.valueOf(strData1);
		
		
		int intData2=150;
		String strData2=String.valueOf(intData2); //작성
		//String strData2 = Integer.toString(intData2);
		//String strData3 = ""+intData2; 간단하게는 빈 문자열과 int를 '+'연산자로 연결하여 문자열로 변환할 수 있다
	}

}
