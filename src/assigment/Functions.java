package assigment;

public class Functions implements Visitor {
	
	private Account account;

	public void visit(Visitable visitable) {
		account = (Account) visitable;
		}
	
	public boolean eligitableForCreditCard() {
		if((double)account.readBalance() >= 5000) {
			return true;
		}
		return false;
	}
	
	public boolean canGetALoan() {
		if((double)account.readBalance() >= 15000) {
			return true;
		}
		return false;
	}
	
	public boolean openSavingsAccount() {
		if((double)account.readBalance() >= 200) {
			return true;
		}
		return false;
	}
	
	public boolean transfer(double amount) {
		double total = (double)account.readBalance() - amount;
		if(total > 0) {
			account.setBalance(total);
			return true;
		}
		return false;
	}

}
