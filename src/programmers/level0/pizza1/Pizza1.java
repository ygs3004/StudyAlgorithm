/*
피자 나눠 먹기 (1)
문제 설명
머쓱이네 피자가게는 피자를 일곱 조각으로 잘라 줍니다. 피자를 나눠먹을 사람의 수 n이 주어질 때,
모든 사람이 피자를 한 조각 이상 먹기 위해 필요한 피자의 수를 return 하는 solution 함수를 완성해보세요.
https://school.programmers.co.kr/learn/courses/30/lessons/120814
*/

package programmers.level0.pizza1;

import programmers.excute.ProgrammersInt;

public class Pizza1 {

    public static void main(String[] args) {

        new Solution().result(7);
        new Solution().result(1);
        new Solution().result(15);

    }

}

class Solution extends ProgrammersInt {

    public int solution(int n) {
        return n%7==0 ? n/7 : n/7+1 ;
    }

}