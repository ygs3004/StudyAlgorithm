package a03forwhile;

import java.util.Scanner;

/*
두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.
첫째 줄에 테스트 케이스의 개수 T가 주어진다.
각 테스트 케이스는 한 줄로 이루어져 있으며, 각 줄에 A와 B가 주어진다. (0 < A, B < 10)

ex)입력		출력
5  			
1 1			Case #1: 2
2 3			Case #2: 5
3 4			Case #3: 7
9 8			Case #4: 17
 */

public class A07sumPrint {

	public static void main(String[] args) {
	
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		
		for(int i=0; i<n; i++) {
			int x=sc.nextInt();
			int y=sc.nextInt();
			System.out.println("Case #"+(i+1)+": "+(x+y));
		}
				
		sc.close();
	}

}
