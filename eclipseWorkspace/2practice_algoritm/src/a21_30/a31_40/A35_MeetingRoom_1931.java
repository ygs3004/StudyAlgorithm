package a21_30.a31_40;

/*
문제
한 개의 회의실이 있는데 이를 사용하고자 하는 N개의 회의에 대하여 회의실 사용표를 만들려고 한다. 
각 회의 I에 대해 시작시간과 끝나는 시간이 주어져 있고, 각 회의가 겹치지 않게 하면서 회의실을 사용할 수 있는 회의의 최대 개수를 찾아보자. 
단, 회의는 한번 시작하면 중간에 중단될 수 없으며 한 회의가 끝나는 것과 동시에 다음 회의가 시작될 수 있다. 회의의 시작시간과 끝나는 시간이 같을 수도 있다. 
이 경우에는 시작하자마자 끝나는 것으로 생각하면 된다.
입력
첫째 줄에 회의의 수 N(1 ≤ N ≤ 100,000)이 주어진다. 둘째 줄부터 N+1 줄까지 각 회의의 정보가 주어지는데 
이것은 공백을 사이에 두고 회의의 시작시간과 끝나는 시간이 주어진다. 시작 시간과 끝나는 시간은 231-1보다 작거나 같은 자연수 또는 0이다.
출력
첫째 줄에 최대 사용할 수 있는 회의의 최대 개수를 출력한다.
예제 입력 1 
11
1 4
5 7
0 6
5 9
3 8
6 10
8 12
3 5
2 13
8 11
12 14
->4
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class A35_MeetingRoom_1931 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		ArrayList<Meeting> meeting = new ArrayList<>();
		StringTokenizer st;
		
		for(int i=0; i<n; i++) {
			st=new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			meeting.add(new Meeting(start, end));
		}
		
		Collections.sort(meeting, new Comparator<Meeting>() {
			@Override 
			public int compare(Meeting a, Meeting b) {
				if(a.end==b.end) {
					return a.start-b.start;
				}
				return a.end-b.end;
			}
			
		});
		
		int count=1;
		Meeting now=meeting.get(0);
		for(int i=1; i<meeting.size(); i++) {
			if(now.end<=meeting.get(i).start) {
				count++;
				now=meeting.get(i);
			}
		}
		
		System.out.println(count);
	}

}


class Meeting{
	int start;
	int end;
	
	Meeting(int start, int end){
		this.start=start;
		this.end=end;
	}
}