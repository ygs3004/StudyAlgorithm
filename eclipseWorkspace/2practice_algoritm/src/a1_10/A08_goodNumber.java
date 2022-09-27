package a1_10;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
N개의 수 중에서 어떤 수가 다른 수 두 개의 합으로 나타낼 수 있다면 그 수를 “좋다(GOOD)”고 한다.
N개의 수가 주어지면 그 중에서 좋은 수의 개수는 몇 개인지 출력하라.
수의 위치가 다르면 값이 같아도 다른 수이다.
첫째 줄에는 수의 개수 N(1 ≤ N ≤ 2,000), 두 번째 줄에는 i번째 수를 나타내는 Ai가 N개 주어진다. (|Ai| ≤ 1,000,000,000, Ai는 정수)

ex) 입력                          => 출력
10									8
1 2 3 4 5 6 7 8 9 10

*3,4,5,6,7,8,9,10은 좋다         >>> 문제가 이상함 ㅡ.ㅡ
 */

public class A08_goodNumber {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		long[] arr = new long[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		
		int count = 0;
		
		for(int i=0; i<n; i++) {
			int sIndex = 0;
			int eIndex = n-1;	
			while(sIndex<eIndex) {
				long sum=arr[sIndex]+arr[eIndex];
				if(sum == arr[i]) {
					if(sIndex!=i && eIndex !=i) {
						count++;
						break;
					}else if(i==sIndex) {
						sIndex++;
					}else if(i==eIndex) {
						eIndex--;
					}
				}
				else if(sum > arr[i])
					eIndex--;
				else 
					sIndex++;
		
			}
		}
		br.close();
		System.out.println(count);
			
	}

}