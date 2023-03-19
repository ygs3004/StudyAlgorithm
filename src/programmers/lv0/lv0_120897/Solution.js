function solution(n) {
    let answer = [];
    answer.length = n;
    return answer.fill(1).map((v, i) => v+i).filter(v => n%v==0);
}