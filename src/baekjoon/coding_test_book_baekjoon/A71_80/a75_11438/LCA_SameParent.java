package baekjoon.coding_test_book_baekjoon.A71_80.a75_11438;
/* 트리, 최소 공통 조상, 점화식 이용(빠른 방법)
N(2 ≤ N ≤ 100,000)개의 정점으로 이루어진 트리가 주어진다. 트리의 각 정점은 1번부터 N번까지 번호가 매겨져 있으며, 루트는 1번이다.
두 노드의 쌍 M(1 ≤ M ≤ 100,000)개가 주어졌을 때, 두 노드의 가장 가까운 공통 조상이 몇 번인지 출력한다.

입력
첫째 줄에 노드의 개수 N이 주어지고, 다음 N-1개 줄에는 트리 상에서 연결된 두 정점이 주어진다.
그 다음 줄에는 가장 가까운 공통 조상을 알고싶은 쌍의 개수 M이 주어지고, 다음 M개 줄에는 정점 쌍이 주어진다.

출력
M개의 줄에 차례대로 입력받은 두 정점의 가장 가까운 공통 조상을 출력한다.

예제 입력 1
15
1 2
1 3
2 4
3 7
6 2
3 8
4 9
2 5
5 11
7 13
10 4
11 15
12 5
14 7
6
6 11
10 9
2 6
7 6
8 13
8 15
예제 출력 1
2
4
2
1
3
1
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class LCA_SameParent {

    static ArrayList<Integer>[] tree;
    static int[] depth;
    static int kmax;
    static int[][] parent;
    static boolean[] visited;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        tree = new ArrayList[n+1];
        depth = new int[n+1];
        visited = new boolean[n+1];

        for(int i=1; i<=n; i++){
            tree[i] = new ArrayList<>();
        }
        // 접 리스트에 그래프 데이터 저장하기
        for(int i=0; i<n-1; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            tree[s].add(e);
            tree[e].add(s);
        }

        int temp = 1;
        kmax = 0;
        while(temp<=n){
            temp <<= 1; // 비트 쉬프트 연산자 2의 k승 형태로 이동
            kmax++;
        }
        parent = new int[kmax+1][n+1]; // 부모 조상을 2의 k승의 형태로 나타남
        bfs(1); // bfs 이용 depth 구하기
        for(int k=1; k<=kmax; k++){
            for(int i=1; i<=n; i++){
                parent[k][i] = parent[k-1][parent[k-1][i]]; // 조상 점화식 이용 parent 배열의 k값 저장(bfs를 통해 k값을 제외한 일반 부모노드는 저장되어있음)
            }
        }

        int m = Integer.parseInt(br.readLine());
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int lca = excuteLCA(a, b);
            bw.write(lca+"\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static int excuteLCA(int a, int b){
        if(depth[a] > depth[b]){
            int temp = a;
            a = b;
            b = temp;
        }

        for(int k =kmax; k>=0; k--){ // depth 빠르게 맞추기
            if(Math.pow(2, k) <= depth[b]-depth[a]){
                if(depth[a] <= depth[parent[k][b]]){
                    b=parent[k][b];
                }
            }
        }
        // 조상 빠르게 찾기
        for(int k=kmax; k>=0 && a!=b; k--){
            if(parent[k][a] != parent[k][b]){
                a = parent[k][a];
                b = parent[k][b];
            }
        }
        int lca = a;
        if(a != b)
            lca = parent[0][lca];

        return lca;
    }

    private static void bfs(int node) {
        Queue<Integer> que = new LinkedList<>();
        que.add(node);
        visited[node] = true;
        int level = 1;
        int now_size = 1;
        int count = 0;
        while(!que.isEmpty()){
            int now = que.poll();
            for(int next : tree[now]){
                if(!visited[next]){
                    visited[next] = true;
                    que.add(next);
                    parent[0][next] = now; //부모노드 저장
                    depth[next] = level; //깊이 저장
                }
            }
            count++;
            if(count == now_size){
                count = 0;
                now_size = que.size();
                level++;
            }
        }
    }

}