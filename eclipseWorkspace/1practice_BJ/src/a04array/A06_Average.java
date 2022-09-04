package a04array;
/*
대학생 새내기들의 90%는 자신이 반에서 평균은 넘는다고 생각한다.
 당신은 그들에게 슬픈 진실을 알려줘야 한다.
입력
첫째 줄에는 테스트 케이스의 개수 C가 주어진다.
둘째 줄부터 각 테스트 케이스마다 학생의 수 N(1 ≤ N ≤ 1000, N은 정수)이 첫 수로 주어지고,
이어서 N명의 점수가 주어진다. 점수는 0보다 크거나 같고, 100보다 작거나 같은 정수이다.
출력
각 케이스마다 한 줄씩 평균을 넘는 학생들의 비율을 반올림하여 소수점 셋째 자리까지 출력한다.
입력)							-> 출력)
5
5 50 50 70 80 100					40.000%  
7 100 95 90 80 70 60 50             57.143%  
3 70 90 80                          33.333%  
3 70 90 81                          66.667%  
9 100 99 98 97 96 95 94 93 91       55.556%  
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A06_Average {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		for(int i=0; i<n; i++) {
			int sum=0;
			double avg=0;
			double count=0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			int stuNum = Integer.parseInt(st.nextToken());
			int[] stuScore = new int[stuNum];
			for(int j=0; j<stuNum; j++) {
				stuScore[j]=Integer.parseInt(st.nextToken());
				sum+=stuScore[j];
			}
			avg = (double)sum/stuNum;
			for(int j=0; j<stuNum; j++) {
				if(stuScore[j]>avg)
					count++;
			}
			System.out.printf("%.3f%%%n", (double)count/stuNum*100);
		}
		br.close();

	}

}
