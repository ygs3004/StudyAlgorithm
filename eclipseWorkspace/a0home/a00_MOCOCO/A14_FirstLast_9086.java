package a0home.a00_MOCOCO;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
입력의 첫 줄에는 테스트 케이스의 개수 T(1 ≤ T ≤ 10)가 주어진다. 각 테스트 케이스는 한 줄에 하나의 문자열이 주어진다.
문자열은 알파벳 A~Z 대문자로 이루어지며 알파벳 사이에 공백은 없으며 문자열의 길이는 1000보다 작다.
입력								   출력
3                                  
ACDKJFOWIEGHE                      AE  
O                                  OO  
AB                                 AB  
*/
public class A14_FirstLast_9086 {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb= new StringBuilder();
		br.readLine();
		String str;
		while((str=br.readLine())!=null) {
			sb.append(Character.toString(str.charAt(0))+str.charAt(str.length()-1)+"\n");
		}
		System.out.println(sb);
	}

}
