function solution(hp) {
    
    return parseInt(hp/5) + parseInt(hp%5/3) + parseInt(hp%5%3);
}