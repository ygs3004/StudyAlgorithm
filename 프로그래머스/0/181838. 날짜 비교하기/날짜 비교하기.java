class Solution {
    public int solution(int[] date1, int[] date2) {
        boolean isSameYear = date1[0] == date2[0];
        boolean isSameMonth = date1[1] == date2[1];
        boolean isSameDay = date1[2] == date2[2];

        return (isSameYear && isSameMonth && date2[2] > date1[2])
            || (isSameYear && date2[1] > date1[1])
            || (date2[0] > date1[0])
            ? 1: 0;
    }
}