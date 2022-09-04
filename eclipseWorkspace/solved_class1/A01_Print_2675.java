package solved_class1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
문자열 S를 입력받은 후에, 각 문자를 R번 반복해 새 문자열 P를 만든 후 출력하는 프로그램을 작성하시오. 
즉, 첫 번째 문자를 R번 반복하고, 두 번째 문자를 R번 반복하는 식으로 P를 만들면 된다. S에는 QR Code "alphanumeric" 문자만 들어있다.
QR Code "alphanumeric" 문자는 0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ\$%*+-./: 이다.
입력										  출력
2
3 ABC                                     AAABBBCCC           
5 /HTP                                    /////HHHHHTTTTTPPPPP
*/
public class A01_Print_2675 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		String str;
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			str = st.nextToken();
			
			for(int j=0; j<str.length(); j++) {
				for(int cnt=0; cnt<a; cnt++)
				bw.write(Character.toString(str.charAt(j)));
			}
			bw.write("\n");		
		}
		
		bw.flush();
		bw.close();
		br.close();
	}

}
