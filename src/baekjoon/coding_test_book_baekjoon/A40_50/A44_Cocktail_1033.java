package baekjoon.coding_test_book_baekjoon.A40_50;
/*
august14는 세상에서 가장 맛있는 칵테일이다. 이 칵테일을 만드는 정확한 방법은 아직 세상에 공개되지 않았지만, 들어가는 재료 N개는 공개되어 있다.

경근이는 인터넷 검색을 통해서 재료 쌍 N-1개의 비율을 알아냈고, 이 비율을 이용해서 칵테일에 들어가는 전체 재료의 비율을 알아낼 수 있다.

총 재료 쌍 N-1개의 비율이 입력으로 주어진다. 이때, 칵테일을 만드는데 필요한 각 재료의 양을 구하는 프로그램을 작성하시오.
이때, 필요한 재료의 질량을 모두 더한 값이 최소가 되어야 한다. 칵테일을 만드는 재료의 양은 정수이고, 총 질량은 0보다 커야한다.

비율은 "a b p q"와 같은 형식이고, a번 재료의 질량을 b번 재료의 질량으로 나눈 값이 p/q라는 뜻이다.

입력
첫째 줄에 august14를 만드는데 필요한 재료의 개수 N이 주어지며, N은 10보다 작거나 같은 자연수이다.

둘째 줄부터 N-1개의 줄에는 재료 쌍의 비율이 한 줄에 하나씩 주어지는데, 문제 설명에 나온 형식인 "a b p q"로 주어진다. 재료는 0번부터 N-1까지이며,
a와 b는 모두 N-1보다 작거나 같은 음이 아닌 정수이다. p와 q는 9보다 작거나 같은 자연수이다.

출력
첫째 줄에 칵테일을 만드는데 필요한 각 재료의 질량을 0번 재료부터 순서대로 공백으로 구분해 출력한다.

예제 입력 1
5
4 0 1 1
4 1 3 1
4 2 5 1
4 3 7 1
예제 출력 1
105 35 21 15 105
예제 입력 2
2
0 1 6 4
예제 출력 2
3 2
예제 입력 3
3
0 1 9 8
1 2 9 8
예제 출력 3
81 72 64
예제 입력 4
4
2 3 6 8
0 1 9 3
3 0 7 5
제 출력 4
60 20 63 84
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class A44_Cocktail_1033 {
    static boolean[] visited;
    static ArrayList<Ratio>[] cocktail;
    static long[] result;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));
        StringTokenizer st;

        long lcm = 1; // 최소 공배수
        int n = Integer.parseInt(br.readLine());
        cocktail = new ArrayList[n];
        visited = new boolean[n];
        result = new long[n];

        for(int i=0; i<n; i++){
            cocktail[i] = new ArrayList<Ratio>();
        }

        for(int i=0; i<n-1; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());

            cocktail[a].add(new Ratio(b, p, q));
            cocktail[b].add(new Ratio(a, q, p));

            lcm *= p*q/gcd(p,q); // 각 각의 비율의 최소 공배수를 모두 더한 값으로 각각의 비율로 나눴을때 정수가 나오는 총 질량 임의 선정
                                // lcm 을 구하는 와중에 연속된 곱으로 int 범위 벗어날 가능성 있음
        }
        result[0] = lcm;
        DFS(0);
        //DFS를 통한 결과값은 최대로 나누어진 결과값이 아님 결과들의 gcd를 이용해서 정답을 도출해야함
        long gcd=lcm;

        for(int i=0; i<n; i++){
            gcd=gcd(gcd, result[i]);
        }

        for(int i=0; i<n; i++){
            result[i]/=gcd;
            bw.write(result[i]+" ");
        }

        bw.flush();
        br.close();
        bw.close();
    }
    public static long gcd(long a, long b) {
        if (b == 0) {
            return a;
        } else {
            long mod = a % b;
            return gcd(b, mod);
        }
    }

    public static void DFS(int a){
        visited[a]=true;
        for(Ratio ratio:cocktail[a]){
            int next = ratio.b;
            if(!visited[next]){
                result[next] = result[a]*ratio.q/ratio.p;
                DFS(next);
            }
        }
    }
}
class Ratio{

    int b;
    int p;
    int q;

    Ratio(int b, int p, int q){
        this.b=b;
        this.p=p;
        this.q=q;
    }

}
