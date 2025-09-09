public class MyClass {
	private String owner;
	private double balance;

	public MyClass(String owner, double balance) {
		this.owner = owner;
		this.balance = balance;
	}

	public MyClass(String owner) {
		this.owner = owner;
		balance = 0.d;
	}

	public String getName() {
		return owner;
	}

	public double getBalance() {
		return balance;
	}

	public void transfer(double amount, MyClass to) {
		if (balance < amount) {
			throw new IllegalArgumentException("Not enough funds!");
		}
		to.balance += amount;
		balance -= amount;
	}

	public String toString() {
		return owner + "'s account balance: $"+ balance;
	}
}