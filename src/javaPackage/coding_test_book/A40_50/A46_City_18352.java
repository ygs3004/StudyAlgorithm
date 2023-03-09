package javaPackage.coding_test_book.A40_50;
/*
어떤 나라에는 1번부터 N번까지의 도시와 M개의 단방향 도로가 존재한다. 모든 도로의 거리는 1이다.
이 때 특정한 도시 X로부터 출발하여 도달할 수 있는 모든 도시 중에서, 최단 거리가 정확히 K인 모든 도시들의 번호를 출력하는 프로그램을 작성하시오.
또한 출발 도시 X에서 출발 도시 X로 가는 최단 거리는 항상 0이라고 가정한다.
예를 들어 N=4, K=2, X=1일 때 다음과 같이 그래프가 구성되어 있다고 가정하자.
https://www.acmicpc.net/problem/18352 사진 참조
이 때 1번 도시에서 출발하여 도달할 수 있는 도시 중에서, 최단 거리가 2인 도시는 4번 도시 뿐이다.  2번과 3번 도시의 경우, 최단 거리가 1이기 때문에 출력하지 않는다.

입력
첫째 줄에 도시의 개수 N, 도로의 개수 M, 거리 정보 K, 출발 도시의 번호 X가 주어진다. (2 ≤ N ≤ 300,000, 1 ≤ M ≤ 1,000,000, 1 ≤ K ≤ 300,000, 1 ≤ X ≤ N)
둘째 줄부터 M개의 줄에 걸쳐서 두 개의 자연수 A, B가 공백을 기준으로 구분되어 주어진다. 이는 A번 도시에서 B번 도시로 이동하는 단방향 도로가 존재한다는 의미다.
(1 ≤ A, B ≤ N) 단, A와 B는 서로 다른 자연수이다.

출력
X로부터 출발하여 도달할 수 있는 도시 중에서, 최단 거리가 K인 모든 도시의 번호를 한 줄에 하나씩 오름차순으로 출력한다.
이 때 도달할 수 있는 도시 중에서, 최단 거리가 K인 도시가 하나도 존재하지 않으면 -1을 출력한다.

예제 입력 1
4 4 2 1
1 2
1 3
2 3
2 4
예제 출력 1
4
예제 입력 2
4 3 2 1
1 2
1 3
1 4
예제 출력 2
-1
예제 입력 3
4 4 1 1
1 2
1 3
2 3
2 4
예제 출력 3
2
3
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class A46_City_18352 {

    static ArrayList<Integer>[] infoAll;
    static int[] visited;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int city = Integer.parseInt(st.nextToken());
        int info = Integer.parseInt(st.nextToken());
        int range = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());
        infoAll = new ArrayList[city+1];
        visited = new int[city+1];

        for(int i=0; i<=city; i++){
            infoAll[i] = new ArrayList<>();
        }

        for(int i=0; i<info; i++){
            st = new StringTokenizer(br.readLine());
            int sCity = Integer.parseInt(st.nextToken());
            int eCity = Integer.parseInt(st.nextToken());

            infoAll[sCity].add(eCity);
        }
        BFS(start);

        ArrayList<Integer> result = new ArrayList<>();
        for(int i=0; i<visited.length; i++){
            if(visited[i]==range){
                result.add(i);
            }
        }

        Collections.sort(result);

        if(result.size()==0) {
            System.out.println(-1);
        }else{
            for(int i : result){
                System.out.println(i);
            }
        }
    }

    public static void BFS(int sCity){

        Queue<Integer> que = new LinkedList<>();
        que.add(sCity);
        visited[sCity] = 0;
        while(!que.isEmpty()){
            int now = que.poll();
            for(int i : infoAll[now]){
                if(i==sCity) continue; // 시작지점으로 돌아갈경우 visited[i] 즉 거리가 0으로 되있어서 또 간다
                if(visited[i] == 0){
                    visited[i] = visited[now]+1;
                    que.add(i);
                }
            }
        }
    }

}
