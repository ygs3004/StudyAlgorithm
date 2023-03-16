package javaPackage.programmers.excute;

public abstract class Programmers2<R, P, P2> extends Programmers<R, P>{

    public abstract R solution(P p, P2 p2);

    public void result(P params1, P2 params2){

        R result = solution(params1, params2);

        System.out.println("---------------------------------");
        System.out.println("parameter1 : " + printV(params1));
        System.out.println("parameter2 : " + printV(params2));
        System.out.println("result     : " + printV(result));
        System.out.println("---------------------------------");

    }
}
