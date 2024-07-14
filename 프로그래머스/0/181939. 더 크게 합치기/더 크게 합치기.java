class Solution {
    public int solution(int a, int b) {
        return Math.max(Integer.parseInt("" + a + b), Integer.parseInt("" + b + a));
    }
}