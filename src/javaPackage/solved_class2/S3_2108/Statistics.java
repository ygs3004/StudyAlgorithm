/*
수를 처리하는 것은 통계학에서 상당히 중요한 일이다. 통계학에서 N개의 수를 대표하는 기본 통계값에는 다음과 같은 것들이 있다.
단, N은 홀수라고 가정하자.

산술평균 : N개의 수들의 합을 N으로 나눈 값
중앙값 : N개의 수들을 증가하는 순서로 나열했을 경우 그 중앙에 위치하는 값
최빈값 : N개의 수들 중 가장 많이 나타나는 값
범위 : N개의 수들 중 최댓값과 최솟값의 차이
N개의 수가 주어졌을 때, 네 가지 기본 통계값을 구하는 프로그램을 작성하시오.

입력
첫째 줄에 수의 개수 N(1 ≤ N ≤ 500,000)이 주어진다. 단, N은 홀수이다. 그 다음 N개의 줄에는 정수들이 주어진다.
입력되는 정수의 절댓값은 4,000을 넘지 않는다.

출력
첫째 줄에는 산술평균을 출력한다. 소수점 이하 첫째 자리에서 반올림한 값을 출력한다.
둘째 줄에는 중앙값을 출력한다.
셋째 줄에는 최빈값을 출력한다. 여러 개 있을 때에는 최빈값 중 두 번째로 작은 값을 출력한다.
넷째 줄에는 범위를 출력한다.

예제 입력 1
5
1
3
8
-2
2
예제 출력 1
2
2
1
10
예제 입력 2
1
4000
예제 출력 2
4000
4000
4000
0
예제 입력 3
5
-1
-2
-3
-1
-2
예제 출력 3
-2
-2
-1
2
예제 입력 4
3
0
0
-1
예제 출력 4
0
0
0
1
*/
package javaPackage.solved_class2.S3_2108;

import java.io.*;
import java.util.*;

public class Statistics {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] integerArr = new int[n];
        int sum=0;
        int max = -4001;
        int min = 4001;
        Map<Integer, Integer> maxMap = new HashMap<>();

        for (int i=0; i < n; i++) {
            int a = Integer.parseInt(br.readLine());
            sum += a;
            integerArr[i] = a;

            max = Math.max(max, a);
            min = Math.min(min, a);
            if (maxMap.get(a) != null) {
                int newVal = maxMap.get(a)+1;
                maxMap.put(a, newVal);
            }else{
                maxMap.put(a, 1);
            }

        }

        Arrays.sort(integerArr);
        List<Map.Entry<Integer, Integer>> entrySet = new ArrayList<>(maxMap.entrySet()) ;
        entrySet.sort(new Comparator<Map.Entry<Integer, Integer>>(){
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                if(o1.getValue() == o2.getValue()){
                    return o1.getKey() - o2.getKey();
                }else{
                    return o2.getValue() - o1.getValue();
                }
            }
        });

        int frequencyNum = 0;
        if(entrySet.size() == 1){
            frequencyNum = entrySet.get(0).getKey();
        } else if(entrySet.get(0).getValue() == entrySet.get(1).getValue()){
            frequencyNum = entrySet.get(1).getKey();
        }else{
            frequencyNum = entrySet.get(0).getKey();
        }

        // 산술평균
        bw.write(Math.round((double) sum/n) + "\n" );
        // 중앙값
        bw.write(integerArr[n/2] + "\n" );
        // 최빈값
        bw.write(frequencyNum + "\n");
        // 범위
        bw.write((max - min) + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

}
