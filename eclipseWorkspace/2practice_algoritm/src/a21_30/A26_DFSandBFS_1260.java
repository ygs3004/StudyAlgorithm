package a21_30;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
문제
그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램을 작성하시오. 단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고, 
더 이상 방문할 수 있는 점이 없는 경우 종료한다. 정점 번호는 1번부터 N번까지이다.
입력
첫째 줄에 정점의 개수 N(1 ≤ N ≤ 1,000), 간선의 개수 M(1 ≤ M ≤ 10,000), 탐색을 시작할 정점의 번호 V가 주어진다. 
다음 M개의 줄에는 간선이 연결하는 두 정점의 번호가 주어진다. 어떤 두 정점 사이에 여러 개의 간선이 있을 수 있다. 입력으로 주어지는 간선은 양방향이다.
출력
첫째 줄에 DFS를 수행한 결과를, 그 다음 줄에는 BFS를 수행한 결과를 출력한다. V부터 방문된 점을 순서대로 출력하면 된다.
ex)
4 5 1
1 2
1 3
1 4
2 4
3 4
->
1 2 4 3
1 2 3 4

5 5 3
5 4
5 2
1 2
3 4
3 1
->
3 1 2 5 4
3 1 4 2 5

1000 1 1000
999 1000
->
1000 999
1000 999
*/

public class A26_DFSandBFS_1260 {
	
	static ArrayList<Integer> [] A;
	static boolean visited[];
	static BufferedWriter bw;
	static Queue<Integer> que = new LinkedList<>();
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		
		A = new ArrayList[n+1];
		
		for(int i=0; i<n+1; i++) {
			A[i]=new ArrayList<Integer>();
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			A[s].add(e);
			A[e].add(s);
		}
		for(int i=0; i<n+1; i++) {
			Collections.sort(A[i]);
		}
		
		visited = new boolean[n+1];
		dfs(l);
		
		bw.write("\n");
		
		visited = new boolean[n+1];
		bfs(l);
		
		br.close();
		bw.flush();
		bw.close();
	}

	public static void dfs(int l) throws Exception {
		if(visited[l]==true) return;
		bw.write(l+" ");
		visited[l]=true;
		
		for(int a : A[l]){
			dfs(a);
		}
		
	}
	
	public static void bfs(int l) throws Exception {
		que.add(l);
		visited[l]=true;
		while(!que.isEmpty()) {
			int first = que.peek();
			for(int a: A[first]) {
				if(visited[a]==false) {
					que.add(a);
					visited[a]=true;
				}
			}
			bw.write(que.poll()+" ");	
		}
	}
}