import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[] D = new int[n+2]; // 오늘부터 퇴사일까지 벌 수 있는 최대 수입
        int[] T = new int[n+1]; // 상담 시작시 경과일
        int[] P = new int[n+1]; // 해당 날짜에 상담 시작시 벌 수 있는 금액
        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=n; i>0; i--){
            if(i+T[i] > n+1){ // 입력된 상담 정보가 상담 종료일까지 못끝나는 경우
                D[i] = D[i+1]; // 오늘 시작하는 상담을 할 수 없으므로 다음날과 D[i]가 같음
            }else{
                D[i] = Math.max(D[i+1], P[i]+D[i+T[i]]); // 상담을 안할경우의 수입 vs 할 경우의 수입을 비교하여 상담 선택
            }
        }

        System.out.println(D[1]);
    }

}