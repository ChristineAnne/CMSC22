public class AccountTester{
	public static void main(String[] args){
		Account a = new Account(54149, 1000.00);
		Account b = new Account(54144);

		System.out.println(a);
		System.out.println(b + "\n");

		a.setBalance(2000.15);
		b.setBalance(100.50);

		System.out.println("a accountNumber = " + a.getAccountNumber());
		System.out.println("b accountNumber = " + b.getAccountNumber());
		System.out.println("a balance = " + a.getBalance());
		System.out.println("b balance = " + b.getBalance() + "\n");

		System.out.println(a);
		System.out.println(b + "\n");

		a.credit(50);
		b.credit(50);

		System.out.println(a);
		System.out.println(b + "\n");

		a.debit(100);
		b.debit(160);

		System.out.println(a);
		System.out.println(b + "\n");

	}
}