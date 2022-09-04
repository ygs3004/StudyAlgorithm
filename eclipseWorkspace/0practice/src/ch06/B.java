package ch06;

public class B{
	public B() {
		A a =new A();
		a.field1=1;
		a.field2=1; // 패키지가 같으므로 default 필드 접근 가능
//		a.field3=1; // private 필드 접근 불가(컴파일 에러)
	
		a.method1();
		a.method2(); // 패키지가 같으므로 default 메소드 접근 가능
//		a.method3(); // priva 메소드 접근 불가(컴파일 에러)
	}
	
}