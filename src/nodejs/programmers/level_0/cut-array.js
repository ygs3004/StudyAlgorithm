/*
문제 설명
정수 배열 numbers와 정수 num1, num2가 매개변수로 주어질 때, numbers의 num1번 째 인덱스부터
num2번째 인덱스까지 자른 정수 배열을 return 하도록 solution 함수를 완성해보세요.
*/

function solution(numbers, num1, num2) {
    return answer = numbers.splice(num1, num2-num1+1);;
}

let numbers1 = [1, 2, 3, 4, 5]; // 1 3
let numbers2 = [1, 3, 5]; // 1 2

console.log(solution(numbers1, 0, 0));
console.log(solution(numbers2, 1, 2));

