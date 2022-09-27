package solved_class1.solved_class2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/10250
//6 12 10 -> 402
public class A06_ACMhotel_10250 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int repeat = Integer.parseInt(br.readLine());
		for(int i=0; i<repeat; i++){
			StringTokenizer st;
			st=new StringTokenizer(br.readLine());
			int h = Integer.parseInt(st.nextToken()); // 높이
			st.nextToken(); // 가로
			int n = Integer.parseInt(st.nextToken()); // 몇번째
			int floor = n%h;
			int ho=n/h+1;
			if(n%h==0) {floor = h; ho=n/h;}
			if(h==1) {System.out.println(100+n);}
			else{System.out.println(floor*100 + ho);}
				
		}
		

	}
}