class Solution {
    public int solution(int n, int[] stations, int w) {
        int left = 0;
        int right = 0;
        int cover = w * 2 + 1;
        int answer = 0;

        for(int station: stations) {
            right = station - w - 2;
            if(left <= right){
                answer += calc(left, right, cover);
            }
            left = station + w;
        }

        if (left < n) {
            right = n - 1;
            answer += calc(left, right, cover);
        }

        return answer;
    }

    public int calc(int left, int right, int cover){
        int area = right - left + 1;
        int div = area / cover;
        int mod = area % cover;
        return mod == 0 ? div : div + 1;
    }
}