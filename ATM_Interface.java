import java.util.Scanner;

class My_BankAccount{
	
	String name;
	String uName;
	String pass;
	String accountNo;
	float bal = 0f;
	int transactions = 0;
	String transactionHistory = "";

	public void register() {
		Scanner sc = new Scanner(System.in);
		System.out.print("\nENTER YOUR NAME:  ");
		this.name = sc.nextLine();
		System.out.print("\nENTER YOUR USERNAME(WILL BE USED REGULARLY) : ");
		this.uName = sc.nextLine();
		System.out.print("\nENTER YOUR PASSWORD : ");
		this.pass= sc.nextLine();
		System.out.print("\n PLEASE ENTER YOUR CORRECT ACCOUNT NUMBER : ");
		this.accountNo = sc.nextLine();
		System.out.println("\nREGISTRATION COMPLETED !..PROCEED TO LOGIN");
	}
	
	public boolean login() {
		boolean isLogin = false;
		Scanner scan = new Scanner(System.in);
		while ( !isLogin ) {
			System.out.print("\n ENTER YOUR USERNAME(WILL BE USED REGULARLY) :");
			String Username = scan.nextLine();
			if ( Username.equals(uName) ) {
				while ( !isLogin ) {
					System.out.print("\nENTER PASSWORD :  ");
					String Password = scan.nextLine();
					if ( Password.equals(pass) ) {
						System.out.print("\nLogin successful!!");
						isLogin = true;
					}
					else {
						System.out.println("\nIncorrect Password");
					}
				}
			}
			else {
				System.out.println("\nUsername not found");
			}
		}
		return isLogin;
	}
	
	public void withdraw() {
		
		System.out.print("\nEnter amount to withdraw - ");
		Scanner scan = new Scanner(System.in);
		float amount = scan.nextFloat();
		try {
			
			if ( bal >= amount ) {
				transactions++;
				bal -= amount;
				System.out.println("\nWithdraw Successfully");
				String str = amount + " Rs Withdrawed\n";
				transactionHistory = transactionHistory.concat(str);
				
			}
			else {
				System.out.println("\nInsufficient Balance");
			}
			
		}
		catch ( Exception e) {
		}
	}
	
	public void deposit() {
		
		System.out.print("\nEnter amount to deposit - ");
		Scanner scan = new Scanner(System.in);
		float amount = scan.nextFloat();
		
		try {
			if ( amount <= 100000f ) {
				transactions++;
				bal += amount;
				System.out.println("\nSuccessfully Deposited");
				String str = amount + " Rs deposited\n";
				transactionHistory = transactionHistory.concat(str);
			}
			else {
				System.out.println("\nSorry...Limit is 100000.00");
			}
			
		}
		catch ( Exception e) {
		}
	}
	
	public void transfer() {
		
		Scanner scan = new Scanner(System.in);
		String receipent = null;
        boolean isValidInput = false;
        while (!isValidInput) {
	            System.out.print("\nEnter Receipent's Name - ");
	            receipent = scan.nextLine();
	            try {
	            	Integer.parseInt(receipent);
	            	System.out.println("Input is not a string. Please try again.");
	            } catch (NumberFormatException e) {
	            	isValidInput = true;
	            }
	    	}
		System.out.print("\nEnter amount to transfer - ");
		float amount = scan.nextFloat();
		
		try {
			if ( bal >= amount ) {
				if ( amount <= 50000f ) {
					transactions++;
					bal-= amount;
					System.out.println("\nSuccessfully Transfered to " + receipent);
					System.out.println("\nYour Blance is:" + bal);
					String str = amount + " Rs transfered to " + receipent + "\n";
					transactionHistory = transactionHistory.concat(str);
				}
				else {
					System.out.println("\nSorry...Limit is 50000.00");
				}
			}
			else {
				System.out.println("\nInsufficient Balance");
			}
		}
		catch ( Exception e) {
		}
	}
	
	public void checkBalance() {
		System.out.println("\n" + bal + " Rs");
	}
	
	public void transHistory() {
		if ( transactions == 0 ) {
			System.out.println("\nEmpty");
		}
		else {
			System.out.println("\n" + transactionHistory);
		}
	}
}


public class ATM_Interface {
	
	
	public static int takeIntegerInput(int limit) {
		int input = 0;
		boolean flag = false;
		
		while ( !flag ) {
			try {
				Scanner scan = new Scanner(System.in);
				input = scan.nextInt();
				flag = true;
				
				if ( flag && input > limit || input < 1 ) {
					System.out.println("Choose the number between 1 to " + limit);
					flag = false;
				}
			}
			catch ( Exception e ) {
				System.out.println("Enter only integer value");
				flag = false;
			}
		};
		return input;
	}
	
	
	public static void main(String[] args) {
		
		System.out.println("\nONLINE ATM SYSTEM IS HERE !!!\n");
		System.out.println("1) Register \n2) Exit");
		System.out.print("Enter Your Choice - ");
		int choice = takeIntegerInput(2);
		
		if ( choice == 1 ) {
			My_BankAccount bank = new My_BankAccount();
			bank.register();
			while(true) {
				System.out.println("\n1.Login \n2.Exit");
				System.out.print("Enter Your Choice - ");
				int charac = takeIntegerInput(2);
				if ( charac == 1 ) {
					if (bank.login()) {
						System.out.println("\n\nWELCOME BACK " + bank.name + "\n");
						boolean isFinished = false;
						while (!isFinished) {
							System.out.println("\n1.Withdraw \n2.Deposit \n3.Transfer \n4.Check Balance \n5.Transaction History \n6.Exit");
							System.out.print("\nEnter Your Choice - ");
							int c = takeIntegerInput(6);
							switch(c) {
								case 1:
								bank.withdraw();
								break;
								case 2:
								bank.deposit();
								break;
								case 3:
								bank.transfer();
								break;
								case 4:
								bank.checkBalance();
								break;
								case 5:
								bank.transHistory();
								break;
								case 6:
								isFinished = true;
								break;
							}
						}
					}
				}
				else {
					System.exit(0);
				}
			}
		}
		else {
			System.exit(0);
		}
	}
}	
