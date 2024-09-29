import java.util.*;

class Solution {
   
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        return Arrays.stream(data)
            .filter(row -> {
                Column filterColumn = Column.valueOf(ext);
                int filterIdx = filterColumn.idx;
                return row[filterIdx] < val_ext;
            })
            .sorted((row1, row2) -> {
                Column sortColumn = Column.valueOf(sort_by);
                int sortIdx = sortColumn.idx;
                return row1[sortIdx] - row2[sortIdx];
            })
            .toArray(int[][]::new);
    }
    
    public enum Column{
        
        code("code"),date("date"),maximum("maximum"),remain("remain");

        String ext;
        int idx;
        
        Column(String ext){
            this.ext = ext;
            this.idx = switch(ext){
                case "code" -> 0;
                case "date" -> 1;
                case "maximum" -> 2;
                case "remain" -> 3;
                default -> 999;
            };
        }
        
    }
    
}