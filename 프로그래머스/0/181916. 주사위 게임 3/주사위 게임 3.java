import java.util.*;

class Solution {
    public int solution(int a, int b, int c, int d) {
        Map<Integer, Integer> dices = new HashMap<>();
        dices.put(a, 1);
        dices.put(b, dices.getOrDefault(b, 0) + 1);
        dices.put(c, dices.getOrDefault(c, 0) + 1);
        dices.put(d, dices.getOrDefault(d, 0) + 1);
                
        int answer = 0;
        
        int p = 7;
        int q = 7;
        int r = 7;
        switch(dices.size()){
            case 1:
                answer = a * 1111;
                break;
            case 2:
                int same = 0;
                for(int dice : dices.keySet()){
                    same = dices.get(dice);
                    if(same == 3){
                        p = dice;
                    }else if(same == 1){
                        q = dice;
                    }else if(same == 2){
                        if(p == 7) p = dice;
                        else q = dice;
                    }
                }
                
                if(same == 2){
                    answer = (p + q) * Math.abs(p - q);
                }else{
                    answer = (int)Math.pow(10 * p + q, 2);
                }
                
                break;
                
            case 3:
                for(int num : dices.keySet()){
                    if(dices.get(num) == 1){
                        if(q == 7) q = num;
                        else r = num;
                    }
                }
                
                answer = q * r;
                break;
            case 4:
                int minNum = 7;
                for(int num : dices.keySet()){
                    minNum = Math.min(minNum, num);
                }
                answer = minNum;
                break;
        }

        return answer;
    }
}