package programmers.lv0.lv0_120894;

class Solution {
    public long solution(String numbers) {
        
        numbers = numbers.replace("zero","0").replace("one", "1").replace("two", "2")
                         .replace("three", "3").replace("four", "4").replace("five", "5")
                         .replace("six", "6").replace("seven", "7").replace("eight", "8")
                         .replace("nine", "9");
        
        return Long.parseLong(numbers);      
        
    }
}