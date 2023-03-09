package javaPackage.coding_test_book_baekjoon.A40_50;/*

모든 자리가 1로만 이루어져있는 두 자연수 A와 B가 주어진다. 이때, A와 B의 최대 공약수를 구하는 프로그램을 작성하시오.
예를 들어, A가 111이고, B가 1111인 경우에 A와 B의 최대공약수는 1이고, A가 111이고, B가 111111인 경우에는 최대공약수가 111이다.

입력
첫째 줄에 두 자연수 A와 B를 이루는 1의 개수가 주어진다. 입력되는 수는 2^63보다 작은 자연수이다.
출력
첫째 줄에 A와 B의 최대공약수를 출력한다. 정답은 천만 자리를 넘지 않는다.

예제 1
3 4 -> 1
예제 2
3 6 -> 111
예제 3
500000000000000000 500000000000000002 -> 11
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class A43_Euiclidean_1850 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        for(int i=0; i<gcd(a,b); i++){
            bw.write(1+"");
        }

        bw.flush();
        br.close();
        bw.close();
    }

    static long gcd(long a, long b){
        if(b==0){
            return a;
        }else{
            long mod = a%b;
            return gcd(b, mod);
        }
    }
}