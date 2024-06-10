import java.util.*;

class Solution {
    
    public int solution(String arr[]) {
        String[] operations = new String[arr.length/2];
        int[] numbers = new int[arr.length/2 + 1];
        int[][] max = new int[arr.length/2 + 1][arr.length/2 + 1];
        int[][] min = new int[arr.length/2 + 1][arr.length/2 + 1];
        
        // 숫자, 기호 분리
        for(int i = 0; i < arr.length; i++){
            if(i%2 == 0){
                numbers[i/2] = Integer.parseInt(arr[i]);
            }else{
                operations[i/2] = arr[i];
            }
        }
        
        for(int i = 0; i < numbers.length; i++){
            for(int j = 0; j < numbers.length; j++){
                if(i == j){
                    min[i][j] = numbers[i];
                    max[i][j] = numbers[i];
                }else{
                    min[i][j] = Integer.MAX_VALUE;
                    max[i][j] = Integer.MIN_VALUE;
                }
            }
        }
        
        for(int j = 1; j <= operations.length; j++){
            for(int i = 0; i + j < numbers.length; i++){
                for(int k = 0; k < j; k++){
                    String oper = operations[i + k];
                    int max1 = calc(max[i][i + k], max[i + k + 1][i + j], oper);
                    int max2 = calc(max[i][i + k], min[i + k + 1][i + j], oper);
                    int min1 = calc(min[i][i + k], min[i + k + 1][i + j], oper);
                    int min2 = calc(min[i][i + k], max[i + k + 1][i + j], oper);
                    max[i][i + j] = Math.max(max[i][i + j], Math.max(max1, max2));
                    min[i][i + j] = Math.min(min[i][i + j], Math.min(min1, min2));
                }
            }
        }
        
        int answer = max[0][numbers.length - 1];
        return answer;
    }
    
    private int calc(int num1, int num2, String oper){
        int result = 0;
        switch(oper){
            case "+" :
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
        }
        return result;
    }
    
    private void printArrays(int[][] arrays){
        for(int[] arr: arrays){
            System.out.println(Arrays.toString(arr));
        }
    }
}