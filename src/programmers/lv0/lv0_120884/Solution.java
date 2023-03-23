package programmers.lv0.lv0_120884;

class Solution {
    public int solution(int chicken) {
        int result = 0;
        
        while(chicken >= 10){
            chicken -= 10;
            result++;
            chicken++;
        }
        
        return result;
    }
}