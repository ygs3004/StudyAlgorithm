package a01easy_print;
// 두 정수 A와 B를 입력받은 다음, A/B를 출력하는 프로그램을 작성하시오.
import java.util.Scanner;

public class A08Divide {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		double x=sc.nextInt();
		double y=sc.nextInt();
		System.out.println(x/y);
		sc.close();
	}

}