import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] line = br.readLine().split(" ");
        StringBuilder sb = new StringBuilder(line[0]);
        for(int i = 0; i < Integer.parseInt(line[1]) - 1; i++){
            sb.append(line[0]);
        }
        
        bw.write(sb.toString());
        bw.flush();
    }
}