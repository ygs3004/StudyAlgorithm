package ch04;

public class Ex04 {

	public static void main(String[] args) {
		
		int a=0; int b=0;
		
		while((a+b)!=5) {

			a=(int)(6*Math.random())+1;
			b=(int)(6*Math.random())+1;

			System.out.println("("+a+", "+b+")");
		}

	}
}