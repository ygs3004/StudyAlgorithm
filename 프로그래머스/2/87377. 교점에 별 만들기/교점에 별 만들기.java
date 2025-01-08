import java.util.*;

class Solution {
    public String[] solution(int[][] line) {
        List<long[]> pos = new ArrayList<>();
        long maxX = Long.MIN_VALUE;
        long minX = Long.MAX_VALUE;
        long maxY = Long.MIN_VALUE;
        long minY = Long.MAX_VALUE;
        
        for(int i = 0; i < line.length - 1; i++){
            int[] line1 = line[i];
            long A = (long)line1[0];
            long B = (long)line1[1];
            long E = (long)line1[2];
            for(int j = i + 1; j < line.length; j++){
                int[] line2 = line[j];
                long C = (long)line2[0];
                long D = (long)line2[1];
                long F = (long)line2[2];
                
                long bottom = (A * D) - (B * C);
                if(bottom == 0) continue;
                
                long x = ((B * F) - (E * D)) / bottom;
                long y = ((E * C) - (A * F)) / bottom;
                
                long check1 = (A * x) + (B * y) + E;
                long check2 = (C * x) + (D * y) + F;
                if(check1 == 0 && check2 == 0) {
                    pos.add(new long[]{x, y});
                    maxX = Math.max(maxX, x);
                    minX = Math.min(minX, x);
                    maxY = Math.max(maxY, y);
                    minY = Math.min(minY, y);
                }
            }
        }
        
        int xLength = (int)(maxX - minX + 1);
        int yLength = (int)(maxY - minY + 1);

        
        boolean[][] stars = new boolean[yLength][xLength];
        for(long[] p : pos){
            int newPointX = (int)(p[0] - minX);
            int newPointY = (int)(p[1] - minY);
            
            stars[newPointY][newPointX] = true;
        }

        
        String[] answer = new String[yLength];
        
        StringBuilder sb = new StringBuilder();
        for(int y = 0; y < stars.length; y++){
            sb.setLength(0);
            for(int x = 0; x < stars[y].length; x++){
                sb.append(stars[yLength - y - 1][x] ? "*" : ".");
            } 
            answer[y] = sb.toString();
        }

        return answer;
    }
}