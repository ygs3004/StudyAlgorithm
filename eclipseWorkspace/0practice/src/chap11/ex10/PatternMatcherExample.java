package chap11.ex10;
// 첫 번째는 알파벳, 두 번째부터 숫자와 알파벳으로 구성된 8~12자 사이의 ID값인지 검사
// 알파벳은 대소문자 모두 허용, 정규 표현식을 이용하여 검증

import java.util.regex.Pattern;

public class PatternMatcherExample {

	public static void main(String[] args) {
		String id ="5Angel1004";
		String regExp = "[a-zA-Z]\\w{7,11}" ;//작성
		boolean isMatch = Pattern.matches(regExp, id);
		if(isMatch) {
			System.out.println("ID로 사용할 수 있습니다.");
		}else
			System.out.println("ID로 사용할 수 없습니다.");
	}

}
