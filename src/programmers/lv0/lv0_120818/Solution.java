package programmers.lv0.lv0_120818;

class Solution {
    public int solution(int price) {
        if(price >= 100000 && price<300000){
            price = (int)((double)price*0.95);
        }else if(price >= 300000 && price<500000){
            price = (int)((double)price*0.90);
        }else if(price >= 500000){
            price = (int)((double)price*0.80);
        }
        return price;
    }
}