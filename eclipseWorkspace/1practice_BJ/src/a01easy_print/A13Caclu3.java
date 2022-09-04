/*
 * (세 자리 수) × (세 자리 수)는 다음과 같은 과정을 통하여 이루어진다.
1)472			3)2360  (472*5)
2)385			4)3776	(472*8)
				5)1416	(472*3)
				6)181720(472*385)

(1)과 (2)위치에 들어갈 세 자리 자연수가 주어질 때 (3), (4), (5), (6)위치에 들어갈 값을 구하는 프로그램을 작성하시오.
*/
package a01easy_print;

import java.util.Scanner;

public class A13Caclu3 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int x=sc.nextInt();
		int y=sc.nextInt();
		
		int h=(y/100);
		int hResult=h*x;
		int t=(y/10-h*10);
		int tResult=t*x;
		int o=y-h*100-t*10;
		int oResult=o*x;
		int result=x*y;
		
				
		System.out.println(oResult);
		System.out.println(tResult);
		System.out.println(hResult);
		System.out.println(result);
		sc.close();
	}
}
