package a03forwhile;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.
 * 입력의 마지막에 0 0이 들어온다
ex)                     
1 1                  2    
2 3                  5  
3 4                  7  
9 8                  17 
5 2                  7  
0 0
*/

public class A12Sum {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if( a==0 && b== 0) break;
			
			bw.append(Integer.toString(a+b)+"\n");
			bw.flush();
		}
	}

}
