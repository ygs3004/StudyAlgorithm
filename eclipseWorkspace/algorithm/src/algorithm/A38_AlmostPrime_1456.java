package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
문제
어떤 수가 소수의 N제곱(N ≥ 2) 꼴일 때, 그 수를 거의 소수라고 한다.

두 정수 A와 B가 주어지면, A보다 크거나 같고, B보다 작거나 같은 거의 소수가 몇 개인지 출력한다.

입력
첫째 줄에 왼쪽 범위 A와 오른쪽 범위 B가 공백 한 칸을 사이에 두고 주어진다.

출력
첫째 줄에 총 몇 개가 있는지 출력한다.

제한
1 ≤ A ≤ B ≤ 1014
예제 입력 1 
1 1000
예제 출력 1 
25
예제 입력 2 
1 10
예제 출력 2 
3
예제 입력 3 
5324 894739
예제 출력 3 
183
*/
public class A38_AlmostPrime_1456 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Long a = Long.parseLong(st.nextToken());
		Long b = Long.parseLong(st.nextToken());
		int count=0;
		int[] arr = new int[(int) (Math.pow(10, 7)+1)];
		
		for(int i=2; i<=Math.sqrt(arr.length); i++) {
			if(arr[i]==1) continue;
			for(int j=i+i; j<arr.length; j=j+i) {
				arr[j] = 1;
			}
		}
		
		
		for(int i=2; i<arr.length; i++) {
			if(arr[i]==0) {
				long temp=i;
				while(temp<=b/i) {
					if(a<=temp*i) {
						count++;
					}
					temp=temp*i;
				}
			}
		}
		
		System.out.println(count);
	}

}
