package a21_30.a31_40;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
문제
세준이는 크기가 N×N인 배열 A를 만들었다. 배열에 들어있는 수 A[i][j] = i×j 이다. 이 수를 일차원 배열 B에 넣으면 B의 크기는 N×N이 된다. 
B를 오름차순 정렬했을 때, B[k]를 구해보자.
배열 A와 B의 인덱스는 1부터 시작한다.

입력
첫째 줄에 배열의 크기 N이 주어진다. N은 10^5보다 작거나 같은 자연수이다. 둘째 줄에 k가 주어진다. k는 min(10^9, N^2)보다 작거나 같은 자연수이다.

출력
B[k]를 출력한다.

ex)
3
7
->6
*/
public class A31_Knumber_1300 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		long k = Long.parseLong(br.readLine());
		
		
		long start=1;
		long end=k;
		long ifK;
		
		while(start<=end) {
			int count=0;
			ifK=(start+end)/2;
			for(int i=1; i<=n; i++) {
				count += Math.min(ifK/i,n);
			}


			if(count>=k) {
				end=ifK-1;
			}else{
				start=ifK+1;
			}
			
		}
		System.out.println(start);
		
	}

}
