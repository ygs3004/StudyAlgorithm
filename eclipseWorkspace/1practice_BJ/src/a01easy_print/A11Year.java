package a01easy_print;

import java.util.Scanner;

//ICPC Bangkok Regional에 참가하기 위해 수완나품 국제공항에 막 도착한 팀 레드시프트 일행은 눈을 믿을 수 없었다. 공항의 대형 스크린에 올해가 2562년이라고 적혀 있던 것이었다.
//불교 국가인 태국은 불멸기원(佛滅紀元), 즉 석가모니가 열반한 해를 기준으로 연도를 세는 불기를 사용한다. 반면, 우리나라는 서기 연도를 사용하고 있다. 불기 연도가 주어질 때 이를 서기 연도로 바꿔 주는 프로그램을 작성하시오.
// ex)입력 : 2541, 출력 : 1998

public class A11Year {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int bYear=sc.nextInt();
		System.out.println(bYear-543);
		
		sc.close();
	}
	
}