function solution(a, b) {
   
    for(let i=b; i>1; i--){
        if(a%i == 0 && b%i ==0){
            a /= i;
            b /= i;
        }
    }
    
    
    for(let i=b; i>1; i--){
        if(i%2!=0 && i%5!=0 && b%i==0) return 2;
    }
    
    return 1;
}