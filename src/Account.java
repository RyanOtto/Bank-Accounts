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
		this.balance-=amount;
	}
	public void deposit(double amount) {
		this.balance+=amount;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber=accountNumber;
	}

}
