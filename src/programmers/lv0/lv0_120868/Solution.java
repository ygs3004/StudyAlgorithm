package programmers.lv0.lv0_120868;

class Solution {
    public int solution(int[] paramSide) {
        int minimumSide = Math.abs(paramSide[1] - paramSide[0])+1;
        int maximumSide = paramSide[0] + paramSide[1]-1;    
        return maximumSide-minimumSide+1;
    }
}