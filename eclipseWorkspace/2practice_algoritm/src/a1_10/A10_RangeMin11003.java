package a1_10;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;


/*
 * 제
N개의 수 A1, A2, ..., AN과 L이 주어진다.
Di = Ai-L+1 ~ Ai 중의 최솟값이라고 할 때, D에 저장된 수를 출력하는 프로그램을 작성하시오. 이때, i ≤ 0 인 Ai는 무시하고 D를 구해야 한다.
입력
첫째 줄에 N과 L이 주어진다. (1 ≤ L ≤ N ≤ 5,000,000)
둘째 줄에는 N개의 수 Ai가 주어진다. (-109 ≤ Ai ≤ 109)
출력
첫째 줄에 Di를 공백으로 구분하여 순서대로 출력한다.
ex)입력							출렭
12 3							1 1 1 2 2 2 2 2 3 3 2 2
1 5 2 3 6 2 3 7 3 5 2 6
 */
public class A10_RangeMin11003 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		Deque<Node> mydeque = new LinkedList<>();
		
		for(int i=0; i<n; i++) {
			int now = Integer.parseInt(st.nextToken());
			while(!mydeque.isEmpty() && mydeque.getLast().value>now) {
				mydeque.removeLast();
			}
			mydeque.add(new Node(i, now));
			if(mydeque.getFirst().index<=i-l) mydeque.removeFirst();
			
			bw.write(mydeque.getFirst().value+" ");
		}
		bw.flush();
		br.close();
		bw.close();
	}
}

class Node{
	int index;
	int value;
	
	Node(int index, int value){
		this.index=index;
		this.value=value;
	}
	
}

/* 시간초과
		int[] num = new int[n];
		int[] min = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
min[0]=num[0];

for (int i=1; i<n; i++){
	if(i<l) {
		if(num[i]<min[i-1]) {
			min[i]=num[i];
		}else {
			min[i]=min[i-1];
		}
	}
	
	else if(i>=l) {
		if(num[i]<=min[i-1]) {
			min[i]=num[i];
		}else {
			int minN=(int)Math.pow(10, 9);
			for(int j=i-l+1; j<=i; j++) {
				if(num[j]<minN) minN = num[j];
			}
			min[i]=minN;
		}
	}
	
	System.out.print(min[i]+" ");
}
*/