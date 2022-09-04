package chap14.reference;

import java.util.function.IntBinaryOperator;

public class MethodReferencesExample {

	public static void main(String[] args) {
		IntBinaryOperator operator;
		
		//정적(static) 메소드 참조 -> 클래스 : (정적)메소드로 표현
		operator = (x,y) -> Calculator.staticMethod(x, y);
		System.out.println("결과 1 : "+operator.applyAsInt(1, 2));
		
		operator = Calculator :: staticMethod;
		System.out.println("결과 2 : "+operator.applyAsInt(3, 4));
		
		//인스턴스 메소드 참조  -> 참조변수 :: 메소드로 표현
		Calculator obj=new Calculator();
		operator = (x, y) -> obj.instanceMethod(x, y);
		System.out.println("결과 3 : "+operator.applyAsInt(5, 6));
		
		operator = obj :: instanceMethod;
		System.out.println("결과 4 : "+operator.applyAsInt(7, 8));
	}

}
