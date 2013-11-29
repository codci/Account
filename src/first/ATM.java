package first;

import java.util.Scanner;

public class ATM {

	static UniversalAccount ua;
	
	static int scanInt(int name){
		@SuppressWarnings("resource")
		Scanner sc1 = new Scanner(System.in);
		name = sc1.nextInt();
		return name;
	}
	
	static void emuleteATM(){
		int action = 0;
		
		while(action != 10){
			System.out.println("Выберете действие:");
			System.out.println("   1 - Начать работу.");
			System.out.println("   2 - Отойти от банкомата.");
			action = ATM.scanInt(action);
			switch(action){
			case 1: System.out.println("Уважаемый абонент, пройдите авторизацию!");
			if (ATM.initialize() == true)
				ATM.menu();break;
			case 2:action = 10;break;
			default: action = 0;System.out.println("Вы ввели неверную команду.");break;
			}
		}
		
	}
	
	static boolean initialize(){
		int password = 0;
		int idAccount = 0;
		
		System.out.println("Введите номер счета:");
		idAccount = ATM.scanInt(idAccount);
		System.out.println("Введите пароль:");
		password = ATM.scanInt(password);
		
		ua = ReadXML.initialize(idAccount,password);
		if(ua != null){
			System.out.println("Вход в систему произведен успешно");
			return true;
		}
		else {
			System.out.println("Вы ввели некорректные данные!");
			return false;
		}
	}
	
	static void menu(){
		int temp = 0;
		 int sum = 0;
		 
		while(temp != 4){
			System.out.println("Выберите действие с вашим счетом: ");
			System.out.println("   1 - Поплинить баланс.");
			System.out.println("   2 - Снять средства.");
			System.out.println("   3 - Посмотреть инфомацию по счету.");
			System.out.println("   4 - Закончить работу.");
			temp = ATM.scanInt(temp);
			switch (temp){
			case 1: System.out.println("Введите сумму пополнения баланса:");sum = ATM.scanInt(sum);ua.Invest(sum);break;
			case 2: System.out.println("Введите сумму которую сы хотите снять:");sum = ATM.scanInt(sum);ua.Remote(sum);break;
			case 3: ua.getInformation();break;
			case 4: System.out.println("Спасибо за использование услуг банка.");WrightXML.modifyXML(ua.idAccount, ua.balance, ua.checkDateYear,ua.checkDateMounth);break;
			default: System.out.println("Вы ввели неверную команду!");
			}
		}
	}
}
