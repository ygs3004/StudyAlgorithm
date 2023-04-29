package programmers.lv2.lv2_12911;

class Solution {
    public int solution(int n) {
        int oneNumber = Integer.toBinaryString(n).replace("0","").length();
        while(n++ > 0){
            int nowOneNumber = Integer.toBinaryString(n).replace("0", "").length();
            if(oneNumber == nowOneNumber) return n;
        }
        return n;
    }
}