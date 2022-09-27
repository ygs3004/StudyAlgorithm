package ch06;

public class Account1 {

	private int balance=0;
		
	static final int MIN_BALANCE=0;
	static final int MAX_BALANCE=1000000;
	
	public int getBalance() {
		return balance;
	}

	void setBalance(int balance) {
		if(balance>=MIN_BALANCE && balance<=MAX_BALANCE) {
			this.balance=balance;	
		}
	}
}	