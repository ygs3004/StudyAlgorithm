import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception{

        int total = 0;
        int[] stone = new int[51];
        double[] percent = new double[51];
        double result=0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for(int i=0; i<m; i++){
            stone[i] = Integer.parseInt(st.nextToken()); // 돌 개수 저장
            total += stone[i];
        }

        int k = Integer.parseInt(br.readLine());

        for(int i=0; i<m; i++){
            if(stone[i]>=k){
                percent[i] = 1.0;
                for(int j=0; j<k; j++){
                    percent[i] *= (double) (stone[i]-j) / (total-j);
                }
            }
            result += percent[i];
        }
        System.out.println(result);
    }

}