package miller_problem2;

public class SavingsAccountTest {
	public static void main(String[] args) {
		
		SavingsAccount saver1 = new SavingsAccount();
		SavingsAccount saver2 = new SavingsAccount();
		
		SavingsAccount.modifyInterestRate(0.04);
		saver1.setSavingsBalance(2000);
		saver2.setSavingsBalance(3000);
		saver1.calculateMonthlyInterest();
		saver2.calculateMonthlyInterest();
		SavingsAccount.modifyInterestRate(0.05);
		saver1.calculateMonthlyInterest();
		saver2.calculateMonthlyInterest();

	}

}
