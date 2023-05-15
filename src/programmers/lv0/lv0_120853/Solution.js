function solution(s) {
    let answer = 0;
    // s.split(" ").forEach((v, i, arr) =>  !isNaN(v) ? answer += +v : answer -= arr[i-1]);
    s.split(' ').reduce((a,c)=> {
        answer = c == 'Z' ? answer - Number(a) : answer + Number(c);
        return c
    }, 0)
    return answer;
}

