package programmers.lv0.aya;

import programmers.lv0.excute.ProgrammersInt;
public class AyaYeeUMaaWyeoo {

    public static void main(String[] args) {

        Solution solution = new Solution();
        String[] babbling1 = {"aya", "yee", "u", "maa", "wyeoo"};
        String[] babbling2 = {"ayaye", "uuuma", "ye", "yemawoo", "ayaa"};

        solution.result(babbling1);
        solution.result(babbling2);
        System.out.println("--------------------------------------------------");

    }

}

class Solution extends ProgrammersInt {
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