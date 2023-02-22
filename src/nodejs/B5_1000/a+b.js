let fs = require('fs');
const filePath = process.platform === "linux" ? "/dev/stdin" : "./input.txt";

let input = fs.readFileSync(filePath);
input = input.toString().split(' ');

const result = parseInt(input[0]) + parseInt(input[1]);

console.log(result);
