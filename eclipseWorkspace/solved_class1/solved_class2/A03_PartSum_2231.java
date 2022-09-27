package solved_class1.solved_class2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
어떤 자연수 N이 있을 때, 그 자연수 N의 분해합은 N과 N을 이루는 각 자리수의 합을 의미한다. 
어떤 자연수 M의 분해합이 N인 경우, M을 N의 생성자라 한다. 예를 들어, 245의 분해합은 256(=245+2+4+5)이 된다. 
따라서 245는 256의 생성자가 된다. 물론, 어떤 자연수의 경우에는 생성자가 없을 수도 있다. 반대로, 생성자가 여러 개인 자연수도 있을 수 있다.

자연수 N이 주어졌을 때, N의 가장 작은 생성자를 구해내는 프로그램을 작성하시오.
첫째 줄에 자연수 N(1 ≤ N ≤ 1,000,000)이 주어진다.
216->198
*/
public class A03_PartSum_2231 {

	public static void main(String[] args) throws Exception {
				
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int count=(int)(9*Math.log10(n));
//		if(n<10) {
//			count=9;
//		}else if(n<100) {
//			count=18;
//		}else if(n<1000) {
//			count=27;
//		}else if(n<10000) {
//			count=36;
//		}else if(n<100000) {
//			count=45;
//		}else if(n<1000000) {
//			count=54;
//		}
		int result = 0;
		for(int x=(n-count); x<n; x++) {
			if(partSum(x)==n) {
				result = x;
				break;
			}
		}
		
		System.out.println(result);

	}
	
	public static int partSum(int x) {
		char[] number = Integer.toString(x).toCharArray();
		int sum=0;
		for(char a:number) {
			sum += Character.getNumericValue(a);
		}
		return x+sum;
	}

}

