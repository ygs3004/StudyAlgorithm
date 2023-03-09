package javaPackage.coding_test_book.A71_80.a71_2042;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 세그먼트 트리
어떤 N개의 수가 주어져 있다. 그런데 중간에 수의 변경이 빈번히 일어나고 그 중간에 어떤 부분의 합을 구하려 한다. 만약에 1,2,3,4,5 라는 수가 있고,
3번째 수를 6으로 바꾸고 2번째부터 5번째까지 합을 구하라고 한다면 17을 출력하면 되는 것이다.
그리고 그 상태에서 다섯 번째 수를 2로 바꾸고 3번째부터 5번째까지 합을 구하라고 한다면 12가 될 것이다.
입력
첫째 줄에 수의 개수 N(1 ≤ N ≤ 1,000,000)과 M(1 ≤ M ≤ 10,000), K(1 ≤ K ≤ 10,000) 가 주어진다. M은 수의 변경이 일어나는 횟수이고, K는 구간의 합을 구하는 횟수이다.
그리고 둘째 줄부터 N+1번째 줄까지 N개의 수가 주어진다. 그리고 N+2번째 줄부터 N+M+K+1번째 줄까지 세 개의 정수 a, b, c가 주어지는데,
a가 1인 경우 b(1 ≤ b ≤ N)번째 수를 c로 바꾸고 a가 2인 경우에는 b(1 ≤ b ≤ N)번째 수부터 c(b ≤ c ≤ N)번째 수까지의 합을 구하여 출력하면 된다.
입력으로 주어지는 모든 수는 -263보다 크거나 같고, 263-1보다 작거나 같은 정수이다.
출력
첫째 줄부터 K줄에 걸쳐 구한 구간의 합을 출력한다. 단, 정답은 -263보다 크거나 같고, 263-1보다 작거나 같은 정수이다.
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
17
12
*/
public class PartialSum {

    static long[] tree;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
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
        int leftNodeStartIndex = treeSize/2-1 ;
        tree = new long[treeSize+1];
        // 데이터를 리프 노드에 입력받기

        for(int i=leftNodeStartIndex+1; i<=leftNodeStartIndex+n; i++){
            tree[i]=Long.parseLong(br.readLine());
        }
        setTree(treeSize-1);
        for(int i=0; i<m+k; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            long e = Long.parseLong(st.nextToken());

            if(a==1){
                changeVal(leftNodeStartIndex+s, e);
            } else if(a==2){
                s = s+leftNodeStartIndex;
                e = e+leftNodeStartIndex;
                System.out.println(getSum(s,(int)e));
            } else {
                return;
            }
        }
        br.close();

    }

    private static void changeVal(int index, long val){
        long diff = val - tree[index];
        while(index>0){
            tree[index] = tree[index] + diff;
            index = index / 2;
        }
    }

    // 초기 트리를 구성하는 함수. index/2의 자리에 index값을 넣어 트리의 중앙을 기점으로 좌우 구성을 맞춤
    private static void setTree(int i){
        while(i!=1){
            tree[i/2] += tree[i];
            i--;
        }
    }

    private static long getSum(int s, int e){
        long partSum = 0;
        while(s<=e){
            if(s%2 == 1){
                partSum += tree[s];
                s++;
            }
            if(e%2 == 0){
                partSum += tree[e];
                e--;
            }
            s /= 2;
            e /= 2;
        }
        return partSum;

    }
}