package a04array;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*8
"OOXXOXXOOO"와 같은 OX퀴즈의 결과가 있다. O는 문제를 맞은 것이고, X는 문제를 틀린 것이다. 문제를 맞은 경우 그 문제의 점수는 그 문제까지 연속된 O의 개수가 된다. 예를 들어, 10번 문제의 점수는 3이 된다.
"OOXXOXXOOO"의 점수는 1+2+0+0+1+0+0+1+2+3 = 10점이다.
OX퀴즈의 결과가 주어졌을 때, 점수를 구하는 프로그램을 작성하시오.
ex)
5
OOXXOXXOOO			10
OOXXOOXXOO			9
OXOXOXOXOXOXOX		7
OOOOOOOOOO			55
OOOOXOOOOXOOOOX		30
*/
public class A05_OXquiz {

	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int totalP=0;
		int p=0;

		for(int i=0; i<n; i++) {
			String str = br.readLine();
			for(int j=0; j<str.length(); j++) {
				if(str.charAt(j)=='O') {
					p++;
					totalP+=p;
				}else {
					p=0;
				}
			}
			System.out.println(totalP);
			totalP=0;
			p=0;
		}
		
	}

}
