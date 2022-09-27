package a21_30;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
문제
방향 없는 그래프가 주어졌을 때, 연결 요소 (Connected Component)의 개수를 구하는 프로그램을 작성하시오.
입력
첫째 줄에 정점의 개수 N과 간선의 개수 M이 주어진다. (1 ≤ N ≤ 1,000, 0 ≤ M ≤ N×(N-1)/2) 
둘째 줄부터 M개의 줄에 간선의 양 끝점 u와 v가 주어진다. (1 ≤ u, v ≤ N, u ≠ v) 같은 간선은 한 번만 주어진다.
6 5
1 2
2 5
5 1
3 4
4 6 
-> 2
6 8
1 2
2 5
5 1
3 4
4 6
5 4
2 4
2 3
->1
s*/
public class A23_DepthFirstSearch_11724 {
	static ArrayList<Integer>[] A;
	static boolean[] check;
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int count=0;
		A=new ArrayList[n+1];
		check=new boolean[n+1];
		for(int i=0; i<=n; i++) {
			A[i]=new ArrayList<Integer>();
		}
		for(int i=0; i<m; i++) {
			st=new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			A[s].add(e);
			A[e].add(s);
		}
		
		for(int i=1; i<=n; i++) {
			if(check[i]!=true) {
				dfs(i);
				count++;
			}
		}
		
		System.out.println(count);
		
	}
	
	public static void dfs(int i) {
		if(check[i]==true) {
			return;
		}else {
			check[i]=true;
			for(int a : A[i]) {
				if(check[a]==false)
				dfs(a);
			}
		}
	}
}