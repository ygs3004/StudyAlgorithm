function solution(n) {
    if(n%3==0) n=n/3;
    if(n%2==0) n=n/2;
    return n;
}