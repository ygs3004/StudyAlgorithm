function solution(box, n) {
    return box.map(v => ~~(v/n)).reduce( (a,c) => a*c, 1);
}