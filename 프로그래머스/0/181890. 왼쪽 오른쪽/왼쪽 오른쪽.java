class Solution {
    public String[] solution(String[] str_list) {
                
        String[] answer = {};
        
        for(int i = 0; i < str_list.length; i++){
            String flag = str_list[i];
            if(flag.equals("l")){
                answer = new String[i];
                System.arraycopy(str_list, 0, answer, 0, i);
                break;
            }else if(flag.equals("r")){
                answer = new String[str_list.length - i - 1];
                System.arraycopy(str_list, i + 1, answer, 0, str_list.length - i - 1);
                break;
            }
        }
        
        return answer;
    }
}