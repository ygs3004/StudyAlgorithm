import java.io.BufferedReader;
import java.io.InputStreamReader;

// 달팽이 (Silver 3)
// https://www.acmicpc.net/problem/1913

public class Main {

    static int[][] snail;
    static int rowIdx;
    static int colIdx;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int target = Integer.parseInt(br.readLine());

        snail = new int[n][n];
        rowIdx = n/2;
        colIdx = n/2;
        int number = 1;
        snail[rowIdx][colIdx] = number++;

        int targetRow = rowIdx + 1;
        int targetCol = colIdx + 1;

        for(int i = 1; i <= n; i = i+2){
            int directionCycle =  i - 1;

            for(int j = 0; j < directionCycle * 4; j++){
                int directionCase = j/directionCycle;
                if(directionCase == 0){
                    moveRight();

                }else if(directionCase == 1){
                    moveDown();

                }else if(directionCase == 2){
                    moveLeft();

                }else if(directionCase == 3){
                    moveUp();
                }
                if(number == target){
                    targetRow = rowIdx + 1;
                    targetCol = colIdx + 1;
                }

                snail[rowIdx][colIdx] = number++;
            }

            moveUp();
            moveLeft();
        }

        StringBuilder snailString = new StringBuilder();
        for(int[] snailRow : snail){
            for(int num : snailRow){
                snailString.append(num).append(" ");
            }
            snailString.deleteCharAt(snailString.length() - 1);
            snailString.append(System.lineSeparator());
        }
        System.out.print(snailString);
        System.out.print(targetRow + " " + targetCol);
    }

    private static void moveUp(){
        rowIdx--;
    }

    private static void moveRight(){
        colIdx++;
    }

    private static void moveDown(){
        rowIdx++;
    }

    private static void moveLeft(){
        colIdx--;
    }
}
