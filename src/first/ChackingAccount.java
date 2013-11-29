package first;

import java.util.Date;

public class ChackingAccount extends UniversalAccount{
//I have "ChackingAccount" "CheckingAccount"=) may be Chak have happy=)
	int totalTransaction;
	static double mounthlyQuota;
	static int transactionFee;
	
	ChackingAccount(int id, double bal, int dateY, int dateM) {
		super(id,bal, dateY, dateM);
		totalTransaction = 0;
		mounthlyQuota = 5;
		transactionFee = 3;
	}
	
	@SuppressWarnings("deprecation")
	void AccuralOfBalance(){
		int y = 0, m =0;
		Date d1 = new Date();
		y = d1.getYear() - this.checkDateYear;
		m = d1.getMonth() - this.checkDateMounth;
		this.checkDateYear = d1.getYear()%100;
		this.checkDateMounth = d1.getMonth();
		
		
		if( y > 0 || m > 0 )
			this.totalTransaction = 0;
		
		this.totalTransaction += 1;
		
		if (ChackingAccount.mounthlyQuota < this.totalTransaction )
			this.balance -= (this.totalTransaction - ChackingAccount.mounthlyQuota)* ChackingAccount.transactionFee;
		
	}

	@Override
	void getInformation() {
		this.AccuralOfBalance();
		System.out.println(this.idAccount + " - Checking account");
		System.out.println("   Баланс на счету: "+this.balance);
		
	}
}
