package a0home.a00_MOCOCO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
0보다 크거나 같은 정수 N이 주어진다. 이때, N!을 출력하는 프로그램을 작성하시오.
첫째 줄에 정수 N(0 ≤ N ≤ 12)이 주어진다.

ex)
10 -> 3628800
0 -> 1
*/
public class A05_FACTORIAL_10872 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		int result=1;
		if(n!=0)
			for(int i=1; i<=n; i++) result *= i;

		bw.write(result+"");
		bw.flush();
		br.close();
		bw.close();

	}

}
