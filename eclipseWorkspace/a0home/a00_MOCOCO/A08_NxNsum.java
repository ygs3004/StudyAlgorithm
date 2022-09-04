package a0home.a00_MOCOCO;
/*
N*M크기의 두 행렬 A와 B가 주어졌을 때, 두 행렬을 더하는 프로그램을 작성하시오.
3 3						4 4 4  
1 1 1                   6 6 6  
2 2 2                   5 6 100
0 1 0
3 3 3
4 4 4
5 5 100
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class A08_NxNsum {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		Line[] lines = new Line[2*n];
		
		for(int i=0; i<2*n; i++) {
			st=new StringTokenizer(br.readLine());
			lines[i] = new Line(st);
		}
		
		for(int i=0; i<n; i++) {
			while(!lines[i+n].line.isEmpty()) {
				int result = lines[i].line.poll()+lines[i+n].line.poll();
				bw.write(result+" ");
			}
			bw.write("\n");
		}
				
		bw.flush();
		br.close();
		bw.close();
	}

}

class Line{
	Queue<Integer> line = new LinkedList<Integer>();
	Line(StringTokenizer st){
		while(st.hasMoreTokens()) {
			line.add(Integer.parseInt(st.nextToken()));
		}
	}
}