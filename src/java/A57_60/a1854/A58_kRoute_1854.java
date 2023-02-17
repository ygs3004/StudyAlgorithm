package java.A57_60.a1854;
/*
봄캠프를 마친 김진영 조교는 여러 도시를 돌며 여행을 다닐 계획이다. 그런데 김 조교는,
'느림의 미학'을 중요시하는 사람이라 항상 최단경로로만 이동하는 것은 별로 좋아하지 않는다.
하지만 너무 시간이 오래 걸리는 경로도 그리 매력적인 것만은 아니어서, 적당한 타협안인 'k번째 최단경로'를 구하길 원한다. 그를 돕기 위한 프로그램을 작성해 보자.

입력
첫째 줄에 n, m, k가 주어진다. (1 ≤ n ≤ 1000, 0 ≤ m ≤ 2000000, 1 ≤ k ≤ 100) n과 m은 각각 김 조교가
여행을 고려하고 있는 도시들의 개수와, 도시 간에 존재하는 도로의 수이다.
이어지는 m개의 줄에는 각각 도로의 정보를 제공하는 세 개의 정수 a, b, c가 포함되어 있다.
이것은 a번 도시에서 b번 도시로 갈 때는 c의 시간이 걸린다는 의미이다. (1 ≤ a, b ≤ n. 1 ≤ c ≤ 1000)
도시의 번호는 1번부터 n번까지 연속하여 붙어 있으며, 1번 도시는 시작도시이다.

출력
n개의 줄을 출력한다. i번째 줄에 1번 도시에서 i번 도시로 가는 k번째 최단경로의 소요시간을 출력한다.

경로의 소요시간은 경로 위에 있는 도로들을 따라 이동하는데 필요한 시간들의 합이다. i번 도시에서 i번 도시로 가는 최단경로는 0이지만,
일반적인 k번째 최단경로는 0이 아닐 수 있음에 유의한다. 또, k번째 최단경로가 존재하지 않으면 -1을 출력한다. 최단경로에 같은 정점이 여러 번 포함되어도 된다.

예제 입력 1
5 10 2
1 2 2
1 3 7
1 4 5
1 5 6
2 4 2
2 3 4
3 4 6
3 5 8
5 2 4
5 4 1
예제 출력 1
-1
10
7
5
14
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class A58_kRoute_1854 {

    static final int INF = 999999999;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] w = new int[n+1][n+1];

        PriorityQueue<Integer>[] disQ = new PriorityQueue[n+1];
        Comparator<Integer> reverse = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        };

        for(int i=0; i<=n; i++){
            disQ[i] = new PriorityQueue<>(k, reverse); // k 크기의, reverse 규칙을 갖는 우선순위큐
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            w[s][e] = v;
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(1, 0));
        disQ[1].add(0);
        while(!pq.isEmpty()){
            Node now = pq.poll();
            for(int next=1; next<=n; next++) {
                if (w[now.target][next] != 0) {
                    if (disQ[next].size() < k) { // 해당 경로까지 k 개가 저장 되지 않았을 경우
                        disQ[next].add(now.val + w[now.target][next]);
                        pq.add(new Node(next, now.val + w[now.target][next]));
                    } else if (disQ[next].peek() > now.val + w[now.target][next]) { // K 번째 경로보다 작은 값만 경로에 넣어 Que 관리
                        disQ[next].poll(); // k 사이즈므로 값 제거
                        disQ[next].add(now.val + w[now.target][next]);
                        pq.add(new Node(next, now.val + w[now.target][next]));
                    }
                }
            }
        }

        for(int i=1; i<=n; i++){
            if(disQ[i].size()==k){ // 해당 지점까지 가는 경우의 수가 k개 이상일 경우
                bw.write(disQ[i].peek()+"\n");
            }else{
                bw.write("-1\n");
            }
        }

        bw.flush();
        br.close();
        bw.close();

    }

}

class Node implements Comparable<Node>{

    int target;
    int val;

    Node(int target, int val){
        this.target=target;
        this.val=val;
    }

    @Override
    public int compareTo(Node o) {
        return val-o.val;
    }
}