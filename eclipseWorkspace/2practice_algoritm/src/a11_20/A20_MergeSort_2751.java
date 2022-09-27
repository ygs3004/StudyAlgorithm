package a11_20;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.
5
5                        1
4                        2
3                        3
2                        4
1                        5
*/
public class A20_MergeSort_2751 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		mergeSort(0, n-1, arr);
		for(int a: arr) {
			bw.write(a+"\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static void mergeSort(int a, int b, int[] arr) {
		if(b-a==0) return;
		int mid = (a+b)/2;
		
		mergeSort(a, mid, arr);
		mergeSort(mid+1, b, arr);
		
		int[] newArr = new int[b+1-a];
		int index1=a;
		int index2=mid+1;
		int tempIndex=0;
		
		while(index1<=mid && index2<=b) {
			if(arr[index1]>arr[index2]) {
				newArr[tempIndex]=arr[index2];
				index2++;
				tempIndex++;
			}else if(arr[index1]<arr[index2]) {
				newArr[tempIndex]=arr[index1];
				index1++;
				tempIndex++;
			}
		}
		
		while(index1<=mid) {
			newArr[tempIndex]=arr[index1];
			index1++;
			tempIndex++;
		}
		
		while(index2<=b) {
			newArr[tempIndex]=arr[index2];
			index2++;
			tempIndex++;
		}
		int c=0;
		for(int i=a; i<=b; i++ ) {
			arr[i]=newArr[c];
			c++;
		}
		
	}

}
