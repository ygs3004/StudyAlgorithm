import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);

        int aIdx = 0;
        int result = 0;
        for(int bIdx = 0; bIdx < B.length; bIdx++) {
            int a = A[aIdx];
            int b = B[bIdx];

            if(b > a){
                aIdx++;
                result++;
            }
        }

        return result;
    }
}