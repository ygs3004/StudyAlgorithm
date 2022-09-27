package a03forwhile;

import java.util.Scanner;

/*
두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.
ex)5
1 1			2
2 3			5
3 4			7
9 8			17
5 2			7
*/

public class A02CalcMinus {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t!=0) {
			int x=sc.nextInt();
			int y=sc.nextInt();
			System.out.println(x+y);
			t--;
		}
		sc.close();
	}

}
