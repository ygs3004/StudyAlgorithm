package baekjoon.coding_test_book_baekjoon.A81_90.a84_1463;
/*
동적 계획법
정수 X에 사용할 수 있는 연산은 다음과 같이 세 가지 이다.

X가 3으로 나누어 떨어지면, 3으로 나눈다.
X가 2로 나누어 떨어지면, 2로 나눈다.
1을 뺀다.
정수 N이 주어졌을 때, 위와 같은 연산 세 개를 적절히 사용해서 1을 만들려고 한다. 연산을 사용하는 횟수의 최솟값을 출력하시오.

입력
첫째 줄에 1보다 크거나 같고, 106보다 작거나 같은 정수 N이 주어진다.

출력
첫째 줄에 연산을 하는 횟수의 최솟값을 출력한다.

예제 입력 1
2
예제 출력 1
1
예제 입력 2
10
예제 출력 2
3
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Make1 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] D = new int[n+1];
        D[1] = 0;
        for(int i=2; i<=n; i++){
            D[i] = D[i-1]+1;
            if(i%2 == 0)D[i] = Math.min(D[i], D[i/2]+1);
            if(i%3 == 0)D[i] = Math.min(D[i], D[i/3]+1);
        }
        System.out.println(D[n]);
    }

}