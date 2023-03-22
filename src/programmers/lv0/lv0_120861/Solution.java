package programmers.lv0.lv0_120861;

class Solution {
    public int[] solution(String[] keyinput, int[] board) {
        int xMax = (board[0]-1)/2;
        int xMin = -(board[0]-1)/2;
        int yMax = (board[1]-1)/2;
        int yMin = - (board[1]-1)/2;
        
        int[] answer = {0, 0};
        
        for(String input : keyinput){
            if(input.equals("left") && answer[0]>xMin){
                answer[0]--;
            }else if (input.equals("right") && answer[0]<xMax){
                answer[0]++;
            }else if (input.equals("up") && answer[1]<yMax){
                answer[1]++;
            }else if(input.equals("down") && answer[1]>yMin){
                answer[1]--;
            }
        }
        
        return answer;
    }
}