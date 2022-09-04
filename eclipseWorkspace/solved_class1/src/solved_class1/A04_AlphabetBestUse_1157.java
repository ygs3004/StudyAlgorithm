package solved_class1;
//알파벳 대소문자로 된 단어가 주어지면, 이 단어에서 가장 많이 사용된 알파벳이 무엇인지 알아내는 프로그램을 작성하시오. 단, 대문자와 소문자를 구분하지 않는다.
// ex) Mississipi -> ?                 baaa->A

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class A04_AlphabetBestUse_1157 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine().toUpperCase();
		StringBuilder sb = new StringBuilder();
		int[] abc = new int[26];
		int max = 0;
		
		for(int i=0; i<str.length(); i++) {
			abc[str.charAt(i)-65]++;
		}
		
		for(int i=0; i<abc.length; i++) {
			if(abc[i]>max){
				max = abc[i];
				sb.setLength(0);
				sb.append((char)(i+65));
			}else if(abc[i]==max) {
				sb.setLength(0);
				sb.append("?");
			}
		}
		
		System.out.println(sb);
		
		br.close();
	}

} // (int)'A' = 65 