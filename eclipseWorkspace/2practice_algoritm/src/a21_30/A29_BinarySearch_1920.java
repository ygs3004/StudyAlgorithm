package a21_30;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
문제
N개의 정수 A[1], A[2], …, A[N]이 주어져 있을 때, 이 안에 X라는 정수가 존재하는지 알아내는 프로그램을 작성하시오.
입력
첫째 줄에 자연수 N(1 ≤ N ≤ 100,000)이 주어진다. 다음 줄에는 N개의 정수 A[1], A[2], …, A[N]이 주어진다. 
다음 줄에는 M(1 ≤ M ≤ 100,000)이 주어진다. 다음 줄에는 M개의 수들이 주어지는데, 이 수들이 A안에 존재하는지 알아내면 된다. 
모든 정수의 범위는 -231 보다 크거나 같고 231보다 작다.
출력
M개의 줄에 답을 출력한다. 존재하면 1을, 존재하지 않으면 0을 출력한다.
ex)
5
4 1 5 2 3
5
1 3 7 9 5

->000
1
1
0
0
1
*/
public class A29_BinarySearch_1920 {
	static long num[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		num = new long[n];
		
		st=new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			num[i]=Long.parseLong(st.nextToken());
		}

		Arrays.sort(num);
		
		int m = Integer.parseInt(br.readLine());
		long checkNum = 0;
		st=new StringTokenizer(br.readLine());
		for(int i=0; i<m; i++) {
			checkNum=Long.parseLong(st.nextToken());
			
			if(findNum(checkNum, 0, num.length-1)) {
				bw.write(1+"\n");
			}else {
				bw.write(0+"\n");
			}
		}
		
		bw.flush();
		br.close();
		bw.close();
	}
	
	public static boolean findNum(long a, int start, int end) {
		if(start>end) return false;
		int sIdx=start;
		int eIdx=end;
		int mid=(sIdx+eIdx)/2;
		
		if(num[mid]==a) return true;
		if(num[mid]<a) {
			if(findNum(a, mid+1, end)) return true;
		} else if(num[mid]>a){
			if(findNum(a, start, mid-1)) return true;
		}
		return false;
	}

}