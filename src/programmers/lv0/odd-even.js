/*
짝수 홀수 개수
문제 설명
정수가 담긴 리스트 num_list가 주어질 때, num_list의 원소 중 짝수와 홀수의 개수를 담은 배열을
return 하도록 solution 함수를 완성해보세요.
*/

function solution(num_list) {
    let odd = 0;
    let even = 0;

    num_list.forEach( v => {
        v % 2 === 0 ? even++ : odd++ ;
    } )

    return [odd, even];
}

const num_list1 = [1, 2, 3, 4, 5];
const num_list2 = [1, 3, 5, 7];
console.log(solution(num_list1));
console.log(solution(num_list2));
