package java.A61_70.a69_14425;
/*
총 N개의 문자열로 이루어진 집합 S가 주어진다.
입력으로 주어지는 M개의 문자열 중에서 집합 S에 포함되어 있는 것이 총 몇 개인지 구하는 프로그램을 작성하시오.

입력
첫째 줄에 문자열의 개수 N과 M (1 ≤ N ≤ 10,000, 1 ≤ M ≤ 10,000)이 주어진다.
다음 N개의 줄에는 집합 S에 포함되어 있는 문자열들이 주어진다.
다음 M개의 줄에는 검사해야 하는 문자열들이 주어진다.
입력으로 주어지는 문자열은 알파벳 소문자로만 이루어져 있으며, 길이는 500을 넘지 않는다. 집합 S에 같은 문자열이 여러 번 주어지는 경우는 없다.

출력
첫째 줄에 M개의 문자열 중에 총 몇 개가 집합 S에 포함되어 있는지 출력한다.

예제 입력 1
5 11
baekjoononlinejudge
startlink
codeplus
sundaycoding
codingsh
baekjoon
codeplus
codeminus
startlink
starlink
sundaycoding
codingsh
codinghs
sondaycoding
startrink
icerink
예제 출력 1
4
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SearchString {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Node root = new Node();
        for(int i=0; i<n; i++){ // 집합 S문자열 저장
            String str = br.readLine();
            Node now = root;
            for(int j=0; j<str.length(); j++){
                int temp= str.charAt(j)-'a';
                // 알파벳 인덱스로 변환
                if(now.next[temp]==null){
                    now.next[temp] = new Node();
                }
                now = now.next[temp];
                if(j == str.length()-1) now.isEnd = true;
            }
        }

        int count=0;
        for(int i=0; i<m; i++){
            String str = br.readLine();
            Node now = root;
            for(int j=0; j<str.length(); j++){
                int temp=str.charAt(j)-'a';
                if(now.next[temp] == null){
                    break;
                }
                now = now.next[temp];
                if(j==str.length()-1 && now.isEnd)
                    count++;
            }
        }

        System.out.println(count);
    }
}

class Node{

    Node[] next = new Node[26];
    boolean isEnd;

}