package programmers.lv1.lv1_67256;

class Solution {
    public String solution(int[] numbers, String hand) {
        
        int[][] distance = {{0, 4, 3, 4, 3, 2, 3, 2, 1, 2, 1, 1}, // 0 에서의 거리
                            {4, 0, 1, 2, 1, 2, 3, 2, 3, 4, 3, 5}, // 1에서의 거리
                            {3, 1, 0, 1, 2, 1, 2, 3, 2, 3, 4, 4}, // 2에서의 거리
                            {4, 2, 1, 0, 3, 2, 1, 4, 3, 2, 5, 3}, // 3에서의 거리
                            {3, 1, 2, 3, 0, 1, 2, 1, 2, 3, 2, 4}, // 4에서의 거리
                            {2, 2, 1, 2, 1, 0, 1, 2, 1, 2, 3, 3}, // 5에서의 거리
                            {3, 3, 2, 1, 2, 1, 0, 3, 2, 1, 4, 2}, // 6에서의 거리
                            {2, 2, 3, 4, 1, 2, 3, 0, 1, 2, 1, 3}, // 7에서의 거리
                            {1, 3, 2, 3, 2, 1, 2, 1, 0, 1, 2, 2}, // 8에서의 거리
                            {2, 4, 3, 2, 3, 2, 1, 2, 1, 0, 3, 1}, // 9에서의 거리
                            {1, 3, 4, 5, 2, 3, 4, 1, 2, 3, 0, 2}, // *에서의 거리
                            {0, 5, 4, 3, 4, 3, 2, 3, 2, 1, 2, 0}, // #에서의 거리
                           };
        
        int left=10;
        int right=11;
        String answer = "";
        
        for(int i=0; i<numbers.length; i++){
            if(numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7){
                left = numbers[i];
                answer += "L";
            }else if(numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9){
                right = numbers[i];
                answer += "R";
            }else{
                if(distance[left][numbers[i]] < distance[right][numbers[i]]){
                    answer += "L";
                    left = numbers[i];
                }else if(distance[left][numbers[i]] > distance[right][numbers[i]]){
                    answer += "R";
                    right = numbers[i];
                }else{
                    if(hand.equals("left")){
                        answer += "L";
                        left = numbers[i];
                    }else{
                        answer += "R";
                        right = numbers[i];
                    }
                }
            }
        }
        return answer;
    }
}