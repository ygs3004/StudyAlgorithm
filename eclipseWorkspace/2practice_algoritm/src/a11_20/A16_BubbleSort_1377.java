package a11_20;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
문제
버블 소트 알고리즘을 다음과 같이 C++로 작성했다.
bool changed = false;
for (int i=1; i<=N+1; i++) {
    changed = false;
    for (int j=1; j<=N-i; j++) {
        if (A[j] > A[j+1]) {
            changed = true;
            swap(A[j], A[j+1]);
        }
    }
    if (changed == false) {
        cout << i << '\n';
        break;
    }
}  스왑 사이클이 멈추는 I 숫자
위 소스에서 N은 배열의 크기이고, A는 정렬해야 하는 배열이다. 배열은 A[1]부터 사용한다.
위와 같은 소스를 실행시켰을 때, 어떤 값이 출력되는지 구해보자.

입력
첫째 줄에 N이 주어진다. N은 500,000보다 작거나 같은 자연수이다. 둘째 줄부터 N개의 줄에 A[1]부터 A[N]까지 하나씩 주어진다. 
A에 들어있는 수는 1,000,000보다 작거나 같은 자연수 또는 0이다.
 
 *예제 입력 1 		출
5					3
10
1
5
2
3

5					1
1
3
5
7
9
*/
public class A16_BubbleSort_1377 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Data[] data = new Data[n];
				for(int i=0; i<n; i++) {
			data[i] = new Data(Integer.parseInt(br.readLine()), i);
		}
		
		Arrays.sort(data);
		
		int max=0;
		for(int i=0; i<n; i++) {
			if(data[i].index-i>max)
				max = data[i].index-i; 
		}
		
		System.out.println(max+1);
	}

}

class Data implements Comparable<Data>{
	
	int number;
	int index;
	
	Data(int number, int index) {
		this.number=number;
		this.index=index;
	}
	
	@Override
	public int compareTo(Data o) {
		if(this.number>o.number) return 1;
		if(this.number<o.number) return -1;
		else return 0;
	}
}