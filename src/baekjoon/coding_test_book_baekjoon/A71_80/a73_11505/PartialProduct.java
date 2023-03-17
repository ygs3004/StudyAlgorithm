package baekjoon.coding_test_book_baekjoon.A71_80.a73_11505;
/* 세그먼트 트리 tree
문제
어떤 N개의 수가 주어져 있다. 그런데 중간에 수의 변경이 빈번히 일어나고 그 중간에 어떤 부분의 곱을 구하려 한다. 만약에 1, 2, 3, 4, 5 라는 수가 있고,
3번째 수를 6으로 바꾸고 2번째부터 5번째까지 곱을 구하라고 한다면 240을 출력하면 되는 것이다.
그리고 그 상태에서 다섯 번째 수를 2로 바꾸고 3번째부터 5번째까지 곱을 구하라고 한다면 48이 될 것이다.

입력
첫째 줄에 수의 개수 N(1 ≤ N ≤ 1,000,000)과 M(1 ≤ M ≤ 10,000), K(1 ≤ K ≤ 10,000) 가 주어진다. M은 수의 변경이 일어나는 횟수이고,
K는 구간의 곱을 구하는 횟수이다. 그리고 둘째 줄부터 N+1번째 줄까지 N개의 수가 주어진다.
그리고 N+2번째 줄부터 N+M+K+1 번째 줄까지 세 개의 정수 a,b,c가 주어지는데, a가 1인 경우 b번째 수를 c로 바꾸고 a가 2인 경우에는 b부터 c까지의 곱을 구하여 출력하면 된다.
입력으로 주어지는 모든 수는 0보다 크거나 같고, 1,000,000보다 작거나 같은 정수이다.

출력
첫째 줄부터 K줄에 걸쳐 구한 구간의 곱을 1,000,000,007로 나눈 나머지를 출력한다.
예제 입력 1
5 2 2
1
2
3
4
5
1 3 6
2 2 5
1 5 2
2 3 5
예제 출력 1
240
48
예제 입력 2
5 2 2
1
2
3
4
5
1 3 0
2 2 5
1 3 6
2 2 5
예제 출력 2
0
240
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PartialProduct {

    static long[] tree;
    static int mod;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =  new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int treeHeight = 0;
        int length = n;
        while(length!=0){
            length /= 2;
            treeHeight++;
        }

        int treeSize = (int)Math.pow(2, treeHeight+1);
        int sIdx = treeSize/2 - 1;
        mod = 1000000007;
        tree = new long[treeSize+1];
        
        for(int i=0; i<tree.length; i++){ //  곱셈이므로 트리의 초기값 1
            tree[i] = 1;
        }

        for(int i=sIdx+1; i<=sIdx+n; i++ ){
            tree[i]=Long.parseLong(br.readLine());
        }
        setTree(treeSize-1);
        for(int i=0; i<m+k; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            long e = Long.parseLong(st.nextToken());

            if(a == 1){
                changeVal(sIdx+s, e);
            }else if(a==2){
                s += sIdx;
                e += sIdx;
                System.out.println(getResult(s, (int) e));
            }
        }
        br.close();
    }

    // 모든 함수에서 곱셈 발생할때 마다 mod 수행( 분배 법칙을 적용 하기 위해 )
    private static long getResult(int s, int e){

        long partMod = 1;
        while(s<=e){
            if(s%2 == 1){
                partMod = partMod * tree[s] % mod;
                s++;
            }
            if(e%2 == 0){
                partMod = partMod * tree[e] % mod;
                e--;
            }
            s=s/2;
            e=e/2;
        }
        return partMod;
    }

    private static void changeVal(int index, long val){
        tree[index] = val;
        while(index>1){
            index = index / 2;
            tree[index] = tree[index * 2] % mod * tree[index * 2 + 1] % mod;
        }
    }

    private static void setTree(int i){
        while(i != 1){
            tree[i / 2] = tree[i / 2] * tree[i] % mod;
            i--;
        }
    }

}