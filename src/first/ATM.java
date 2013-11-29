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
			System.out.println("�������� ��������:");
			System.out.println("   1 - ������ ������.");
			System.out.println("   2 - ������ �� ���������.");
			action = ATM.scanInt(action);
			switch(action){
			case 1: System.out.println("��������� �������, �������� �����������!");
			if (ATM.initialize() == true)
				ATM.menu();break;
			case 2:action = 10;break;
			default: action = 0;System.out.println("�� ����� �������� �������.");break;
			}
		}
		
	}
	
	static boolean initialize(){
		int password = 0;
		int idAccount = 0;
		
		System.out.println("������� ����� �����:");
		idAccount = ATM.scanInt(idAccount);
		System.out.println("������� ������:");
		password = ATM.scanInt(password);
		
		ua = ReadXML.initialize(idAccount,password);
		if(ua != null){
			System.out.println("���� � ������� ���������� �������");
			return true;
		}
		else {
			System.out.println("�� ����� ������������ ������!");
			return false;
		}
	}
	
	static void menu(){
		int temp = 0;
		 int sum = 0;
		 
		while(temp != 4){
			System.out.println("�������� �������� � ����� ������: ");
			System.out.println("   1 - ��������� ������.");
			System.out.println("   2 - ����� ��������.");
			System.out.println("   3 - ���������� ��������� �� �����.");
			System.out.println("   4 - ��������� ������.");
			temp = ATM.scanInt(temp);
			switch (temp){
			case 1: System.out.println("������� ����� ���������� �������:");sum = ATM.scanInt(sum);ua.Invest(sum);break;
			case 2: System.out.println("������� ����� ������� �� ������ �����:");sum = ATM.scanInt(sum);ua.Remote(sum);break;
			case 3: ua.getInformation();break;
			case 4: System.out.println("������� �� ������������� ����� �����.");WrightXML.modifyXML(ua.idAccount, ua.balance, ua.checkDateYear,ua.checkDateMounth);break;
			default: System.out.println("�� ����� �������� �������!");
			}
		}
	}
}
