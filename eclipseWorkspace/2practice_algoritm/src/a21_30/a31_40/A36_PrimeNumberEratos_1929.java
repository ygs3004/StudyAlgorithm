package a21_30.a31_40;
/*
문제
M이상 N이하의 소수를 모두 출력하는 프로그램을 작성하시오.

입력
첫째 줄에 자연수 M과 N이 빈 칸을 사이에 두고 주어진다. (1 ≤ M ≤ N ≤ 1,000,000) M이상 N이하의 소수가 하나 이상 있는 입력만 주어진다.

출력
한 줄에 하나씩, 증가하는 순서대로 소수를 출력한다.

예제 입력 1 
3 16
예제 출력 1 
3
5
7
11
13
*/


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class A36_PrimeNumberEratos_1929 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); 
		int m = Integer.parseInt(st.nextToken());
		int[] arr = new int[m+1];
		
		for(int i=n; i<arr.length; i++) {
			arr[i]=1;
		}
		
		for(int i=2; i<=Math.sqrt(m);i++) {
			if(arr[i]==2) continue;
			for(int j=2; j<=m/i; j++) {
				arr[i*j]=2;
			}
		}
		
		for(int i=n; i<arr.length; i++) {
			if(arr[i]==1 && i!=1)
				bw.write(i+"\n");
		}
		
		bw.flush();
		br.close();
		bw.close();
	}

}
