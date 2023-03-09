package javaPackage.coding_test_book_baekjoon.A40_50;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
자연수 n이 주어졌을 때, GCD(n, k) = 1을 만족하는 자연수 1 ≤ k ≤ n 의 개수를 구하는 프로그램을 작성하시오.
입력
첫째 줄에 자연수 n (1 ≤ n ≤ 10^12)이 주어진다.
출력
GCD(n, k) = 1을 만족하는 자연수 1 ≤ k ≤ n 의 개수를 출력한다.

1->1
5->4
10->4
45->24
99->60
*/

//오일러 함수란? k까지의 의 서로소인 갯수를 구하는 함수 k*(1-1/소인수)* ..... (1-1/소인수)로 서로소의 갯수를 구할수 있다
public class A41_GCD_11689 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long k = Long.parseLong(br.readLine());
        long result=k;

        for(long i=2; i<=Math.sqrt(k); i++){
            if(k%i==0){
                result=result-result/i;
                while(k%i==0){
                    k/=i;
                }
            }
        }

        if(k>1) result=result-result/k;
        System.out.println(result);
        br.close();
    }
}
