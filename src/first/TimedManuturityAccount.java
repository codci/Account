package first;

public class TimedManuturityAccount extends SavingAccount{

	static double penalty;	
	
	TimedManuturityAccount(int id, double bal, int dateY, int dateM) {
		super(id, bal, dateY, dateM);
		penalty = 0.05;
		// TODO Auto-generated constructor stub
	}

	void getInformation() {
		System.out.println(this.idAccount + " - Saving account");
		System.out.println("   Баланс на счету: "+this.balance);
		
	}		 
}
