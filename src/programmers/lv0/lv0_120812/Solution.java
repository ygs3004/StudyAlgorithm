package programmers.lv0.lv0_120812;

class Solution {
    public int solution(int[] array) {
        int[] count = new int[1001];
        int result = 0;
        int maxCount = 0;
        
        for(int n : array){
            count[n]++;
            if(count[n] >= maxCount){
                result = count[n] == maxCount ? -1 : n;
              maxCount = count[n];
            } 
        }
  
        return result;
    }
}