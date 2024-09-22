class Solution {
    public int solution(String ineq, String eq, int n, int m) {
        boolean isTrue = false;
        switch(ineq){
            case "<": 
                isTrue = isEqual(eq) ? n <= m : n < m;
                break;
            case ">" :
                isTrue = isEqual(eq) ? n >= m : n > m;
                break;
        }
        return isTrue ? 1 : 0;
    }
    
    public boolean isEqual(String eq){
        return eq.equals("=");
    }
}