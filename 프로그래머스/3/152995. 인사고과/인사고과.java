import java.util.*;

class Solution {
    public int solution(int[][] scores) {

        int n = scores.length;

        int[][] arr = new int[n][3];

        for (int i = 0; i < n; i++) {
            arr[i][0] = scores[i][0];
            arr[i][1] = scores[i][1];
            arr[i][2] = i;
        }

        Arrays.sort(arr, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            }
            return b[0] - a[0];
        });

        int maxWorkerScore = -1;
        List<int[]> valid = new ArrayList<>();

        int i = 0;

        while (i < n) {

            int attitude = arr[i][0];

            // 같은 태도 점수 그룹
            int j = i;

            while (j < n && arr[j][0] == attitude) {
                j++;
            }

            // 같은 그룹 내부에서는
            // 이전 그룹의 maxWorkerScore만 가지고 판단
            for (int k = i; k < j; k++) {

                int[] score = arr[k];

                if (score[1] < maxWorkerScore) {
                    continue;
                }

                valid.add(score);
            }

            // 그룹을 전부 판단한 뒤 max 갱신
            for (int k = i; k < j; k++) {
                maxWorkerScore =
                    Math.max(maxWorkerScore, arr[k][1]);
            }

            i = j;
        }

        valid.sort((a, b) ->
            (b[0] + b[1]) - (a[0] + a[1])
        );

        int rank = 0;
        int beforeScore = -1;

        for (int k = 0; k < valid.size(); k++) {

            int[] score = valid.get(k);

            int total = score[0] + score[1];

            if (total != beforeScore) {
                rank = k + 1;
            }

            if (score[2] == 0) {
                return rank;
            }

            beforeScore = total;
        }

        return -1;
    }
}