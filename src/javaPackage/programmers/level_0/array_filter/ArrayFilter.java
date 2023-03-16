/*
머쓱이보다 키 큰 사람
문제 설명
머쓱이는 학교에서 키 순으로 줄을 설 때 몇 번째로 서야 하는지 궁금해졌습니다.
머쓱이네 반 친구들의 키가 담긴 정수 배열 array와 머쓱이의 키 height가 매개변수로 주어질 때,
머쓱이보다 키 큰 사람 수를 return 하도록 solution 함수를 완성해보세요.
*/

package javaPackage.programmers.level_0.array_filter;

import javaPackage.programmers.excute.ProgrammersInt;

import java.util.Arrays;

public class ArrayFilter {

    public static void main(String[] args) {

        new Solution().result(new int[]{149, 180, 192, 170}, 167); // 3
        new Solution().result(new int[]{180, 120, 140}, 190); // 0

    }
}

class Solution extends ProgrammersInt {
    public int solution(int[] array, int height) {
        return Arrays.stream(array).filter( v -> v > height ).toArray().length;
    }
}