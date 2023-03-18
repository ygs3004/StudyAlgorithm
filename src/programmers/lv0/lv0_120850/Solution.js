function solution(my_string) {
    return [...my_string].filter( v => v == 0 || parseInt(v)).map(v => v == 0 ? 0 : +v).sort();
}