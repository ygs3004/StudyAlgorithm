/*
N!에서 뒤에서부터 처음 0이 아닌 숫자가 나올 때까지 0의 개수를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 N이 주어진다. (0 ≤ N ≤ 500)

출력
첫째 줄에 구한 0의 개수를 출력한다.

예제 입력 1
10
예제 출력 1
2

예제 입력 2
3
예제 출력 2
0
*/
const filePath = process.platform === 'linux' ? '/dev/stdin' : './input.txt';
const n = +require('fs').readFileSync(filePath, 'utf-8').trim();
let factorial = 1n;

for(let i=BigInt(1); i<=n; i++){
    factorial *= i
}

factorial = factorial.toString();
let result = 0;
for (let i=factorial.length-1; i>=0; i--){
    if(factorial.charAt(i) !== '0') break;
    result++;
}

console.log(result);