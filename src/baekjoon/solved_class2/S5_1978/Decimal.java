package baekjoon.solved_class2.S5_1978;
/*
문제
주어진 수 N개 중에서 소수가 몇 개인지 찾아서 출력하는 프로그램을 작성하시오.
예제 입력 1
4
1 3 5 7
예제 출력 1
3
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Decimal {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int num = 0;
        int count = 0;

        for(int i=0; i<n; i++){
            num = Integer.parseInt(st.nextToken());
            if(num==2) {
                count++;
                continue;
            }
            for(int j=2; j<num; j++){
                if(num%j == 0) break;
                if(j==num-1) count++;
            }
        }

        System.out.println(count);

    }

}
