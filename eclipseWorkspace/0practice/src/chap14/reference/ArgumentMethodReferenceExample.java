package chap14.reference;

import java.util.function.ToIntBiFunction;

//매개변수의 메소드 참조 
// (a, b) ->{ a.instanceMethod(b) }
// 클래스 :: intanceMethod로 표현

public class ArgumentMethodReferenceExample {

	public static void main(String[] args) {
		ToIntBiFunction<String, String> function;
		
		function = (a, b) -> a.compareToIgnoreCase(b);
		print(function.applyAsInt("Java8", "JAVA8"));
		
		function = String :: compareToIgnoreCase;
		print(function.applyAsInt("Java8", "JAVA8"));
	}
	
	public static void print(int order) {
		if(order<0) {
			System.out.println("사전순으로 먼저 옵니다.");
		}else if(order==0) {
			System.out.println("동일한 문자열 입니다.");
		}else {
			System.out.println("사전순으로 나중에 옵니다.");
		}
		
	}

}
