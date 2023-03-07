package javaPackage.programmers.Level_0.wallpaper;

public class ClearWallPaper {

    public static void main(String[] args) {

        String[] wallpaper1 = {".#...", "..#..", "...#."};
        String[] wallpaper2 = {"..........", ".....#....", "......##..", "...##.....", "....#....."};
        String[] wallpaper3 = {".##...##.", "#..#.#..#", "#...#...#", ".#.....#.", "..#...#..", "...#.#...", "....#...."};
        String[] wallpaper4 = {"..", "#."};

        Solution solution = new Solution();
        int[] result1 = solution.solution(wallpaper1);
        int[] result2 = solution.solution(wallpaper2);
        int[] result3 = solution.solution(wallpaper3);
        int[] result4 = solution.solution(wallpaper4);

        System.out.println(result1[0] + " " + result1[1] + " "  + result1[2] + " "  + result1[3]);
        System.out.println(result2[0] + " " + result2[1] + " "  + result2[2] + " "  + result2[3]);
        System.out.println(result3[0] + " " + result3[1] + " "  + result3[2] + " "  + result3[3]);
        System.out.println(result4[0] + " " + result4[1] + " "  + result4[2] + " "  + result4[3]);
    }

}

class Solution {
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