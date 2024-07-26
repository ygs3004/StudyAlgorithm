import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[] delete_list) {
        return Arrays.stream(arr)
            .filter(num -> Arrays.stream(delete_list).noneMatch(delNum -> num == delNum))
            .toArray();
    }
}