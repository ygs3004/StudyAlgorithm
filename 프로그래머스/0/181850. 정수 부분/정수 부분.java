class Solution {
    public int solution(double flo) {
        String floStr = String.valueOf(flo);
        String intPartStr = floStr.substring(0, floStr.indexOf("."));
        return Integer.parseInt(intPartStr);
    }
}