function solution(n) {
    let i = 2;
    while(n >= 1){
        n /= i++;
    }
    return n%i == 0 ? i-1 : i-2;
}