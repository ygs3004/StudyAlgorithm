package programmers.lv1.lv1_12934;

class Solution {
    public long solution(long n) {
        return Math.pow((int)Math.sqrt(n), 2) == n ? (long)Math.pow((int)Math.sqrt(n)+1, 2) : -1;
    }
}