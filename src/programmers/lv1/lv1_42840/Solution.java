package programmers.lv1.lv1_42840;

class Solution {
    
    public int[] solution(int[] answers) {
        
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] arr3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        
        for(int i=0; i<answers.length; i++){
            if(answers[i] == arr1[i%5]) count1++;
            if(answers[i] == arr2[i%8]) count2++;
            if(answers[i] == arr3[i%10]) count3++;
        }
        
        if(count1 == count2 && count2 == count3) return new int[]{1,2,3};  
        else if(count1 > count2 & count1 > count3) return new int[]{1};  
        else if(count2 > count1 & count2 > count3) return new int[]{2};  
        else if(count3 > count1 & count3 > count2) return new int[]{3};  
        else if(count1 == count2) return new int[]{1,2};  
        else if(count1 == count3) return new int[]{1,3};
        else return new int[]{2,3};
    }
    
}
