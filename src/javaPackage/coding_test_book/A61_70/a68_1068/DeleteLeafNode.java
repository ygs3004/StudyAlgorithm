package javaPackage.coding_test_book.A61_70.a68_1068;
/*
https://www.acmicpc.net/problem/1068
트리에서 리프 노드란, 자식의 개수가 0인 노드를 말한다.
트리가 주어졌을 때, 노드 하나를 지울 것이다. 그 때, 남은 트리에서 리프 노드의 개수를 구하는 프로그램을 작성하시오.
노드를 지우면 그 노드와 노드의 모든 자손이 트리에서 제거된다.
예를 들어, 다음과 같은 트리가 있다고 하자.
현재 리프 노드의 개수는 3개이다. (초록색 색칠된 노드) 이때, 1번을 지우면, 다음과 같이 변한다. 검정색으로 색칠된 노드가 트리에서 제거된 노드이다.
이제 리프 노드의 개수는 1개이다.

입력
첫째 줄에 트리의 노드의 개수 N이 주어진다. N은 50보다 작거나 같은 자연수이다. 둘째 줄에는 0번 노드부터 N-1번 노드까지
각 노드의 부모가 주어진다. 만약 부모가 없다면 (루트) -1이 주어진다. 셋째 줄에는 지울 노드의 번호가 주어진다.

출력
첫째 줄에 입력으로 주어진 트리에서 입력으로 주어진 노드를 지웠을 때, 리프 노드의 개수를 출력한다.

예제 입력 1
5
-1 0 0 1 1
2
예제 출력 1
2
예제 입력 2
5
-1 0 0 1 1
1
예제 출력 2
1
예제 입력 3
5
-1 0 0 1 1
0
예제 출력 3
0
예제 입력 4
9
-1 0 0 2 2 4 4 6 6
4
예제 출력 4
2
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class DeleteLeafNode {

    static boolean[] visited;
    static ArrayList<Integer>[] arr;
    static int deleteNode;
    static int result=0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        visited = new boolean[n];
        arr = new ArrayList[n];

        for(int i=0; i<arr.length; i++){
            arr[i] = new ArrayList<>();
        }

        int rootNode=0;
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            int temp = Integer.parseInt(st.nextToken());
            if(temp == -1) {
                rootNode = i;
            }else{
                arr[temp].add(i);
            }

        }
        deleteNode = Integer.parseInt(br.readLine());
        if(rootNode == deleteNode){
            System.out.println(0);
            return;
        }

        DFS(rootNode);

        System.out.println(result);

    }

    public static void DFS(int a){
        if(visited[a]) return;

        visited[a] = true;
        int check = 0;
        for(int i : arr[a]){
            if(visited[i] || i==deleteNode) {
                continue;
            }else {
                check++;
                DFS(i);
            }
        }
        if(check==0) result++;
    }

}