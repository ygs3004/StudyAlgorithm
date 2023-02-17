package java.A81_90.a90_9252;
/*
동적 계획법, 다이나믹 프로그래밍
LCS(Longest Common Subsequence, 최장 공통 부분 수열)문제는 두 수열이 주어졌을 때, 모두의 부분 수열이 되는 수열 중 가장 긴 것을 찾는 문제이다.
예를 들어, ACAYKP와 CAPCAK의 LCS는 ACAK가 된다.

입력
첫째 줄과 둘째 줄에 두 문자열이 주어진다. 문자열은 알파벳 대문자로만 이루어져 있으며, 최대 1000글자로 이루어져 있다.

출력
첫째 줄에 입력으로 주어진 두 문자열의 LCS의 길이를, 둘째 줄에 LCS를 출력한다.

LCS가 여러 가지인 경우에는 아무거나 출력하고, LCS의 길이가 0인 경우에는 둘째 줄을 출력하지 않는다.

예제 입력 1
ACAYKP
CAPCAK
예제 출력 1
4
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class LCS {

    static long[][] dp;
    static ArrayList<Character> path;
    static char[] a;
    static char[] b;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        a = br.readLine().toCharArray();
        b = br.readLine().toCharArray();
        dp = new long[a.length+1][b.length+1];
        path = new ArrayList<>();

        for(int i=1; i<=a.length; i++) {
            for (int j = 1; j <= b.length; j++) {
                if (a[i - 1] == b[j - 1]) { // 글자가 같을떄
                    dp[i][j] = dp[i - 1][j - 1] + 1; // 대각선 위보다 +1 (두 문장이 한글자씩 각각 추가되었기때문
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]); // 왼쪽 또는 위쪽 값 중 큰수(글자가 추가 되기 전의 경우중 큰 경우)
                }
            }
        }

        System.out.println(dp[a.length][b.length]);
        getText(a.length, b.length);
        for(int i=path.size()-1; i>=0; i--){
            System.out.print(path.get(i));
        }
    }

    static void getText(int r, int c){
        if(r == 0 || c==0) return;
        if(a[r-1] == b[c-1]){
            path.add(a[r-1]);
            getText(r-1, c-1);
        }else{
            if(dp[r-1][c]>dp[r][c-1])
                getText(r-1, c);
            else
                getText(r, c-1);
        }
    }

}