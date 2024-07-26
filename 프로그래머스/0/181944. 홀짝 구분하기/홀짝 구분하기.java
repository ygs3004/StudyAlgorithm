import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String suffix = n % 2 == 0 ? " is even" : " is odd";
        System.out.println(n + suffix);
    }
}