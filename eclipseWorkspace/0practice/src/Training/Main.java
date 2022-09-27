package Training;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

	public static void main(String[] args) {
		int[] a = new int[2];
		check(a);
			
		System.out.println(a[0]);
	}
	
	public static void check(int[] a) {
		a[0]=1;
	}
}