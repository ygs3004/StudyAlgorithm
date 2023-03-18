package programmers.lv0.wallpaper;

import programmers.excute.Programmers;

public class ClearWallPaper {

    public static void main(String[] args) {

        String[] wallpaper1 = {".#...", "..#..", "...#."};
        String[] wallpaper2 = {"..........", ".....#....", "......##..", "...##.....", "....#....."};
        String[] wallpaper3 = {".##...##.", "#..#.#..#", "#...#...#", ".#.....#.", "..#...#..", "...#.#...", "....#...."};
        String[] wallpaper4 = {"..", "#."};


        Solution solution = new Solution();

        solution.result(wallpaper1);
        solution.result(wallpaper2);
        solution.result(wallpaper3);
        solution.result(wallpaper4);
    }

}

class Solution extends Programmers<int[], String[]>{

    public int[] solution(String[] wallpaper) {

        int minX = 50;
        int minY = 50;
        int maxX = 0;
        int maxY = 0;

        int y = 0;
        int x = 0;
        for(String points : wallpaper){

            char[] point = points.toCharArray();
            for (int i = 0; i < point.length; i++) {
                if(point[i] == '#') {
                    x = i;
                    minX = Math.min(x, minX);
                    minY = Math.min(y, minY);
                    maxX = Math.max(x, maxX);
                    maxY = Math.max(y, maxY);
                }
            }

            y++;
        }

        maxX++;
        maxY++;

        int[] answer = {minY, minX, maxY, maxX};
        return answer;
    }
}