package programmers.lv0.lv0_120923;

class Solution {
    public int[] solution(int num, int total) {

        int sum = 0;
        for(int i=0; i<num; i++){
            sum += i;
        }

        int zeroIndexNum = 0;
        
        while(sum != total){
            if(sum > total){
                sum = sum - (zeroIndexNum+num-1) + (zeroIndexNum-1);
                zeroIndexNum--;
            }else{
                sum = sum + (zeroIndexNum+num) - zeroIndexNum;
                zeroIndexNum++;
            }
        }
        
        int[] answer = new int[num];
        for(int i=0; i<num; i++){
            answer[i] = zeroIndexNum + i;
        }

        return answer;
    }
}