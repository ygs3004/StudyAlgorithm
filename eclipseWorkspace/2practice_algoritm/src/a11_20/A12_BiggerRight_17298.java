package a11_20;
/*
크기가 N인 수열 A = A1, A2, ..., AN이 있다. 수열의 각 원소 Ai에 대해서 오큰수 NGE(i)를 구하려고 한다. 
Ai의 오큰수는 오른쪽에 있으면서 Ai보다 큰 수 중에서 가장 왼쪽에 있는 수를 의미한다. 그러한 수가 없는 경우에 오큰수는 -1이다.
예를 들어, A = [3, 5, 2, 7]인 경우 NGE(1) = 5, NGE(2) = 7, NGE(3) = 7, NGE(4) = -1이다. A = [9, 5, 4, 8]인 경우에는 
NGE(1) = -1, NGE(2) = 8, NGE(3) = 8, NGE(4) = -1이다.

입력
첫째 줄에 수열 A의 크기 N (1 ≤ N ≤ 1,000,000)이 주어진다. 둘째 줄에 수열 A의 원소 A1, A2, ..., AN (1 ≤ Ai ≤ 1,000,000)이 주어진다.
출력
총 N개의 수 NGE(1), NGE(2), ..., NGE(N)을 공백으로 구분해 출력한다.
예제 입력 1              예제 출력 1          
4                        5 7 7 -1         
3 5 2 7
예제 입력 2 				예제 출력 2  
4                       -1 8 8 -1
9 5 4 8
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class A12_BiggerRight_17298 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		Stack<Integer> stack = new Stack<Integer>();
		int[] arr = new int[n]; 
		int[] result = new int[n];
		
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		stack.push(0); // 0번 자리는 비교할 대상이 없으므로 넣고 시작
		
		for(int i=1; i<n; i++) { //전체 수열 인덱스 반복
			while(!stack.isEmpty() && arr[i]>arr[stack.peek()]) { //숫자가 이전 인덱스보다 큰 숫자가 나오는 순간 오큰수가 됨
 				result[stack.pop()] = arr[i];					  // 4, 3, 2, 5 -> arr[i]=5는 오큰수가 되어 조건문에 의해 result에 저장
			}													  // 4의 경우 5보다 작아 인덱스가 스택에 쌓여있는 상태로 본인보다 큰 오큰수가 나올떄까지 저장
			stack.push(i);
		}
		
		while(!stack.isEmpty()) {
			result[stack.pop()]=-1;							// 인덱스에 오큰수가 존재하지 않을경우 스택에 인덱스 주소가 남음, -1값 지정
		}
		
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int i=0; i<n; i++) {
			bw.write(result[i]+" ");	
		}
		
		bw.flush();
		br.close();
		bw.close();
	}
	
}