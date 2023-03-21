function solution(s) {
    let answer = 0;
    s.split(" ").forEach((v, i, arr) =>  !isNaN(v) ? answer += +v : answer -= arr[i-1]);
    return answer;
}