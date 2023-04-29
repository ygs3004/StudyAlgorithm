package programmers.lv2.lv2_12945;

class Solution {
    public int solution(int n) {
        int[] fibonachi = new int[n+1];
        fibonachi[1] = 1;
        fibonachi[2] = 1;
        int divideNum = 1234567;
        for(int i=3; i<=n; i++){
            fibonachi[i] = (fibonachi[i-1]%divideNum + fibonachi[i-2]%divideNum)%divideNum;
        }
        return fibonachi[n];
    }
}