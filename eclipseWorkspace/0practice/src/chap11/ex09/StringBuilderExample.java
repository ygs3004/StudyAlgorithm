package chap11.ex09;

//1부터 100까지 숫자 문자열 만들기 String Builder 사용
//for문을 이용한 기본코드 100개 의 객체를 만들어내므로 비효율적임

public class StringBuilderExample {

	public static void main(String[] args) {
		String str="";
		for(int i=1; i<=100; i++) {
			str+=i;
		}
		System.out.println(str);
		
		StringBuilder sb=new StringBuilder();
		for(int i=1; i<=100; i++) {
			sb.append(i);	
		}
		System.out.println(sb.toString());
	}
	
}
