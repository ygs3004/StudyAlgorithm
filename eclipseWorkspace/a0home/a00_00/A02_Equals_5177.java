package a0home.a00_00;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
지금껏 문제를 풀면서 출력 형식 오류 메시지를 본 적이 있을 것이다.

출력 형식 오류는 답은 적절히 맞았으나 공백 설정이 잘못되었거나, 일부 답안에 대해 자칫 지나치기 쉬운 사소한 오타를 냈을 때 볼 수가 있다.

이번 기회에 출력 형식 오류를 직접 잡아내는 프로그램을 작성해보면서 출력 형식 오류에 대한 이해도를 높이고 실수를 줄여보도록 하자.

프로그램은 두 개의 문자열을 비교하여 두 문자열이 출력 형식을 감안하면 같은 문자열인지, 혹은 그냥 서로 다른 문자열인지를 판정해야 한다.

프로그램에 입력되는 문자열은 다음의 문자들로만 이루어져 있다.

대문자 혹은 소문자 영문 알파벳
숫자
공백 (탭이 아닌 스페이스바)
특수 부호
특수 부호의 목록은 아래와 같다.

( ) [ ] { } . , ; :
출력 형식만 다른 문자열인지는 아래의 규칙에 따라 판정한다.

알파벳 대문자와 소문자는 구별하지 않는다.
공백이 하나 이상이라면, 공백의 크기는 관계없다. 물론 어떤 문자열엔 공백이 있고 어떤 문자열엔 공백이 없는 것, 즉 공백 유무의 차이 자체는 문제가 된다.
문자열의 맨 앞 혹은 맨 뒤에 나타나는 공백은 있으나 없으나 관계없다.
특수 부호의 바로 앞이나 바로 뒤에 나오는 공백도 있으나 없으나 상관없다.
여는 괄호끼리는 종류를 구별하지 않는다.
닫는 괄호끼리는 종류를 구별하지 않는다.
쉼표(",")와 세미콜론(";")은 구별하지 않는다.

3
( 1, 4 ) (2,3) (2,4)
{ 1; 4)   {2;3)  {2;4)
Data Set 1: equal
data   set 1 :  EQUAL
Data Set 1: equal
DataSet 1: equal
*/
public class A02_Equals_5177 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		for(int i=0; i<n ;i++) {
			String str1 = br.readLine();
			String str2 = br.readLine();

			str1=str1.toUpperCase();
			str2=str2.toUpperCase();
			
			str1=str1.replaceAll("\\{", "\\(");
			str1=str1.replaceAll("\\[", "\\(");
			str2=str2.replaceAll("\\{", "\\(");
			str2=str2.replaceAll("\\[", "\\(");
			
			str1=str1.replaceAll("\\}", "\\)");
			str1=str1.replaceAll("\\]", "\\)");
			str2=str2.replaceAll("\\}", "\\)");
			str2=str2.replaceAll("\\]", "\\)");
			
			str1=str1.replace(",", ";");
			str2=str2.replace(",", ";");
			
			String str3 = str1;
			String str4 = str2;

			str1=str1.replaceAll("\\s+","");
			str2=str2.replaceAll("\\s+","");

			if(str1.equals(str2)){
				str3=str3.replaceAll("\\(", " ");
				str4=str4.replaceAll("\\(", " ");

				str3=str3.replaceAll("\\)"," ");
				str4=str4.replaceAll("\\)"," ");
				
				str3=str3.replace(";", " ");
				str4=str4.replace(";", " ");
				
				str3=str3.replace(":", " ");
				str4=str4.replace(":", " ");
				
				str3=str3.replaceAll("\\s+"," ");
				str4=str4.replaceAll("\\s+"," ");
				

				if(str3.equals(str4)) {
					bw.write("Data Set "+(i+1)+": equal");

				}else {
					bw.write("Data Set "+(i+1)+": not equal");	

				}	
			}else if(!str1.equals(str2)) {
				bw.write("Data Set "+(i+1)+": not equal");
			}
			if(i==n-1) break;
			bw.write("\n"+"\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}

}
