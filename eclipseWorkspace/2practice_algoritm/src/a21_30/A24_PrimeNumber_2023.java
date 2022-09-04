package a21_30;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
수빈이가 세상에서 가장 좋아하는 것은 소수이고, 취미는 소수를 가지고 노는 것이다. 요즘 수빈이가 가장 관심있어 하는 소수는 7331이다.
7331은 소수인데, 신기하게도 733도 소수이고, 73도 소수이고, 7도 소수이다.
즉, 왼쪽부터 1자리, 2자리, 3자리, 4자리 수 모두 소수이다! 수빈이는 이런 숫자를 신기한 소수라고 이름 붙였다.
수빈이는 N자리의 숫자 중에서 어떤 수들이 신기한 소수인지 궁금해졌다. N이 주어졌을 때, 수빈이를 위해 N자리 신기한 소수를 모두 찾아보자.
*/
public class A24_PrimeNumber_2023 {
	static int[] digit = {10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000};
	static int startDigit;
	static int thisDigit; 
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		if(n==1) {
			System.out.println(2+"\n"+3+"\n"+5+"\n"+7);
		}else {
		thisDigit = digit[n-1];
		startDigit = digit[n-2];
		dfs(2);
		dfs(3);
		dfs(5);
		dfs(7);
		}
		br.close();
	}
	
	static void dfs(int a) {
		if(a>thisDigit) return;
		if(!isPrime(a)) return;
		else if(a>startDigit){
			System.out.println(a);
			return;
		}else {
			a *= 10;
			for(int i=1; i<=9; i+=2) {
				dfs(a+i);
			}
		}
	}
	
	static boolean isPrime(int a) {
		for(int i=2;i<a; i++) {
			if(a%i==0) return false; 
		}
	return true;
	}
}

