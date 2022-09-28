package A91_100.a91_1915;
/*
n×m의 0, 1로 된 배열이 있다. 이 배열에서 1로 된 가장 큰 정사각형의 크기를 구하는 프로그램을 작성하시오.
0	1	0	0
0	1	1	1
1	1	1	0
0	0	1	0
위와 같은 예제에서는 가운데의 2×2 배열이 가장 큰 정사각형이다.

입력
첫째 줄에 n, m(1 ≤ n, m ≤ 1,000)이 주어진다. 다음 n개의 줄에는 m개의 숫자로 배열이 주어진다.

출력
첫째 줄에 가장 큰 정사각형의 넓이를 출력한다.

예제 입력 1
4 4
0100
0111
1110
0010
예제 출력 1
4
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LargeSquare {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        long max=0;
        long[][] D = new long[n][m];

        for(int i=0; i<n; i++){
            String mline = br.readLine();
            for(int j=0; j<m; j++){
                D[i][j] = Long.parseLong(String.valueOf(mline.charAt(j)));
                if(D[i][j]==1 && j>0 && i>0){
                    D[i][j] = Math.min(D[i-1][j-1], Math.min(D[i-1][j], D[i][j-1]))+D[i][j];
                }
                if(max < D[i][j]){
                    max = D[i][j];
                }
            }
        }
        System.out.println(max*max);
    }

}