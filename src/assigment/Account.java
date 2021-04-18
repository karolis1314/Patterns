package assigment;

public class Account implements Visitable{

	public void accept(Visitor visitor) {
		visitor.visit(this);
		}
	
	private String acountName;
	private double balance;
	private String uniqueAccountNumber;
	
	public Account(String name, String number, double balance) {
		this.acountName = name;
		this.uniqueAccountNumber = number;
		this.balance = balance;
	}
	
	public boolean withdraw(int amount) {
		this.balance -= amount;
		if(this.balance < 0) {
			return false;
		}else return true;
	}
	
	public void deposit(int amount) {
		this.balance += amount;
	}
	
	public String readAccountName() {
		return this.acountName;
	}
	
	public String readAcountNumber() {
		return this.uniqueAccountNumber;
	}
	
	public double readBalance() {
		return this.balance;
	}
	
	public double setBalance(double amount) {
		return this.balance = amount;
	}

}
