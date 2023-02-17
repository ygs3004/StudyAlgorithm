let fs = require('fs');

let input = fs.readFileSync('dev/stdin');
input = input.toString().split(' ');

const result = parseInt(input[0]) + parseInt(input[1]);

console.log(result);
