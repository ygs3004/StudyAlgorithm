/*
숫자 비교하기
문제 설명
정수 num1과 num2가 매개변수로 주어집니다. 두 수가 같으면 1 다르면 -1을 retrun하도록 solution 함수를 완성해주세요.

제한사항
0 ≤ num1 ≤ 10,000
0 ≤ num2 ≤ 10,000
입출력 예
num1	num2	result
2	3	-1
11	11	1
7	99	-1
*/

package programmers.level0.number_compare;

public class NumberCompare {

    public static void main(String[] args) {
        Solution solution = new Solution();
        StringBuilder sb = new StringBuilder();
        sb.append(solution.solution(2, 3))
          .append("\n").append(solution.solution(11, 11))
          .append("\n").append(solution.solution(7, 99));

        System.out.println(sb);
    }

}

class Solution {
    public int solution(int num1, int num2) {
        return num1 == num2 ? 1 : -1;
    }
}
