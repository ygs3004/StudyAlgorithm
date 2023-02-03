package A91_100.a99_2162;
/* 유니온 파인드, ccw
N개의 선분들이 2차원 평면상에 주어져 있다. 선분은 양 끝점의 x, y 좌표로 표현이 된다.
두 선분이 서로 만나는 경우에, 두 선분은 같은 그룹에 속한다고 정의하며,
그룹의 크기는 그 그룹에 속한 선분의 개수로 정의한다. 두 선분이 만난다는 것은 선분의 끝점을 스치듯이 만나는 경우도 포함하는 것으로 한다.
N개의 선분들이 주어졌을 때, 이 선분들은 총 몇 개의 그룹으로 되어 있을까? 또, 가장 크기가 큰 그룹에 속한 선분의 개수는 몇 개일까?
이 두 가지를 구하는 프로그램을 작성해 보자.

입력
첫째 줄에 N(1 ≤ N ≤ 3,000)이 주어진다. 둘째 줄부터 N+1번째 줄에는 양 끝점의 좌표가 x1, y1, x2, y2의 순서로 주어진다.
각 좌표의 절댓값은 5,000을 넘지 않으며, 입력되는 좌표 사이에는 빈칸이 하나 있다.

출력
첫째 줄에 그룹의 수를, 둘째 줄에 가장 크기가 큰 그룹에 속한 선분의 개수를 출력한다.

예제 입력 1
3
1 1 2 3
2 1 0 0
1 0 1 1
예제 출력 1
1
3
예제 입력 2
3
-1 -1 1 1
-2 -2 2 2
0 1 -1 0
예제 출력 2
2
2
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LineGroup {

    static int[] parent = new int[3001];
    static int[][] L = new int[3001][4];

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        for(int i=1; i<=n; i++){
            parent[i] = -1;
        }
        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            L[i][0] = Integer.parseInt(st.nextToken());
            L[i][1] = Integer.parseInt(st.nextToken());
            L[i][2] = Integer.parseInt(st.nextToken());
            L[i][3] = Integer.parseInt(st.nextToken());
            for(int j=1; j<i; j++){ // 이전에 저장된 선분과 교차 여부 확인
                if(isCross(L[i][0], L[i][1], L[i][2], L[i][3], L[j][0], L[j][1], L[j][2], L[j][3])){
                    union(i,j);
                }
            }
        }

        int ans = 0,res =0; // 그룹의 수, 개수
        for(int i=1; i<=n; i++){
            if(parent[i]<0){ // 음수 -> 그룹 대표 부모 노드
                ans++;
                res = Math.min(res, parent[i]); // 음수 절대값이 선분 그룹의 선분 개수
            }
        }

        System.out.println(ans);
        System.out.println(-res);
    }

    static int find(int i){
        if(parent[i]<0)
            return i;
        return parent[i] = find(parent[i]);
    }

    static void union(int i, int j){
        int p = find(i);
        int q = find(j);
        if(p==q) // 부모가 같을경우
            return;
        parent[p] += parent[q];
        parent[q] = p;
    }

    static int ccw(long x1, long y1, long x2, long y2, long x3, long y3){
        long temp = (x1*y2 + x2*y3 + x3*y1) - (x2*y1 + x3*y2 + x1*y3);
        if(temp>0) return 1;
        else if(temp<0) return -1;
        else return 0;
    }

    static boolean isOverlab(long x1, long y1, long x2, long y2, long x3, long y3, long x4, long y4){ // 겹치는지
        if(Math.min(x1,x2) <= Math.max(x3, x4) && Math.min(x3, x4) <= Math.max(x1, x2)
                && Math.min(y1,y2) <= Math.max(y3, y4) && Math.min(y3, y4) <= Math.max(y1, y2))
            return true;
        return false;
    }

    static boolean isCross(long x1, long y1, long x2, long y2, long x3, long y3, long x4, long y4){
        int abc = ccw(x1, y1, x2, y2, x3, y3);
        int abd = ccw(x1, y1, x2, y2, x4, y4);
        int cda = ccw(x3, y3, x4, y4, x1, y1);
        int cdb = ccw(x3, y3, x4, y4, x2, y2);
        if(abc*abd == 0 && cda * cdb == 0){ //선분이 일직선 일떄
            return isOverlab(x1, y1, x2, y2, x3, y3, x4, y4);
        } else if(abc*abd <=0 && cda * cdb <=0){// 교차
            return true;
        }
        return false;
    }
}
