package programmers.excute;

import java.util.Arrays;

public abstract class ProgrammersInt {

    public int solution(int[] a){
        return 0;
    }
    public int solution(int[] a, int b){
        return 0;
    }

    public int solution(int a){
        return 0;
    }
    public int solution(int a, int b){
        return 0;
    }

    public int solution(String[] a){
        return 0;
    }
    public int solution(String[] a, String[] b){ return 0;}

    public void result(int[] a) {
        System.out.println("parameter 1 : "+ Arrays.toString(a));
        System.out.println("result      : " + solution(a));
    }

    public void result(String[] a) {
        System.out.println("parameter 1 : "+ Arrays.toString(a));
        System.out.println("result      : " + solution(a));
    }
    public void result(String[] a, String[] b) {
        System.out.println("parameter 1 : "+ Arrays.toString(a));
        System.out.println("parameter 2 : "+ Arrays.toString(b));
        System.out.println("result      : " + solution(a, b));
    }

    public void result(int[] a, int b) {
        System.out.println("parameter 1 : "+ Arrays.toString(a));
        System.out.println("parameter 2 : "+ b);
        System.out.println("result      : " + solution(a, b));
    }

    public void result(int a) {
        System.out.println("parameter 1 : "+ a);
        System.out.println("result : " + solution(a));
    }

    public void result(int a, int b) {
        System.out.println("parameter 1 : "+ a);
        System.out.println("parameter 2 : "+ b);
        System.out.println("result : " + solution(a, b));
    }
}
