class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        int walletMax = Math.max(wallet[0], wallet[1]);
        int walletMin = Math.min(wallet[0], wallet[1]);
        
        int billMax = Math.max(bill[0], bill[1]);
        int billMin = Math.min(bill[0], bill[1]);
        
        while(walletMax < billMax || walletMin < billMin){
            int fold = billMax / 2;
            billMax = Math.max(fold, billMin);
            billMin = Math.min(fold, billMin);
            answer++;
        }
        
        return answer;
    }
}