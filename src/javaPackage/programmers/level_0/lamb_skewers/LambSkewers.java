/*
양꼬치
문제 설명
머쓱이네 양꼬치 가게는 10인분을 먹으면 음료수 하나를 서비스로 줍니다.
양꼬치는 1인분에 12,000원, 음료수는 2,000원입니다. 정수 n과 k가 매개변수로 주어졌을 때,
양꼬치 n인분과 음료수 k개를 먹었다면 총얼마를 지불해야 하는지 return 하도록 solution 함수를 완성해보세요.

제한사항
0 < n < 1,000
n / 10 ≤ k < 1,000
서비스로 받은 음료수는 모두 마십니다.
입출력 예
n	k	result
10	3	124,000
64	6	768,000
입출력 예 설명
입출력 예 #1
10인분을 시켜 서비스로 음료수를 하나 받아 총 10 * 12000 + 3 * 2000 - 1 * 2000 = 124,000원입니다.
입출력 예 #2
64인분을 시켜 서비스로 음료수를 6개 받아 총 64 * 12000 + 6 * 2000 - 6 * 2000 =768,000원입니다.
*/

package javaPackage.programmers.level_0.lamb_skewers;

import javaPackage.programmers.excute.ProgrammersInt;

public class LambSkewers {

    public static void main(String[] args) {
        new Solution().result(10, 3);
        new Solution().result(64, 6);

    }
}

class Solution extends ProgrammersInt {

    public int solution(int n, int k) {

        k -= n/10;

        int lambMoney = 12000*n;
        int drinkMoney = 2000*k;

        return lambMoney + drinkMoney;
    }

}