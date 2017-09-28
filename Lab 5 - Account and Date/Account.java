public class Account{
	
	private int accountNumber;
	private double balance = 0.0;

	Account(int accountNumber, double balance){
		this.accountNumber = accountNumber;
		setBalance(balance);
	}

	Account(int accountNumber){
		this.accountNumber = accountNumber;
	}

	int getAccountNumber(){
		return this.accountNumber;
	}

	double getBalance(){
		return this.balance;
	}

	void setBalance(double balance){
		this.balance = balance;
	}

	void credit(double amount){
		this.balance += amount;
	}

	void debit(double amount){ 
		if(this.balance >= amount){
			this.balance -= amount;
		} else{
			System.out.println("Amount withdrawn exceeds the current balance!");
		}
	}

	public String toString(){
		return String.format("A/C no: %d, Balance = $%.2f", this.accountNumber, this.balance);
	}

}