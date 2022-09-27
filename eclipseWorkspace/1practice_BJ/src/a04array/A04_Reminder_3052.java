package a04array;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
두 자연수 A와 B가 있을 때, A%B는 A를 B로 나눈 나머지 이다. 예를 들어, 7, 14, 27, 38을 3으로 나눈 나머지는 
1, 2, 0, 2이다. 수 10개를 입력받은 뒤, 이를 42로 나눈 나머지를 구한다. 그 다음 서로 다른 값이 몇 개 있는지
출력하는 프로그램을 작성하시오.

ex)
1					-> 10
2
3
4
5
6
7
8
9
10
ex2)
42					->1
84
252
420
840
126
42
84
420
126
*/
public class A04_Reminder_3052 {

	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] reminder = new int[42];
		int count=0;
		for(int i=0; i<10; i++) {
			int a = Integer.parseInt(br.readLine());
			reminder[a%42]++;
		}
		
		for(int i=0; i<42; i++) {
			if(reminder[i]>=1) count++;
		}
		
		System.out.println(count);
	}
}
