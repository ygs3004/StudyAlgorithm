/*
문자 반복 출력하기
문제 설명
문자열 my_string과 정수 n이 매개변수로 주어질 때, my_string에 들어있는
각 문자를 n만큼 반복한 문자열을 return 하도록 solution 함수를 완성해보세요.
https://school.programmers.co.kr/learn/courses/30/lessons/120825
*/

function solution(my_string, n) {
    return my_string.split("").map(v => {
        let result = "";
        for(let i=0; i<n; i++){
            result += v;
        }
        return result;
    }).join("");
}

console.log(solution("hello", 3));

function solution2(array) {

    return array.sort((a, b) => a-b)[Math.floor(array.length/2)];
}

console.log(solution2([1,2,3,4,5,6,7,8,9,10,11]));