package programmers.lv1.lv1_64061;

import java.util.*;
class Solution {
    public int solution(int[][] board, int[] moves) {
        
        Stack<Integer> stackPop = new Stack<>();
        Queue<Integer>[] queue = new LinkedList[board.length];
        for(int i=0; i<queue.length; i++){
            queue[i] = new LinkedList<Integer>();
        }
        
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[i].length; j++){
                if(board[i][j] != 0){
                  queue[j].add(board[i][j]);
                } 
            }
        }
        
        int answer = 0;        
        for(int i=0; i<moves.length; i++){
            int index = moves[i]-1;
            if(!queue[index].isEmpty()){
                int newPick = queue[index].poll();
                if(!stackPop.isEmpty()){
                    if(stackPop.peek() == newPick){
                        stackPop.pop();
                        answer += 2;
                    }else{
                        stackPop.push(newPick);
                    }    
                }else{
                    stackPop.push(newPick);
                }
            }
        }
        return answer;
    }
}