class Solution {

    int solution(int[][] land) {
        int result = 0;
        int beforeMax = 0;
        int beforeMaxIdx = 0;
        int beforeSecondMax = 0;
        int beforeSecondMaxIdx = 0;
        
        for(int i=0; i<land[0].length; i++){
            if(land[0][i] >= beforeMax){
                beforeSecondMax = beforeMax;
                beforeSecondMaxIdx = beforeMaxIdx;
                beforeMax = land[0][i];
                beforeMaxIdx = i;
            }else if(land[0][i] >= beforeSecondMax){
                beforeSecondMax = land[0][i];
                beforeSecondMaxIdx = i;
            }
        }
        
        for(int i=1; i<land.length; i++){
            int nowMax = 0;
            int nowSecondMax = 0;
            int nowMaxIdx = 0;
            int nowSecondMaxIdx = 0;
            
            for(int j=0; j<land[0].length; j++){
                int nowSum =
                    j == beforeMaxIdx 
                    ? land[i][j] + beforeSecondMax
                    : land[i][j] + beforeMax;
                
                if(nowSum >= nowMax){
                    nowSecondMax = nowMax;
                    nowSecondMaxIdx = nowMaxIdx;
                    nowMax = nowSum;
                    nowMaxIdx = j;
                }else if(nowSum >= nowSecondMax){
                    nowSecondMax = nowSum;
                    nowSecondMaxIdx = j;
                }
            }
            
            beforeSecondMax = nowSecondMax;
            beforeSecondMaxIdx = nowSecondMaxIdx;
            beforeMax = nowMax;
            beforeMaxIdx = nowMaxIdx;                

        }

        return beforeMax;
    }

}