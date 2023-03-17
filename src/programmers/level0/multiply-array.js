/*
배열 두배 만들기
문제 설명
정수 배열 numbers가 매개변수로 주어집니다. numbers의 각 원소에 두배한 원소를 가진 배열을 return하도록 solution 함수를 완성해주세요.
*/
function solution(numbers) {
    let answer = [];
    answer = numbers.map(v => v*2);
    return answer;
}

let number1 = [1, 2, 3, 4, 5];
let number2 = [1, 2, 100, -99, 1, 2, 3];
console.log(number1);
console.log(number2);
