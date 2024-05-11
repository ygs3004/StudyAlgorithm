import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int maxNum = Integer.parseInt(st.nextToken());
        int cycle = Integer.parseInt(st.nextToken());
        Queue<Integer> que = new LinkedList<>();

        for (int i = 1; i <= maxNum; i++) {
            que.add(i);
        }

        int[] result = new int[maxNum];
        for(int i=0; i<maxNum; i++){
            int repeat = cycle;
            while(repeat != 0){
                repeat--;
                int num = que.poll();
                if(repeat == 0){
                    result[i] = num;
                }else{
                    que.add(num);
                }
            }
        }
        StringBuilder ret = new StringBuilder(Arrays.toString(result));
        ret.deleteCharAt(0);
        ret.deleteCharAt(ret.length() - 1);
        ret.insert(0, "<");
        ret.append(">");
        System.out.println(ret);
    }

}

