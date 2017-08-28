/*
 * This class Show deposit and withdraw functionality for the Online Banking Application
 *  
 */

package bankingApp;

public class TestBanking extends Thread  {

	public static void main(String[] args) {

		Banking account = new Banking("sr262760", "Citi", "Yelahanka", 40000.00); // creating account of the bank 

		new Thread() {  // user 1 trying to withdraw amount from the account 
			public void run() {
				account.withdraw(20000.00);
			}
		}.start();
		new Thread() {	// user 2 trying to withdraw amount from the account
			public void run() {
				account.withdraw(30000.00);
			}
		}.start();
		new Thread() {	// user 3 trying to withdraw amount from the account
			public void run() {
				account.withdraw(30000.00);
			}
		}.start();
		new Thread() {	// user 4 trying to deposit amount from the account
			public void run() {
				account.deposit(100000.00);
			}
		}.start();

	}

}
