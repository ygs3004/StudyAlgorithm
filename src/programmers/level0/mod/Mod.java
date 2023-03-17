/*
정수 num1, num2가 매개변수로 주어질 때, num1를 num2로 나눈 나머지를 return 하도록 solution 함수를 완성해주세요.

제한사항
0 < num1 ≤ 100
0 < num2 ≤ 100
입출력 예
num1	num2	result
3	2	1
10	5	0
*/
package programmers.level0.mod;

public class Mod {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result1 = solution.solution(3, 2);
        int result2 = solution.solution(10, 5);

        System.out.println(result1);
        System.out.println(result2);
    }

}
class Solution {
    public int solution(int num1, int num2) {
        int answer = num1%num2;
        return answer;
    }
}