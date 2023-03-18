const readline = require('readline');
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

let input = [];

rl.on('line', function (line) {
    input = line.split(' ');
}).on('close', function () {
    const solution = (n) => {
        let arr = [];
        arr.length = n;
        arr.fill("0");
        return arr.map( (v,i) =>{
            v='';
            while(i-- >= 0){
                v += '*';
            }
            return v;
        }).join('\n')
    }
    
    console.log(solution(input));
});