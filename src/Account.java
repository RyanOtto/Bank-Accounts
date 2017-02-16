public class Account {
	private double balance;
	private int accountNumber;
	
	public Account(double accountBalance, int number){
		balance=accountBalance;
		accountNumber=number;
	}
	public double getBalance() {
		return balance;
	}

	public void withdraw(double amount) {
		if(amount<=balance && amount>0) this.balance-=amount;
	}
	public void deposit(double amount) {
		if(amount>0) this.balance+=amount;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber=accountNumber;
	}

}
