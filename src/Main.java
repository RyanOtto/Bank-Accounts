import java.util.Scanner;

//TODO: Allow for transfer of funds between accounts
//TODO: Handle savings account interest
//TODO: Handle checking account min. balance


public class Main {
	public static void main(String[] args) {
		
		Scanner scanner=new Scanner(System.in);
		System.out.println("Welcome!  Enter 0 to enter your savings account and 1 for your checking account: ");
		int whichAccount=scanner.nextInt(); //0 represents savings, 1 represents checking
		double wAmount=0;
		double dAmount=0;
		SavingsAccount savingsAccount=new SavingsAccount(0, 0);
		CheckingAccount checkingAccount = new CheckingAccount(0, 1, 0);
		Boolean hasQuit=false;
		int outputInt=0; //Addresses the double-print bug introduced by scanner conditional code
		
		while(!hasQuit){
			if(whichAccount==0 && outputInt==0){ //if handling the savings account
			System.out.println("You have $" + savingsAccount.getBalance() + " in your savings account.  Your account number is " + savingsAccount.getAccountNumber() + 
				".  Would you like to [d]eposit, [w]ithdraw, [s]witch to another account, or [q]uit?");
			outputInt=1;
			}
			else if(whichAccount==1 && outputInt==0){ //if handling the checking account
				System.out.println("You have $" + checkingAccount.getBalance() + " in your checking account.  Your account number is " + checkingAccount.getAccountNumber() + 
						".  Would you like to [d]eposit, [w]ithdraw, [s]witch to another account, [t]ransfer funds between account or [q]uit?\n");
				outputInt=1;
			}
			String accountChoiceLetter=scanner.next();
			switch(accountChoiceLetter.toLowerCase()){
			case "w":
				System.out.println("Enter withdrawal amount: ");
				if(!scanner.hasNextDouble()){
					System.out.println("\nERROR: Please enter a valid number");
					outputInt=0;
					break;
				}
				wAmount=scanner.nextDouble();
				if(whichAccount==0){
					if(wAmount > savingsAccount.getBalance() || wAmount < 0){//If user withdraws too much or withdraws an invalid number
						System.out.println("\nERROR: Invalid withdrawal amount");
						outputInt=0;
						break;
					}	
					savingsAccount.withdraw(wAmount);
				}
				else{
					if(wAmount > checkingAccount.getBalance() || wAmount < 0){//If user withdraws too much or withdraws an invalid number
						System.out.println("\nERROR: Invalid withdrawal amount");
						outputInt=0;
						break;
					}
					checkingAccount.withdraw(wAmount); 
				}
				outputInt=0;
				break;
				
			case "d":
				System.out.println("Enter deposit amount: ");
				if(!scanner.hasNextDouble()){
						System.out.println("\nERROR: Please enter a valid number");
						outputInt=0;
						break;
				}
				dAmount=scanner.nextDouble();
				if(dAmount < 0){//If user deposits an invalid number
					System.out.println("\nERROR: Invalid deposit amount");
					outputInt=0;
					break;
				}
				if(whichAccount==0){
					savingsAccount.deposit(dAmount);
				}
				else{
					checkingAccount.deposit(dAmount);
				}
				outputInt=0;
				break;
				
			case "s":
				System.out.println("Enter 0 to enter your savings account, and 1 to enter your checking account");
				whichAccount=scanner.nextInt();
				outputInt=0;
				break;
				
			case "q":
				System.out.println("\nGoodbye.");
				hasQuit=true;
				break;
			}
		}
		scanner.close();
	}
}
