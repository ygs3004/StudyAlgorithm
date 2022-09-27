package a21_30;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
문제
트리의 지름이란, 트리에서 임의의 두 점 사이의 거리 중 가장 긴 것을 말한다. 트리의 지름을 구하는 프로그램을 작성하시오.

입력
트리가 입력으로 주어진다. 먼저 첫 번째 줄에서는 트리의 정점의 개수 V가 주어지고 (2 ≤ V ≤ 100,000)
둘째 줄부터 V개의 줄에 걸쳐 간선의 정보가 다음과 같이 주어진다. 정점 번호는 1부터 V까지 매겨져 있다.
먼저 정점 번호가 주어지고, 이어서 연결된 간선의 정보를 의미하는 정수가 두 개씩 주어지는데, 하나는 정점번호, 
다른 하나는 그 정점까지의 거리이다. 예를 들어 네 번째 줄의 경우 정점 3은 정점 1과 거리가 2인 간선으로 연결되어 있고, 
정점 4와는 거리가 3인 간선으로 연결되어 있는 것을 보여준다. 각 줄의 마지막에는 -1이 입력으로 주어진다. 
주어지는 거리는 모두 10,000 이하의 자연수이다.

출력
첫째 줄에 트리의 지름을 출력한다.
ex) 
5
1 3 2 -1
2 4 4 -1
3 1 2 4 3 -1
4 2 4 3 3 5 6 -1
5 4 6 -1
->11

3
1 2 1 -1
2 1 1 3 1 -1
3 2 1 -1
-> 2
*/
public class A28_TreeRadius_1167 {
	static ArrayList<Node>[] point;
	static boolean visited[];
	static int distance[];

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int p = Integer.parseInt(br.readLine());
		point = new ArrayList[p+1];
		
		StringTokenizer st;
		
		for(int i=0; i<p; i++) {
			st = new StringTokenizer(br.readLine());
			ArrayList<Node> node=new ArrayList<>();
			int headP = Integer.parseInt(st.nextToken());
			int connectP;
			while((connectP = Integer.parseInt(st.nextToken()))!=-1) {
				int distanceP = Integer.parseInt(st.nextToken());
				node.add(new Node(connectP, distanceP));
			}
			point[headP] = node;
		}
		
		visited = new boolean[p+1];
		distance = new int[p+1];
		dfs(1);
		int maxD=0;
		int maxIdx=0;
		for(int i=1; i<=p; i++) {
			if(distance[i]>maxD) {
				maxD=distance[i];
				maxIdx=i;
			}
		}
		
		visited = new boolean[p+1];
		distance = new int[p+1];
		dfs(maxIdx);
		maxD=0;
		for(int i=1; i<=p; i++) {
			if (distance[i]>maxD) maxD=distance[i]; 
		}
		
		System.out.println(maxD);
		br.close();
	}
	
	
	public static void dfs(int p) {
		if(visited[p]==true) return;
		visited[p] = true;
		if(point[p].size()==0) return;
		int nowDistance;
		for(Node n : point[p]) {
			if(visited[n.point]==true) continue;
			nowDistance=distance[p];
			nowDistance+=n.distance;
			distance[n.point] = nowDistance;
			dfs(n.point);
		}
	}

}


class Node{
	int point;
	int distance;
	
	Node(int point, int distance){
		this.point = point;
		this.distance = distance;
	}
}