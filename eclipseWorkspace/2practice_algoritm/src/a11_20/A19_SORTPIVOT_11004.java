package a11_20;
/*
수 N개 A1, A2, ..., AN이 주어진다. A를 오름차순 정렬했을 때, 앞에서부터 K번째 있는 수를 구하는 프로그램을 작성하시오.
5 2				-> 2
4 1 2 3 5
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A19_SORTPIVOT_11004 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken())-1;
		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		System.out.println(quickSort(arr, 0, n-1, k)[k]);
	}

	public static int[] quickSort(int[] arr, int start, int end, int k) {
		int pivot = arr[end];
		int l = start;
		int r = end-1;
		if(end-start==1) {
			if(arr[end]<arr[start]) {
				int temp = arr[end];
				arr[end] = arr[start];
				arr[start] = temp;
			}
		}else {
			while(l<r) {
				if(arr[l]<pivot || arr[r]>pivot) {
					if(arr[l]<pivot)
						l++;
					if(arr[r]>pivot)
						r--;	
				}else if(arr[l]>pivot && arr[r]<pivot) {
					int temp = arr[r];
					arr[r] = arr[l];
					arr[l] = temp;
					l++;
					r--;
				}
			}
			
			if(r==end-1){
				r=end;
			}else if (l>r){
				int temp= arr[r-1];
				arr[r-1] = arr[end];
				arr[end] = temp; 
			} else if (l==r) {
				if(arr[r]>pivot) {
					int temp = arr[r];
					arr[r] = pivot;
					arr[end] = temp;	
				}else if(arr[r]<pivot) {
					r=r+1;
					int temp = arr[r];
					arr[r] = pivot;
					arr[end] = temp;
				}
			}
			
			if(r==k) return arr;

			if(end-(r+1)>=1)
			quickSort(arr, r+1, end, k);
			if (r-1-start>=1)
			quickSort(arr, start, r-1, k);
		}
		
		return arr;
	}
	
}

