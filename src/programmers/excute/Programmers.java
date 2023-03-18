package programmers.excute;

public class Programmers<R, P> {

    public R solution(P p){
        return null;
    }
    public void result(P params){

        R result = solution(params);

        System.out.println("---------------------------------");
        System.out.println("parameter1 : " + printV(params));
        System.out.println("result     : " + printV(result));
        System.out.println("---------------------------------");
    }

    public <V> StringBuilder printV(V values){

        StringBuilder sb = new StringBuilder();
        if(values.getClass().getTypeName().equals("int[]")){
            sb.append("[");
            int[] valuesArr = (int[])values ;
            for (int v : valuesArr) {
                sb.append(v).append(", ");
            }
            sb.delete(sb.length()-2, sb.length());
            sb.append("]");
        }else if(values.getClass().getTypeName().equals("java.lang.String[]")){
            String[] valuesArr = (String[])values ;
            sb.append("[");
            for (String v : valuesArr) {
                sb.append(v).append(", ");
            }
            sb.delete(sb.length()-2, sb.length());
            sb.append("]");
        }else{
            sb.append(values);
        }

        return sb;
    }

}
