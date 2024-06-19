import java.util.*;
class Solution {
    public int solution(int n, String control) {
        return control.chars().reduce(n, (acc, c) -> {
            switch(c) {
                case 'w' : acc++;
                    break;
                case 's' : acc--;
                    break;
                case 'd' : acc += 10;
                    break;
                case 'a' : acc -= 10;
            }
            return acc;
        });
    }
}