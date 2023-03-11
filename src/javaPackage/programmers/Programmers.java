package javaPackage.programmers;

public abstract class Programmers<R, P> {

    public abstract R solution(P p);

    public void result(P params){

        R results = solution(params);

        System.out.println("---------------------------------");
        System.out.println("parameter : " + printV(params));
        System.out.println("result : " + printV(results));
        System.out.println("---------------------------------");
    }

    public <V> StringBuilder printV(V values){

        StringBuilder sb = new StringBuilder();

        if(values.getClass().getTypeName().equals("int[]")){
            int[] valuesArr = (int[])values ;
            for (int v : valuesArr) {
                sb.append(v).append(" ");
            }
        }else if(values.getClass().getTypeName().equals("java.lang.String[]")){
            String[] valuesArr = (String[])values ;
            for (String v : valuesArr) {
                sb.append(v).append(" ");
            }
        }else{
            sb.append(values);
        }

        return sb;
    }

}
