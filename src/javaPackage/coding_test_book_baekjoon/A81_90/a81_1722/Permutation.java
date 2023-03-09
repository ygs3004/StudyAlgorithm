package javaPackage.coding_test_book_baekjoon.A81_90.a81_1722;
/*
순열
1부터 N까지의 수를 임의로 배열한 순열은 총 N! = N×(N-1)×…×2×1 가지가 있다.
임의의 순열은 정렬을 할 수 있다. 예를 들어  N=3인 경우
{1, 2, 3}, {1, 3, 2}, {2, 1, 3}, {2, 3, 1}, {3, 1, 2}, {3, 2, 1}의 순서로 생각할 수 있다.
첫 번째 수가 작은 것이 순서상에서 앞서며, 첫 번째 수가 같으면 두 번째 수가 작은 것이, 두 번째 수도 같으면 세 번째 수가 작은 것이….
N이 주어지면, 아래의 두 소문제 중에 하나를 풀어야 한다. k가 주어지면 k번째 순열을 구하고,
임의의 순열이 주어지면 이 순열이 몇 번째 순열인지를 출력하는 프로그램을 작성하시오.

입력
첫째 줄에 N(1 ≤ N ≤ 20)이 주어진다. 둘째 줄의 첫 번째 수는 소문제 번호이다. 1인 경우 k(1 ≤ k ≤ N!)를 입력받고,
2인 경우 임의의 순열을 나타내는 N개의 수를 입력받는다. N개의 수에는 1부터 N까지의 정수가 한 번씩만 나타난다.

출력
k번째 수열을 나타내는 N개의 수를 출력하거나, 몇 번째 수열인지를 출력하면 된다.

예제 입력 1
4
1 3
예제 출력 1
1 3 2 4
예제 입력 2
4
2 1 3 2 4
예제 출력 2
3
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Permutation {

    public static void main(String[] args) throws Exception {

        long[] F = new long[21]; // 팩토리얼
        int[] S = new int[21]; // 정답 순열


        boolean[] visited = new boolean[21];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        F[0] = 1;
        for(int i=1; i<=n; i++){
            F[i] = F[i-1]*i;
        }

        st = new StringTokenizer(br.readLine());
        
        if(Integer.parseInt(st.nextToken()) == 1){ // 1번 문제 순서 -> 순열
            long k = Long.parseLong(st.nextToken());
            for(int i=1; i<=n; i++){
                int count=1;
                for(int j=1; j<=n; j++){
                    if(visited[j]) continue;
                    if(k <= count*F[n-i]){
                        k -= F[n-i]*(count-1);
                        S[i] = j; // 순열의 i번째 자리에 j
                        visited[j] = true;
                        break;
                    }
                    count++;
                }
            }
            for (int i=1; i<=n; i++) {
                System.out.print(S[i]+" ");
            }


        }else{ // 2번문제 순열 -> 순서
            long k = 1;
            for(int i=1; i<=n; i++){
                S[i] = Integer.parseInt(st.nextToken());
                long count = 0;
                for(int j=1; j<S[i]; j++){
                    if(visited[j] == false){
                        count++;
                    }
                }
                k += count*F[n-i]; // 앞자리부터 순서 체크
                visited[S[i]] = true;
            }
            System.out.println(k);
        }
    }

}