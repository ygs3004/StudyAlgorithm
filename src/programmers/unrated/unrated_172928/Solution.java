package programmers.unrated.unrated_172928;

import java.util.*;
class Solution {
    static int[] answer = new int[2];
    static int xMax = 0;
    static int yMax = 0;
    static int x = 0;
    static int y = 0;
    static String[] pos;
        
    public int[] solution(String[] park, String[] routes) {
        pos = park;
        xMax = pos[0].length();
        yMax = pos.length;
        
        // 시작지점 좌표저장
        for(int i=0; i<park.length; i++){
            if(pos[i].indexOf("S")>=0){
                x = park[i].indexOf("S");
                y = i;
                break;
            } 
        }
 
        for(int i=0; i<routes.length; i++){
            String[] moveOrder = routes[i].split(" ");
            String moveDirection = moveOrder[0];
            int distance = Integer.parseInt(moveOrder[1]);
            if(canMove(moveDirection, distance)){
                move(moveDirection, distance);
            }
        }
        answer[1] = x;
        answer[0] = y;
        return answer;
    }
    
    public static boolean canMove(String moveDirection, int distance){
        if(moveDirection.equals("E")){
            if(x + distance >= xMax){
              return false;  
            }
            for(int i=x+1; i<=x+distance; i++){
                if(pos[y].charAt(i) == 'X') {
                    return false;
                }
            }
        }else if(moveDirection.equals("W")){
            if(x - distance < 0) return false;
            for(int i=x-1; i>=x-distance; i--){
                if(pos[y].charAt(i) == 'X') return false;
            }
                
        }else if(moveDirection.equals("N")){
            if(y - distance < 0) return false;
            for(int i=y-1; i>=y-distance; i--){
                if(pos[i].charAt(x) == 'X') return false;
            }
        }else{
            if(y + distance >= yMax) return false;
            for(int i=y+1; i<=y+distance; i++){
                if(pos[i].charAt(x) == 'X') return false;
            }
            
        }
        return true;
    }
    
    public static void move(String moveDirection, int distance){
        if(moveDirection.equals("E")){
            x = x+distance;
        }else if(moveDirection.equals("W")){
            x = x-distance;
        }else if(moveDirection.equals("N")){
            y = y-distance;
        }else{
            y = y+distance;
        }
    }
}