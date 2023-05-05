package programmers.lv2.lv2_42842;

class Solution {
    public int[] solution(int brown, int yellow) {
        int yellowRow = 1;
        int yellowColumn = yellow;
        
        for(yellowRow=1; yellowRow<=yellowColumn; yellowRow++){
            yellowColumn = yellow/yellowRow;
            if(((yellowRow*2 + yellowColumn*2 + 4) == brown) 
               && yellowRow*yellowColumn == yellow){
                break;
            }
        }

        return new int[]{yellowColumn+2, yellowRow+2};
    }
}