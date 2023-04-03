function solution(n) {
    return n.toString().split("").map(v=> +v).reduce( (a, c) => a+c);
}