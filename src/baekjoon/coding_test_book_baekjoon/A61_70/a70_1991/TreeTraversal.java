package baekjoon.coding_test_book_baekjoon.A61_70.a70_1991;
/*
이진 트리를 입력받아 전위 순회(preorder traversal), 중위 순회(inorder traversal), 후위 순회(postorder traversal)한 결과를 출력하는 프로그램을 작성하시오.
예를 들어 위와 같은 이진 트리가 입력되면,
전위 순회한 결과 : ABDCEFG // (루트) (왼쪽 자식) (오른쪽 자식)
중위 순회한 결과 : DBAECFG // (왼쪽 자식) (루트) (오른쪽 자식)
후위 순회한 결과 : DBEGFCA // (왼쪽 자식) (오른쪽 자식) (루트)
가 된다.

입력
첫째 줄에는 이진 트리의 노드의 개수 N(1 ≤ N ≤ 26)이 주어진다. 둘째 줄부터 N개의 줄에 걸쳐 각 노드와 그의 왼쪽 자식 노드, 오른쪽 자식 노드가 주어진다.
노드의 이름은 A부터 차례대로 알파벳 대문자로 매겨지며, 항상 A가 루트 노드가 된다. 자식 노드가 없는 경우에는 .으로 표현한다.

출력
첫째 줄에 전위 순회, 둘째 줄에 중위 순회, 셋째 줄에 후위 순회한 결과를 출력한다. 각 줄에 N개의 알파벳을 공백 없이 출력하면 된다.

예제 입력 1
7
A B C
B D .
C E F
E . .
F . G
D . .
G . .
예제 출력 1
ABDCEFG
DBAECFG
DBEGFCA
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TreeTraversal {
    static int[][] tree;

    public static void main(String[] args) throws Exception{
        tree = new int[26][2];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++){
            String[] edge = br.readLine().split(" ");
            int node = edge[0].charAt(0)-'A';
            char left = edge[1].charAt(0);
            char right = edge[2].charAt(0);

            if(left == '.'){
                tree[node][0] = -1;
            }else{
                tree[node][0] = left-'A';
            }

            if(right == '.'){
                tree[node][1] = -1;
            } else{
                tree[node][1] = right-'A';
            }
        }
        preOrder(0);
        System.out.println();
        inOrder(0);
        System.out.println();
        postOrder(0);
        System.out.println();
    }

    private static void preOrder(int now) {
        if(now == -1)
            return;
        System.out.print((char)(now+'A'));        // 현재
        preOrder(tree[now][0]);                     // 왼쪽
        preOrder(tree[now][1]);                     // 오른쪽
    }

    private static void inOrder(int now) {
        if(now==-1)
            return;
        inOrder(tree[now][0]);                      // 왼쪽
        System.out.print((char)(now+'A'));        // 현재
        inOrder(tree[now][1]);                      // 오른쪽
    }

    private static void postOrder(int now) {
        if(now==-1)
            return;
        postOrder(tree[now][0]);                    // 왼쪽
        postOrder(tree[now][1]);                    // 오른쪽
        System.out.print((char)(now+'A'));        // 현재
    }

}