package programmers.lv0.lv0_120876;

class Solution {
    
    public int solution(int[][] lines) {
        
        int[] line = new int[201];
        int stackLength = 0;

        for(int i=0; i<3; i++){
            for(int k=lines[i][0]+100; k<lines[i][1]+100; k++){
                line[k]++;
            }
        }
        
        for(int i=0; i<201; i++){
            if(line[i]>=2) {
                stackLength ++;
            }
        }
        
        return stackLength ;
    }
    
}