/*
특정 문자 제거하기
문제 설명
문자열 my_string과 문자 letter이 매개변수로 주어집니다.
my_string에서 letter를 제거한 문자열을 return하도록 solution 함수를 완성해주세요.
https://school.programmers.co.kr/learn/courses/30/lessons/120826
*/

package javaPackage.programmers.level_0.removeString;

import javaPackage.programmers.excute.Programmers2;

public class RemoveString {

    public static void main(String[] args) {
        String my_string1 = "abcdef";
        String letter1 = "f";
        new Solution().result(my_string1, letter1); // "abcde"
        String my_string2 = "BCBdbe";
        String letter2 = "B";
        new Solution().result(my_string2, letter2); // "Cdbe"

    }

}

class Solution extends Programmers2<String, String, String> {

    public String solution(String my_string, String letter){
        return my_string.replace(letter, "");
    }

}