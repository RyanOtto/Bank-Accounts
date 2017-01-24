import java.util.Scanner;

//TODO: Create Checking and Savings subclasses, modify accordingly
//TODO: Allow for switching between accounts
//TODO: Allow for transfer of funds between accounts
//TODO: Ensure scanners close when appropriate

public class Main {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Welcome!  Enter your initial deposit: ");
		int initBalance=scanner.nextInt();
		Account accountOne=new Account(initBalance, 1);
		Boolean hasQuit=false;
		while(!hasQuit){
			System.out.println("You have $" + accountOne.getBalance() + " in your account.  Your account number is " + accountOne.getAccountNumber() + 
				".\nWould you like to [d]eposit, [w]ithdraw, [s]witch to another account, or [q]uit?");
			String accountChoiceLetter=scanner.next();
			switch(accountChoiceLetter.toLowerCase()){
			case "w":
				System.out.println("w");
				break;
			case "d":
				System.out.println("d");
				break;
			case "s":
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
