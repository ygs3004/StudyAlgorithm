package javaPackage.coding_test_book_baekjoon.A81_90.a87_11726;
/* DP, 다이나믹 프로그래밍
2×n 크기의 직사각형을 1×2, 2×1 타일로 채우는 방법의 수를 구하는 프로그램을 작성하시오.
아래 그림은 2×5 크기의 직사각형을 채운 한 가지 방법의 예이다.

입력
첫째 줄에 n이 주어진다. (1 ≤ n ≤ 1,000)

출력
첫째 줄에 2×n 크기의 직사각형을 채우는 방법의 수를 10,007로 나눈 나머지를 출력한다.

예제 입력 1
2
예제 출력 1
2
예제 입력 2
9
예제 출력 2
55
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Tile_2xN {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long mod = 10007;
        long[] D = new long[n+1];
        D[1] = 1;
        D[2] = 2;

        for(int i=3; i<=n; i++){
            D[i] = (D[i-2]+D[i-1]) % mod;
        }

        System.out.println(D[n]);
    }

}