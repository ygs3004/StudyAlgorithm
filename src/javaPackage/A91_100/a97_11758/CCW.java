package javaPackage.A91_100.a97_11758;
/* CCW Counter Clockwise
CCW = (x1y2+x2y3+x3y1)-(x2y1+x3y2+x1y3)
CCW > 0일경우 세점은 반시계모양 
CCW = 0일경우 세점은 직선
CCW < 0일경우 세점은 시계
2차원 좌표 평면 위에 있는 점 3개 P1, P2, P3가 주어진다. P1, P2, P3를 순서대로
이은 선분이 어떤 방향을 이루고 있는지 구하는 프로그램을 작성하시오.

입력
첫째 줄에 P1의 (x1, y1), 둘째 줄에 P2의 (x2, y2), 셋째 줄에 P3의 (x3, y3)가 주어진다.
(-10,000 ≤ x1, y1, x2, y2, x3, y3 ≤ 10,000) 모든 좌표는 정수이다. P1, P2, P3의 좌표는 서로 다르다.

출력
P1, P2, P3를 순서대로 이은 선분이 반시계 방향을 나타내면 1, 시계 방향이면 -1, 일직선이면 0을 출력한다.

예제 입력 1
1 1
5 5
7 3
예제 출력 1
-1
예제 입력 2
1 1
3 3
5 5
예제 출력 2
0
예제 입력 3
1 1
7 3
5 5
예제 출력 3
1
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CCW {
    // 알고리즘 코딩테스트(자바편) 책 카피코드
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x1 = Integer.parseInt(st.nextToken());
        int y1 = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int x2 = Integer.parseInt(st.nextToken());
        int y2 = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int x3 = Integer.parseInt(st.nextToken());
        int y3 = Integer.parseInt(st.nextToken());
        int ccw = (x1*y2 + x2*y3 + x3*y1) - (x2*y1 + x3*y2 + x1*y3);
        int result=0;

        if(ccw>0){
            result = 1;
        } else if (ccw<0) {
            result = -1;
        } else {
            result = 0;
        }
        System.out.println(result);
    }
}