package programmers.lv1.lv1_12947;

class Solution {
    public boolean solution(int x) {
        
        return x%Integer.toString(x).chars().mapToObj(Character::getNumericValue).reduce((a, c) -> a+c).get() == 0;
    }
}