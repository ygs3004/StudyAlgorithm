package javaPackage.coding_test_book.A91_100.a98_17387;
/* CCW
2차원 좌표 평면 위의 두 선분 L1, L2가 주어졌을 때, 두 선분이 교차하는지 아닌지 구해보자.
한 선분의 끝 점이 다른 선분이나 끝 점 위에 있는 것도 교차하는 것이다.
L1의 양 끝 점은 (x1, y1), (x2, y2), L2의 양 끝 점은 (x3, y3), (x4, y4)이다.

입력
첫째 줄에 L1의 양 끝 점 x1, y1, x2, y2가, 둘째 줄에 L2의 양 끝 점 x3, y3, x4, y4가 주어진다.

출력
L1과 L2가 교차하면 1, 아니면 0을 출력한다.

제한
-1,000,000 ≤ x1, y1, x2, y2, x3, y3, x4, y4 ≤ 1,000,000
x1, y1, x2, y2, x3, y3, x4, y4는 정수
선분의 길이는 0보다 크다.
예제 입력 1
1 1 5 5
1 5 5 1
예제 출력 1
1
예제 입력 2
1 1 5 5
6 10 10 6
예제 출력 2
0
예제 입력 3
1 1 5 5
5 5 1 1
예제 출력 3
1
예제 입력 4
1 1 5 5
3 3 5 5
예제 출력 4
1
예제 입력 5
1 1 5 5
3 3 1 3
예제 출력 5
1
예제 입력 6
1 1 5 5
5 5 9 9
예제 출력 6
1
예제 입력 7
1 1 5 5
6 6 9 9
예제 출력 7
0
예제 입력 8
1 1 5 5
5 5 1 5
예제 출력 8
1
예제 입력 9
1 1 5 5
6 6 1 5
예제 출력 9
0
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Cross {
    // 알고리즘 코딩테스트(자바) 책 카피코드
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long x1 = Integer.parseInt(st.nextToken());
        long y1 = Integer.parseInt(st.nextToken());
        long x2 = Integer.parseInt(st.nextToken());
        long y2 = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        long x3 = Integer.parseInt(st.nextToken());
        long y3 = Integer.parseInt(st.nextToken());
        long x4 = Integer.parseInt(st.nextToken());
        long y4 = Integer.parseInt(st.nextToken());

        boolean cross = isCross(x1,y1,x2,y2,x3,y3,x4,y4);
        if(cross) System.out.println(1);
        else System.out.println(0);


    }

    static int ccw(long x1, long y1, long x2, long y2, long x3, long y3){
        long temp = (x1*y2 + x2*y3 + x3*y1) - (x2*y1 + x3*y2 + x1*y3);
        if(temp >0) return 1;
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
