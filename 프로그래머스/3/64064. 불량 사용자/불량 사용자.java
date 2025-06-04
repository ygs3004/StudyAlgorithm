import java.util.*;

class Solution {
    
    String[] user_id;
    String[] banned_id;
    Set<String> answers;
    final String separator = "-";
    
    public int solution(String[] user_id, String[] banned_id) {
        
        this.user_id = user_id;
        this.banned_id = banned_id;
        this.answers = new HashSet<>();
        
        dfs(0, new ArrayList<String>());    
        
        return answers.size();
    }
    
    private void dfs(int depth, List<String> list){
        if(depth == banned_id.length){
            Collections.sort(list);
            StringBuilder sb = new StringBuilder();
            for(String answer: list){
                sb.append(answer).append(separator);
            }

            answers.add(sb.toString());
            return;
        }
        
        for(int i = 0; i < user_id.length; i++){
            String userId = user_id[i];
            String bannedId = banned_id[depth];
            if(!list.contains(userId) && checkBanned(bannedId, userId)){
                list.add(userId);
                dfs(depth + 1, list);
                list.remove(userId);
            }
        }
    }
    
    private boolean checkBanned(String bannedId, String userId){
        if(bannedId.length() != userId.length()){
            return false;
        }
        
        for(int i = 0; i < bannedId.length(); i++){
            char bannedChar = bannedId.charAt(i);
            char userIdChar = userId.charAt(i);
            if(bannedChar != '*' && userIdChar != bannedChar){
                return false;
            }
        }
        
        return true;
    }
    
}