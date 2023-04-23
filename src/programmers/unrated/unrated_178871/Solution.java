package programmers.unrated.unrated_178871;

import java.util.*;
class Solution {
    static String[] players;
    static Map<String, Integer> map;
    
    public String[] solution(String[] players, String[] callings) {
        this.players = players;
        map = new HashMap<>();
        for(int i=0; i<players.length; i++){
            map.put(players[i], i);
        }
        
        for(String callName : callings){
            int callIdx = map.get(callName);
            int callBeforeIdx = callIdx-1;
            changeIndex(callIdx, callBeforeIdx);
        }
        return this.players;
    }
    
    public static void changeIndex(int a, int b){
        String temp = players[a];
        players[a] = players[b];
        players[b] = temp;
        map.put(players[a], a);
        map.put(players[b], b);
    }
    
}