package programmers.lv0.lv0_120912;

class Solution {
    public int solution(int[] array) {
        
        System.out.println((int)'7');
        int count = 0;
        
        for(int n : array){
            char[] arr = String.valueOf(n).toCharArray();
            for(char a : arr){
                if( a == 55) count++;
            }           
        }
        
        return count;
    }
}