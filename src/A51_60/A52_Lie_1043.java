package A51_60;
/*
지민이는 파티에 가서 이야기 하는 것을 좋아한다. 파티에 갈 때마다, 지민이는 지민이가 가장 좋아하는 이야기를 한다.
지민이는 그 이야기를 말할 때, 있는 그대로 진실로 말하거나 엄청나게 과장해서 말한다. 당
연히 과장해서 이야기하는 것이 훨씬 더 재미있기 때문에, 되도록이면 과장해서 이야기하려고 한다. 하지만,
지민이는 거짓말쟁이로 알려지기는 싫어한다. 문제는 몇몇 사람들은 그 이야기의 진실을 안다는 것이다.
따라서 이런 사람들이 파티에 왔을 때는, 지민이는 진실을 이야기할 수 밖에 없다. 당연히,
어떤 사람이 어떤 파티에서는 진실을 듣고, 또다른 파티에서는 과장된 이야기를 들었을 때도 지민이는 거짓말쟁이로 알려지게 된다.
지민이는 이런 일을 모두 피해야 한다.
사람의 수 N이 주어진다. 그리고 그 이야기의 진실을 아는 사람이 주어진다. 그리고 각 파티에 오는 사람들의 번호가 주어진다.
지민이는 모든 파티에 참가해야 한다. 이때, 지민이가 거짓말쟁이로 알려지지 않으면서,
이야기를 할 수 있는 파티 개수의 최댓값을 구하는 프로그램을 작성하시오.

입력
첫째 줄에 사람의 수 N과 파티의 수 M이 주어진다.
둘째 줄에는 이야기의 진실을 아는 사람의 수와 번호가 주어진다.
진실을 아는 사람의 수가 먼저 주어지고 그 개수만큼 사람들의 번호가 주어진다.
사람들의 번호는 1부터 N까지의 수로 주어진다.
셋째 줄부터 M개의 줄에는 각 파티마다 오는 사람의 수와 번호가 같은 방식으로 주어진다.
N, M은 50 이하의 자연수이고, 진실을 아는 사람의 수는 0 이상 50 이하의 정수,
각 파티마다 오는 사람의 수는 1 이상 50 이하의 정수이다.

출력
첫째 줄에 문제의 정답을 출력한다.

예제 입력 1
4 3
0
2 1 2
1 3
3 2 3 4
예제 출력 1
3
예제 입력 2
4 1
1 1
4 1 2 3 4
예제 출력 2
0
예제 입력 3
4 1
0
4 1 2 3 4
예제 출력 3
1
예제 입력 4
4 5
1 1
1 1
1 2
1 3
1 4
2 4 1
예제 출력 4
2
예제 입력 5
10 9
4 1 2 3 4
2 1 5
2 2 6
1 7
1 8
2 7 8
1 9
1 10
2 3 10
1 4
예제 출력 5
4
예제 입력 6
8 5
3 1 2 7
2 3 4
1 5
2 5 6
2 6 8
1 8
예제 출력 6
5
예제 입력 7
3 4
1 3
1 1
1 2
2 1 2
3 1 2 3
예제 출력 7
0
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class A52_Lie_1043 {

    static int[] people;
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 사람수
        int m = Integer.parseInt(st.nextToken()); // 파티수
        int result = 0;
        ArrayList<Integer>[] info = new ArrayList[m];
        people = new int[n+1];
        for(int i=0; i< people.length; i++){
            people[i]=i;
        }

        st = new StringTokenizer(br.readLine()); // 진실을 알고있는 사람 정보
        int truePeople = Integer.parseInt(st.nextToken());
        if(truePeople == 0){
            System.out.println(m);
            return;
        }

        int[] know = new int[truePeople];
        for(int i=0; i<truePeople; i++){
            know[i] = Integer.parseInt(st.nextToken());
        }

        ArrayList<Integer> partyPeople;
        for(int cnt=0; cnt<m; cnt++){
            st = new StringTokenizer(br.readLine(), " ");
            int partyPeoples = Integer.parseInt(st.nextToken());

            partyPeople = new ArrayList<>();
            for(int i=1; i<=partyPeoples; i++){
                partyPeople.add(Integer.parseInt(st.nextToken()));
            }
            if(partyPeople.size()>=2) {
                for (int i = 0; i < partyPeople.size() - 1; i++) {
                    union(partyPeople.get(i), partyPeople.get(i + 1));
                }
            }

            info[cnt] = partyPeople;
        }

        boolean check = true;

        for(int i=0; i<m; i++){
            check = true;
            for(int j=0; j<know.length; j++){
                if(find(know[j]) == find(info[i].get(0))){
                    check = false;
                    break;
                }
            }
            if(check) result++;
        }

        System.out.println(result);

    }

    public static void union(int a, int b){
        a = find(a);
        b = find(b);

        if(a != b){
            people[b] = a;
        }

    }

    public static int find(int a){
        if(people[a] == a){
            return a;
        }

        return people[a] = find(people[a]);
    }

}