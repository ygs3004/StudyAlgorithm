import java.util.*;

class Solution {
    int[] position = {0, 0};
    int maxX = 5;
    int maxY = 5;
    int minX = -5;
    int minY = -5;
    Set<MoveRoad> moveRoads = new HashSet();
    
    public int solution(String dirs) {
        for(String dir : dirs.split("")){
            move(dir);
        }
        return moveRoads.size();
    }
    
    private void move(String dir){
        int[] moveX = {0, 1, 0, -1};
        int[] moveY = {1, 0, -1, 0};
        int dirIdx = convertDir(dir);
        
        boolean isMovable
            = (dir.equals("U") && position[1] < maxY)
            || (dir.equals("R") && position[0] < maxX)
            || (dir.equals("D") && position[1] > minY)
            || (dir.equals("L") && position[0] > minX);
        
        if(isMovable){
            int[] before = {position[0], position[1]};
            position[0] += moveX[dirIdx];
            position[1] += moveY[dirIdx];            
            int[] after = {position[0], position[1]};
            addMoveRoad(before, after, dir);
        }
    }
    
    private void addMoveRoad(int[] before, int[] after, String dir){
        switch(dir){
            case "U":case "R":
                moveRoads.add(new MoveRoad(before[0], after[0], before[1], after[1]));
                break;
            case "D":case "L":
                moveRoads.add(new MoveRoad(after[0], before[0], after[1], before[1]));
                break;
        }
    }
    
    private class MoveRoad{
        int startX;
        int endX;
        int startY;
        int endY;
        
        MoveRoad(int startX, int endX, int startY, int endY){
            this.startX = startX;
            this.endX = endX;
            this.startY = startY;
            this.endY = endY;
        }
        
        @Override
        public boolean equals(Object mr){
            MoveRoad o = (MoveRoad)mr;
            return this.startX == o.startX 
                && this.endX == o.endX
                && this.startY == o.startY
                && this.endY == o.endY;
        }
        
        @Override
        public int hashCode(){
            return this.startX + this.startY + this.endX + this.endY;
        }
    }
    
    private int convertDir(String dir){
        int result = -1;
        switch(dir){
            case "U":
                result = 0;
                break;
            case "R":
                result = 1;
                break;
            case "D":
                result = 2;
                break;
            case "L":
                result = 3;
                break;
        }
        return result;
    }
    
}