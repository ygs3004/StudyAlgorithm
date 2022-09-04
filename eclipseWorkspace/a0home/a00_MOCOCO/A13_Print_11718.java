package a0home.a00_MOCOCO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class A13_Print_11718 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str;
		while((str = br.readLine()) != null) {
			bw.write(str+"\n");
			bw.flush();
		}	
		br.close();
		bw.close();	
	}

}