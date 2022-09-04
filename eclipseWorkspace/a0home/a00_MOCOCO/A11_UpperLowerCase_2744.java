package a0home.a00_MOCOCO;
///영어 소문자와 대문자로 이루어진 단어를 입력받은 뒤, 대문자는 소문자로, 소문자는 대문자로 바꾸어 출력하는 프로그램을 작성하시오.

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class A11_UpperLowerCase_2744 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str = br.readLine();
		
		for(int i=0; i<str.length(); i++) {
			if (Character.isUpperCase(str.charAt(i))) {
				bw.write(Character.toLowerCase(str.charAt(i)));
			} else 
				bw.write(Character.toUpperCase(str.charAt(i)));
		}
		
		bw.flush();
		bw.close();
		br.close();
	}

}