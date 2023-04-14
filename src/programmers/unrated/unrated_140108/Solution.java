package programmers.unrated.unrated_140108;

class Solution {
    public int solution(String s) {
        
        String[] word = s.split("");
        String first = word[0];
        int firstCount = 0;
        int otherCount = 0;
        int answer = 0;
        for(int i=0; i<word.length; i++){
            if(otherCount == 0 && firstCount ==0){
                first = word[i];
                firstCount++;
            }else if(word[i].equals(first)){
                firstCount++;
            }else{
                otherCount++;    
            }
            
            if(firstCount == otherCount || i==word.length-1){
                answer++;
                firstCount = 0;
                otherCount = 0;
            }
        }
        return answer;
    }
}