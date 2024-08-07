class Solution {
    public int solution(String number) {
        return number.chars().map(numChar -> Integer.parseInt(Character.toString(numChar))).sum() % 9;
    }
}