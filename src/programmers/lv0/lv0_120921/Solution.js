function solution(A, B) {
    
    let a = [...A];
    let count = 0;
    
    for(let i=0; i<B.length; i++){
        if(a.join('') == B) break;
        a.unshift(a.pop());    
        count++;
    }
    
    return B.length == count ? -1 : count;

}