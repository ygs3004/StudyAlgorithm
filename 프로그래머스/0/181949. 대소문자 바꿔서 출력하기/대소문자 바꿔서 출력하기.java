import java.util.Scanner;
import java.util.stream.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String change = a.chars()
            .mapToObj(c -> {
                String str = Character.toString(c);
                return str.equals(str.toUpperCase()) ? str.toLowerCase() : str.toUpperCase();
                })
            .collect(Collectors.joining());
        
        System.out.println(change);
    }
    
}