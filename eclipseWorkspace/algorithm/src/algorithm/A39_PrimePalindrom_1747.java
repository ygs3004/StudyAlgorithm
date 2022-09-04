package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
문제
어떤 수와 그 수의 숫자 순서를 뒤집은 수가 일치하는 수를 팰린드롬이라 부른다. 예를 들어 79,197과 324,423 등이 팰린드롬 수이다.

어떤 수 N (1 ≤ N ≤ 1,000,000)이 주어졌을 때, N보다 크거나 같고, 소수이면서 팰린드롬인 수 중에서, 가장 작은 수를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 N이 주어진다.

출력
첫째 줄에 조건을 만족하는 수를 출력한다.

31->101
*/

public class A39_PrimePalindrom_1747 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a = Integer.parseInt(br.readLine()); 
		int max=1003002;
		int[] arr=new int[max];

		for(int i=2; i<=Math.sqrt(max); i++) {
			if(arr[i]==1) continue;
			for(int j=i+i; j<max; j=j+i) {
				arr[j]=1;
			}
		}
		int result=0;
		if(a==1) a=2;
		for(int i=a; i<max; i++) {
			if(arr[i]==0) {
				if(palindrom(i)) {
					result=i; break;
				}
			}
		}
		br.close();
		System.out.println(result);
	}
	
	public static boolean palindrom(int n) {

		char[] number = String.valueOf(n).toCharArray();
		
		int sIdx=0;
		int eIdx=number.length-1;
		
		while(sIdx<=eIdx) {
			if(number[sIdx]!=number[eIdx])
				return false;
			sIdx++;
			eIdx--;
		}
		return true;
	}

}


