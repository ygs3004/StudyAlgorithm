package chap13.extendsparameter;

public class BoundedTypeParameteerExample {

	public static void main(String[] args) {
		// String str=Util.compare("a", "b");;  "a", "b"는 string 이라서 Number extends 아님
		
		int result1=Util.compare(10, 20); // int => Integer 자동 Boxing 되서 객체화 
		System.out.println(result1);
		
		int result2=Util.compare(4.5,  3);
		System.out.println(result2);
	}
	
}