import java.util.*;

class Solution {
    
    final int[] discounts = {10, 20, 30, 40};
    int emoticonKinds;
    int bestJoin;
    int bestSell;
    int[][] users;
    int[] emoticons;
    int[] answer;
    
    public int[] solution(int[][] users, int[] emoticons) {
        emoticonKinds = emoticons.length;
        int[] emoticonDiscount = new int[emoticonKinds];
        this.users = users;
        this.emoticons = emoticons;
        bestJoin = 0;
        bestSell = 0;
        answer = new int[2];
        
        dfs(emoticonDiscount, 0);

        return answer;
    }
    
    public void dfs(int[] emoticonDiscount, int depth){
        if(depth == emoticonKinds){
            int joinUser = 0;
            int totalPrice = 0;
            
            for(int[] user: users){
                int userBuyForDiscount = user[0];
                int userJoinForCost = user[1];
                int userEmoticonPrice = 0;
                for(int i = 0; i < emoticonKinds; i ++){
                    if(emoticonDiscount[i] >= userBuyForDiscount){
                        userEmoticonPrice += emoticons[i] * (100 - emoticonDiscount[i]) * 0.01;             
                    }
                }
                
                if(userEmoticonPrice >= userJoinForCost) {
                    joinUser++;
                } else {
                    totalPrice += userEmoticonPrice;
                }
                
            }
            
            if(joinUser > answer[0]){

                answer[0] = joinUser;
                answer[1] = totalPrice;
            }else if(joinUser == answer[0]){
                answer[1] = Math.max(answer[1], totalPrice);
            }
            
            return;
        }
        
        for(int i = 0; i < discounts.length; i++){
            emoticonDiscount[depth] = discounts[i];
            dfs(emoticonDiscount, depth + 1);
        }
    }
    
}