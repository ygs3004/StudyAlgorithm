package javaPackage.coding_test_book_baekjoon.A40_50;
//
//A, B, C가 주어졌을 때, Ax+By=C를 만족하는 (x, y)중에서 다음을 만족하는 것을 아무거나 찾아보자.
//
//x, y는 정수
//-1,000,000,000 ≤ x, y ≤ 1,000,000,000
//입력
//첫째 줄에 정수 A, B, C가 주어진다.
//
//출력
//Ax+By=C를 만족하는 x, y를 공백으로 구분해 출력한다. 문제의 조건을 만족하는 (x, y)가 존재하지 않는 경우에는 -1을 출력한다.
//
//제한
//-1,000,000 ≤ A, B, C ≤ 1,000,000
//A, B ≠ 0
//예제 입력 1
//1 2 3
//예제 출력 1
//3 0
//예제 입력 2
//3 4 5
//예제 출력 2
//-5 5
//예제 입력 3
//6 8 3
//예제 출력 3
//-1

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A45_AxByC_21568 {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long c = Long.parseLong(st.nextToken());
        long gcd = gcd(a, b);
        if(c%gcd!=0){
            System.out.println(-1);
        }else{
            long target= c/gcd;
            long[] xy = reverse(a, b);
            System.out.println(xy[0]*target+" "+xy[1]*target);
        }

    }

    private static long[] reverse(long x, long y){  // x=y', y=x'-y'*q 의 역순 계산 b==0 -> y'==0;
        long[] xy = new long[2];
        if(y==0){
            xy[0] = 1;
            xy[1] = 0;
            return xy;
        }
        long q = x/y;
        long[] v = reverse(y, x%y);
        xy[0] = v[1];
        xy[1] = v[0]-v[1]*q;
        return xy;
    }
    private static long gcd(long a, long b){
        if(b==0){
            return Math.abs(a);
        }else{
            return gcd(b, a%b);
        }
    }
}
