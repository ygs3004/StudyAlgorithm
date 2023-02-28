package javaPackage.A61_70.a66_1414;
/*
다솜이는 불우이웃 돕기 활동을 하기 위해 무엇을 할지 생각했다. 마침 집에 엄청나게 많은 랜선이 있다는 것을 깨달았다.
마침 랜선이 이렇게 많이 필요 없다고 느낀 다솜이는 랜선을 지역사회에 봉사하기로 했다.
다솜이의 집에는 N개의 방이 있다. 각각의 방에는 모두 한 개의 컴퓨터가 있다. 각각의 컴퓨터는 랜선으로 연결되어 있다.
어떤 컴퓨터 A와 컴퓨터 B가 있을 때, A와 B가 서로 랜선으로 연결되어 있거나, 또 다른 컴퓨터를 통해서 연결이 되어있으면 서로 통신을 할 수 있다.
다솜이는 집 안에 있는 N개의 컴퓨터를 모두 서로 연결되게 하고 싶다.
N개의 컴퓨터가 서로 연결되어 있는 랜선의 길이가 주어질 때, 다솜이가 기부할 수 있는 랜선의 길이의 최댓값을 출력하는 프로그램을 작성하시오.

입력
첫째 줄에 컴퓨터의 개수 N이 주어진다. 둘째 줄부터 랜선의 길이가 주어진다. i번째 줄의 j번째 문자가 0인 경우는 컴퓨터 i와 컴퓨터 j를 연결하는 랜선이 없음을 의미한다.
그 외의 경우는 랜선의 길이를 의미한다. 랜선의 길이는 a부터 z는 1부터 26을 나타내고, A부터 Z는 27부터 52를 나타낸다. N은 50보다 작거나 같은 자연수이다.

출력
첫째 줄에 다솜이가 기부할 수 있는 랜선의 길이의 최댓값을 출력한다. 만약, 모든 컴퓨터가 연결되어 있지 않으면 -1을 출력한다.
예제 입력 1
3
abc
def
ghi
예제 출력 1
40
예제 입력 2
2
a0
0b
예제 출력 2
-1
예제 입력 3
4
0X00
00Y0
0000
00Z0
예제 출력 3
0
예제 입력 4
2
Az
aZ
예제 출력 4
105
예제 입력 5
4
0top
c0od
er0o
pen0
예제 출력 5
134
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Help {

    static int[] parent;
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int sum=0;
        parent = new int[n];
        PriorityQueue<Computer> que = new PriorityQueue<>();

        for(int i=0; i<n; i++){
            char[] tempC = br.readLine().toCharArray();
            for(int j=0; j<n; j++){
                int temp=0;
                if(tempC[j]>='a' && tempC[j]<='z')
                    temp=tempC[j]-'a'+1;
                else if (tempC[j]>='A' && tempC[j]<='Z')
                    temp=tempC[j]-'A'+27;
                sum+=temp;
                if(i!=j && temp!=0) que.add(new Computer(i, j, temp));
            }
        }

        for(int i=0; i<parent.length; i++)
            parent[i]=i;

        int useComputer = 0;
        int result =0;
        while(!que.isEmpty()){
            Computer now = que.poll();
            if(find(now.s) != find(now.e)){
                union(now.s, now.e);
                result += now.v;
                useComputer++;
            }
        }

        if(useComputer == n-1){
            System.out.println(sum-result);
        }else{
            System.out.println(-1);
        }

    }

    public static void union(int a, int b){
        a = find(a);
        b = find(b);
        if(a!=b){
            parent[b]=a;
        }
    }

    public static int find(int a){
        if(parent[a] == a){
            return a;
        }else{
            return parent[a] = find(parent[a]);
        }
    }

}

class Computer implements Comparable<Computer>{
    int s;
    int e;
    int v;

    Computer(int s, int e, int v){
        this.s=s;
        this.e=e;
        this.v=v;
    }

    @Override
    public int compareTo(Computer o) {
        return this.v-o.v;
    }
}