package solved_class1.solved_class2;
/*
한수는 지금 (x, y)에 있다. 직사각형은 각 변이 좌표축에 평행하고, 왼쪽 아래 꼭짓점은 (0, 0), 오른쪽 위 꼭짓점은 (w, h)에 있다.
직사각형의 경계선까지 가는 거리의 최솟값을 구하는 프로그램을 작성하시오.
1 ≤ w, h ≤ 1,000
1 ≤ x ≤ w-1
1 ≤ y ≤ h-1
x, y, w, h는 정수

첫째 줄에 x, y, w, h가 주어진다.
ex)
6 2 10 3 -> 1
1 1 5 5 -> 1
653 375 1000 1000 -> 347
161 181 762 375 -> 161
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class A01_SquareEscape_1085 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int x= Integer.parseInt(st.nextToken());
		int y= Integer.parseInt(st.nextToken());
		int w= Integer.parseInt(st.nextToken());
		int h= Integer.parseInt(st.nextToken());
		
		int a = w-x < x ? w-x : x; // x축 가까운 거리
		int b = h-y < y ? h-y : y; // y축 가까운 거리
		
		if(a>b) bw.write(Integer.toString(b));
		else bw.write(Integer.toString(a));

		bw.flush();
		bw.close();
		br.close();
	}

}
