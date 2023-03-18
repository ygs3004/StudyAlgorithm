function solution(my_string, num1, num2) {
    return [...my_string].map((v,i,arr) => i==num1 ? arr[num2] : i==num2 ? arr[num1] : v).join('');
}