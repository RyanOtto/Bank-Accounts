import java.util.Scanner;

//TODO: Create Checking and Savings subclasses, modify accordingly
//TODO: Allow for switching between accounts
//TODO: Allow for transfer of funds between accounts
//TODO: Ensure scanners close when appropriate
//Create a new checking account

public class Main {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Welcome!  Enter your initial deposit: ");
		int initBalance=scanner.nextInt();
		SavingsAccount savingsAccount=new SavingsAccount(initBalance, 1);
		CheckingAccount checkingAccount = new CheckingAccount(initBalance, 1, 0);
		Boolean hasQuit=false;
		int whichAccount=0; //0 represents savings, 1 represents checking
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
				//Sys, how much to withdraw?
				//int wAmount=scanner.nextInt();
				if(whichAccount==0){
					//withdraw wAmount from savings
				}
				else{
					//withdraw wAmount from checking 
				}
				System.out.println("w");
				break;
			case "d":
				//Sys, how much to deposit?
				//int dAmount=scanner.nextInt();
				if(whichAccount==0){
					//deposit dAmount in savings
				}
				else{
					//deposit dAmount in checking
				}
				System.out.println("d");
				break;
			case "s":
				//0 for savings, 1 for checking
				//whichAccount=scanner.nextInt()
				System.out.println("s");
				break;
			case "q":
				System.out.println("q");
				hasQuit=true;
				break;
			}
		}
		scanner.close();
	}
}
