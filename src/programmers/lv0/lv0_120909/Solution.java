package programmers.lv0.lv0_120909;

class Solution {
    public int solution(int n) {
        
        return Math.ceil(Math.sqrt(n)) == Math.floor(Math.sqrt(n)) ? 1 : 2;
        
    }
}