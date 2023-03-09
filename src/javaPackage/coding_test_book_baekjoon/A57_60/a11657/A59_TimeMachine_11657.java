package javaPackage.coding_test_book_baekjoon.A57_60.a11657;
/*
N개의 도시가 있다. 그리고 한 도시에서 출발하여 다른 도시에 도착하는 버스가 M개 있다.
각 버스는 A, B, C로 나타낼 수 있는데, A는 시작도시, B는 도착도시, C는 버스를 타고 이동하는데 걸리는 시간이다. 시간 C가 양수가 아닌 경우가 있다.
C = 0인 경우는 순간 이동을 하는 경우, C < 0인 경우는 타임머신으로 시간을 되돌아가는 경우이다.
1번 도시에서 출발해서 나머지 도시로 가는 가장 빠른 시간을 구하는 프로그램을 작성하시오.
입력
첫째 줄에 도시의 개수 N (1 ≤ N ≤ 500), 버스 노선의 개수 M (1 ≤ M ≤ 6,000)이 주어진다.
둘째 줄부터 M개의 줄에는 버스 노선의 정보 A, B, C (1 ≤ A, B ≤ N, -10,000 ≤ C ≤ 10,000)가 주어진다.

출력
만약 1번 도시에서 출발해 어떤 도시로 가는 과정에서 시간을 무한히 오래 전으로 되돌릴 수 있다면 첫째 줄에 -1을 출력한다.
그렇지 않다면 N-1개 줄에 걸쳐 각 줄에 1번 도시에서 출발해 2번 도시, 3번 도시, ..., N번 도시로 가는 가장 빠른 시간을 순서대로 출력한다.
만약 해당 도시로 가는 경로가 없다면 대신 -1을 출력한다.

예제 입력 1
3 4
1 2 4
1 3 3
2 3 -1
3 1 -2
예제 출력 1
4
3
예제 입력 2
3 4
1 2 4
1 3 3
2 3 -4
3 1 -2
예제 출력 2
-1
예제 입력 3
3 2
1 2 4
1 2 3
예제 출력 3
3
-1
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class A59_TimeMachine_11657 {

    static Edge[] edges;
    static long distance[];
    static int inf = 999999999;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        edges = new Edge[m+1];
        distance = new long[n+1];
        for(int i=0; i<n+1; i++){
            distance[i] = inf;
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(start, end, time);
        }

        distance[1] = 0;
        for(int i=1; i<n; i++){ // 최단 거리 배열 업데이트 n회 시행
            for(int j=0; j<m; j++){ // m개의 edge에 대한 최단 거리 배열 업데이트 1회
                Edge edge = edges[j];

                if(distance[edge.start] != inf && distance[edge.end]>distance[edge.start]+edge.time){
                    distance[edge.end] = distance[edge.start] + edge.time;
                }
            }
        }

        boolean mCycle = false;

        for(int i=0; i<m; i++){
            Edge edge = edges[i];
            if(distance[edge.start] != inf && distance[edge.end] > distance[edge.start]+ edge.time){
                mCycle = true; // 엣지에 마이너스가 있음
            }
        }

        if(!mCycle){ // 음의 사이클이 없음
            for(int i=2; i<=n; i++){
                if(distance[i]== inf)
                    System.out.println("-1");
                else
                    System.out.println(distance[i]);
            }
        }else{ // 음의 사이클이 있을때
            System.out.println("-1");
        }
    }

}


class Edge{

    int start;
    int end;
    int time;
    Edge(){}

    Edge(int start, int end, int time) {
        this.start = start;
        this.end = end;
        this.time = time;
    }
}