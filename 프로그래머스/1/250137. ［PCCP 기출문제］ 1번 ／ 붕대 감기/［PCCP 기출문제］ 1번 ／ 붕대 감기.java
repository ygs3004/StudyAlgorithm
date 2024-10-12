class Solution {
    
    public int solution(int[] bandage, int health, int[][] attacks) {
        int maxTime = attacks[attacks.length - 1][0];
        
        int curHealth = health;
        int castCompleteTime = bandage[0];
        int restore = bandage[1];
        int castCompleteRestore = bandage[2];
        
        int attackSeq = 0;
        int curTime = -1;
        int restoreTick = 0;
        
        while(curTime++ < maxTime && curHealth > 0){
            int[] attack = attacks[attackSeq];
            int attackTime = attack[0];
            if(curTime == attackTime){
                attackSeq++;
                curHealth -= attack[1];
                restoreTick = 0;
            }else{
                restoreTick++;
                curHealth = Math.min(curHealth + restore, health);
                if(restoreTick == castCompleteTime){
                    restoreTick = 0;
                    curHealth = Math.min(curHealth + castCompleteRestore, health);
                }
            }
        }
        
        return curHealth <= 0 ? -1 : curHealth;
    }
    
}