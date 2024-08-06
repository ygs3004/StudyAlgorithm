class Solution {
    public int solution(int a, int b) {
        boolean isOddA = a % 2 != 0;
        boolean isOddB = b % 2 != 0;
        return isOddA && isOddB ? (a * a) + (b * b)
            : isOddA ^ isOddB ? 2 * (a+b)
                : a - b > b - a ? a- b : b- a;
    }
}