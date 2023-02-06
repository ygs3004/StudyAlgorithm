package class2.S5_11650;
/*
문제
2차원 평면 위의 점 N개가 주어진다. 좌표를 x좌표가 증가하는 순으로,
x좌표가 같으면 y좌표가 증가하는 순서로 정렬한 다음 출력하는 프로그램을 작성하시오.

입력
첫째 줄에 점의 개수 N (1 ≤ N ≤ 100,000)이 주어진다. 둘째 줄부터 N개의 줄에는 i번점의 위치 xi와 yi가 주어진다.
(-100,000 ≤ xi, yi ≤ 100,000) 좌표는 항상 정수이고, 위치가 같은 두 점은 없다.

출력
첫째 줄부터 N개의 줄에 점을 정렬한 결과를 출력한다.

예제 입력
5
3 4
1 1
1 -1
2 2
3 3

예제 출력
1 -1
1 1
2 2
3 3
3 4

알고리즘 : 정렬
*/

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SortCoordinates {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        PriorityQueue<Point> pointQueue = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            pointQueue.add(new Point(x, y));
        }

        Point nowPoint;
        while(!pointQueue.isEmpty()){
            nowPoint = pointQueue.poll();
            bw.write(nowPoint.x + " " + nowPoint.y+"\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    static class Point implements Comparable<Point> {

        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o) {

            if (this.x != o.x) {
                return this.x - o.x;
            }

            return this.y - o.y;
        }
    }

}
