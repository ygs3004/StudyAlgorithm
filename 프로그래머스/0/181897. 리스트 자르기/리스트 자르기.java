import java.util.*;

class Solution {
    
    int[] num_list;
    
    public int[] solution(int n, int[] slicer, int[] num_list) {
        this.num_list = num_list;
        int a = slicer[0];
        int b = slicer[1];
        int c = slicer[2];
        
        return switch(n){
            case 1 -> createResult(0, b, 1);
            case 2 -> createResult(a, num_list.length - 1, 1);
            case 3 -> createResult(a, b, 1);
            case 4 -> createResult(a, b, c);
            default -> new int[]{};
        };
    }
    
    public int[] createResult(int start, int end, int diff){
        List<Integer> list = new ArrayList<>();
        for(int i = start; i <= end; i = i + diff){
            list.add(num_list[i]);
        }
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}