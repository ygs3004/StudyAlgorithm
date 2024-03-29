package programmers.lv1.lv1_72410;

class Solution {
    public String solution(String new_id) {

        new_id = new_id.toLowerCase();
        String[] test = {"~", "!", "@", "#", "[$]", "%", "\\^", "&", "[*]", "\\(", "\\)", "=", 
                          "[+]", "\\[", "\\]", "\\{", "\\}", ":", "\\?", ",", "<", ">","/"};
        for(int i=0; i<test.length; i++){
            new_id = new_id.replaceAll(test[i],"");
        }
        
        while(new_id.indexOf("..")>=0){
            new_id = new_id.replace("..", ".");    
        }
        
        while(new_id.charAt(0) == '.'){
            if(new_id.length() == 1){
              new_id = "";
              break;  
            } 
            new_id = new_id.substring(1);
        }
        
        while(new_id.length() != 0 && new_id.charAt(new_id.length()-1) == '.'){
            if(new_id.length() == 1) break;
            new_id = new_id.substring(0, new_id.length()-1);
        }
        
        if(new_id.length()==0){
            return "aaa";
        }
        
        if(new_id.length() >= 16){
            new_id = new_id.substring(0, 15);
            
            while(new_id.charAt(new_id.length()-1) == '.') new_id = new_id.substring(0, new_id.length()-1);
        }
        
        while(new_id.length() <= 2){
            new_id += new_id.charAt(new_id.length()-1);
        }
        return new_id;
    }
}