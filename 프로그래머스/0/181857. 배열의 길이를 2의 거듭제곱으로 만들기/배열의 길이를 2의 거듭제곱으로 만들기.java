class Solution {
    public int[] solution(int[] arr) {
        int answerLength = 1;
        while(answerLength < arr.length){
            answerLength *= 2;
        }
        
        int[] answer = new int[answerLength];
        System.arraycopy(arr, 0, answer, 0, arr.length);
        return answer;
    }
}