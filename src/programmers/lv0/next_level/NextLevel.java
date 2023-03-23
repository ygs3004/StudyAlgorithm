/*
다음에 올 숫자
문제 설명
등차수열 혹은 등비수열 common이 매개변수로 주어질 때, 마지막 원소 다음으로 올 숫자를 return 하도록 solution 함수를 완성해보세요.

제한사항
2 < common의 길이 < 1,000
-1,000 < common의 원소 < 2,000
common의 원소는 모두 정수입니다.
등차수열 혹은 등비수열이 아닌 경우는 없습니다.
등비수열인 경우 공비는 0이 아닌 정수입니다.
입출력 예
common	result
[1, 2, 3, 4]	5
[2, 4, 8]	16
*/
package programmers.lv0.next_level;

import programmers.lv0.excute.ProgrammersInt;

public class NextLevel {

    public static void main(String[] args) {

        int[] common = {1, 2, 3, 4};
        int[] common2 = {2, 4, 8};
        int[] common3 = {1, 2, 4};

        new Solution().result(common);
        new Solution().result(common2);
        new Solution().result(common3);
    }

}

class Solution extends ProgrammersInt {

    public int solution(int[] common) {
        int gap1 = common[1]-common[0];
        int gap2 = common[2]-common[1];

        if(gap1 == gap2){
            return common[common.length-1] + gap1;
        }else{
            return common[common.length-1] * gap2/gap1;
        }
    }

}