package ch06;

import java.util.Scanner;

public class BankApplication {
	private static Account[] accountArray = new Account[100];
	private static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		boolean run=true;
		while(run) {
			System.out.println("-----------------------------------------");
			System.out.println("1.계좌생성 | 2.계좌목록 | 3.예금 | 4.출금 | 5.종료");
			System.out.println("-----------------------------------------");
			System.out.println("선택> ");

			int selectNo=scanner.nextInt();
			
			if(selectNo==1) {
				createAccount();
			}else if(selectNo==2) {
				accountList();
			}else if(selectNo==3) {
				deposit();
			}else if(selectNo==4) {
				withdraw();
			}else if(selectNo==5) {
				run = false;
			}
		}
		System.out.println("프로그램 종료");
	}

	//계좌 생성하기
	private static void createAccount(){
		
		System.out.println("-------------");
		System.out.println("계좌생성");
		System.out.println("-------------");
		
		scanner.nextLine();
		System.out.print("계좌번호 : ");
		String ano=scanner.nextLine();
		
		System.out.print("계좌주 : ");
		String owner=scanner.nextLine();
		
		System.out.print("초기입금액 : ");
		int balance=scanner.nextInt();

		System.out.println("결과 : 계좌가생성되었습니다.");
		
		for(int i=0; i<accountArray.length; i++) {
			if(accountArray[i]==null) {
				accountArray[i]=new Account(ano, owner, balance);
				break;
			}
		}
	}
				
	
	//계좌목록보기
	private static void accountList() {
		for(int i=0; i<accountArray.length; i++) {
			if(accountArray[i]==null) {
				break;	
			}
			System.out.println(accountArray[i].getAno()+" "+accountArray[i].getOwner()+" "+accountArray[i].getBalance());
		}
		
	}
	
	//예금하기
	private static void deposit() {
		scanner.nextLine();
		System.out.print("계좌번호 : ");
		String ano=scanner.nextLine();
		
		Account account=findAccount(ano);
		
		if(account==null) {
			System.out.println("없는 계좌번호입니다.");
			return;
		}
		
		int balance=account.getBalance();
		
		System.out.print("예금액 : ");
		int deposit=scanner.nextInt();
		balance+=deposit;
		account.setBalance(balance);
		System.out.println("결과 : 예금이 성공되었습니다.");
	}
	
	//출금하기
	private static void withdraw() {
		scanner.nextLine();
		System.out.print("계좌번호 : ");
		String ano=scanner.nextLine();
		
		Account account=findAccount(ano);
		
		if(account==null) {
			System.out.println("없는 계좌번호입니다.");
			return;
		}
		
		int balance=account.getBalance();
		System.out.print("출금액 : ");
		int deposit=scanner.nextInt();
		balance-=deposit;
		account.setBalance(balance);
		System.out.println("결과 : 출금이 성공되었습니다.");
		
	}
	
	//Account 배열에서 ano와 동일한 Account 객체 찾기
	private static Account findAccount(String ano) {
		Account account=null;
		for(int i=0; i<accountArray.length; i++) {
			if(accountArray[i]==null) {
				return null;
			}
			if(ano.equals(accountArray[i].getAno())){ 
				account=accountArray[i];
				break;
			}
		}
		return account;
	}
		
}