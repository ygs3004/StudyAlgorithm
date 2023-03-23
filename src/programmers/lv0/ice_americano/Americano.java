/*
아이스 아메리카노
문제 설명
머쓱이는 추운 날에도 아이스 아메리카노만 마십니다. 아이스 아메리카노는 한잔에 5,500원입니다.
머쓱이가 가지고 있는 돈 money가 매개변수로 주어질 때, 머쓱이가 최대로 마실 수 있는
아메리카노의 잔 수와 남는 돈을 순서대로 담은 배열을 return 하도록 solution 함수를 완성해보세요.
*/

package programmers.lv0.ice_americano;

import programmers.lv0.excute.Programmers;

public class Americano {

    public static void main(String[] args) {
        int money1 = 5500;
        int money2 = 15000;

        new Solution().result(money1);
        new Solution().result(money2);
    }

}

class Solution extends Programmers<int[], Integer> {
    final static int COFFEE_MONEY = 5500;
    public int[] solution(Integer money) {
        int[] answer = new int[2];
        answer[0] = money/COFFEE_MONEY;
        answer[1] = money%COFFEE_MONEY;
        return answer;
    }
}
