package baekjoon.solved_class2.B1_2869;
/*
땅 위에 달팽이가 있다. 이 달팽이는 높이가 V미터인 나무 막대를 올라갈 것이다.
달팽이는 낮에 A미터 올라갈 수 있다. 하지만, 밤에 잠을 자는 동안 B미터 미끄러진다. 또, 정상에 올라간 후에는 미끄러지지 않는다.
달팽이가 나무 막대를 모두 올라가려면, 며칠이 걸리는지 구하는 프로그램을 작성하시오.

입력
첫째 줄에 세 정수 A, B, V가 공백으로 구분되어서 주어진다. (1 ≤ B < A ≤ V ≤ 1,000,000,000)

출력
첫째 줄에 달팽이가 나무 막대를 모두 올라가는데 며칠이 걸리는지 출력한다.

예제 입력
2 1 5
예제 출력
4

예제 입력
5 1 6
예제 출력
2

예제 입력
100 99 1000000000
예제 출력
999999901

12 10 102
46

3 1 6
3
*/

import java.io.*;
import java.util.StringTokenizer;

public class Snail {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int lastDayUp = Integer.parseInt(st.nextToken());
        int oneDayDown = Integer.parseInt(st.nextToken());
        int goal = Integer.parseInt(st.nextToken());
        int oneDayUp = lastDayUp-oneDayDown;
        int totalDays = 0;

        if((goal - lastDayUp)%oneDayUp==0){
            totalDays = (goal - lastDayUp) / oneDayUp + 1;
        }else{
            totalDays = (goal - lastDayUp) / oneDayUp + 2;
        }

        //while (true) {
        //    totalDays++;
        //    height += lastDayUp;
        //    if (height >= goal) {
        //        break;
        //    }
        //    height -= oneDayDown;
        //}
        // 시간초과
        
        bw.write(totalDays+"");
        bw.flush();
        br.close();
        bw.close();

    }

}