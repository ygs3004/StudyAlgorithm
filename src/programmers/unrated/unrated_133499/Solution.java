package programmers.unrated.unrated_133499;

class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        for(String babbl : babbling){
            babbl = cutText(babbl, "aya");
            babbl = cutText(babbl, "ye");
            babbl = cutText(babbl, "woo");
            babbl = cutText(babbl, "ma");
            babbl = babbl.replace("2", "");
            if(babbl.length()==0) answer++;
        }
        return answer;
    }
    
    public static String cutText(String str, String cutText){
        int count = 0;
        while(str.indexOf(cutText)>=0){
            count++;
            int save = str.indexOf(cutText);
            str = str.substring(0, str.indexOf(cutText)) +
                "2" + str.substring(str.indexOf(cutText)+cutText.length());
            if(count > 0 && str.indexOf(cutText) == save+1) str += "1";
        }
        return str;
    }
    
}