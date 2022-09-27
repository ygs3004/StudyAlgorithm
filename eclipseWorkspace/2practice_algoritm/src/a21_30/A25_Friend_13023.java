package a21_30;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
문제
BOJ 알고리즘 캠프에는 총 N명이 참가하고 있다. 사람들은 0번부터 N-1번으로 번호가 매겨져 있고, 일부 사람들은 친구이다.

오늘은 다음과 같은 친구 관계를 가진 사람 A, B, C, D, E가 존재하는지 구해보려고 한다.

A는 B와 친구다.
B는 C와 친구다.
C는 D와 친구다.
D는 E와 친구다.
위와 같은 친구 관계가 존재하는지 안하는지 구하는 프로그램을 작성하시오.
입력
첫째 줄에 사람의 수 N (5 ≤ N ≤ 2000)과 친구 관계의 수 M (1 ≤ M ≤ 2000)이 주어진다.
둘째 줄부터 M개의 줄에는 정수 a와 b가 주어지며, a와 b가 친구라는 뜻이다. (0 ≤ a, b ≤ N-1, a ≠ b) 같은 친구 관계가 두 번 이상 주어지는 경우는 없다.
출력
문제의 조건에 맞는 A, B, C, D, E가 존재하면 1을 없으면 0을 출력한다.
ex)
5 4
0 1
1 2
2 3
3 4
->1

5 5
0 1
1 2
2 3
3 0
1 4
->1

6 5
0 1
0 2
0 3
0 4
0 5
->0

8 8
1 7
3 7
4 7
3 4
4 6
3 5
0 4
2 7
->1

5 5
1 2
2 4
2 3
3 4
4 5
->1
*/
public class A25_Friend_13023 {
	static ArrayList<Integer>[] friend;
	static boolean[] connected;
	static int count=0;
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		friend = new ArrayList[n+1];
		
		for(int i=0; i<n+1; i++) {
			friend[i]=new ArrayList<Integer>();
		}
		
		for(int i=0; i<m; i++) {
			st=new StringTokenizer(br.readLine());
			int s=Integer.parseInt(st.nextToken());
			int e=Integer.parseInt(st.nextToken());
			friend[s].add(e);
			friend[e].add(s);
		}
		
		for(int i=0; i<n+1; i++ ) {
			connected = new boolean[n+1];
			count=0;
			dfs(i);
		}
		System.out.println(0);
	}
	
	static void dfs(int a) {
		count++;
		if(count==5) {System.out.println(1); System.exit(0);}
		if(connected[a]==true) {count--;return;}
		connected[a]=true;
		for(int i: friend[a]) {
			if(connected[i]==false) {
				dfs(i);
			}
		}
		count--;
		connected[a]=false;
		return;
	}

}
