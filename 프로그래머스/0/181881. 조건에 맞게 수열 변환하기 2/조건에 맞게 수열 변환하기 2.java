class Solution {
    public int solution(int[] arr) {
        int result = -1;
        boolean isChange = true;
        while(isChange){
            isChange = changeAndCheck(arr);
            result++;
        }

        return result;
    }
    
    public boolean changeAndCheck(int[] arr){
        
        boolean isChange = false;
        
        for(int i = 0; i < arr.length; i++){
            int num = arr[i];
            if(num >= 50 && num % 2 == 0){
                arr[i] /= 2;
                isChange = true;
            }else if(num <= 50 && num % 2 != 0){
                arr[i] = num * 2 + 1;
                isChange = true;
            }
        }
        
        return isChange;
    }
}