package first;

import java.util.Date;

public class SavingAccount extends UniversalAccount {
	
	double investRate;
	
	SavingAccount(int id, double bal, int dateY, int dateM){
		super(id,bal,dateY,dateM);
		investRate = 0.02;
	}
	
	
	@SuppressWarnings("deprecation")
	public void AccuralOfBalance(){
		int y = 0, m =0;
		Date d1 = new Date();
		y = d1.getYear()%100 - this.checkDateYear;
		m = d1.getMonth() - this.checkDateMounth;
		this.checkDateYear = d1.getYear()%100;
		this.checkDateMounth = d1.getMonth();
		if(m < 0){
			y--;
			m = 12-m;
		}
		
		if (y > 0 ){
			for( int j = 0; j < y; j++){
					for (int i = 0; i < 12; i++)
						this.balance += (this.balance * this.investRate/12);
				}
		} 
		else{
			for (int i = 0; i < m; i++)
				this.balance += (this.balance * this.investRate/12);
		}
	}


	@Override
	void getInformation() {
		System.out.println(this.idAccount + " - Saving account");
		System.out.println("   Баланс на счету: "+this.balance);
		
	}		 

}
