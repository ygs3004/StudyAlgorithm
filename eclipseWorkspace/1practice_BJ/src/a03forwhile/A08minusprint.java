package a03forwhile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.
첫째 줄에 테스트 케이스의 개수 T가 주어진다.
각 테스트 케이스는 한 줄로 이루어져 있으며, 각 줄에 A와 B가 주어진다. (0 < A, B < 10)

ex)
5                                              
1 1                     Case #1: 1 + 1 = 2                          
2 3                     Case #2: 2 + 3 = 5     
3 4                     Case #3: 3 + 4 = 7     
9 8                     Case #4: 9 + 8 = 17    
5 2                     Case #5: 5 + 2 = 7     
*/

public class A08minusprint {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		StringTokenizer st;
		int n=Integer.parseInt(br.readLine());
		
		for(int i=0; i<n; i++) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			sb.append(("Case #"+(i+1)+": "+a+" + "+b+" = "+(a+b))+"\n");
		}
		System.out.println(sb);
		br.close();
	}

}