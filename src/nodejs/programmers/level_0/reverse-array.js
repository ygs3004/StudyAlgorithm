/*
배열뒤집기
문제 설명
정수가 들어 있는 배열 num_list가 매개변수로 주어집니다. num_list의 원소의 순서를 거꾸로 뒤집은 배열을 return하도록 solution 함수를 완성해주세요.

[1, 2, 3, 4, 5]	         ->   [5, 4, 3, 2, 1]
[1, 1, 1, 1, 1, 2]       ->   [2, 1, 1, 1, 1, 1]
[1, 0, 1, 1, 1, 3, 5]    ->   [5, 3, 1, 1, 1, 0, 1]
https://school.programmers.co.kr/learn/courses/30/lessons/120821?language=javascript
*/

function solution(num_list) {
    return  num_list.map( (v,i,arr) => {
        return arr[arr.length-1-i];
    });
}

let num_list1 = [1, 2, 3, 4, 5];
let num_list2 = [1, 1, 1, 1, 1, 2];
let num_list3 = [1, 0, 1, 1, 1, 3, 5];

console.log(solution(num_list1));
console.log(solution(num_list2));
console.log(solution(num_list3));