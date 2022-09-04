package a21_30;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.
첫째 줄에 수의 개수 N(1 ≤ N ≤ 10,000,000)이 주어진다. 둘째 줄부터 N개의 줄에는 수가 주어진다. 이 수는 10,000보다 작거나 같은 자연수이다.
ex)
10
5	                                 1
2                                    1
3                                    2
1                                    2
4                                    3
2                                    3
3                                    4
5                                    5
1                                    5
7                                    7
*/

public class A22_RadixSoirt_10989 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int[] num = new int[n];
		int maxDigit = 10000;
		int digit = 1;
		int[] arrange = new int[n];
		int[] save; 
		for(int i=0; i<n; i++) {
			num[i]=Integer.parseInt(br.readLine());
		}
		
		
		while(digit<=maxDigit) {
			save=new int[10];
			for(int i=0; i<n; i++) {
				save[(num[i]/digit)%10]++;	
			}
			
			for(int i=1; i<=9; i++) {
				save[i] += save[i-1];
			}
			
			for(int i=num.length-1; i>=0; i--) {  // i=num.length-1 부터 넣어야 앞서 정렬한 자릿수 기준 큰수가 앞자리를 차지함
				arrange[save[(num[i]/digit)%10]-1]=num[i];
				save[(num[i]/digit)%10]--;
			}
			
			for(int i=0; i<n; i++) {
				num[i]=arrange[i];
			}
			digit *= 10;
		}
		
		for(int a : num) 
			bw.write(a+"\n");
		
		bw.flush();
		br.close();
		bw.close();

	}

}