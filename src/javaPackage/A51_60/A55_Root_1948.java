package javaPackage.A51_60;
/*
월드 나라는 모든 도로가 일방통행인 도로이고, 싸이클이 없다. 그런데 어떤 무수히 많은 사람들이 월드 나라의 지도를 그리기 위해서,
어떤 시작 도시로부터 도착 도시까지 출발을 하여 가능한 모든 경로를 탐색한다고 한다.
이 지도를 그리는 사람들은 사이가 너무 좋아서 지도를 그리는 일을 다 마치고 도착 도시에서 모두 다 만나기로 하였다.
그렇다고 하였을 때 이들이 만나는 시간은 출발 도시로부터 출발한 후 최소 몇 시간 후에 만날 수 있는가? 즉, 마지막에 도착하는 사람까지 도착을 하는 시간을 의미한다.
어떤 사람은 이 시간에 만나기 위하여 1분도 쉬지 않고 달려야 한다. 이런 사람들이 지나는 도로의 수를 카운트 하여라.
출발 도시는 들어오는 도로가 0개이고, 도착 도시는 나가는 도로가 0개이다.
입력
첫째 줄에 도시의 개수 n(1 ≤ n ≤ 10,000)이 주어지고 둘째 줄에는 도로의 개수 m(1 ≤ m ≤ 100,000)이 주어진다. 그리고 셋째 줄부터 m+2줄까지 다음과 같은 도로의 정보가 주어진다.
처음에는 도로의 출발 도시의 번호가 주어지고 그 다음에는 도착 도시의 번호, 그리고 마지막에는 이 도로를 지나는데 걸리는 시간이 주어진다.
도로를 지나가는 시간은 10,000보다 작거나 같은 자연수이다.
그리고 m+3째 줄에는 지도를 그리는 사람들이 출발하는 출발 도시와 도착 도시가 주어진다.
모든 도시는 출발 도시로부터 도달이 가능하고, 모든 도시로부터 도착 도시에 도달이 가능하다.
출력
첫째 줄에는 이들이 만나는 시간을, 둘째 줄에는 1분도 쉬지 않고 달려야 하는 도로의 수가 몇 개인지 출력하여라.
예제 입력 1
7
9
1 2 4
1 3 2
1 4 3
2 6 3
2 7 5
3 5 1
4 6 4
5 6 2
6 7 5
1 7
예제 출력 1
12
5
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class A55_Root_1948 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<City>> A = new ArrayList<>();
        ArrayList<ArrayList<City>> rA = new ArrayList<>();
        int[] indegree= new int[n+1];

        for(int i=0; i<=n; i++){
            A.add(new ArrayList<>());
            rA.add(new ArrayList<>());
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            A.get(s).add(new City(e, v));
            rA.get(e).add(new City(s, v));
            indegree[e]++;
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        Queue<Integer> que = new LinkedList<>();
        que.add(start);
        int[] result = new int[n+1]; // 정답 거리 계산
        while(!que.isEmpty()){
            int now = que.poll();
            for(City next : A.get(now)){
                indegree[next.target]--;
                result[next.target] = Math.max(result[next.target], result[now] + next.val); // next 지점까지의 시간, 현재 경로를 거치는게 더 오래 걸릴 경우 업데이트
                if(indegree[next.target]==0){
                    que.add(next.target);
                }
            }
        }

        int resultCount=0; // 정답 도시 수 계산
        boolean visited[] = new boolean[n+1];
        que.add(end);
        visited[end] = true;
        while(!que.isEmpty()){
            int now = que.poll();
            for(City next : rA.get(now)){
                if(result[next.target]+next.val == result[now]){ //1분도 쉬지 않아야하는지(임계경로인지) 체크
                    resultCount++;
                    if(visited[next.target] == false){ // 중복 카운트 방지
                        visited[next.target] = true;
                        que.add(next.target);
                    }
                }
            }
        }

        System.out.println(result[end]);
        System.out.println(resultCount);
    }
}

class City{
    int target;
    int val;

    City(int target, int val){
        this.target=target;
        this.val=val;
    }
}