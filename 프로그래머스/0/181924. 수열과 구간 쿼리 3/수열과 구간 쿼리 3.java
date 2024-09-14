class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        for(int[] querie : queries){
            swap(arr, querie[0], querie[1]);
        }
        
        return arr;
    }
    
    public void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}