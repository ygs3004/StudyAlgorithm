import java.util.*;

class Solution {
    
    int maxCount = 0;
    List<Dungeon> dungeonList = new ArrayList();
    
    public int solution(int totalEnergy, int[][] dungeons) {
        for(int[] dungeon: dungeons){
            dungeonList.add(new Dungeon(dungeon[0], dungeon[1]));
        }
       
        for(int i=0; i < dungeonList.size(); i++){
            boolean[] visited = new boolean[dungeonList.size()];
            searchDungeon(i, 0, totalEnergy, visited);
        }
        
        return maxCount;
    }
   
    private void searchDungeon(int index, int count, int totalEnergy, boolean[] visited){
        if(visited[index]) return;
        
        visited[index] = true;
        if(dungeonList.get(index).minEnergy > totalEnergy) return;
            
        count++;
        totalEnergy -= dungeonList.get(index).useEnergy;
        maxCount = Math.max(count, maxCount);

        for(int i=0; i<dungeonList.size(); i++){
            if(visited[i] == false){
                searchDungeon(i, count, totalEnergy, visited);   
                visited[i] = false;    
            }
        }
    }
            
    private class Dungeon{
        int minEnergy;
        int useEnergy;
        
        Dungeon(int minEnergy, int useEnergy){
            this.minEnergy = minEnergy;
            this.useEnergy = useEnergy;
        }
    }
    
}