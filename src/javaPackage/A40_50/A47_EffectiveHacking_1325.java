package javaPackage.A40_50;
/*
해커 김지민은 잘 알려진 어느 회사를 해킹하려고 한다. 이 회사는 N개의 컴퓨터로 이루어져 있다. 김지민은 귀찮기 때문에,
한 번의 해킹으로 여러 개의 컴퓨터를 해킹 할 수 있는 컴퓨터를 해킹하려고 한다.
이 회사의 컴퓨터는 신뢰하는 관계와, 신뢰하지 않는 관계로 이루어져 있는데, A가 B를 신뢰하는 경우에는 B를 해킹하면, A도 해킹할 수 있다는 소리다.
이 회사의 컴퓨터의 신뢰하는 관계가 주어졌을 때, 한 번에 가장 많은 컴퓨터를 해킹할 수 있는 컴퓨터의 번호를 출력하는 프로그램을 작성하시오.
입력
첫째 줄에, N과 M이 들어온다. N은 10,000보다 작거나 같은 자연수, M은 100,000보다 작거나 같은 자연수이다.
둘째 줄부터 M개의 줄에 신뢰하는 관계가 A B와 같은 형식으로 들어오며, "A가 B를 신뢰한다"를 의미한다. 컴퓨터는 1번부터 N번까지 번호가 하나씩 매겨져 있다.

출력
첫째 줄에, 김지민이 한 번에 가장 많은 컴퓨터를 해킹할 수 있는 컴퓨터의 번호를 오름차순으로 출력한다.

예제 입력 1
5 4
3 1
3 2
4 3
5 3
예제 출력 1
1 2
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class A47_EffectiveHacking_1325 {
    // 가장 만이 해킹할 수 있는 컴퓨터 -> DFS
    static ArrayList<Integer>[] info;
    static boolean visited[];
    static int[] result; // 컴퓨터 별 최대 해킹 횟수

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 컴퓨터 개수
        int m = Integer.parseInt(st.nextToken()); // 정보 개수

        result = new int[n+1];
        info = new ArrayList[n+1];
        for(int i=1; i<n+1; i++){
            info[i] = new ArrayList<>(); // 컴퓨터의 신뢰 정보, 0번 index는 없는 컴퓨터
        }

        for(int i=0; i<m; i++){
           st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            // a가 b를 신뢰한다 (b를 해킹시 a도 해킹 가능)

            info[b].add(a); // 연속 해킹할 수 있는 컴퓨터 정보 저장
        }

        for(int i=1; i<=n; i++){
            visited = new boolean[n+1];
            visited[i] = true; // 시작 노드 재방문 금지
            bfs(i);
        }

        int max=0;
        for(int i=1; i<=n; i++){
            if(result[i]>max) max = result[i];
        }

        for(int i=1; i<=n; i++){
            if(result[i]==max) bw.write(i+" ");
        }

        bw.flush();
        br.close();
        bw.close();
    }

    public static void bfs(int startComputer){

        Queue<Integer> que = new LinkedList<>();
        ArrayList<Integer> connect;

        que.add(startComputer);

        while(!que.isEmpty()){

            int a = que.poll();
            connect = info[a];  // 특정 컴퓨터를 해킹 했을때 해킹 할 수 있는 인덱스의 정보

            for(int i=0; i<connect.size(); i++){

                int connected = connect.get(i) ; // 연결된 컴퓨터
                if(visited[connected]) continue; // 이미 해킹한 경우 다음 인덱스 확인
                que.add(connected); // 아닐 경우 다음 해킹을 위해 que에 저장
                visited[connected] = true; // 방문 흔적 저장
                result[startComputer]++;
            }
        }
    }

}