/*
 * Class to implement the withdrawal and deposit functions for the Online Banking Application (Using synchronized).
 */
package bankingApp;

public class Banking {
private String accountId;
private String bankName;
private String location;
private double balance;

//Constructor to initialize properties
Banking(String accountId,String bankName,String location,double balance){
	this.accountId=accountId;
	this.bankName=bankName;
	this.location=location;
	this.balance=balance;
	
}
/*
 * synchronized method for withdrawing amount
 */
synchronized public void withdraw(double amt){  
	System.out.println("\nGoing to Withdraw ");
	/*
	 * if the balance is less than the amount to be withdrawn 
	 */
	if(amt>this.balance){  
		System.out.println("Amount to be withdrawn is greater than balance");
		try {
			wait(); //Causes current thread to release the lock and wait until either another thread invokes the notify() method . Waits till the deposit is done
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * If the balance is less than 10000 or the balance after withdrawal will be less than 10000 
	 */
	if(( this.balance-amt)<10000 || this.balance<10000 ){ 
		System.out.println("Minimum Balance should be 10000");
		try {
			wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	this.balance = this.balance-amt;  //balance after withdrawal
	System.out.println("Withdraw completed. Balance after withdrawl is :" + this.balance);
	
}
/*
 * synchronized method for depositing amount
 */
synchronized public void deposit(double amt){ 
	System.out.println("\n Going to Deposit ");
	this.balance= this.balance+amt; //balance after depositing
	System.out.println("Deposit completed .Balance after deposit is :"+ this.balance);
	notify(); // wakes up the thread , which was waiting
}

}
