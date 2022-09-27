package Training;

import java.util.Scanner;

public class Diamond {

	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		
		System.out.print("숫자를 입력해주세요:");
		int num=sc.nextInt();
		int width=num*2-1;
		
		
		for(int r=1;r<=num;r++) {
			
			for(int c=1;c<=width;c++) {
				if(c==num+(r-1)) {
					System.out.print("*");
				}else if(c==num-(r-1)){
					System.out.print("*");
				}else {
					System.out.print(" ");
				}
			}
		System.out.println();
		}
		
		
		for(int r=1;r<=num-1;r++) {
			
			for(int c=1;c<=width;c++) {
				if(c==r+1) {
					System.out.print("*");
				}else if(c==width-r){
					System.out.print("*");
				}else {
					System.out.print(" ");
				}
			}
		System.out.println();
		}
		sc.close();
	}
}