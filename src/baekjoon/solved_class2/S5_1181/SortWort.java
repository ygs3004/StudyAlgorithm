package baekjoon.solved_class2.S5_1181;
/*
알파벳 소문자로 이루어진 N개의 단어가 들어오면 아래와 같은 조건에 따라 정렬하는 프로그램을 작성하시오.

길이가 짧은 것부터
길이가 같으면 사전 순으로
입력
첫째 줄에 단어의 개수 N이 주어진다. (1 ≤ N ≤ 20,000) 둘째 줄부터 N개의 줄에 걸쳐 알파벳 소문자로 이루어진 단어가 한 줄에 하나씩 주어진다. 주어지는 문자열의 길이는 50을 넘지 않는다.

출력
조건에 따라 정렬하여 단어들을 출력한다. 단, 같은 단어가 여러 번 입력된 경우에는 한 번씩만 출력한다.

예제 입력 1          예제 출력 1
13                  i
but                 im
i                   it
wont                no
hesitate            but
no                  more
more                wait
no                  wont
more                yours
it                  cannot
cannot              hesitate
wait
im
yours
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class SortWort {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int wordNumber = Integer.parseInt(br.readLine());

        if(wordNumber == 1){
            System.out.println(br.readLine());
            return;
        }

        String[] wordList = new String[wordNumber];

        for(int i=0; i<wordNumber; i++){
            wordList[i] = br.readLine();
        }

        Arrays.sort(wordList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() == o2.length() && !o1.equals(o2)){
                    char[] s1 = o1.toCharArray();
                    char[] s2 = o2.toCharArray();

                    int i = 0;
                    while(s1[i] == s2[i]){
                        i++;
                    }

                    return s1[i] - s2[i];
                }
                return o1.length()-o2.length();
            }
        });

        for(int i=0; i<wordNumber; i++){
            if(i!=0 && !wordList[i].equals(wordList[i-1])){
                System.out.println(wordList[i]);
            }else if(i==0){
                System.out.println(wordList[0]);
            }
        }

    }

}
