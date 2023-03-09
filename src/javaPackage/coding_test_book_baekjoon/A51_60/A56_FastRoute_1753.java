package javaPackage.coding_test_book_baekjoon.A51_60;
/*
문제
방향그래프가 주어지면 주어진 시작점에서 다른 모든 정점으로의 최단 경로를 구하는 프로그램을 작성하시오. 단, 모든 간선의 가중치는 10 이하의 자연수이다.

입력
첫째 줄에 정점의 개수 V와 간선의 개수 E가 주어진다. (1 ≤ V ≤ 20,000, 1 ≤ E ≤ 300,000) 모든 정점에는 1부터 V까지 번호가 매겨져 있다고 가정한다.
둘째 줄에는 시작 정점의 번호 K(1 ≤ K ≤ V)가 주어진다. 셋째 줄부터 E개의 줄에 걸쳐 각 간선을 나타내는 세 개의 정수 (u, v, w)가 순서대로 주어진다.
이는 u에서 v로 가는 가중치 w인 간선이 존재한다는 뜻이다. u와 v는 서로 다르며 w는 10 이하의 자연수이다. 서로 다른 두 정점 사이에 여러 개의 간선이 존재할 수도 있음에 유의한다.

출력
첫째 줄부터 V개의 줄에 걸쳐, i번째 줄에 i번 정점으로의 최단 경로의 경로값을 출력한다. 시작점 자신은 0으로 출력하고, 경로가 존재하지 않는 경우에는 INF를 출력하면 된다.

예제 입력 1
5 6
1
5 1 1
1 2 2
1 3 3
2 3 4
2 4 5
3 4 6
예제 출력 1
0
2
3
7
INF
------------------
4 5
1
1 3 2
3 2 4
1 4 2
4 2 1
1 3 5

0
3
2
2
------
4 4
1
1 2 10
1 3 1
3 2 1
2 4 1

0
2
1
3
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class A56_FastRoute_1753 {

    public static void main(String[] args) throws Exception {

        int infinite = 999999999;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine());
        int[] range = new int[n+1];
        boolean[] visited = new boolean[n+1];
        ArrayList<Node>[] node = new ArrayList[n+1];

        for(int i=0; i<=n; i++){
            node[i] = new ArrayList<>();
            range[i] = infinite;
        }
        range[start]=0;
        visited[start] = true;
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            node[s].add(new Node(e, v));
        }
/* 시간 초과
        Queue<Integer> que = new LinkedList<>();
        que.add(start);

        while(!que.isEmpty()){
            int now = que.poll();
            for(Node next:node[now]){
                if(range[next.target] > range[now]+next.val){
                    range[next.target] = range[now]+next.val;
                    que.add(next.target);
                    continue;
                }
                if(!visited[next.target]) {
                    visited[next.target] = true;
                    que.add(next.target);
                }
            }
        }
*/
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        while(!pq.isEmpty()){
            Node now = pq.poll();
            int current = now.target;
            for(int i=0; i<node[current].size(); i++){
                Node tmp = node[current].get(i);
                int next = tmp.target;
                int value = tmp.val;
                if(range[next] > range[current]+value){
                    range[next] = range[current]+value;
                    pq.add(new Node(next, range[next]));
                }
            }
        }

        for(int i=1; i<=n; i++){
            if(range[i]!=infinite){
                bw.write(range[i]+"\n");
            }else{
                bw.write("INF\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

}

class Node implements Comparable<Node>{

    int target;
    int val;

    Node(int target, int val){
        this.target=target;
        this.val=val;
    }

    public int compareTo(Node n){
        if(this.val > n.val) return 1;
        else return -1;
    }
}