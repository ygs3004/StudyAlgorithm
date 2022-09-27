package Training;

public class Outter {
	
	public void method2(int arg) { // <=final arg
		int localVariable=1; // <=final localVariable
		// arg=100;
		// localVariable=100; 로컬 클래스엥서 사용되는 변수는 자동으로 final 
		class Inner{
			public void method() {
				int result=arg+localVariable;
				
			}
		}
	}
}
