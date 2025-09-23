import java.util.*;

class Solution {
    
    private static final String NONE_REFER = "-";
    
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        
        Map<String, User> users = new HashMap<>();
        for(int i = 0; i < enroll.length; i++){
            String userName = enroll[i];
            User user = new User(i, userName);
            users.put(userName, user);
            
            String referUserName = referral[i];
            if(referUserName.equals(NONE_REFER)) continue;
            
            User referUser = users.get(referUserName);
            user.setRefer(referUser);
        }
        
        for(int i = 0; i < seller.length; i++){
            String sellUserName = seller[i];
            int incomeAmount = amount[i] * 100;
            User user = users.get(sellUserName);
            user.addIncome(incomeAmount);
        }
        
        int[] answer = new int[enroll.length];
        for(int i = 0; i < enroll.length; i++){
            answer[i] = users.get(enroll[i]).income;
        }        

        return answer;
    }
    
    private static class User{
        
        int id;
        String name;
        User refer;
        int income;

        
        User(int id, String name){
            this.id = id;
            this.name = name;
        }
        
        private void setRefer(User refer){
            this.refer = refer;
        }
        
        private void addIncome(int income){
            int commition = income / 10;
            int remain = income - commition;
            this.income += remain;
            
            if(refer != null){
                refer.addIncome(commition);
            }
        }
    }
    
}