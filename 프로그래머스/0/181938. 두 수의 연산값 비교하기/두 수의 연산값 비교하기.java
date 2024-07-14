class Solution {
    public int solution(int a, int b) {
        int result1 = Integer.parseInt(Integer.toString(a) + Integer.toString(b));
        int result2 = 2 * a * b;
        return result1 >= result2 ? result1 : result2;
    }
}