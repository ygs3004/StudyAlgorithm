package ch04;

import java.util.Scanner;

public class Ex07 {

	public static void main(String[] args) {
		
		boolean run=true;
		
		int balance=0;
		
		Scanner sc=new Scanner(System.in);
		
		Label:while(run) {
			System.out.println("-----------------------------");
			System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료");
			System.out.println("-----------------------------");
			System.out.print("선택>");
			int cho=sc.nextInt();
			switch(cho){
				case 1:
					System.out.print("예금액>");
					int in=sc.nextInt();
					balance+=in;
					System.out.println();
					break;
				case 2:
					System.out.print("출금액>");
					int out=sc.nextInt();
					balance-=out;
					System.out.println();
					break;
				case 3:
					System.out.print("잔고>"+balance);
					System.out.println();
					break;
				case 4:
					System.out.println();
					break Label;
			}
		
			
		}
				
		System.out.println("프로그램 종료");
		sc.close();
		
	}

}
