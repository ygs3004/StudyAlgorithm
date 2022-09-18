package A51_60;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
동혁이는 친구들과 함께 여행을 가려고 한다. 한국에는 도시가 N개 있고 임의의 두 도시 사이에 길이 있을 수도, 없을 수도 있다.
동혁이의 여행 일정이 주어졌을 때, 이 여행 경로가 가능한 것인지 알아보자. 물론 중간에 다른 도시를 경유해서 여행을 할 수도 있다.
예를 들어 도시가 5개 있고, A-B, B-C, A-D, B-D, E-A의 길이 있고, 동혁이의 여행 계획이 E C B C D 라면 E-A-B-C-B-C-B-D라는 여행경로를 통해 목적을 달성할 수 있다.
도시들의 개수와 도시들 간의 연결 여부가 주어져 있고, 동혁이의 여행 계획에 속한 도시들이 순서대로 주어졌을 때 가능한지 여부를 판별하는 프로그램을 작성하시오.
같은 도시를 여러 번 방문하는 것도 가능하다.
입력
첫 줄에 도시의 수 N이 주어진다. N은 200이하이다. 둘째 줄에 여행 계획에 속한 도시들의 수 M이 주어진다. M은 1000이하이다.
다음 N개의 줄에는 N개의 정수가 주어진다. i번째 줄의 j번째 수는 i번 도시와 j번 도시의 연결 정보를 의미한다. 1이면 연결된 것이고 0이면 연결이 되지 않은 것이다.
A와 B가 연결되었으면 B와 A도 연결되어 있다. 마지막 줄에는 여행 계획이 주어진다. 도시의 번호는 1부터 N까지 차례대로 매겨져 있다.

출력
첫 줄에 가능하면 YES 불가능하면 NO를 출력한다.
예제 입력 1
3
3
0 1 0
1 0 1
0 1 0
1 2 3
예제 출력 1
YES*/

public class A51_TravelPlan_1976 {
    static int[] city;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine()); // 도시 수
        int m = Integer.parseInt(br.readLine()); // 여행할 도시의 수
        city = new int[n+1];

        for(int i=1; i<city.length; i++){
            city[i]=i;
        }

        for(int i=0; i<n; i++){
            String[] info = br.readLine().split(" ");
            for(int j=0; j<info.length; j++){
                if(info[j].equals("1")){
                    int a = city[i+1];
                    int b = city[j+1];
                    union(a, b);
                }
            }
        }

        boolean result = true;
        String[] plan = br.readLine().split(" ");
            for(int i=0; i<plan.length-1; i++){
                if(!isConnected(Integer.parseInt(plan[i]), Integer.parseInt(plan[i+1]))){
                    result = false;
                    break;
                }
            }

        if(result) System.out.println("YES");
        else System.out.println("NO");

    }

    public static void union(int a, int b){

        if(!isConnected(a, b)){
            city[a]=b;
        }
    }

    public static int find(int a){
        if(city[a]==a)
            return a;
        else
           return find(city[a]);
    }

    public static boolean isConnected(int a, int b){
        a = find(a);
        b = find(b);
        if(a==b) return true;
        else return false;
    }

}