/*
짝수의 합
문제 설명
정수 n이 주어질 때, n이하의 짝수를 모두 더한 값을 return 하도록 solution 함수를 작성해주세요.
제한사항
0 < n ≤ 1000
입출력 예
n	result
10	30
4	6
입출력 예 설명
입출력 예 #1
n이 10이므로 2 + 4 + 6 + 8 + 10 = 30을 return 합니다.
입출력 예 #2
n이 4이므로 2 + 4 = 6을 return 합니다.
*/

function solution(n) {
    let result = 0;
    for(let i=0; i<=n; i=i+2){
        result += i;
    }
    return result;
}

console.log(solution(10));
console.log(solution(4));