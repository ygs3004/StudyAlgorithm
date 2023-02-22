/*
좌표 정렬하기 2
2차원 평면 위의 점 N개가 주어진다. 좌표를 y좌표가 증가하는 순으로,
y좌표가 같으면 x좌표가 증가하는 순서로 정렬한 다음 출력하는 프로그램을 작성하시오.

입력
첫째 줄에 점의 개수 N (1 ≤ N ≤ 100,000)이 주어진다. 둘째 줄부터 N개의 줄에는 i번점의 위치 xi와 yi가 주어진다.
(-100,000 ≤ xi, yi ≤ 100,000) 좌표는 항상 정수이고, 위치가 같은 두 점은 없다.

출력
첫째 줄부터 N개의 줄에 점을 정렬한 결과를 출력한다.

 예제 입력 1
5
0 4
1 2
1 -1
2 2
3 3
예제 출력 1
1 -1
1 2
2 2
3 3
0 4

2
2 200
1 200

3
2 0
1 0
0 0
*/
let fs = require('fs');
const filePath = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
let input = fs.readFileSync("./input.txt").toString().trim();
let inputLineArr = input.split('\n').map(v => v.trim());
let n = inputLineArr.shift();
inputLineArr.sort((a, b) => {
    a = a.split(' ');
    b = b.split(' ');

    let ax = a[0];
    let ay = a[1];

    let bx = b[0];
    let by = b[1];

    if (ay === by){
        return ax - bx;
    }else{
        return ay - by;
    }
});
let result = ''
for (let i = 0; i < n; i++) {
    result += inputLineArr[i]+'\n'
}
console.log(result)