package programmers.lv0.lv0_120871;

class Solution {
    public int solution(int n) {
        int[] numbers = new int[n+1];
        int number = 1;
        
        for(int i=1; i<=n; i++){
            while(String.valueOf(number).indexOf("3")>=0 || number%3==0){
                number++;
            }
            numbers[i] = number++;
        }
        
        return numbers[n];
    }
}