package programmers.lv1.lv1_87389;

class Solution {
    public int solution(int n) {
        
        for(int i=2; i<=n; i++){
            if(n%i == 1) return i;
        }
  
        return 0;
    }
    
}