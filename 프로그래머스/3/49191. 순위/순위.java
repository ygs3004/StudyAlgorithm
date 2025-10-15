import java.util.*;

class Solution {
    
    static int N;
    
    public int solution(int n, int[][] results) {
        this.N = n;
        Player[] players = new Player[n + 1];
        for(int i = 1; i <= n; i++){
            players[i] = new Player(i);
        }
        
        for(int[] result : results){
            int winner = result[0];
            int loser = result[1];
            
            Player winnerPlayer = players[winner];
            Player loserPlayer = players[loser];
            
            boolean[][] visited1 = new boolean[n + 1][n + 1];
            boolean[][] visited2 = new boolean[n + 1][n + 1];
            winnerPlayer.checkWin(loserPlayer, visited1);
            loserPlayer.checkLose(winnerPlayer, visited2);
        }
        
        int answer = 0;
        for(int i = 1; i <= n; i++){
            Player player = players[i];
            // System.out.println(player.upper);
            // System.out.println(player.lower);
            // System.out.println("====================== " + i);
            if(player.checkResult()){
                answer++;
            }
        }

        return answer;
    }
    
    private static class Player{
        
        int num;
        Set<Player> upper = new HashSet<>();
        Set<Player> lower = new HashSet<>();
        
        Player(int num){
            this.num = num;
        }
        
        private boolean checkResult(){
            return upper.size() + lower.size() == N - 1;
        }
        
        private void checkWin(Player loserPlayer, boolean[][] visited){
            if(visited[this.num][loserPlayer.num]) return;
            visited[this.num][loserPlayer.num] = true;
            lower.add(loserPlayer);
            
            for(Player upperPlayer : upper){
                upperPlayer.checkWin(loserPlayer, visited);
            }
            
            for(Player loserLower : loserPlayer.lower){
                loserLower.checkLose(this, visited);
                this.checkWin(loserLower, visited);
            }
        }
        
        private void checkLose(Player winnerPlayer, boolean[][] visited){
            if(visited[this.num][winnerPlayer.num]) return;
            visited[this.num][winnerPlayer.num] = true;
            
            upper.add(winnerPlayer);
            for(Player lowerPlayer : lower){
                lowerPlayer.checkLose(winnerPlayer, visited);
            }
            
            for(Player winnerUpper : winnerPlayer.upper){
                winnerUpper.checkWin(this, visited);
                this.checkLose(winnerUpper, visited);
            }
        }
    }
    
}