import java.util.*;
import java.lang.*;

class Solution {
    
    int goal = 0;
    List<Method> methods = new ArrayList();
    static int visited[] = new int[1000001];
    
    public int solution(int x, int y, int n) {
        if(x==y) return 0;
        goal = x;
        listingMethods(n);
        
        Queue<Acc> queue = new LinkedList<>();
        queue.add(new Acc(y, 0));
        int result = -1;
        
        while(!queue.isEmpty()){
            Acc acc = queue.poll();
            visited[acc.value] = acc.no;
            if(acc.value == goal){
                result = acc.no;
                break;
            }
            
            for(Method method : methods){
                int nextValue = method.execute(acc.value);
                int nextNo = acc.no + 1;
                if(nextValue >= goal && visited[nextValue] == 0){
                    queue.add(new Acc(nextValue, nextNo));    
                }
            }
        }
        
        return result;
    }
    
    private class Acc{
        int value; // 합계
        int no; // 실행횟수
        
        Acc(int value, int no){
            this.value = value;
            this.no = no;
        }
    }
    
    private void listingMethods(int n){        
        methods.add(a -> {
            return a - n;
        });
        
        methods.add(a -> {
            return a % 2 == 0 ? a / 2 : -1;
        });
        
        methods.add(a -> {
            return a % 3 == 0 ? a / 3 : -1;
        });
    }
    
    @FunctionalInterface
    private interface Method{
        public int execute(int a);
    }
    
}