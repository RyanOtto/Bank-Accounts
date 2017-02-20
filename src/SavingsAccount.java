
public class SavingsAccount extends Account{

		private double interestRate;
		
	public SavingsAccount(double accountBalance, int number, double accountInterestRate) {
		super(accountBalance, number);
		interestRate = accountInterestRate;
	}

	public double getInterestRate() {
		return interestRate;
	}
}
