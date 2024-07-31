import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

// 최소힙 (Silver 2)
// https://www.acmicpc.net/problem/1927

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int lineNum = Integer.parseInt(br.readLine());
        String line = "";
        while ((line = br.readLine()) != null) {
            int num = Integer.parseInt(line);
            switch (num) {
                case 0:
                    if(heap.isEmpty()){
                        bw.write(String.valueOf(0));
                        bw.newLine();
                    }else{
                        bw.write(String.valueOf(heap.poll()));
                        bw.newLine();
                    }
                    break;
                default: heap.add(num);
            }
        }

        bw.flush();
        br.close();
        bw.close();
    }

}