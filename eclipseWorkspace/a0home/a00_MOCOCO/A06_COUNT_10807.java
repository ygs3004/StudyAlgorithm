package a0home.a00_MOCOCO;
/*총 N개의 정수가 주어졌을 때, 정수 v가 몇 개인지 구하는 프로그램을 작성하시오.
11
1 4 1 2 4 2 4 2 3 4 4		-> 3
2

11
1 4 1 2 4 2 4 2 3 4 4       -> 0
5
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A06_COUNT_10807 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int v = Integer.parseInt(br.readLine());
		int count=0;
		
		for(int i=0; i<n; i++){
			if(Integer.parseInt(st.nextToken())==v) count++;
		}

		System.out.println(count);
	}

}
