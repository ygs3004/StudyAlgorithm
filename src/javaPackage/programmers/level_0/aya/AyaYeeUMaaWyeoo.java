package javaPackage.programmers.level_0.aya;

public class AyaYeeUMaaWyeoo {

    public static void main(String[] args) {

        Solution solution = new Solution();
        String[] babbling1 = {"aya", "yee", "u", "maa", "wyeoo"};
        String[] babbling2 = {"ayaye", "uuuma", "ye", "yemawoo", "ayaa"};

        int result1 = solution.solution(babbling1);
        int result2 = solution.solution(babbling2);

        System.out.println("result1 : "+ result1);
        System.out.println("result2 : "+ result2);
    }

}

class Solution {
    public int solution(String[] babbling) {
        int answer = 0;

        for(String babble : babbling){
            babble = babble.replaceAll("aya", ",");
            babble = babble.replaceAll("ye", ",");
            babble = babble.replaceAll("woo", ",");
            babble = babble.replaceAll("ma", ",");
            babble = babble.replaceAll(",", "");

            if(babble.length() == 0){
                answer++;
            }
        }

        return answer;
    }
}