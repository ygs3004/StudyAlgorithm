/*
배열 원소의 길이
문제 설명
문자열 배열 strlist가 매개변수로 주어집니다. strlist 각 원소의 길이를 담은 배열을 retrun하도록 solution 함수를 완성해주세요.
*/

package javaPackage.programmers.level_0.array_length;


import javaPackage.programmers.excute.Programmers;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ArrayLength {

    public static void main(String[] args) {
        String[] strlist1 = {"We", "are", "the", "world!"};
        String[] strlist2 = new String[]{"I", "Love", "Programmers."};

        new Solution().result(strlist1);
        new Solution().result(strlist2);
    }
}

class Solution extends Programmers<int[], String[]> {
    public int[] solution(String[] strlist) {
        return Arrays.stream(strlist).mapToInt(v -> v.length()).toArray();
    }
}