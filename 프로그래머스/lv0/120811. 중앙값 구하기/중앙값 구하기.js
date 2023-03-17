function solution(array) {
    let answer = array.sort((a, b) => a-b)[Math.floor(array.length/2)];
    return answer;
}