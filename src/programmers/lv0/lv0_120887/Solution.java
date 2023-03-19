package programmers.lv0.lv0_120887;

class Solution {
    public int solution(int s, int e, int k) {
        
        String checkN = String.valueOf(k);
        int count = 0;
        
        int[] numbers = new int[100001];
        for(int i=s; i<=e; i++){
            count += String.valueOf(i).length() - String.valueOf(i).replace(checkN, "").length();
        }
        return count;
    }
}