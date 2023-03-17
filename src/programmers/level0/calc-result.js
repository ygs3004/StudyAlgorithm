/*
정수 num1, num2가 매개변수로 주어질 때, num1을 num2로 나눈 몫을 return 하도록 solution 함수를 완성해주세요.
num1	num2	result
10	5	2
7	2	3
*/

function solution(num1, num2) {
    let answer = 0;

    answer = Math.floor(num1/num2);

    return answer;
}

console.log(solution(10, 5));
console.log(solution(7, 2));