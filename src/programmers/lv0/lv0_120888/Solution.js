function solution(my_string) {
    let result = '';
    [...my_string].forEach( v => {
        if(result.indexOf(v)==-1) result+=v;
    })
    return result;
}