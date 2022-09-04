package a1_10;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
어떠한 자연수 N은, 몇 개의 연속된 자연수의 합으로 나타낼 수 있다. 당신은 어떤 자연수 N(1 ≤ N ≤ 10,000,000)에 대해서,
이 N을 몇 개의 연속된 자연수의 합으로 나타내는 가지수를 알고 싶어한다. 이때, 사용하는 자연수는 N이하여야 한다.
예를 들어, 15를 나타내는 방법은 15, 7+8, 4+5+6, 1+2+3+4+5의 4가지가 있다. 반면에 10을 나타내는 방법은 10, 1+2+3+4의 2가지가 있다.
N을 입력받아 가지수를 출력하는 프로그램을 작성하시오.

첫 줄에 정수 N이 주어진다.->입력된 자연수 N을 몇 개의 연속된 자연수의 합으로 나타내는 가지수를 출력하시오
ex) 15 => 4
*/
public class A06_continuedNumSum2018 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int count=1;// n인경우 1개
		int sP=1;
		int eP=2;
		
		
		while(sP<(n/2)+1) { // sp가 2/n+1일때 연속된 두수의 합은 항상 n 을 넘음
			int sum=0;
			for(int i=sP; i<=eP; i++) {
				sum += i ;
			}
			if(sum == n) count++;
			if(sum<n) eP++;
			if(sum>=n) sP++;
				
		}
		


		bw.append(Integer.toString(count));
		bw.flush();
		br.close();
	}
}


/* 시간 초과
int count=0;
int end=2;
int start=1;
int sum=0;

boolean check = true;
while(check) {
	for(int i=start; i<end; i++) {
		sum+=i;
		if(sum==n) count ++;
	}
	
	if(sum>=n) {
		start++;
	}
	if(sum<n) {
		end++;
	}
	if(start==n) {
		count++;
		check=false;
	}
	sum=0;
}
*/

/* 시간초과
  
int count=1;
for(int i=1; i<=n; i++){
	sum[i]=i+sum[i-1];
	if(sum[i]<n)
		continue;
	if(sum[i]>n) {
		for(int j=1; j<i; j++) {
			if(sum[i]-sum[j]<n) break;
			if((sum[i]-sum[j])==n) count++;
		}				
	}
}
*/