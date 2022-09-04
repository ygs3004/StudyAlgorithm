package a03forwhile;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
준원이는 저번 주에 살면서 처음으로 코스트코를 가 봤다. 정말 멋졌다. 그런데, 몇 개 담지도 않았는데 수상하게 높은 금액이 나오는 것이다! 
준원이는 영수증을 보면서 정확하게 계산된 것이 맞는지 확인해보려 한다.
영수증에 적힌,구매한 각 물건의 가격과 개수, 구매한 물건들의 총 금액을 보고, 
구매한 물건의 가격과 개수로 계산한 총 금액이 영수증에 적힌 총 금액과 일치하는지 검사해보자.

입력
첫째 줄에는 영수증에 적힌 총 금액 $X$가 주어진다.
둘째 줄에는 영수증에 적힌 구매한 물건의 종류의 수 $N$이 주어진다.
이후 $N$개의 줄에는 각 물건의 가격 $a$와 개수 $b$가 공백을 사이에 두고 주어진다.

출력
구매한 물건의 가격과 개수로 계산한 총 금액이 영수증에 적힌 총 금액과 일치하면 Yes를 출력한다. 일치하지 않는다면 No를 출력한다.

제한
 $1 ≤ X ≤ 1\,000\,000\,000$ 
 $1 ≤ N ≤ 100$ 
 $1 ≤ a ≤ 1\,000\,000$ 
 $1 ≤ b ≤ 10$
 
ex)
260000
4
20000 5
30000 2
10000 6
5000 8
-> Yes

250000
4
20000 5
30000 2
10000 6
5000 8
->No
*/
public class A14_Recipient_25304 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int total = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());
		
		int sum=0;
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			sum += Integer.parseInt(st.nextToken())*Integer.parseInt(st.nextToken());
		}
		
		if(sum==total) System.out.println("Yes");
		else System.out.println("No");

	}

}

