package javaPackage.coding_test_book_baekjoon.A81_90.a89_13398;
/*
n개의 정수로 이루어진 임의의 수열이 주어진다. 우리는 이 중 연속된 몇 개의 수를 선택해서 구할 수 있는 합 중 가장 큰 합을 구하려고 한다.
단, 수는 한 개 이상 선택해야 한다. 또, 수열에서 수를 하나 제거할 수 있다. (제거하지 않아도 된다)
예를 들어서 10, -4, 3, 1, 5, 6, -35, 12, 21, -1 이라는 수열이 주어졌다고 하자. 여기서 수를 제거하지 않았을 때의 정답은 12+21인 33이 정답이 된다.
만약, -35를 제거한다면, 수열은 10, -4, 3, 1, 5, 6, 12, 21, -1이 되고, 여기서 정답은 10-4+3+1+5+6+12+21인 54가 된다.

입력
첫째 줄에 정수 n(1 ≤ n ≤ 100,000)이 주어지고 둘째 줄에는 n개의 정수로 이루어진 수열이 주어진다. 수는 -1,000보다 크거나 같고, 1,000보다 작거나 같은 정수이다.

출력
첫째 줄에 답을 출력한다.

예제 입력 1
10
10 -4 3 1 5 6 -35 12 21 -1
예제 출력 1
54
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class PartialSum {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] a = new int[n];
        for(int i=0; i<n; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = a[0];
        right[n-1] = a[n-1];
        int result = left[0];
        for(int i=1; i<n; i++){
            left[i] = Math.max(a[i], left[i-1]+a[i]);
            result = Math.max(result,left[i]); // 제거 없을경우 최대값 저장
        }

        for(int i=n-2; i>=0; i--){
            right[i] = Math.max(a[i], right[i+1]+a[i]);
        }
        // 제거할 경우
        for(int i=1; i<n-1; i++){
            int temp = left[i-1]+right[i+1];
            result = Math.max(result,temp);
        }

        bw.write(result+"");
        bw.flush();
        bw.close();
        br.close();

    }

}