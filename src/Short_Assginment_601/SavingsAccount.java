package Short_Assginment_601;

public class SavingsAccount {
	private double intRate ;
	private double savBal;
	
	public SavingsAccount() {
		this.intRate = 0d;
		this.savBal = 0d;
	}

	public SavingsAccount(double intRate, double savBal) {
		this.intRate = intRate;
		this.savBal = savBal;
	}

	public double getIntRate() {
		return intRate;
	}

	public void setIntRate(double intRate) {
		this.intRate = intRate;
	}

	public double getSavBal() {
		return savBal;
	}

	public void setSavBal(double savBal) {
		this.savBal = savBal;
	}
	
	public void calculateMonthlyInterest() {
		System.out.println("monthly interest : " + this.intRate*savBal/12);
		this.savBal = this.savBal + this.intRate*this.savBal/12;
		System.out.println("the new balances " + this.savBal);
	}
}
