class Solution {
    
    String[][] places;
    
    public int[] solution(String[][] places) {
        this.places = places;
        int totalPlace = places.length;
        int caseNum = 0;
        int[] answer = new int[totalPlace];
        
        while(caseNum < totalPlace){
            answer[caseNum] = checkCase(caseNum);
            caseNum++;
        }
        
        return answer;
    }
    
    private int checkCase(int caseNum){
        String[] place = this.places[caseNum];
        int result = 1;
        
        for(int i = 0; i < place.length; i++){
            for(int j = 0; j < place[i].length(); j++){                
                if(!isValidPosition(i, j, place)){
                    result = 0;
                    break;
                }
            }
        }
        
        return result;
    }
    
    private boolean isValidPosition(int row, int col, String[] place){
        // 좌측 위 좌표부터 체크하므로 
        // 우측 아래만 체크
        char pos = place[row].charAt(col);
        int[] dirRow = new int[]{1, 0, -1, 0};
        int[] dirCol = new int[]{0, 1, 0, -1};
        int countP = 0;
        
        for(int i = 0; i < 4; i++){
            int checkRow = row + dirRow[i];
            int checkCol = col + dirCol[i];
            if(!isValidIdx(checkRow, checkCol)) continue;
            char checkPos = place[checkRow].charAt(checkCol);
            if(checkPos == 'P') countP++;
        }
        
        return (pos == 'X') || (pos == 'P' && countP < 1) || (pos == 'O' && countP < 2);
    }
    
    private boolean isValidIdx(int row, int col){
        return row >= 0 && row < 5 && col >= 0 &&  col < 5;
    }
}