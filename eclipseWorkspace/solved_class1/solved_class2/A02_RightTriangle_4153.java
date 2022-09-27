package solved_class1.solved_class2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
과거 이집트인들은 각 변들의 길이가 3, 4, 5인 삼각형이 직각 삼각형인것을 알아냈다. 주어진 세변의 길이로 삼각형이 직각인지 아닌지 구분하시오.
입력은 여러개의 테스트케이스로 주어지며 마지막줄에는 0 0 0이 입력된다. 각 테스트케이스는 모두 30,000보다 작은 양의 정수로 주어지며, 각 입력은 변의 길이를 의미한다.
6 8 10                           right
25 52 60                         wrong
5 12 13                          right
0 0 0
*/
public class A02_RightTriangle_4153 {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		String str;
		while(!(str=br.readLine()).equals("0 0 0")) {
			st = new StringTokenizer(str);
			
			double a = Math.pow(Double.parseDouble(st.nextToken()), 2);
			double b = Math.pow(Double.parseDouble(st.nextToken()), 2);
			double c = Math.pow(Double.parseDouble(st.nextToken()), 2);
			
			if(a+b==c || b+c==a || c+a==b) {
				sb.append("right"+"\n");
			}else
				sb.append("wrong"+"\n");
		}
		
		System.out.println(sb);
		br.close();
	}

}
