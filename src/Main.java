import java.util.Scanner;

//TODO: Allow for transfer of funds between accounts
//TODO: Handle negative account balances 
//TODO: Handle negative user input for withdraw/deposit
//TODO: Handle savings account interest
//TODO: Handle checking account min. balance


public class Main {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Welcome!  Enter 0 to enter your savings account and 1 for your checking account: ");
		int whichAccount=scanner.nextInt(); //0 represents savings, 1 represents checking
		SavingsAccount savingsAccount=new SavingsAccount(0, 0);
		CheckingAccount checkingAccount = new CheckingAccount(0, 1, 0);
		Boolean hasQuit=false;
		while(!hasQuit){
			if(whichAccount==0){ //if handling the savings account
			System.out.println("You have $" + savingsAccount.getBalance() + " in your savings account.  Your account number is " + savingsAccount.getAccountNumber() + 
				".\nWould you like to [d]eposit, [w]ithdraw, [s]witch to another account, or [q]uit?");
			}
			else{ //if handling the checking account
				System.out.println("You have $" + checkingAccount.getBalance() + " in your checking account.  Your account number is " + checkingAccount.getAccountNumber() + 
						".\nWould you like to [d]eposit, [w]ithdraw, [s]witch to another account, or [q]uit?");
			}
			String accountChoiceLetter=scanner.next();
			switch(accountChoiceLetter.toLowerCase()){
			case "w":
				System.out.println("Enter withdrawal amount: ");
				int wAmount=scanner.nextInt();
				if(whichAccount==0){
					savingsAccount.withdraw(wAmount);
				}
				else{
					checkingAccount.withdraw(wAmount); 
				}
				break;
			case "d":
				System.out.println("Enter deposit amount: ");
				int dAmount=scanner.nextInt();
				if(whichAccount==0){
					savingsAccount.deposit(dAmount);
				}
				else{
					checkingAccount.deposit(dAmount);
				}
				break;
			case "s":
				System.out.println("Enter 0 to switch to your savings account, and 1 to switch to your checking account");
				whichAccount=scanner.nextInt();
				break;
			case "q":
				hasQuit=true;
				break;
			}
		}
		scanner.close();
	}
}
