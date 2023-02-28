package javaPackage.B5.o3733;
/*
A group of N persons and the ACM Chief Judge share equally a number of S shares (not necessary all of them).
Let x be the number of shares aquired by each person (x must be an integer).
The problem is to compute the maximum value of x.
Write a program that reads pairs of integer numbers from an input text file.
Each pair contains the values of 1 ≤ N ≤ 10000 and 1 ≤ S ≤ 109 in that order.
The input data are separated freely by white spaces, are correct, and terminate with an end of file.
For each pair of numbers the program computes the maximum value of x and prints that value on the
standard output from the beginning of a line, as shown in the example below.

예제 입력 1
1 100
2 7
10 9
10 10
예제 출력 1
50
2
0
0

수학
사칙연산
*/

import java.io.*;
import java.util.StringTokenizer;

public class Shares {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        try{
            while(true){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken()) + 1;
                int b = Integer.parseInt(st.nextToken());

                System.out.println(b/a);
            }
        }catch (Exception e){

        }

    }

}
