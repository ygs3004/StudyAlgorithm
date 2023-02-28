package javaPackage.B5.o2558;

// 두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.
//수학
//구현
//사칙연산
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AplusBminus2 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(Integer.parseInt(br.readLine())+Integer.parseInt(br.readLine()));
    }
}
