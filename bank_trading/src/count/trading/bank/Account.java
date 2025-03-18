package count.trading.bank;

public class Account {
	
	
	
	private int accountNumber;
	private String accountHolderName;
	private double balance;


	
	
	
	
	
	
	public Account(int accountNumber, String accountHolderName, double balance) {
		this.accountNumber=accountNumber;
		this.accountHolderName=accountHolderName;
		this.balance=balance;

				
	}
	
	
	public int getaccountNumber() {
		return accountNumber;
	}
	
	public String getaccountHolderName() {
		return accountHolderName;
	}
	public double getbalance() {
		return balance;
	}
	
	
	public double setamount(double amount) {
		return amount;
	}
	
//	
//	@override
//	public String display() {
//		return super.display();
//	}
//	
	
	void depositing(double amount) {
		if (amount <= this.getbalance()) {
	        System.out.println("error you dont have mony");
		
		}else {
			this.am
		}
		
		
	}
        
	
	
	
	
	public static void main(String[] args) {

	}

}
