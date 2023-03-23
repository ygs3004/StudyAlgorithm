package programmers.lv0.lv0_120860;

class Solution {
    public int solution(int[][] dots) {
        int answer = 0;
        int maxX = (int)Math.max(dots[0][0], Math.max(dots[1][0], dots[2][0]));
        int minX = (int)Math.min(dots[0][0], Math.min(dots[1][0], dots[2][0]));
        int maxY = (int)Math.max(dots[0][1], Math.max(dots[1][1], dots[2][1]));
        int minY = (int)Math.min(dots[0][1], Math.min(dots[1][1], dots[2][1]));
        
        return (maxX-minX)*(maxY-minY);
    }
}