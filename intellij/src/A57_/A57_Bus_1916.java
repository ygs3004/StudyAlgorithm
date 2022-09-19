package A57_;
/*
N개의 도시가 있다. 그리고 한 도시에서 출발하여 다른 도시에 도착하는 M개의 버스가 있다.
우리는 A번째 도시에서 B번째 도시까지 가는데 드는 버스 비용을 최소화 시키려고 한다.
A번째 도시에서 B번째 도시까지 가는데 드는 최소비용을 출력하여라. 도시의 번호는 1부터 N까지이다.

입력
첫째 줄에 도시의 개수 N(1 ≤ N ≤ 1,000)이 주어지고 둘째 줄에는 버스의 개수 M(1 ≤ M ≤ 100,000)이 주어진다.
그리고 셋째 줄부터 M+2줄까지 다음과 같은 버스의 정보가 주어진다. 먼저 처음에는 그 버스의 출발 도시의 번호가 주어진다.
그리고 그 다음에는 도착지의 도시 번호가 주어지고 또 그 버스 비용이 주어진다. 버스 비용은 0보다 크거나 같고, 100,000보다 작은 정수이다.

그리고 M+3째 줄에는 우리가 구하고자 하는 구간 출발점의 도시번호와 도착점의 도시번호가 주어진다. 출발점에서 도착점을 갈 수 있는 경우만 입력으로 주어진다.

출력
첫째 줄에 출발 도시에서 도착 도시까지 가는데 드는 최소 비용을 출력한다.

예제 입력 1
5
8
1 2 2
1 3 3
1 4 1
1 5 10
2 4 2
3 4 1
3 5 1
4 5 3
1 5
예제 출력 1
4
*/

import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class A57_Bus_1916 {

    static ArrayList<Node>[] list;
    static int[] distance;
    static boolean[] visited;
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        list = new ArrayList[n+1];
        distance = new int[n+1];
        visited = new boolean[n+1];

        for(int i=0; i<=n; i++){
            list[i] = new ArrayList<Node>();
            distance[i] = 999999999;
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            list[s].add(new Node(e,v));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        bw.write(dijkstra(start, end)+"");
        bw.close();
        br.close();
    }

    public static int dijkstra(int start, int end){

        PriorityQueue<Node> pq = new PriorityQueue<>();

        pq.offer(new Node(start,0));
        distance[start] = 0;
        while(!pq.isEmpty()){
            Node nowNode = pq.poll();
            int now = nowNode.target;
            if(!visited[now]) {
                for (Node next : list[now]) {
                    if (distance[next.target] > distance[now] + next.val) {
                        distance[next.target] = distance[now] + next.val;
                        pq.add(new Node(next.target, distance[next.target]));
                    }
                }
            }
        }

        return distance[end];
    }
}

class Node implements Comparable<Node>{

    int target;
    int val;

    Node(int next, int val){
        this.target = next;
        this.val = val;
    }

    @Override
    public int compareTo(Node o) {
        return this.val-o.val;
    }
}