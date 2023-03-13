/*
문제 설명
정수 num1과 num2가 주어질 때, num1에서 num2를 뺀 값을 return하도록 soltuion 함수를 완성해주세요.

제한사항
-50000 ≤ num1 ≤ 50000
-50000 ≤ num2 ≤ 50000
입출력 예
num1	num2	result
2	3	-1
100	2	98
*/
package javaPackage.programmers.level_0.minus;

public class Minus {

    public static void main(String[] args) {

        Solution solution = new Solution();
        System.out.println(solution.solution(2, 3));
        System.out.println(solution.solution(100, 2));
    }

}

class Solution {
    public int solution(int num1, int num2) {
        return num1 - num2;
    }
}