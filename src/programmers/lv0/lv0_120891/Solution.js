function solution(order) {
    return order.toString().split('').reduce( (a, c) => c%3==0 && c != '0'? ++a : a, 0);
}