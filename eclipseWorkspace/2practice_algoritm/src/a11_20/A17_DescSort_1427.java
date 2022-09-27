package a11_20;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 첫째 줄에 정렬하려고 하는 수 N이 주어진다. N은 1,000,000,000보다 작거나 같은 자연수이다.


public class A17_DescSort_1427 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		List<Integer> list = new ArrayList<Integer>();
		String str = br.readLine();
		
		for(int i=0; i<str.length(); i++) {
			list.add(Character.getNumericValue(str.charAt(i)));
		}
		
		list.sort(Collections.reverseOrder());
		for(int a : list) {
			bw.write(a+"");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}

}