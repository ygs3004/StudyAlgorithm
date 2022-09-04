package a06string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
상근이의 할머니는 아래 그림과 같이 오래된 다이얼 전화기를 사용한다.

전화를 걸고 싶은 번호가 있다면, 숫자를 하나를 누른 다음에 금속 핀이 있는 곳 까지 시계방향으로 돌려야 한다. 숫자를 하나 누르면 다이얼이 처음 위치로 돌아가고, 
다음 숫자를 누르려면 다이얼을 처음 위치에서 다시 돌려야 한다.
숫자 1을 걸려면 총 2초가 필요하다. 1보다 큰 수를 거는데 걸리는 시간은 이보다 더 걸리며, 한 칸 옆에 있는 숫자를 걸기 위해선 1초씩 더 걸린다.
상근이의 할머니는 전화 번호를 각 숫자에 해당하는 문자로 외운다. 즉, 어떤 단어를 걸 때, 각 알파벳에 해당하는 숫자를 걸면 된다. 예를 들어, UNUCIC는 868242와 같다.
할머니가 외운 단어가 주어졌을 때, 이 전화를 걸기 위해서 필요한 최소 시간을 구하는 프로그램을 작성하시오.

입력
첫째 줄에 알파벳 대문자로 이루어진 단어가 주어진다. 단어의 길이는 2보다 크거나 같고, 15보다 작거나 같다.
출력
첫째 줄에 다이얼을 걸기 위해서 필요한 최소 시간을 출력한다.

1=" "
2=ABC ->2초
3=DEF ->3초
4=GHI ->4초
5=JKL ->5초
6=MNO ->6초
7=PQRS ->7초
8=TUV ->8초
9=WXYZ ->9초
0
ex)
WA -> 13
UNUCIC -> 36
*/
public class A01_Dial_5622 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] abc=br.readLine().toCharArray();
		int sumTime=0;
		
		for(char a : abc) {
			if(a=='A'||a=='B'||a=='C') 
				sumTime+=3;
			if(a=='D'||a=='E'||a=='F') 
				sumTime+=4;
			if(a=='G'||a=='H'||a=='I') 
				sumTime+=5;
			if(a=='J'||a=='K'||a=='L') 
				sumTime+=6;
			if(a=='M'||a=='N'||a=='O') 
				sumTime+=7;
			if(a=='P'||a=='Q'||a=='R'|| a=='S') 
				sumTime+=8;
			if(a=='T'||a=='U'||a=='V') 
				sumTime+=9;
			if(a=='W'||a=='X'||a=='Y'|| a=='Z') 
				sumTime+=10;
		}
		
		System.out.println(sumTime);
		
		
		// 
	}

}
