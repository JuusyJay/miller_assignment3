package miller_problem2;

public class SavingsAccount {

	private static double annualInterestRate;
	private double savingsBalance;
	
	public void calculateMonthlyInterest() {
		
		for(int i = 0; i< 12; i++) {
			double monthlyInterest = (savingsBalance * annualInterestRate) / 12;
			savingsBalance += monthlyInterest;
			System.out.printf("%d. %.2f at %.0f percent interest rate.\n", i + 1, savingsBalance, (getAnnualInterestRate() * 100));
		}
		
	
		
	}
	
	public double setSavingsBalance(double bal) {
		
		savingsBalance = bal;
		
		return savingsBalance;
		
	}
	
	public static void modifyInterestRate(double num){
		
		annualInterestRate = num;
	}
	
	public double getAnnualInterestRate() {
		return annualInterestRate;
	}
}
