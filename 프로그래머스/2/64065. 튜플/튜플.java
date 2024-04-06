class Solution {
    public int[] solution(String s) {
        
        s = s.replace("}", "");
        s = s.replace("{", "");
        
        String[] arr = s.split(",");
        int[] tuple = new int[100001];
        
        for(String an : arr){
            tuple[Integer.parseInt(an)] = tuple[Integer.parseInt(an)] + 1;
        }
        
        int size = 0;
        int sum = 0;
        for(int i=1; i<1000001; i++){
            sum += i;
            if(arr.length == sum){
                size = i;
                break;
            }
        }

        int[] result = new int[size];
        for(int i = 0; i<100001; i++){
            if(tuple[i] != 0){
                result[size-tuple[i]] = i;
            }
        }
                
        return result;
    }
    
}