package javaPackage.programmers.excute;

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

    public void result(int[] a) {
        System.out.println("parameter 1 : "+ Arrays.toString(a));
        System.out.println("result : " + solution(a));
    }

    public void result(int[] a, int b) {
        System.out.println("parameter 1 : "+ Arrays.toString(a));
        System.out.println("parameter 2 : "+ b);
        System.out.println("result : " + solution(a, b));
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
