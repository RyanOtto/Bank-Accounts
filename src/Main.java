import java.util.Scanner;

//TODO: Handle checking account min. balance
	//If withdrawal or transfer puts user down below min. balance, do something about it

public class Main {
	public static void main(String[] args) {
		
		Scanner scanner=new Scanner(System.in);
		System.out.println("Welcome!  Enter 0 to enter your savings account and 1 for your checking account: ");
		int whichAccount=scanner.nextInt(); //0 represents savings, 1 represents checking
		double wAmount=0; //Withdrawal amount
		double dAmount=0; //Deposit amount
		double tAmount=0; //Transfer amount
		SavingsAccount savingsAccount=new SavingsAccount(0, 0, .15);
		CheckingAccount checkingAccount = new CheckingAccount(0, 1, 0);
		Boolean hasQuit=false;
		int outputInt=0; //Addresses the double-print bug introduced by scanner conditional code
		
		while(!hasQuit){
			if(whichAccount==0 && outputInt==0){ //if handling the savings account
			System.out.println("You have $" + savingsAccount.getBalance() + " in your savings account.  Your account number is " + savingsAccount.getAccountNumber() + 
				".  Would you like to [d]eposit, [w]ithdraw, [s]witch to another account, [t]ransfer funds between accounts, [c]ollect interest or [q]uit?\n");
			outputInt=1;
			}
			else if(whichAccount==1 && outputInt==0){ //if handling the checking account
				System.out.println("You have $" + checkingAccount.getBalance() + " in your checking account.  Your account number is " + checkingAccount.getAccountNumber() + 
						".  Would you like to [d]eposit, [w]ithdraw, [s]witch to another account, [t]ransfer funds between accounts or [q]uit?\n");
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
				if(whichAccount==0 && wAmount <= savingsAccount.getBalance() && !(wAmount < 0))  savingsAccount.withdraw(wAmount);
				else if(whichAccount==1 && wAmount <= checkingAccount.getBalance() && !(wAmount < 0))  checkingAccount.withdraw(wAmount);
				else System.out.println("ERROR: Invalid withdrawal amount");
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
				if(dAmount < 0) System.out.println("ERROR: Invalid deposit amount");
				else if(whichAccount==0) savingsAccount.deposit(dAmount);
				else checkingAccount.deposit(dAmount);
				outputInt=0;
				break;
				
			case "s":
				System.out.println("Enter 0 to enter your savings account, and 1 to enter your checking account");
				if(!scanner.hasNextInt()){
					System.out.println("ERROR: Invalid number");
					outputInt=0;
					break;
				}
				whichAccount=scanner.nextInt();
				if(whichAccount!=0 && whichAccount!=1){
					System.out.println("Please enter 0 (savings account) or 1 (checking account)");
					outputInt=0;
					break;
				}
				outputInt=0;
				break;	

			case "q":
				System.out.println("\nGoodbye.");
				hasQuit=true;
				break;
				
			case "t":
				if(whichAccount==0){
					System.out.println("Enter tranfer amount to checking account: ");
					if(!scanner.hasNextDouble()){
						System.out.println("\nERROR: Please enter a valid number");
						outputInt=0;
						break;
					}
					tAmount=scanner.nextDouble();
					if(tAmount < 0 || tAmount > savingsAccount.getBalance()) System.out.println("ERROR: Invalid transfer amount");
					else if(tAmount<=savingsAccount.getBalance()){
						savingsAccount.withdraw(tAmount);
						checkingAccount.deposit(tAmount);		
					}
				}
				else if(whichAccount==1){
					System.out.println("Enter tranfer amount to savings account: ");
					if(!scanner.hasNextDouble()){
						System.out.println("\nERROR: Please enter a valid number");
						outputInt=0;
						break;
					}
					tAmount=scanner.nextDouble();
					if(tAmount < 0 || tAmount > checkingAccount.getBalance()) System.out.println("ERROR: Invalid transfer amount");
					else if(tAmount<=checkingAccount.getBalance()){
						checkingAccount.withdraw(tAmount);
						savingsAccount.deposit(tAmount);		
					}
				}
				else{
					System.out.println("Please enter a valid account number");
				}
				outputInt=0;
				break;
				
			case "c": 	
				if(whichAccount == 0){
					savingsAccount.deposit(savingsAccount.getBalance() * savingsAccount.getInterestRate());
				}
				outputInt=0;
				break;
			}
		}
		scanner.close();
	}
}
