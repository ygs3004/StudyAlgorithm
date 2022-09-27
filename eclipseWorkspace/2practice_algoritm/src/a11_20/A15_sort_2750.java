package a11_20;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
문제
N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.

 예제 입력 1         예제 출력 1 
5                  1       
5                  2       
2                  3       
3                  4       
4                  5       
1
  */
public class A15_sort_2750 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int a;
		int[] arr = new int[n];
		
		for(int i=0; i<n; i++) {
			a = Integer.parseInt(br.readLine());
			arr[i]=a;
		}
	
		for(int i=0; i<n-1; i++) {
			for(int j=i+1; j<n; j++) {
				if(arr[i]>arr[j]) {
					int temp = arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}
			}
		}
	
		for(int i=0; i<n; i++) {
			bw.write(arr[i]+"\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	
	}
}