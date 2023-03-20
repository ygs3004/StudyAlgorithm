package programmers.lv0.lv0_120885;

class Solution {
    public String solution(String bin1, String bin2) {
        return Integer.toBinaryString(Integer.parseInt(bin1,2)+Integer.parseInt(bin2,2));
    }
}