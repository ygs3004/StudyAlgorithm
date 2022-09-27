package a21_30;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
문제
N×M크기의 배열로 표현되는 미로가 있다.

1	0	1	1	1	1
1	0	1	0	1	0
1	0	1	0	1	1
1	1	1	0	1	1

미로에서 1은 이동할 수 있는 칸을 나타내고, 0은 이동할 수 없는 칸을 나타낸다. 
이러한 미로가 주어졌을 때, (1, 1)에서 출발하여 (N, M)의 위치로 이동할 때 지나야 하는 최소의 칸 수를 구하는 프로그램을 작성하시오. 
한 칸에서 다른 칸으로 이동할 때, 서로 인접한 칸으로만 이동할 수 있다.
위의 예에서는 15칸을 지나야 (N, M)의 위치로 이동할 수 있다. 칸을 셀 때에는 시작 위치와 도착 위치도 포함한다.
입력
첫째 줄에 두 정수 N, M(2 ≤ N, M ≤ 100)이 주어진다. 다음 N개의 줄에는 M개의 정수로 미로가 주어진다. 각각의 수들은 붙어서 입력으로 주어진다.
출력
첫째 줄에 지나야 하는 최소의 칸 수를 출력한다. 항상 도착위치로 이동할 수 있는 경우만 입력으로 주어진다.
ex)
4 6
101111
101010
101011
111011
-> 15

4 6
110110
110110
111111
111101
->9

2 25
1011101110111011101110111
1110111011101110111011101
->38

7 7
1011111
1110001
1000001
1000001
1000001
1000001
1111111
->13

3 3
111
001
001
->5
*/

public class A27_Maze_2178 {
	
	static boolean visited[][];
	static Queue<Maze> que=new LinkedList<Maze>();
	static Maze[][] mazeArr;
	static int n;
	static int m;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		mazeArr = new Maze[n][m];
		visited = new boolean[n][m];
		for(int i=0; i<n; i++) {
			String line = br.readLine();
			for(int j=0; j<m; j++) {
				mazeArr[i][j] = new Maze(i, j, Character.getNumericValue(line.charAt(j)));
			}
		}
		
		bfs(mazeArr[0][0]);
	}
	
	public static void bfs(Maze maze) {
		visited[0][0]=true;
		int[][] distance=new int[n][m];
		distance[0][0]=1;
		que.add(maze);
		while(!que.isEmpty()) {
			Maze temp = que.poll();
			if(temp.idxi==n-1 && temp.idxj==m-1) {
				System.out.println(distance[temp.idxi][temp.idxj]); return;
			}
			if(temp.idxi<n-1 && mazeArr[temp.idxi+1][temp.idxj].val==1 && visited[temp.idxi+1][temp.idxj]==false) {
				que.add(mazeArr[temp.idxi+1][temp.idxj]);
				visited[temp.idxi+1][temp.idxj]=true;
				distance[temp.idxi+1][temp.idxj]=distance[temp.idxi][temp.idxj]+1;
			}
			if(temp.idxi>0 && mazeArr[temp.idxi-1][temp.idxj].val==1 && visited[temp.idxi-1][temp.idxj]==false) {
				que.add(mazeArr[temp.idxi-1][temp.idxj]);
				visited[temp.idxi-1][temp.idxj]=true;
				distance[temp.idxi-1][temp.idxj]=distance[temp.idxi][temp.idxj]+1;
			}
			if(temp.idxj<m-1 && mazeArr[temp.idxi][temp.idxj+1].val==1 && visited[temp.idxi][temp.idxj+1]==false) {
				que.add(mazeArr[temp.idxi][temp.idxj+1]);
				visited[temp.idxi][temp.idxj+1]=true;
				distance[temp.idxi][temp.idxj+1]=distance[temp.idxi][temp.idxj]+1;
			}
			if(temp.idxj>0 && mazeArr[temp.idxi][temp.idxj-1].val==1 && visited[temp.idxi][temp.idxj-1]==false) {
				que.add(mazeArr[temp.idxi][temp.idxj-1]);
				visited[temp.idxi][temp.idxj-1]=true;
				distance[temp.idxi][temp.idxj-1]=distance[temp.idxi][temp.idxj]+1;
			}
			
		}
		
	}

}

class Maze{
	int idxi;
	int idxj;
	int val;
	
	Maze(int idxi, int idxj, int val){
		this.idxi=idxi;
		this.idxj=idxj;
		this.val=val;
	}
	
}
