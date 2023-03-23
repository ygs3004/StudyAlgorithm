function solution2(cipher, code) {
    return [...cipher].filter((v, i) => (i+1)%code === 0).join('');
}

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

console.log(solution(5))