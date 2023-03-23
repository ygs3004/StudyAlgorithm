/*
두 수의 곱
문제 설명
정수 num1, num2가 매개변수 주어집니다. num1과 num2를 곱한 값을 return 하도록 solution 함수를 완성해주세요.

제한사항
0 ≤ num1 ≤ 100
0 ≤ num2 ≤ 100
입출력 예
num1	num2	result
3	4	12
27	19	513
입출력 예 설명
입출력 예 #1

num1이 3, num2가 4이므로 3 * 4 = 12를 return합니다.
입출력 예 #2

num1이 27, num2가 19이므로 27 * 19 = 513을 return합니다.
*/

package programmers.lv0.multiply;

import programmers.lv0.excute.ProgrammersInt;

public class Multiply {
    public static void main(String[] args) {
        int num1 = 3;
        int num2 = 4;
        new Solution().result(num1, num2);
    }
}

class Solution extends ProgrammersInt {
    @Override
    public int solution(int num1, int num2) {
        return num1*num2;
    }

}