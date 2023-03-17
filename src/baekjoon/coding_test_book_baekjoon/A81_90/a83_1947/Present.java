package baekjoon.coding_test_book_baekjoon.A81_90.a83_1947;
/*
완전 순열 점화식
D[N] = (N-1)*(D([N-2] + D[N-1]) N명일 경우의 경우의 수는 자기 자신을 제외한 (N-1)명중
한 명을 선택하여 둘이 완전히 자리를 바꾸거나(D[N-2]), 한 명만 해당 자리로 옮기거나(D[N-1]) 하는 두가지의 경우로 전체 경우의 수를 계산할수 있다
이번 ACM-ICPC 대회에 참가한 모든 사람들은 선물을 하나씩 준비했다.
대회가 끝나고 난 후에 각자 선물을 전달하려고 할 때, 선물을 나누는 경우의 수를 구하는 프로그램을 작성하시오.
모든 사람은 선물을 하나씩 받으며, 자기의 선물을 자기가 받는 경우는 없다.

입력
첫째 줄에 ACM-ICPC 대회에 참가한 학생의 수 N(1 ≤ N ≤ 1,000,000)이 주어진다.

출력
경우의 수를 1,000,000,000으로 나눈 나머지를 첫째 줄에 출력한다.

예제 입력 1
5
예제 출력 1
44
예제 입력 2
4
예제 출력 2
9
예제 입력 3
3
예제 출력 3
2
예제 입력 4
21
예제 출력 4
50944540
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Present {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long mod = 1000000000;
        long[] D = new long[1000001]; // 경우의 수를 저장할 배열
        D[1] = 0; // 혼자서는 선물을 줄 수 없음
        D[2] = 1; // 교환하는 경우 한가지임
        for(int i=3; i<=n; i++){
            D[i] = (i-1)*(D[i-1]+D[i-2]) % mod;
        }
        System.out.println(D[n]);
    }
}
