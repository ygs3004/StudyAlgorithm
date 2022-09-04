package a0home.a00_MOCOCO;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
알파벳 소문자로만 이루어진 단어 S가 주어진다. 각각의 알파벳에 대해서, 단어에 포함되어 있는 경우에는 처음 등장하는 위치를, 포함되어 있지 않은 경우에는 -1을 출력하는 프로그램을 작성하시오.
ex)
baekjoon
-> 1 0 -1 -1 2 -1 -1 -1 -1 4 3 -1 -1 7 5 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1
*/
public class A12_ALPHABET_10809 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int[] abc = new int[26];
		
		for(int i=0; i<26; i++) {
			abc[i]=-1;
		}
		
		for(int i=0; i<str.length(); i++) {
			if(abc[(int)str.charAt(i)-97]==-1)
				abc[(int)str.charAt(i)-97]=i;
		}
		
		for(int a : abc) {
			System.out.print(a+" ");
		}
	}

}

// a=97