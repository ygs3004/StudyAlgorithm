class Solution {
    public boolean solution(boolean x1, boolean x2, boolean x3, boolean x4) {
        return isTrue2(isTrue1(x1, x2), isTrue1(x3, x4));
    }
    
    public boolean isTrue1(boolean x, boolean y){
        return x || y;
    }
    
    public boolean isTrue2(boolean x, boolean y){
        return x && y;
    }
}