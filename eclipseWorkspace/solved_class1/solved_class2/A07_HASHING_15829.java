package solved_class1.solved_class2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
https://www.acmicpc.net/problem/15829
EX) 
5					
abcde
->4739715
*/

public class A07_HASHING_15829 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] arr = br.readLine().toCharArray();
		long[] arrlong=new long[arr.length];
		
		for(int i=0; i<arr.length; i++) {
			arrlong[i] = (long)arr[i]-96;
		}
		
		long result=0;;
		for(int i=0; i<arr.length; i++) {
			result += (arr[i]*(long)Math.pow(31, i));//%1234567891;
		}
		
		System.out.println(result);
		System.out.println(1*Math.pow(31,1)+2*Math.pow(31,2)+3*Math.pow(31,3)+4*Math.pow(31,4)+Math.pow(31,0));
		br.close();
	}
	

}



//'a' = 97;