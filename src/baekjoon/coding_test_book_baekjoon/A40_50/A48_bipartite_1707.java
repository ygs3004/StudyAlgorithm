package baekjoon.coding_test_book_baekjoon.A40_50;
/*
그래프의 정점의 집합을 둘로 분할하여, 각 집합에 속한 정점끼리는 서로 인접하지 않도록 분할할 수 있을 때,
그러한 그래프를 특별히 이분 그래프 (Bipartite Graph) 라 부른다.
그래프가 입력으로 주어졌을 때, 이 그래프가 이분 그래프인지 아닌지 판별하는 프로그램을 작성하시오.

입력
입력은 여러 개의 테스트 케이스로 구성되어 있는데, 첫째 줄에 테스트 케이스의 개수 K가 주어진다.
각 테스트 케이스의 첫째 줄에는 그래프의 정점의 개수 V와 간선의 개수 E가 빈 칸을 사이에 두고 순서대로 주어진다.
각 정점에는 1부터 V까지 차례로 번호가 붙어 있다. 이어서 둘째 줄부터 E개의 줄에 걸쳐 간선에 대한 정보가 주어지는데,
각 줄에 인접한 두 정점의 번호 u, v (u ≠ v)가 빈 칸을 사이에 두고 주어진다.

출력
K개의 줄에 걸쳐 입력으로 주어진 그래프가 이분 그래프이면 YES, 아니면 NO를 순서대로 출력한다.

제한
2 ≤ K ≤ 5
1 ≤ V ≤ 20,000
1 ≤ E ≤ 200,000
예제 입력 1
2
3 2
1 3
2 3
4 4
1 2
2 3
3 4
4 2
예제 출력 1
YES
NO

1
5 4
1 2
3 4
4 5
5 3
-> No
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class A48_bipartite_1707 {
    static boolean[] visited;
    static int[] group;
    static ArrayList<Integer>[] info;
    static boolean isYes;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int k = Integer.parseInt(br.readLine());

        for(int testCase=0; testCase<k; testCase++){ // 테스트 CASE 수만큼 반복

            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken()); // 노드 개수
            int e = Integer.parseInt(st.nextToken()); // 에지 개수

            info = new ArrayList[v+1];
            visited = new boolean[v+1];
            group = new int[v+1];

            for(int i=0; i<v+1; i++){
                info[i] = new ArrayList<>();
            }

            for(int i=0; i<e; i++){
                st = new StringTokenizer(br.readLine());
                int sNode = Integer.parseInt(st.nextToken());
                int eNode = Integer.parseInt(st.nextToken());
                info[sNode].add(eNode);
                info[eNode].add(sNode);
            }

            isYes = true;
            for(int i=1; i<=v; i++){
                if(isYes){
                    dfs(i);
                }else{
                    break;
                }
            }

            if(isYes) bw.write("YES\n");
            else bw.write("NO\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int node){
        visited[node] = true;
        ArrayList<Integer> thisNode = info[node];
        for(int i=0; i<thisNode.size(); i++){
            int connect = thisNode.get(i);
            if(!visited[connect]){
                if(group[node]==0) group[connect]=1;
                else group[connect] =0;
                dfs(connect);
            }else{
                if(group[connect]==group[node])
                    isYes = false;
            }
        }

    }

}