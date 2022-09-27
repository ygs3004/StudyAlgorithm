package ch04; // 중첩 for 문을 사용하여 4x+5y=60의 모든해를 구해서 (x,y)로 출력(x,y는 10 이하)

public class Ex05 {

	public static void main(String[] args) {
		
		int x;
		int y;
		
		for(x=1;x<=10;x++) {
			for(y=1;y<=10;y++) {
				if(4*x+5*y==60) {
					System.out.println("("+x+","+y+")");
				}
			}
		}
	}
}
