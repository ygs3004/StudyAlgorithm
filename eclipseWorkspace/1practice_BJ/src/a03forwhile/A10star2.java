package a03forwhile;
/*
첫째 줄에는 별 1개, 둘째 줄에는 별 2개, N번째 줄에는 별 N개를 찍는 문제
하지만, 오른쪽을 기준으로 정렬한 별(예제 참고)을 출력하시오.
ex)
n=5  =>            *     
                  **     
                 ***     
                ****     
               *****     
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class A10star2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n=Integer.parseInt(br.readLine());
		
		for(int i=1; i<n+1; i++) {
			for(int j=n; j>i; j--) {
				bw.write(" ");
			}
			
			for(int k=1; k<=i; k++) {
				if(i==k) {
					bw.write("*\n");
					break;
				}
				bw.write("*");
			}
		}
		bw.flush();
		bw.close();
		br.close();
		
	}

}
