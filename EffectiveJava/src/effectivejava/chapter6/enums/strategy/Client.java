package effectivejava.chapter6.enums.strategy;

public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		double hoursWorked = 12;
		double payRate = 8;
		for (PayRollDay p : PayRollDay.values()){
			double amount = p.pay(hoursWorked, payRate);
			System.out.printf("Working on %s gives me %f dollars%n", p,amount);
		}

	}

}
