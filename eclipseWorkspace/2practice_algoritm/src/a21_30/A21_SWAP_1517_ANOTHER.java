package a21_30;
/*
N개의 수로 이루어진 수열 A[1], A[2], …, A[N]이 있다. 이 수열에 대해서 버블 소트를 수행할 때,
Swap이 총 몇 번 발생하는지 알아내는 프로그램을 작성하시오.

버블 소트는 서로 인접해 있는 두 수를 바꿔가며 정렬하는 방법이다.
예를 들어 수열이 3 2 1 이었다고 하자. 이 경우에는 인접해 있는 3, 2가 바뀌어야 하므로 2 3 1 이 된다. 
다음으로는 3, 1이 바뀌어야 하므로 2 1 3 이 된다. 다음에는 2, 1이 바뀌어야 하므로 1 2 3 이 된다. 
그러면 더 이상 바꿔야 할 경우가 없으므로 정렬이 완료된다.
3
3 2 1	-> 	3
*/

import java.io.*;
import java.util.*;

public class A21_SWAP_1517_ANOTHER {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		int result=0;
		
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<n-1; i++) {
			int gap=0;;
			for(int j=i+1; j<n; j++) {
				if(arr[i]>arr[j] && j-i>gap) {
					gap = j-i;
				}
			}
			result+=gap;
		}
		
		System.out.println(result); // 시간초과
		
	}
}