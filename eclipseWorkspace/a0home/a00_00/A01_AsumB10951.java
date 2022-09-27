	package a0home.a00_00;
	
	import java.io.BufferedReader;
	import java.io.BufferedWriter;
	import java.io.InputStreamReader;
	import java.io.OutputStreamWriter;
	import java.util.StringTokenizer;
	
	//두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.
	
	
	public class A01_AsumB10951 {
	
		public static void main(String[] args) throws Exception {
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			StringTokenizer st;
			try {
				while(true) {
					st = new StringTokenizer(br.readLine());
					int n=Integer.parseInt(st.nextToken());
					int m=Integer.parseInt(st.nextToken());
					int sum = n+m;
					String result = Integer.toString(sum);
					bw.write(result+"\n");
				}
			}catch(Exception e) {
				bw.flush();
				bw.close();	
			}
			
		}
	}
