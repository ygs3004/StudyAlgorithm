package a1_10;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
수 N개 A1, A2, ..., AN이 주어진다. 이때, 연속된 부분 구간의 합이 M으로 나누어 떨어지는 구간의 개수를 구하는 프로그램을 작성하시오.
즉, Ai + ... + Aj (i ≤ j) 의 합이 M으로 나누어 떨어지는 (i, j) 쌍의 개수를 구해야 한다.
첫째 줄에 N과 M이 주어진다. (1 ≤ N ≤ 106, 2 ≤ M ≤ 103)
둘째 줄에 N개의 수 A1, A2, ..., AN이 주어진다. (0 ≤ Ai ≤ 109)
첫째 줄에 연속된 부분 구간의 합이 M으로 나누어 떨어지는 구간의 개수를 출력한다.
ex)입				출
5 3					7
1 2 3 1 2
*/

public class A05_DivideSum10986 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int count=0;	
		long[] sum=new long[(int) (n+1)];
		int [] reminder=new int[(int)m];
		st = new StringTokenizer(br.readLine());
		
		for(int i=1; i<=n; i++) {
			sum[i]=Integer.parseInt(st.nextToken())+sum[i-1];
			if(sum[i]%m==0)	count++;
			reminder[(int)sum[i]%m]++;
		}
		
		
		for(int i=0; i<=m; i++) {
			count+=reminder[i]*(reminder[i]-1)/2;
			
		}
		
		
		
		
		/*
		for(int i=1; i<=n; i++) {
			sum[i]=Integer.parseInt(st.nextToken())+sum[i-1];
			for(int j=1; j<=i; j++) {
				if((sum[j]-sum[i-1])%m==0)
					count++;
			}
		}
		}
		시간초과 */ 
		
		
		
		System.out.println(count);
		br.close();
	}

}
