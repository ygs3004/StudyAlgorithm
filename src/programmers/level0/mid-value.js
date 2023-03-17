function solution(array) {
    let answer = array.sort((a, b) => a - b)[Math.floor(array.length / 2)];
    return answer;
}

let array1 = [1, 2, 7, 10, 11];
let array2 = [9, -1, 0];

console.log(solution(array1));
console.log(solution(array2));