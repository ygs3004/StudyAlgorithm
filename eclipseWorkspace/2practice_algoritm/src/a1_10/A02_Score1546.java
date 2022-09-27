package a1_10;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
세준이는 기말고사를 망쳤다. 세준이는 점수를 조작해서 집에 가져가기로 했다.
일단 세준이는 자기 점수 중에 최댓값을 골랐다. 이 값을 M이라고 한다.
그리고 나서 모든 점수를 점수/M*100으로 고쳤다. 예를 들어, 세준이의 최고점이 70이고,
수학점수가 50이었으면 수학점수는 50/70*100이 되어 71.43점이 된다.
세준이의 성적을 위의 방법대로 새로 계산했을 때, 새로운 평균을 구하는 프로그램을 작성하시오.
ex)입       축
3			75.0
40 80 60

3
10 20 30 	66.666667

*/

public class A02_Score1546 {

	public static void main(String[] args) throws IOException {
/*		
	  BR로 과목개수 정수 n 입력받기
	  나머지 점수 입력받기
	  Tokenizer로 배열에 넣기
	  최대값 구하기
	  합계, 평균 구하기
*/
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		String str=br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		int arr[]=new int[n];
		int sum=0;
		double avg=0;
		int max=0;
		
		for(int i=0; i<n; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
			if(arr[i]>max) {
				max=arr[i];
			}
			sum+=arr[i];
		}
		avg=(double)sum/(max*n)*100;
		System.out.println(avg);
	}

}
