package java.A40_50;
/*
각각 부피가 A, B, C(1≤A, B, C≤200) 리터인 세 개의 물통이 있다. 처음에는 앞의 두 물통은 비어 있고,
세 번째 물통은 가득(C 리터) 차 있다.
이제 어떤 물통에 들어있는 물을 다른 물통으로 쏟아 부을 수 있는데, 이때에는 한 물통이 비거나,
다른 한 물통이 가득 찰 때까지 물을 부을 수 있다. 이 과정에서 손실되는 물은 없다고 가정한다.
이와 같은 과정을 거치다보면 세 번째 물통(용량이 C인)에 담겨있는 물의 양이 변할 수도 있다. 첫 번째 물통(용량이 A인)이 비어 있을 때,
세 번째 물통(용량이 C인)에 담겨있을 수 있는 물의 양을 모두 구해내는 프로그램을 작성하시오.
입력
첫째 줄에 세 정수 A, B, C가 주어진다.
출력
첫째 줄에 공백으로 구분하여 답을 출력한다. 각 용량은 오름차순으로 정렬한다.

예제 입력 1
8 9 10
예제 출력 1
1 2 8 9 10
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class A49_water_2251 {
    static boolean[][] visited;
    static boolean[] result;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        result = new boolean[c+1];
        visited = new boolean[c+1][c+1];
        visited[0][0] = true;

        Bottle b1 = new Bottle(a);
        Bottle b2 = new Bottle(b);
        Bottle b3 = new Bottle(c, c);
        result[c]=true;
        bfs(b1,b2,b3);

        for(int i=0; i<result.length; i++){
            if(result[i])
             bw.write(i+" ");
        }

        bw.flush();
        bw.close();
        br.close();

    }

    public static void bfs(Bottle b1, Bottle b2, Bottle b3){

        Queue<Bottle[]> que = new LinkedList<>();
        Bottle[] bottle = new Bottle[4];
        bottle[1] = b1; bottle[2] = b2; bottle[3] = b3;
        que.add(bottle);

        while(!que.isEmpty()){

            Bottle[] now = que.poll();
            visited[now[1].water][now[2].water] = true;

            for(int i=1; i<=3; i++){  // i는 주는 물통, j는 받는 물통
                if((now[i].water)==0) continue;
                for(int j=1; j<=3; j++){
                    if(i==j) continue;
                    Bottle[] next = {null,
                            new Bottle(now[1].size, now[1].water),
                            new Bottle(now[2].size, now[2].water),
                            new Bottle(now[3].size, now[3].water)
                    };

                    if(now[i].water > now[j].size-now[j].water){ // 주는 물이 받는 물통의 크기보다 많은경우
                        next[j].water = now[j].size;
                        next[i].water = now[i].water - (now[j].size-now[j].water);
                    }else{ // 주는 물이 받는 물통의 크기보다 적어 모두 주게 되는경우
                        next[j].water += now[i].water;
                        next[i].water = 0;
                    }

                    if(!visited[next[1].water][next[2].water]){
                        visited[next[1].water][next[2].water]=true;
                        que.add(next);

                        if(next[1].water==0) result[next[3].water] = true;
                    }
                }
            }
        }
    }

}

class Bottle{

    int size;
    int water=0;

    Bottle(){

    }

    Bottle(int size){
        this.size = size;
    }

    Bottle(int size, int water){
        this.size = size;
        this.water = water;
    }

}