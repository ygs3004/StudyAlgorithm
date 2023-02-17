package java.A81_90.a82_1256;
/*
점화식, 순열(x), 조합
동호와 규완이는 212호에서 문자열에 대해 공부하고 있다. 김진영 조교는 동호와 규완이에게 특별 과제를 주었다.
특별 과제는 특별한 문자열로 이루어 진 사전을 만드는 것이다. 사전에 수록되어 있는 모든 문자열은 N개의 "a"와 M개의 "z"로 이루어져 있다.
그리고 다른 문자는 없다. 사전에는 알파벳 순서대로 수록되어 있다.
규완이는 사전을 완성했지만, 동호는 사전을 완성하지 못했다. 동호는 자신의 과제를 끝내기 위해서 규완이의 사전을 몰래 참조하기로 했다.
동호는 규완이가 자리를 비운 사이에 몰래 사전을 보려고 하기 때문에, 문자열 하나만 찾을 여유밖에 없다.

N과 M이 주어졌을 때, 규완이의 사전에서 K번째 문자열이 무엇인지 구하는 프로그램을 작성하시오.

입력
첫째 줄에 세 정수 N, M, K가 순서대로 주어진다.

출력
첫째 줄에 규완이의 사전에서 K번째 문자열을 출력한다. 만약 규완이의 사전에 수록되어 있는 문자열의 개수가 K보다 작으면 -1을 출력한다.

제한
1 ≤ N, M ≤ 100
1 ≤ K ≤ 1,000,000,000
예제 입력 1
2 2 2
예제 출력 1
azaz
예제 입력 2
2 2 6
예제 출력 2
zzaa
예제 입력 3
10 10 1000000000
예제 출력 3
-1
예제 입력 4
7 4 47
예제 출력 4
aaazazaazaz
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Dictonary {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] D = new int[202][202];

        for(int i=0; i<=200; i++){  // 조합테이블 초기화
            for(int j=0; j<=i; j++){
                if(j==0 || j==i){
                    D[i][j] = 1;
                }else{
                    D[i][j] = D[i-1][j-1]+D[i-1][j];
                    if(D[i][j]>1000000000) D[i][j] = 1000000001; //K 범위 넘어갈경우
                }
            }
        }

        if(D[n+m][m] < k )
            System.out.println(-1);
        else {
            while(!(n==0 && m==0)){
                //a 를 선택했을때 남은 문자로 만들수 있는 경우의 수가 k보다 크면
                if(D[n-1+m][m]>=k){ // 전체 경우의 수에서 a를 선택(-1)한 후 z의 문자 위치를 선택하는 경우(조합이라 볼수 있음)의 수
                    System.out.print("a");
                    n--;
                }else{
                    System.out.print("z");
                    k=k-D[n-1+m][m];
                    m--;
                }
            }
        }
    }
}