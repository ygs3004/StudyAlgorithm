package a0home.a00_MOCOCO;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
부산일과학고등학교의 효진이는 수학의 귀재이다. 어떤 문제라도 보면 1분 내에 풀어버린다는 학교의 전설이 내려올 정도였는데, 이런 킹ㅡ갓 효진에게도 고민이 생겼다. 
대부분의 문제에서 반복되는 연산이 있었기 때문이다! 이 연산은 너무 길어서 종이에 풀던 효진이는 너무 고통스러워서, 자신이 새로 연산자를 만들기로 했다.
연산자의 기호는 ＠으로, A＠B = (A+B)×(A-B)으로 정의내리기로 했다.
하지만, 효진이는 막상 큰 숫자가 들어오자 계산하기 너무 귀찮아졌다.
효진이를 도와 정수 A, B가 주어지면 A＠B를 계산하는 프로그램을 만들어주자!
4 3 -> 7
3 4 -> -7
*/
public class A15_MethodNew_15964 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		System.out.println((a+b)*(a-b));

	}

}
