package a0home.a00_MOCOCO;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
어떤 사람의 C언어 성적이 주어졌을 때, 평점은 몇 점인지 출력하는 프로그램을 작성하시오.

A+: 4.3, A0: 4.0, A-: 3.7

B+: 3.3, B0: 3.0, B-: 2.7

C+: 2.3, C0: 2.0, C-: 1.7

D+: 1.3, D0: 1.0, D-: 0.7

F: 0.0
*/
public class A12_Grade_2754 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String score = br.readLine();
		double result;
		if (score.equals("A+")) {
			result = 4.3;
		} else if (score.equals("A0")) {
			result = 4.0;
		} else if (score.equals("A-")) {
			result = 3.7;
		} else if (score.equals("B+")) {
			result = 3.3;
		} else if (score.equals("B0")) {
			result = 3.0;
		} else if (score.equals("B-")) {
			result = 2.7;
		} else if (score.equals("C+")) {
			result = 2.3;
		} else if (score.equals("C0")) {
			result = 2.0;
		} else if (score.equals("C-")) {
			result = 1.7;
		} else if (score.equals("D+")) {
			result = 1.3;
		} else if (score.equals("D0")) {
			result = 1.0;
		} else if (score.equals("D-")) {
			result = 0.7;
		} else
			result = 0.0;

		System.out.println(result);
	}

}
