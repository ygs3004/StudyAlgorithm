class Solution {
    
    int numbersLength;
    int[] numbersCopy;
    int targetCopy;
    int answer = 0;
    
    public int solution(int[] numbers, int target) {
        numbersLength = numbers.length;
        numbersCopy = numbers;
        targetCopy = target;
        dfs(0, 0, (a, b) -> a+b);
        dfs(0, 0, (a, b) -> a-b);
        
        return answer;
    }
    
    public void dfs(int value, int depth, Operator oper){
        value = oper.execute(value, numbersCopy[depth]);
        depth++;
        if(depth == numbersLength && value == targetCopy){
           answer++;
        }
        
        if(depth < numbersLength){
           dfs(value, depth, (a, b) -> a+b);
           dfs(value, depth, (a, b) -> a-b);
        }
    }
    
    @FunctionalInterface
    public interface Operator{
        public int execute(int a, int b);
    }
}