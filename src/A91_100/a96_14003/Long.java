package A91_100.a96_14003;
/*
수열 A가 주어졌을 때, 가장 긴 증가하는 부분 수열을 구하는 프로그램을 작성하시오.
예를 들어, 수열 A = {10, 20, 10, 30, 20, 50} 인 경우에 가장 긴 증가하는 부분 수열은
A = {10, 20, 10, 30, 20, 50} 이고, 길이는 4이다.

입력
첫째 줄에 수열 A의 크기 N (1 ≤ N ≤ 1,000,000)이 주어진다.

둘째 줄에는 수열 A를 이루고 있는 Ai가 주어진다. (-1,000,000,000 ≤ Ai ≤ 1,000,000,000)

출력
첫째 줄에 수열 A의 가장 긴 증가하는 부분 수열의 길이를 출력한다.

둘째 줄에는 정답이 될 수 있는 가장 긴 증가하는 부분 수열을 출력한다.

예제 입력 1
6
10 20 10 30 20 50
예제 출력 1
4
10 20 30 50
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Long {
    // 알고리즘 코딩테스트(자바편) 카피 코드
    static int n, maxLength;
    static int[] B = new int[1000001]; // 현재 가장 유리한 "수열"
    static int[] A = new int[1000001];
    static int[] D = new int[1000001]; // 0~i까지 i를 포함하는 최장 수열 길이
    static int[] ans = new int[1000001];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        int index;
        B[++maxLength] = A[1];
        D[1] = 1;
        for(int i=2; i<=n; i++){
            if(B[maxLength]<A[i]){ // 가장 마지막 수열보ㅗ다 현재 수열이 클 때
                B[++maxLength] = A[i];
                D[i] = maxLength;
            }else{
                // B 배열에서 data[i]보다 처음으로 크거나 같아지는 원소의 index 찾기
                index = binarysearch(1, maxLength, A[i]);
                B[index] = A[i]; // 최선의 배열에 a[i]를 넣어서 업데이트
                D[i] = index;
            }
        }
        System.out.println(maxLength);
        index = maxLength;
        int x = B[maxLength]+1;
        for(int i=n; i>=1; i--){
            if(D[i]==index && A[i]<x){
                ans[index] = A[i];
                x = A[i];
                index--;
            }
        }
        for(int i=1; i<=maxLength; i++)
            System.out.print(ans[i]+" ");
    }

    //현재 수열이 들어갈 수 있는 위치를 빠르게 찾아 주기 위한 바이너리 서치
    static int binarysearch(int l, int r, int now){
        int mid;
        while(l<r){
            mid = (l+r)/2;
            if(B[mid]<now)
                l=mid+1;
            else
                r=mid;
        }
        return l;
    }
}
