package baekjoon.coding_test_book_baekjoon.A57_60.a1219;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
오민식은 세일즈맨이다. 오민식의 회사 사장님은 오민식에게 물건을 최대한 많이 팔아서 최대 이윤을 남기라고 했다.
오민식은 고민에 빠졌다.어떻게 하면 최대 이윤을 낼 수 있을까?
이 나라에는 N개의 도시가 있다. 도시는 0번부터 N-1번까지 번호 매겨져 있다. 오민식의 여행은 A도시에서 시작해서 B도시에서 끝난다.
오민식이 이용할 수 있는 교통수단은 여러 가지가 있다. 오민식은 모든 교통수단의 출발 도시와 도착 도시를 알고 있고, 비용도 알고 있다.
게다가, 오민식은 각각의 도시를 방문할 때마다 벌 수 있는 돈을 알고있다. 이 값은 도시마다 다르며, 액수는 고정되어있다. 또, 도시를 방문할 때마다 그 돈을 벌게 된다.
오민식은 도착 도시에 도착할 때, 가지고 있는 돈의 액수를 최대로 하려고 한다. 이 최댓값을 구하는 프로그램을 작성하시오.
오민식이 버는 돈보다 쓰는 돈이 많다면, 도착 도시에 도착할 때 가지고 있는 돈의 액수가 음수가 될 수도 있다. 또, 같은 도시를 여러 번 방문할 수 있으며,
그 도시를 방문할 때마다 돈을 벌게 된다. 모든 교통 수단은 입력으로 주어진 방향으로만 이용할 수 있으며, 여러 번 이용할 수도 있다.


입력
첫째 줄에 도시의 수 N과 시작 도시, 도착 도시 그리고 교통 수단의 개수 M이 주어진다. 둘째 줄부터 M개의 줄에는 교통 수단의 정보가 주어진다.
교통 수단의 정보는 “시작 끝 가격”과 같은 형식이다. 마지막 줄에는 오민식이 각 도시에서 벌 수 있는 돈의 최댓값이 0번 도시부터 차례대로 주어진다.
N과 M은 50보다 작거나 같고, 돈의 최댓값과 교통 수단의 가격은 1,000,000보다 작거나 같은 음이 아닌 정수이다.


출력
첫째 줄에 도착 도시에 도착할 때, 가지고 있는 돈의 액수의 최댓값을 출력한다. 만약 오민식이 도착 도시에 도착하는 것이 불가능할 때는 "gg"를 출력한다.
그리고, 오민식이 도착 도시에 도착했을 때 돈을 무한히 많이 가지고 있을 수 있다면 "Gee"를 출력한다.


예제 입력 1

5 0 4 7
0 1 13
1 2 17
2 4 20
0 3 22
1 3 4747
2 0 10
3 4 10
0 0 0 0 0
예제 출력 1
-32

예제 입력 2
5 0 4 5
0 1 10
1 2 10
2 3 10
3 1 10
2 4 10
0 10 10 110 10
예제 출력 2
Gee

예제 입력 3
3 0 2 3
0 1 10
1 0 10
2 1 10
1000 1000 47000
예제 출력 3
gg

예제 입력 4
2 0 1 2
0 1 1000
1 1 10
11 11
예제 출력 4
Gee

예제 입력 5
1 0 0 1
0 0 10
7
예제 출력 5
7

예제 입력 6
5 0 4 7
0 1 13
1 2 17
2 4 20
0 3 22
1 3 4747
2 0 10
3 4 10
8 10 20 1 100000
예제 출력 6
99988
*/

public class A60_SalesMan_1219 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int sCity = Integer.parseInt(st.nextToken());
        int eCity = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Edge[] edges = new Edge[m];
        long[] money = new long[n];
        long[] cityMoney = new long[n];

        for(int i=0; i<n; i++){
            money[i] = Long.MIN_VALUE;
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(s, e, v);
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            cityMoney[i] = Long.parseLong(st.nextToken());
        }

        money[sCity] = cityMoney[sCity];

        for(int i=0; i<=n+100; i++){ // 특정 지점이 무한히 벌 경우 다음 도시도 무한히 번다는 경우 적용 시키기 위해, 사이클이 충분히 돌경우 양수 사이클이 전파될수 있도록
            for(int j=0; j<m; j++){
                int start = edges[j].start;
                int end = edges[j].end;
                int val = edges[j].val;

                if(money[start]==Long.MIN_VALUE) {
                    continue; // 도달 하지 못한 도시
                }else if(money[start]==Long.MAX_VALUE){ // 돈을 무한히 가질수 있는 경로에서 출발할 경우
                    money[end]=Long.MAX_VALUE; // 다음 도시도 돈을 무한히 가질수 있음
                }else if(money[end]<money[start]+cityMoney[end]-val){
                    money[end] = money[start]+cityMoney[end]-val;
                    if(i>=n-1) money[end] = Long.MAX_VALUE; //N-1 이후 방문했을때도 무한히 돈을 벌 경우
                }
            }
        }

        if(money[eCity]==Long.MIN_VALUE){
            System.out.println("gg"); //도착 불가능
        }else if(money[eCity] == Long.MAX_VALUE){
            System.out.println("Gee"); //무한히 벌수 있음
        }else{
            System.out.println(money[eCity]);
        }
    }
}

class Edge{

    int start;
    int end;
    int val; // 교통비

    Edge(int start, int end, int val){
        this.start = start;
        this.end = end;
        this.val = val;
    }

}