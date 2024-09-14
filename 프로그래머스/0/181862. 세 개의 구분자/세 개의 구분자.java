import java.util.*;

class Solution {
    public String[] solution(String myStr) {
        String[] split1 = myStr.split("a");
        
        List<String> list = new ArrayList<>();
        for(String str1 : split1){
            list.add(str1);
        }

        list = splitOper(list, "b");
        list = splitOper(list, "c");
        
        return list.isEmpty() ? new String[]{"EMPTY"} : list.toArray(String[]::new);
    }
    
    public List<String> splitOper(List<String> list, String oper){
        List<String> result = new ArrayList<>();
               
        for(String str : list){
            String[] split = str.split(oper);
            for(String splitStr : split){
                if(splitStr.length() > 0) result.add(splitStr);
            }
        }
        
        return result;
    }

}