import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        
        Map<String, User> allUsers = new HashMap<>();
        for(String friend: friends){
            User user = new User(friend);
            allUsers.put(friend, user);
        }
        
        for(String gift : gifts){
            String[] info = gift.split(" ");
            String from = info[0];
            String to = info[1];
            User fromUser = allUsers.get(from);
            User toUser = allUsers.get(to);
            
            fromUser.giveGift(toUser);
        }
        
        Map<User, Integer> nextMonth = new HashMap<>();
        for(int i = 0; i < friends.length - 1; i++){
            for(int j = i + 1; j< friends.length; j++){
                User userA = allUsers.get(friends[i]);
                User userB = allUsers.get(friends[j]);
                
                int userAtoB = userA.toGiftUser.getOrDefault(userB, 0);
                int userBtoA = userB.toGiftUser.getOrDefault(userA, 0);
                
                User receiveUser = null;
                if(userAtoB != userBtoA){
                    receiveUser = userAtoB > userBtoA ? userA : userB;
                }else{
                    int userAGiftParam = userA.getGiftParam();
                    int userBGiftParam = userB.getGiftParam();
                    if(userAGiftParam != userBGiftParam){
                        receiveUser = userAGiftParam > userBGiftParam ? userA : userB;    
                    }
                }
                if(receiveUser != null){
                    nextMonth.compute(receiveUser, (user, value) -> value == null ? 1 : value + 1);    
                }
            }
        }
        
        int answer = 0;
        for(int userReceive : nextMonth.values()){
            answer = Math.max(answer, userReceive);
        }
        
        return answer;
    }
    
    private class User{
        final String name;
        final Map<User, Integer> toGiftUser;
        final Map<User, Integer> fromGiftUser;
        
        User(String name){
            this.name = name;
            toGiftUser = new HashMap<>();
            fromGiftUser = new HashMap<>();
        }
        
        void giveGift(User toUser){
            this.toGiftUser.compute(toUser, (user, value) -> value == null ? 1 : value + 1);
            toUser.fromGiftUser.compute(this, (user, value) -> value == null ? 1 : value + 1);
        }
        
        int getReceiveTotalGift(){
            int total = 0;
            for(int gift : fromGiftUser.values()){
                total += gift;
            }
            
            return total;
        }
        
        int getGiftParam(){
            int result = 0;
            for(int toParam: toGiftUser.values()){
                result += toParam;
            }
            
            for(int fromParam: fromGiftUser.values()){
                result -= fromParam;
            }
            
            return result;
        }
        
        @Override
        public String toString(){
            return this.name;
        }
        
    }
    
}