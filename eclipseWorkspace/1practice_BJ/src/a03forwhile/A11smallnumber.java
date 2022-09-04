package a03forwhile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
  정수 N개로 이루어진 수열 A와 정수 X가 주어진다. 이때, A에서 X보다 작은 수를 모두 출력하는 프로그램을 작성하시오.
  X보다 작은 수를 입력받은 순서대로 공백으로 구분해 출력한다. X보다 작은 수는 적어도 하나 존재한다.
	ex)입력						출력
	10 5						1 4 2 3
	1 10 4 9 2 3 8 5 7 6
 */
public class A11smallnumber {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		List<Integer> list = new ArrayList<Integer>();
		for(int i=0; i<n; i++){
			int b = Integer.parseInt(st.nextToken());
			if(b<x) {
				list.add(b);	
			}
		}
		
		for(int i=0; i<list.size(); i++) {
			sb.append(list.get(i)).append(" ");
		}
		
		br.close();
	}
}

// 배열을 만들 필요가 없음...