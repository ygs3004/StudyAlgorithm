package javaPackage.A91_100.a94_11049;
/*
다이나믹 프로그래밍, 동적 계획법
크기가 N×M인 행렬 A와 M×K인 B를 곱할 때 필요한 곱셈 연산의 수는 총 N×M×K번이다. 행렬 N개를 곱하는데 필요한 곱셈 연산의 수는 행렬을 곱하는 순서에 따라 달라지게 된다.
예를 들어, A의 크기가 5×3이고, B의 크기가 3×2, C의 크기가 2×6인 경우에 행렬의 곱 ABC를 구하는 경우를 생각해보자.
AB를 먼저 곱하고 C를 곱하는 경우 (AB)C에 필요한 곱셈 연산의 수는 5×3×2 + 5×2×6 = 30 + 60 = 90번이다.
BC를 먼저 곱하고 A를 곱하는 경우 A(BC)에 필요한 곱셈 연산의 수는 3×2×6 + 5×3×6 = 36 + 90 = 126번이다.
같은 곱셈이지만, 곱셈을 하는 순서에 따라서 곱셈 연산의 수가 달라진다.
행렬 N개의 크기가 주어졌을 때, 모든 행렬을 곱하는데 필요한 곱셈 연산 횟수의 최솟값을 구하는 프로그램을 작성하시오. 입력으로 주어진 행렬의 순서를 바꾸면 안 된다.

입력
첫째 줄에 행렬의 개수 N(1 ≤ N ≤ 500)이 주어진다.
둘째 줄부터 N개 줄에는 행렬의 크기 r과 c가 주어진다. (1 ≤ r, c ≤ 500)
항상 순서대로 곱셈을 할 수 있는 크기만 입력으로 주어진다.

출력
첫째 줄에 입력으로 주어진 행렬을 곱하는데 필요한 곱셈 연산의 최솟값을 출력한다. 정답은 231-1 보다 작거나 같은 자연수이다. 또한, 최악의 순서로 연산해도 연산 횟수가 231-1보다 작거나 같다.

예제 입력 1
3
5 3
3 2
2 6
예제 출력 1
90
*/

import java.util.Scanner;

public class MinimalProduct {
    
    static int n;
    static Matrix[] M;
    static int[][] D;
    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        M = new Matrix[n+1];
        D = new int[n+1][n+1];
        for(int i=0; i<D.length; i++)
            for(int j=0; j<D[i].length; j++)
                D[i][j] = -1;

        for(int i=1; i<=n; i++){
            int y = sc.nextInt();
            int x = sc.nextInt();
            M[i] = new Matrix(y, x);
        }
        System.out.println(excute(1, n));
    }

    static int excute(int s, int e){
        int result = Integer.MAX_VALUE;
        if(D[s][e] != -1) // 계산했던 부분이면 계산 x
            return D[s][e];
        if(s==e) // 행렬 1개 자체 곱셈 연산 (
            return 0;
        if(s+1==e) // 행렬 2개의 곱셈 연산
            return M[s].y*M[s].x*M[e].x;
        for(int i=s; i<e; i++) // 행렬이 3개 이상일 떄 곱셈 -> 점화식(재귀)
            result = Math.min(result, M[s].y*M[i].x*M[e].x+excute(s,i)+excute(i+1, e));

        return D[s][e]=result;
    }
    
}

class Matrix{
    public int y;
    public int x;

    Matrix(int y, int x){
        this.y=y;
        this.x=x;

    }
}