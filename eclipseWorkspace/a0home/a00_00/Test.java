package a0home.a00_00;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Test {

	public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] sum = new int[n+1];
        int[] rem = new int[m];
        int count=0;
        st = new StringTokenizer(br.readLine());
        
        for(int i=1; i<=n; i++){
            int add = Integer.parseInt(st.nextToken());
            sum[i] = sum[i-1]+add;
            
            if(sum[i]%m == 0) {
                count++;
            }
            rem[(int)(sum[i]%m)]+=1;
        }
        
        for(int i=0; i<m; i++){
            if(rem[i]>1){
                count+=(rem[i]*(rem[i]-1))/2;
            }
        }
        
        System.out.println(count);
    }
}