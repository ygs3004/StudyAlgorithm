/*
배열 원소의 길이
문제 설명
문자열 배열 strlist가 매개변수로 주어집니다. strlist 각 원소의 길이를 담은 배열을 retrun하도록 solution 함수를 완성해주세요.
https://school.programmers.co.kr/learn/courses/30/lessons/120854
*/

let strlist1 = ["We", "are", "the", "world!"];	    // [2, 3, 3, 6]
let strlist2 = ["I", "Love", "Programmers."];       // [1, 4, 12]

function solution(strlist) {
    var answer = [];
    return strlist.map( v => v.length);
}

console.log(solution(strlist1));
console.log(solution(strlist2));