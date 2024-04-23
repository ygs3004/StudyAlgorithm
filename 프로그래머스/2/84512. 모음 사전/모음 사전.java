class Solution {
    
    String[] charArr ={"A","E","I","O","U"};
    int MAX_LENGTH = 5;
    String answerWord;
    int answer;
    int seq;
    boolean isEnd;
    
    public int solution(String answerWord) {
        
        this.answerWord = answerWord;
        
        for(String c : charArr){
            dfs(c);
        }
        
        return answer;
    }
    
    private void dfs(String word){
        seq++;
        if(word.equals(answerWord)){
            answer = seq;
            isEnd = true;
            return;
        }
        
        if(word.length() == MAX_LENGTH || isEnd){
            return;
        }

        for(String c : charArr){
            String w = word + c;
            dfs(w);
        }
    }
    
}