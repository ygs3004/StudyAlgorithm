package Class2.B3_4153;
/*
과거 이집트인들은 각 변들의 길이가 3, 4, 5인 삼각형이 직각 삼각형인것을 알아냈다. 주어진 세변의 길이로 삼각형이 직각인지 아닌지 구분하시오.
        
입력
입력은 여러개의 테스트케이스로 주어지며 마지막줄에는 0 0 0이 입력된다. 각 테스트케이스는 모두 30,000보다 작은 양의 정수로 주어지며, 각 입력은 변의 길이를 의미한다.

출력
각 입력에 대해 직각 삼각형이 맞다면 "right", 아니라면 "wrong"을 출력한다.

예제 입력 1                   예제 출력 1
6 8 10                    right
25 52 60                  wrong
5 12 13                   right
0 0 0
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class RightTriangle {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int a = 0;
        int b = 0;
        int c = 0;

        while(true){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            if(a==0 && b==a && c==a) break;
            if(checkTriangle(a, b, c)) System.out.println("right");
            else System.out.println("wrong");
        }
    }

    static boolean checkTriangle(int a, int b, int c){
        int[] numberArr = {a, b, c};
        Arrays.sort(numberArr);

        return Math.pow(numberArr[0], 2)+Math.pow(numberArr[1], 2) ==Math.pow(numberArr[2], 2);
    }

}
