import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visited;
    static ArrayList<Ratio>[] cocktail;
    static long[] result;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));
        StringTokenizer st;

        long lcm = 1; // 최소 공배수
        int n = Integer.parseInt(br.readLine());
        cocktail = new ArrayList[n];
        visited = new boolean[n];
        result = new long[n];

        for(int i=0; i<n; i++){
            cocktail[i] = new ArrayList<Ratio>();
        }

        for(int i=0; i<n-1; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());

            cocktail[a].add(new Ratio(b, p, q));
            cocktail[b].add(new Ratio(a, q, p));

            lcm *= p*q/gcd(p,q); // 각 각의 비율의 최소 공배수를 모두 더한 값으로 각각의 비율로 나눴을때 정수가 나오는 총 질량 임의 선정
        }
        result[0] = lcm;
        DFS(0);
        //DFS를 통한 결과값은 최대로 나누어진 결과값이 아님 결과들의 gcd를 이용해서 정답을 도출해야함
        long gcd=lcm;

        for(int i=0; i<n; i++){
            gcd=gcd(gcd, result[i]);
        }

        for(int i=0; i<n; i++){
            result[i]/=gcd;
            bw.write(result[i]+" ");
        }

        bw.flush();
        br.close();
        bw.close();
    }
    public static long gcd(long a, long b) {
        if (b == 0) {
            return a;
        } else {
            long mod = a % b;
            return gcd(b, mod);
        }
    }

    public static void DFS(int a){
        visited[a]=true;
        for(Ratio ratio:cocktail[a]){
            int next = ratio.b;
            if(!visited[next]){
                result[next] = result[a]*ratio.q/ratio.p;
                DFS(next);
            }
        }
    }
}
class Ratio{

    int b;
    int p;
    int q;

    Ratio(int b, int p, int q){
        this.b=b;
        this.p=p;
        this.q=q;
    }

}
