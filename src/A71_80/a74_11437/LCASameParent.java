package A71_80.a74_11437;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/* 트리, 최소 공통 조상 Lowest Common Ancestor
N(2 ≤ N ≤ 50,000)개의 정점으로 이루어진 트리가 주어진다. 트리의 각 정점은 1번부터 N번까지 번호가 매겨져 있으며, 루트는 1번이다.
두 노드의 쌍 M(1 ≤ M ≤ 10,000)개가 주어졌을 때, 두 노드의 가장 가까운 공통 조상이 몇 번인지 출력한다.

입력
첫째 줄에 노드의 개수 N이 주어지고, 다음 N-1개 줄에는 트리 상에서 연결된 두 정점이 주어진다. 그 다음 줄에는 가장 가까운 공통 조상을 알고싶은 쌍의 개수 M이 주어지고, 다음 M개 줄에는 정점 쌍이 주어진다.

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
public class LCASameParent {

    static ArrayList<Integer>[] tree;
    static int[] depth;
    static int[] parent;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        tree = new ArrayList[n+1];

        for(int i=1; i<=n; i++){
            tree[i] = new ArrayList<Integer>();
        }

        for(int i=0; i<n-1; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            tree[s].add(e);
            tree[e].add(s);
        }
        depth = new int[n+1];
        parent = new int[n+1];
        visited = new boolean[n+1];
        bfs(1);

        int m = Integer.parseInt(br.readLine());
        for(int i=0; i<m; i++){
            //공통 조상을 구할 노드
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int lca = excuteLCA(a,b);
            System.out.println(lca);
        }
    }

    private static int excuteLCA(int a, int b){
        if(depth[a] < depth[b]){
            int temp = a;
            a = b;
            b = temp;
        }

        // a가 깊이가 더 깊은 경우로 고정
        while(depth[a] != depth[b]){
            a = parent[a]; // 깊이 맞추기
        }

        //깊이가 같은 상황에서 두 값이 같을때까지 깊이 변경
        while(a != b){
            a = parent[a];
            b = parent[b];;
        }
        return a;
    }

    private static void bfs(int node){
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
                    parent[next] = now;
                    depth[next] = level;
                }
            }
            count++;
            if(count==now_size){
                count = 0;
                now_size = que.size();
                level++;
            }
        }

    }

}