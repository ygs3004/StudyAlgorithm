function solution(numbers) {
    numbers = numbers.sort((a,b) => a-b).filter((v,i) => v!=0&& i==numbers.length-1 || i==numbers.length-2 || i==0 | i==1);
    return numbers[0]*numbers[1] > numbers[numbers.length-1]*numbers[numbers.length-2] ? numbers[0]*numbers[1] : numbers[numbers.length-1]*numbers[numbers.length-2]
}