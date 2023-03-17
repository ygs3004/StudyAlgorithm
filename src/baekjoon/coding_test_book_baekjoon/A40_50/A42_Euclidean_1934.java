package baekjoon.coding_test_book_baekjoon.A40_50;
/*

문제
        두 자연수 A와 B에 대해서, A의 배수이면서 B의 배수인 자연수를 A와 B의 공배수라고 한다. 이런 공배수 중에서 가장 작은 수를 최소공배수라고 한다.
        예를 들어, 6과 15의 공배수는 30, 60, 90등이 있으며, 최소 공배수는 30이다.

        두 자연수 A와 B가 주어졌을 때, A와 B의 최소공배수를 구하는 프로그램을 작성하시오.

        입력
        첫째 줄에 테스트 케이스의 개수 T(1 ≤ T ≤ 1,000)가 주어진다. 둘째 줄부터 T개의 줄에 걸쳐서 A와 B가 주어진다. (1 ≤ A, B ≤ 45,000)

        예제 입력 1    예제 출력 1
        3
        1 45000      45000
        6 10         30
        13 17        221




*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A42_Euclidean_1934 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int a=0;
        int b=0;
        int result=0;

        for(int i=0; i<n; i++){

            st = new StringTokenizer(br.readLine());
            a=Integer.parseInt(st.nextToken());
            b=Integer.parseInt(st.nextToken());
            result=a*b/gcd(a,b);
            System.out.println(result);
        }

        br.close();
    }

    public static int gcd(int a, int b){
        if(b==0){
            return a;
        }else{
            int mod = a%b;
            return gcd(b, mod);
        }
    }

}