package chap11.ex08;

import java.util.StringTokenizer;

// 아이디,이름,패스워드
// (,)로 분리된 문자열을 split, StringTokernizer로 분리
public class SplitExample {

	public static void main(String[] args) {
		String str="아이디, 이름, 패스워드";
		//split() 이용
		String[] splits=str.split(", ");
		for(String split:splits) {
			System.out.println(split);
		}
		System.out.println();

		//StringTokenizer 이용
		StringTokenizer token=new StringTokenizer(str,", ");
		while(token.hasMoreTokens()) {
			System.out.println(token.nextToken());
		}
		
	}

}