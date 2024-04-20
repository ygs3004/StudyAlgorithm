import java.util.*;

class Solution {
    public List<Integer> solution(String msg) {
        Map<String, Integer> dictionary = initDictionary();
        String[] msgChar = msg.split("");
        String w = "";
        String wc = "";
        int lastNumber = 27;
        
        List<Integer> result = new ArrayList<>();
        
        for(int i=0; i<msgChar.length; i++){
            w += msgChar[i];
            if(i != msgChar.length-1){
                wc = w + msgChar[i+1];
            }else{
                result.add(dictionary.get(w));
                break;
            }

            if(!dictionary.containsKey(wc)){
                dictionary.put(wc, lastNumber++);
                result.add(dictionary.get(w));
                w = "";
            }
            
        }
        
        return result;
    }
    
    private Map<String, Integer> initDictionary(){
        Map<String, Integer> dictionary = new HashMap<>();
       
        for(int i = 65; i < 65+26; i++){
            dictionary.put(Character.toString(i), i-64);
        }
        
        return dictionary;
    }
}