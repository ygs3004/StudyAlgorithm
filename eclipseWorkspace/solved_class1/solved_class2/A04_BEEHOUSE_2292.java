package solved_class1.solved_class2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
위의 그림과 같이 육각형으로 이루어진 벌집이 있다. 그림에서 보는 바와 같이 중앙의 방 1부터 시작해서 
이웃하는 방에 돌아가면서 1씩 증가하는 번호를 주소로 매길 수 있다. 숫자 N이 주어졌을 때, 
벌집의 중앙 1에서 N번 방까지 최소 개수의 방을 지나서 갈 때 몇 개의 방을 지나가는지(시작과 끝을 포함하여)를 
계산하는 프로그램을 작성하시오. 예를 들면, 13까지는 3개, 58까지는 5개를 지난다.
첫째 줄에 N(1 ≤ N ≤ 1,000,000,000)이 주어진다.
13 -> 3
*/
public class A04_BEEHOUSE_2292 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long n = Long.parseLong(br.readLine());
		long x=0; 
		long count=0;
		
		if(n!=1) {
			n=n-2;
			for(long i=1; i<1000000000; i++) {
				n-=(6*i);
				count++;
				if(n==0) {
					x=count-1;
				}else if(n<0) {
					x=count;
					break;
				}
			}
		}
		System.out.println(x+1);
	}
}
