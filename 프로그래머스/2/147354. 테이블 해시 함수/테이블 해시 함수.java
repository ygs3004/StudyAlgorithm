import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        
        Tuple[] database = new Tuple[data.length];
        for(int i = 0; i < data.length; i++){
            database[i] = new Tuple(col, data[i]);
        }
        
        Arrays.sort(database);
        int answer = 0;
        
        for(int i = row_begin-1; i <= row_end-1; i++){
            int rowNum = i + 1;
            Tuple row = database[i];
            answer ^= row.sumMod(rowNum);
        }
        
        return answer;
    }
    
    private static class Tuple implements Comparable<Tuple>{
        int orderIdx;
        int[] rowData;
        
        public Tuple(int orderCol, int[] rowData){
            this.orderIdx = orderCol - 1;
            this.rowData = rowData;
        }
        
        public int sumMod(int modNum){
            int sum = 0;
            for(int colData : rowData){
                sum += colData % modNum;
            }
            
            return sum;
        }
        
        @Override
        public int compareTo(Tuple t){
            int orderDiff = this.rowData[orderIdx] - t.rowData[orderIdx];
            int primaryDiff = t.rowData[0] - this.rowData[0];
            return orderDiff == 0 ? primaryDiff : orderDiff;
        }
        
        @Override
        public String toString(){
            return Arrays.toString(rowData);
        }
    }
}