package a1_10;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 N개의 숫자가 공백 없이 쓰여있다. 이 숫자를 모두 합해서 출력하는 프로그램을 작성하시오.                      
 첫째 줄에 숫자의 개수 N (1 ≤ N ≤ 100)이 주어진다. 둘째 줄에 숫자 N개가 공백없이 주어진다.             
 입력으로 주어진 숫자 N개의 합을 출력한다.                                               
ex)
입				출
1				1
1
ex2)
5				15
54321
*/

public class A01_Sum11720 {

	public static void main(String[] args) throws IOException {
		// N값 입력받기
		// 숫자 N개만큼의 숫자를 문자열 str로입력
		// str을 for문을 이용하여 배열에 저장
		// 각 문자를 배열 인덱스에 저장
		// 인덱스를 불러와 합계 계산
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		String str=br.readLine();
		int[] arr=new int[n];
		int sum=0;
		
		for(int i=0; i<n; i++) {
			arr[i]=Character.getNumericValue(str.charAt(i));
			sum += arr[i];
			//sum += str.charAt(i)- '0';  '0' 으로 casting 가능
		}
		
		System.out.println(sum);
	}

}

// 배열에 안넣고 바로 charAt(i)로 바로 계산 가능,
// charAt(i)가 문자로 인ㅅauto unboxing 하는듯?
