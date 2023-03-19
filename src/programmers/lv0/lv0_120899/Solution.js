function solution(array) {
    let index = 0;
    let max = 0;
    
    array.forEach((v,i) => {
        if(v>max) index = i;
        max = Math.max(v, max);
    });
    
    return [max, index];
}