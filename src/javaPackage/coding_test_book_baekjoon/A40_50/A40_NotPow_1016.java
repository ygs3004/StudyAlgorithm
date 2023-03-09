package javaPackage.coding_test_book_baekjoon.A40_50;
/*
어떤 정수 X가 1보다 큰 제곱수로 나누어 떨어지지 않을 때, 그 수를 제곱ㄴㄴ수라고 한다.
제곱수는 정수의 제곱이다. min과 max가 주어지면, min보다 크거나 같고, max보다 작거나 같은 제곱ㄴㄴ수가 몇 개 있는지 출력한다.

1 ≤ min ≤ 1,000,000,000,000
min ≤ max ≤ min + 1,000,000

예제 입력 1
1 10
-> 7
예제 입력 2
15 15
-> 1
예제 입력 3
1 1000
-> 608
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A40_NotPow_1016 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long min = Long.parseLong(st.nextToken());
        long max = Long.parseLong(st.nextToken());
        boolean[] check = new boolean[(int)(max-min)+1];

        for(long i=2; i*i<=max; i++){
            long pow = i*i;
            long sIdx = min/pow;
            if(min%pow != 0)
                sIdx++;
            for(long j=sIdx; j*pow<=max; j++){
                check[(int)(j*pow-min)] = true;
            }
        }

        int count=0;
        for(int i=0; i<check.length; i++){
            if(!check[i]) count++;
        }

        System.out.println(count);
    }
}
