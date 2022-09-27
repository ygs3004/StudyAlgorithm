package a1_10;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class A03_SumN11659 {
/*
	수 N개가 주어졌을 때, i번째 수부터 j번째 수까지 합을 구하는 프로그램을 작성하시오.
	입력)
	첫째 줄에 수의 개수 N과 합을 구해야 하는 횟수 M이 주어진다. 둘째 줄에는 N개의 수가 주어진다.
	수는 1,000보다 작거나 같은 자연수이다. 셋째 줄부터 M개의 줄에는 합을 구해야 하는 구간 i와 j가 주어진다.
	출력)
	총 M개의 줄에 입력으로 주어진 i번째 수부터 j번째 수까지 합을 출력한다.
	ex)
	입력						출력
	5 3						12
	5 4 3 2 1				9
	1 3						1
	2 4
	5 5
 */

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n=0;
		int m=0;
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int[] sum = new int[n+1];
		
		for(int i=1; i<=n; i++) {
			sum[i]=sum[i-1]+Integer.parseInt(st.nextToken());
		}

		for(int cnt=1; cnt<=m; cnt++) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			bw.write((sum[j]-sum[i-1])+"\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}

}