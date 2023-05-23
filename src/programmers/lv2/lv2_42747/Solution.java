package programmers.lv2.lv2_42747;

class Solution {
    public int solution(int[] citations) {
        int h = citations.length;
        for(int i=0; i<citations.length; i++){
            if(checkQuote(citations, h)) break;
            h--;
        }
        
        return h;
    }
    
    public static boolean checkQuote(int[] citations, int h){
        int quoteNum = 0;
        for(int citation : citations){
            if(citation>=h) quoteNum++;
        }
        
        return quoteNum >= h;
    }
    
}