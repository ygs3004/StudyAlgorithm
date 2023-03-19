function solution(age) {
    let numbers = ['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j'];
    return age.toString().split("").map(v => numbers[v]).join('');;
}