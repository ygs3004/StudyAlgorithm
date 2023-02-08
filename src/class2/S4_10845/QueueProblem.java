package class2.S4_10845;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
정수를 저장하는 큐를 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성하시오.

명령은 총 여섯 가지이다.

push X: 정수 X를 큐에 넣는 연산이다.
pop: 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
size: 큐에 들어있는 정수의 개수를 출력한다.
empty: 큐가 비어있으면 1, 아니면 0을 출력한다.
front: 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
back: 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
입력
첫째 줄에 주어지는 명령의 수 N (1 ≤ N ≤ 10,000)이 주어진다. 둘째 줄부터 N개의 줄에는 명령이 하나씩 주어진다. 주어지는 정수는 1보다 크거나 같고, 100,000보다 작거나 같다. 문제에 나와있지 않은 명령이 주어지는 경우는 없다.

출력
출력해야하는 명령이 주어질 때마다, 한 줄에 하나씩 출력한다.

15
push 1
push 2
front
back
size
empty
pop
pop
pop
size
empty
pop
push 3
empty
front

1
2
2
0
1
2
-1
0
1
-1
0
3
*/
public class QueueProblem {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        NewQueue<Integer> queue = new NewQueue<>();

        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                String command = st.nextToken();
                int pushNum=0;
                if (st.hasMoreTokens()) {
                    pushNum = Integer.parseInt(st.nextToken());
                }

                queue.execute(command, pushNum, bw);
        }

        bw.flush();
        br.close();
        bw.close();
    }

    static class NewQueue<E> extends LinkedList<E> {

        public void execute(String command, E number, BufferedWriter bw) throws IOException {

            switch (command){
                case "push":
                    push(number);
                    break;
                case "pop":
                    pop(bw);
                    break;
                case "size":
                    size(bw);
                    break;
                case "empty":
                    empty(bw);
                    break;
                case "front":
                    front(bw);
                    break;
                case "back":
                    back(bw);
                    break;
            }

        }

        public void pop(BufferedWriter bw) throws IOException {
            if(!isEmpty()){
                bw.write(super.pop()+"\n");
            }else{
                bw.write(-1 + "\n");
            }
        }

        public void empty(BufferedWriter bw) throws IOException {
            if(isEmpty()) bw.write(1+"\n");
            else  bw.write(0+"\n");
        }

        public void size(BufferedWriter bw) throws IOException {
            bw.write(super.size()+"\n");
        }

        public void push(E e){
            add(e);
        }

        public void front(BufferedWriter bw)  throws IOException {
            if(!isEmpty()){
                bw.write(peekFirst()+"\n");
            }else{
                bw.write(-1 + "\n");
            }
        }

        public void back(BufferedWriter bw)  throws IOException {
            if(!isEmpty()){
                bw.write(peekLast()+"\n");
            }else{
                bw.write(-1 + "\n");
            }
        }

    }

}
