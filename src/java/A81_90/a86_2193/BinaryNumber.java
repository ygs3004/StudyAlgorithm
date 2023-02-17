package java.A81_90.a86_2193;
/*
동적 계획법, DP
0과 1로만 이루어진 수를 이진수라 한다. 이러한 이진수 중 특별한 성질을 갖는 것들이 있는데, 이들을 이친수(pinary number)라 한다. 이친수는 다음의 성질을 만족한다.
이친수는 0으로 시작하지 않는다.
이친수에서는 1이 두 번 연속으로 나타나지 않는다. 즉, 11을 부분 문자열로 갖지 않는다.
예를 들면 1, 10, 100, 101, 1000, 1001 등이 이친수가 된다. 하지만 0010101이나 101101은 각각 1, 2번 규칙에 위배되므로 이친수가 아니다.
N(1 ≤ N ≤ 90)이 주어졌을 때, N자리 이친수의 개수를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 N이 주어진다.

출력
첫째 줄에 N자리 이친수의 개수를 출력한다.

예제 입력 1
3
예제 출력 1
2
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BinaryNumber {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[][] D = new long[n+1][2]; // 0으로 끝나는 경우, 1로 끝나는 경우 저장
        D[1][1] = 1; // 첫째 자리는 1로 시작
        D[1][0] = 0; // 1로 시작하기때문에 1자리 0으로 시작은 0

        for(int i=2; i<=n; i++){
            D[i][0] = D[i-1][1] + D[i-1][0]; // 모든 경우
            D[i][1] = D[i-1][0]; // 이전 자리에 1인 경우는 불가능, 고로 0인경우만 카운팅
        }
        System.out.println(D[n][0]+D[n][1]);
    }

}