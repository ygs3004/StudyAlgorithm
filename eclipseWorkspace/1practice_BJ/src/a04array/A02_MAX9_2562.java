package a04array;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
9개의 서로 다른 자연수가 주어질 때, 이들 중 최댓값을 찾고 그 최댓값이 몇 번째 수인지를 구하는 프로그램을 작성하시오.

예를 들어, 서로 다른 9개의 자연수

3, 29, 38, 12, 57, 74, 40, 85, 61

이 주어지면, 이들 중 최댓값은 85이고, 이 값은 8번째 수이다.
e)입			출
3			85	
29			8
38
12
57
74
40
85
61
*/
public class A02_MAX9_2562 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num=0;
		int max=0;
		int count=0;
		int best=0;

		for(int i=0; i<9; i++) {
			num=Integer.parseInt(br.readLine());
			count++;
			if(num>max) {
				max=num;
				best=count;
			}
			
		}
		br.close();
		System.out.println(max + "\n"+ best);
	}

}
