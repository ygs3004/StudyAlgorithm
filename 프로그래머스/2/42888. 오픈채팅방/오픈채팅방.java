import java.util.*;

class Solution {
    
    public String[] solution(String[] records) {
        
        Map<String, String> nickNameMap = new HashMap<>();
        List<String> visitInfo = new ArrayList();
        
        for(String record : records){
            String[] info = record.split(" ");
            String command = info[0];
            String userId = info[1];
            if(command.equals(COMMAND.CHANGE.value) || command.equals(COMMAND.ENTER.value)){
                String nickName = info[2];
                nickNameMap.put(userId, nickName);
            }
            
            if(command.equals(COMMAND.LEAVE.value) || command.equals(COMMAND.ENTER.value)){
                visitInfo.add(command + " " + userId);
            }
        }
        
        String[] answer = new String[visitInfo.size()];
        for(int i=0; i<answer.length; i++){
            String visit = visitInfo.get(i);
            String[] info = visit.split(" ");
            String command = info[0];
            String userId = info[1];
            
            String template = command.equals(COMMAND.LEAVE.value) ? "나갔습니다." : "들어왔습니다.";
            answer[i] = nickNameMap.get(userId) + "님이 " + template;
        }
        
        return answer;
    }
    
    private enum COMMAND{
        CHANGE("Change"),
        ENTER("Enter"),
        LEAVE("Leave");
        
        String value;
        
        COMMAND(String value){
            this.value = value;
        }
    }
    
}