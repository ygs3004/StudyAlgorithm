class Solution {
    public String solution(String code) {
        StringBuilder sb = new StringBuilder();
        String[] str = code.split("");
        int mode = 0;
        
        for(int i = 0; i < str.length; i++){
            if(str[i].equals("1")){
                mode = mode == 0 ? 1 : 0 ;   
            }else if(i % 2 == mode){
                sb.append(str[i]);
            }
        }
        
        return sb.length() == 0 ? "EMPTY" : sb.toString();
    }
}