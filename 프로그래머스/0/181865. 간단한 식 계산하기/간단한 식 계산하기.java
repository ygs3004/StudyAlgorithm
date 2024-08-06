class Solution {
    public int solution(String binomial) {
        String[] params = binomial.split(" ");
        int a = Integer.parseInt(params[0]);
        int b = Integer.parseInt(params[2]);
        String oper = params[1];
        int answer = 0;
        switch(oper){
            case "+" :
                answer = a + b;
                break;
            case "-" :
                answer = a - b;
                break;
            case "*" :
                answer = a * b;
                break;
        }
        return answer;
    }
}