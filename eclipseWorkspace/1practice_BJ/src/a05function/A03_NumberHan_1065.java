package a05function;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
문제
어떤 양의 정수 X의 각 자리가 등차수열을 이룬다면, 그 수를 한수라고 한다. 등차수열은 연속된 두 개의 수의 차이가 일정한 수열을 말한다. 
N이 주어졌을 때, 1보다 크거나 같고, N보다 작거나 같은 한수의 개수를 출력하는 프로그램을 작성하시오. 
입력
첫째 줄에 1,000보다 작거나 같은 자연수 N이 주어진다.
출력
첫째 줄에 1보다 크거나 같고, N보다 작거나 같은 한수의 개수를 출력한다.

ex)
110 -> 9 		1 -> 1			210->105 		1000->144		500->199
*/

public class A03_NumberHan_1065 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n =Integer.parseInt(br.readLine());
		int count=0;
		for(int i=1; i<=n; i++) {
			if(numberHan(i)) {
				count++;
			}
		}
		
		System.out.println(count);
	}

	public static boolean numberHan(int a) {
		if(a<10) return true;
			
		char[] numberTmp = Integer.toString(a).toCharArray();
		int[] number = new int[numberTmp.length];
		
		for(int i=0; i<number.length; i++) {
			number[i]=numberTmp[i]+'0';
		}

		int gap = number[1]-number[0];
		
		for(int i=0; i<number.length-1; i++) {
			if(gap != number[i+1]-number[i])
				return false;
		}
		return true;
	}
	
}