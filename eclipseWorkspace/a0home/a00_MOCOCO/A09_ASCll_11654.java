package a0home.a00_MOCOCO;
//알파벳 소문자, 대문자, 숫자 0-9중 하나가 주어졌을 때, 주어진 글자의 아스키 코드값을 출력하는 프로그램을 작성하시오.

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class A09_ASCll_11654 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println((int)br.readLine().charAt(0));
	}

}
