public class Account {
	private double balance;
	private int accountNumber;
	
	public Account(double accountBalance, int number){
		balance = accountBalance;
		accountNumber = number;
	}
	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

}
