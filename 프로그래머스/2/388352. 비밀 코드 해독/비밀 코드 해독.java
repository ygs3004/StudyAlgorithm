import java.util.*;

class Solution {
    
    int n;
    int[] numbers;
    int answerLength;
    Checker checker;
    int answer;
    
    public int solution(int n, int[][] q, int[] ans) {
        answerLength = q[0].length;
        this.checker = new Checker(q, ans);
        this.n = n;
        this.answer =0;


        // 조합으로 만들어진 숫자를 저장할 배열
        int[] made = new int[answerLength];
        dfs(made, -1, -1);

        return answer;
    }
    
    private void dfs(int[] made, int before, int depth){
        
        if(depth + 1 == this.answerLength){
            if(this.checker.isPass(made)){  
                answer++;   
            }
            return;
        }
        
        depth++;
        // 마지막으로 입력된 숫자 기준보다 큰 숫자를 기준으로 순회(조합)
        for(int i = before + 1; i < this.n; i++){
            made[depth] = i + 1;
            dfs(made, i, depth);
        }
    }
    
    private class Checker{
        // int[][] q
        int[][] caseNumbers;
        // int[] ans
        int[] caseCounts;
        
        Checker(int[][] caseNumbers, int[] caseCounts){
            this.caseNumbers = caseNumbers;
            this.caseCounts = caseCounts;
        }
        
        // 만들어진 숫자 배열이 조건에 부합하는지 체크
        boolean isPass(int[] arr){
            for(int i = 0; i < caseNumbers.length; i++){
                int[] caseNumber = caseNumbers[i];
                int caseCount = caseCounts[i];
                int includeCnt = 0;
                for(int j = 0; j < arr.length; j++){
                    int arrNum =  arr[j];
                    for(int checkCaseNum : caseNumber){
                        if(arrNum == checkCaseNum) includeCnt++;
                    }
                }

                if(includeCnt != caseCount) return false;
            }
            
            return true;
        }
    }
    
}