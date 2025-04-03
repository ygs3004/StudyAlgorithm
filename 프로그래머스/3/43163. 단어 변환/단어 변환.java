import java.util.*;

class Solution {
    
    static int answer;
    static List[] graphs;
    boolean[] visited; 
    
    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        graphs = new ArrayList[words.length];   
        for(int i = 0; i < graphs.length; i++){
            graphs[i] = new ArrayList<>();
        }
        
        answer = Integer.MAX_VALUE;
        
        for(int i = 0; i < words.length - 1; i++){
            String str1 = words[i];
            for(int j = i + 1; j < words.length; j++){
                String str2 = words[j];
                if(canChange(str1, str2)){
                    graphs[i].add(j);
                    graphs[j].add(i);
                }
            }
        }
        
        for(int i = 0; i < words.length; i++){
            String word = words[i];
            if(canChange(begin, word)){
                System.out.println("==============");
                dfs(words, i, target, 1);
            }
        }
        
        return answer == Integer.MAX_VALUE ? 0 : answer;
    }
    
    private void dfs(String[] words, int curIdx, String target, int depth){
        if(visited[curIdx]) return;
        visited[curIdx] = true;
        
        String word = words[curIdx];
        System.out.println(word + " " + depth);
        if(word.equals(target)){
            answer = Math.min(depth, answer);
            return;
        }
        
        List<Integer> graph = graphs[curIdx];
        for(int nextIdx : graph){
            if(!visited[nextIdx]){
                dfs(words, nextIdx, target, depth + 1);
                visited[nextIdx] = false;   
            }
        }
        
    }
    
    
    private boolean canChange(String str1, String str2){
        int cnt = 0;
        
        for(int i = 0; i < str1.length(); i++){
            if(str1.charAt(i) != str2.charAt(i)) cnt++;
            
            if(cnt == 2){
                return false;
            }
        }
        
        return true;
    }
}