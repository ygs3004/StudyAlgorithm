package programmers.lv1.lv1_68935;

class Solution {
    public int solution(int n) {
        String three = Integer.toString(n, 3);
        String reverseThree = new StringBuilder(three).reverse().toString();
        return Integer.parseInt(reverseThree, 3);
    }
}