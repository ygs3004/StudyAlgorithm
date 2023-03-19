function solution(n) {
    let count = 0;
    for(let i=1; i<=n; i++){
        checkN(i) && count ++
    }
    return count;
}

const checkN = n => {
    let count = 0;
    for(let i=1; i<=n; i++){
        n%i == 0 && count++
        if(count == 3) return true;
    }
    return false;
}