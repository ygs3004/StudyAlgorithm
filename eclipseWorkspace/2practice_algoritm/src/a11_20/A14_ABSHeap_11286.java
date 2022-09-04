package a11_20;
/*
문제
절댓값 힙은 다음과 같은 연산을 지원하는 자료구조이다.

배열에 정수 x (x ≠ 0)를 넣는다.
배열에서 절댓값이 가장 작은 값을 출력하고, 그 값을 배열에서 제거한다. 절댓값이 가장 작은 값이 여러개일 때는, 가장 작은 수를 출력하고, 그 값을 배열에서 제거한다.
프로그램은 처음에 비어있는 배열에서 시작하게 된다.

첫째 줄에 연산의 개수 N(1≤N≤100,000)이 주어진다. 다음 N개의 줄에는 연산에 대한 정보를 나타내는 정수 x가 주어진다.
만약 x가 0이 아니라면 배열에 x라는 값을 넣는(추가하는) 연산이고, x가 0이라면 배열에서 절댓값이 가장 작은 값을 출력하고 그 값을 배열에서 제거하는 경우이다.
입력되는 정수는 -2^31보다 크고, 2^31보다 작다.

ex)입력					  출력
18                         -1
1                          1 
-1                         0 
0                          -1
0                          -1
0                          1 
1                          1 
1                          -2
-1                         2 
-1                         0 
2
-2
0
0
0
0
0
0
0
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class A14_ABSHeap_11286 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> priorQ = new PriorityQueue<>(       //우선순위 큐 '조건정하기' 람다식 comparator
				(n1, n2) -> {
					if(Math.abs(n1) == Math.abs(n2)) {
						if(n1<n2)
							return -1;
						return 1;
					}else if(Math.abs(n1)<Math.abs(n2)) {
						return -1;
					}else {
						return 1;
					}
				}
			);
		
		for(int i=0; i<n; i++) {
			int m = Integer.parseInt(br.readLine());
			if(m !=0 ) {
				priorQ.add(m);	
			}else if(priorQ.isEmpty()){
				System.out.println(0);
			}
			else {
				System.out.println(priorQ.poll());
			}
			
		}
		
		
		
		
		
		
		
		
		/* 시간초과
		Deque<Long> deqS = new LinkedList<Long>();
		Deque<Long> deqB = new LinkedList<Long>();
		long m;
		deqS.push((long) 0);
		
		for(int i=0; i<n; i++) {
			m=Long.parseLong(br.readLine());
			
			if(m!=0) {
				if(Math.abs(deqS.getLast())==Math.abs(m)) {
					 while(m<deqS.getLast() && deqS.getLast()!=0) {
						deqB.addFirst(deqS.pollLast());
					} deqS.addLast(m);
				}else if(Math.abs(deqS.getLast())<Math.abs(m)){
					if(deqB.isEmpty()) {
						deqS.addLast(m);
					}else if(!deqB.isEmpty()) {
						while(!deqB.isEmpty() && Math.abs(deqB.getFirst())<Math.abs(m)) {
							deqS.addLast(deqB.pollFirst());
						}deqB.addFirst(m);
					}
				}else if(Math.abs(deqS.getLast())>Math.abs(m)) {
					while(Math.abs(m)<Math.abs(deqS.getLast())) {
						deqB.addFirst(deqS.pollLast());
					}
					if(deqS.getLast()>m && m>0) deqB.addFirst(deqS.pollLast());
					deqS.addLast(m);
				}
			}
			
			if(m==0) {
				while(deqS.getLast()!=0){
					deqB.addFirst(deqS.pollLast());
				}
				if(deqB.isEmpty()) {
					System.out.println("0");
				}else {
					System.out.println(deqB.pollFirst());
				}
				
			}
		}*/
	}
}