package first;

public abstract class UniversalAccount {
		int idAccount;
		double balance;											//balance of account
		int checkDateYear;										//format YY
		int checkDateMounth;									//format MM
		static final int chackingAccount = 1;					
		static final int savingAccount = 2;
		static final int timedManuturityAccount = 3;
		static final int overdraftAccount = 4;
		
		static UniversalAccount accountFactory (int type,int id,double bal,int dateY, int dateM){
			UniversalAccount ua = null;
			if(type == chackingAccount)
				ua = new ChackingAccount(id,bal,dateY,dateM);
			else if(type == savingAccount)
				ua = new SavingAccount(id,bal,dateY,dateM);
			else if(type == timedManuturityAccount)
				ua = new TimedManuturityAccount(id,bal,dateY,dateM);
			else if(type == overdraftAccount)
				ua = new OverdraftAccount(id,bal,dateY,dateM);
			else 
				System.out.println("accountFactory Create is failed");
			return ua;
		}
			

		UniversalAccount(int id,double bal,int dateY,int dateM){
			idAccount = id;
			balance = bal;
			checkDateYear = dateY;
			checkDateMounth = dateM;
		}

			
		public void Invest(double summ){
			if(summ > 0)
				this.balance += summ;
			else
				System.out.println("Невозможно пополнить баланс!");
		}
			
		void Remote(double summ){
			if(summ < this.balance && summ >0){
				this.balance -= summ;
			System.out.println("Вы получаете "+ summ );
			} else
				System.out.println("Недостаточно средств на балансе");
		}
		
		double CheckBalance(){
			return this.balance;
		}
		
		abstract void getInformation();
			
		abstract void AccuralOfBalance();

		
}
