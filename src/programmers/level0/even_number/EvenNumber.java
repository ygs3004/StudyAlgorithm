/*
짝수는 싫어요
문제 설명
정수 n이 매개변수로 주어질 때, n 이하의 홀수가 오름차순으로 담긴 배열을 return하도록
solution 함수를 완성해주세요.
*/

package programmers.level0.even_number;

import programmers.excute.Programmers;

import java.util.Arrays;
import java.util.stream.IntStream;

public class EvenNumber {

    public static void main(String[] args) {
        int n1 = 10;  // {1, 3, 5, 7, 9}
        int n2 = 15;  // {1, 3, 5, 7, 9, 11, 13, 15}

        new Solution().result(n1);
        new Solution().result(n2);
    }
}

class Solution extends Programmers<int[], Integer> {
    
    int value = 1;

    public int[] solution(Integer n) {
        n = n%2 == 0 ? n/2 : n/2+1;
        int[] answer = new int[n];
        answer = Arrays.stream(answer).map( v -> {
            v = value;
            value += 2;
            return v;
        } ).toArray();

        return answer;
    }
}

// 저장용: 다른사람 풀이
class Solution2 {
    public int[] solution(int n) {
        return IntStream.rangeClosed(0, n).filter(value -> value % 2 == 1).toArray();
    }
}