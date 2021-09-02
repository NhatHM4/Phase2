package Short_Assginment_601;

public class ManagerAccount {
	public static void main(String[] args) {
		SavingsAccount sa1 = new SavingsAccount(0.04, 2000);
		SavingsAccount sa2 = new SavingsAccount(0.04, 3000);
		sa1.calculateMonthlyInterest();
		sa2.calculateMonthlyInterest();
		sa1.setIntRate(0.05);
		sa2.setIntRate(0.05);
		sa1.calculateMonthlyInterest();
		sa2.calculateMonthlyInterest();
	}
}
