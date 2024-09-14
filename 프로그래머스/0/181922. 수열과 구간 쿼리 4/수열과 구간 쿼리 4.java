class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        for(int[] querie : queries){
            int s = querie[0];
            int e = querie[1];
            int k = querie[2];
            
            for(int i = s; i <= e; i++){
                if(i % k == 0) arr[i]++;
            }
        }
        return arr;
    }
}