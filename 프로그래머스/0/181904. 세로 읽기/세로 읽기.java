class Solution {
    public String solution(String my_string, int m, int c) {
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i + c - 1 < my_string.length(); i = i + m){
            sb.append(String.valueOf(my_string.charAt(i + c - 1)));
        }
        
        return sb.toString();
    }
}