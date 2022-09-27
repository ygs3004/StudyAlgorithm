package a03forwhile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*첫째 줄에는 별 1개, 둘째 줄에는 별 2개, N번째 줄에는 별 N개를 찍는 문제
ex)
5	         *    
             **   
             ***  
             **** 
             *****
*/

public class A09star {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		
		int n=Integer.parseInt(br.readLine());
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<i+1; j++) {
				sb.append("*");	
			}
			sb.append("\n");
		}
	System.out.println(sb);
	br.close();
	}

}