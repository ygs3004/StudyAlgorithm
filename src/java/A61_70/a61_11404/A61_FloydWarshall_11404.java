package java.A61_70.a61_11404;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
문제
n(2 ≤ n ≤ 100)개의 도시가 있다. 그리고 한 도시에서 출발하여 다른 도시에 도착하는 m(1 ≤ m ≤ 100,000)개의 버스가 있다.
각 버스는 한 번 사용할 때 필요한 비용이 있다.
모든 도시의 쌍 (A, B)에 대해서 도시 A에서 B로 가는데 필요한 비용의 최솟값을 구하는 프로그램을 작성하시오.

입력
첫째 줄에 도시의 개수 n이 주어지고 둘째 줄에는 버스의 개수 m이 주어진다. 그리고 셋째 줄부터 m+2줄까지 다음과 같은 버스의 정보가 주어진다.
먼저 처음에는 그 버스의 출발 도시의 번호가 주어진다. 버스의 정보는 버스의 시작 도시 a, 도착 도시 b, 한 번 타는데 필요한 비용 c로 이루어져 있다.
시작 도시와 도착 도시가 같은 경우는 없다. 비용은 100,000보다 작거나 같은 자연수이다.
시작 도시와 도착 도시를 연결하는 노선은 하나가 아닐 수 있다.

출력
n개의 줄을 출력해야 한다. i번째 줄에 출력하는 j번째 숫자는 도시 i에서 j로 가는데 필요한 최소 비용이다. 만약, i에서 j로 갈 수 없는 경우에는 그 자리에 0을 출력한다.

예제 입력 1
5
14
1 2 2
1 3 3
1 4 1
1 5 10
2 4 2
3 4 1
3 5 1
4 5 3
3 5 10
3 1 8
1 4 2
5 1 7
3 4 2
5 2 4
예제 출력 1
0 2 3 1 4
12 0 15 2 5
8 5 0 1 1
10 7 13 0 3
7 4 10 6 0
*/
public class A61_FloydWarshall_11404 {
    //플로이드
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int inf = 999999999;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[][] price = new int[n+1][n+1];

        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(i==j)
                    price[i][j] = 0;
                else
                    price[i][j] = inf;
            }
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            if(price[s][e]>v) price[s][e] = v;
        }

        for(int k=1; k<=n; k++){ // 경유지에 관해
            for(int s=1; s<=n; s++){ // 출발점에 관해
                for(int e=1; e<=n; e++){ // 도착점에 관해
                    if(price[s][e] > price[s][k] + price[k][e])
                        price[s][e] = price[s][k] + price[k][e];
                }
            }
        }

        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(price[i][j]==inf) System.out.print("0 ");
                else System.out.print(price[i][j]+" ");
            }
            System.out.println();
        }
    }
}