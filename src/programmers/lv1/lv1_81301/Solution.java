package programmers.lv1.lv1_81301;

class Solution {
    public int solution(String s) {
        String[] number = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        for(int i=0; i<10; i++){
            s = s.replace(number[i], Integer.toString(i));
        }
        return Integer.parseInt(s);
    }
}