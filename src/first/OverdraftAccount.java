package first;

public class OverdraftAccount extends UniversalAccount{

	static double investRate;
	
	OverdraftAccount(int id, double bal, int dateY, int dateM) {
		super(id, bal, dateY, dateM);
		investRate = 0.2;
	}

	@Override
	void AccuralOfBalance() {
		
		
	}

	@Override
	void getInformation() {
		System.out.println(this.idAccount + " - Overdraft account");
		System.out.println("   Баланс на счету: "+this.balance);
		
	}
	

}
