package first;

import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class Bank {

	static int scanInt(int name){
		@SuppressWarnings("resource")
		Scanner sc1 = new Scanner(System.in);
		name = sc1.nextInt();
		return name;
	}
	
	static void emulateBank(){
		int action = 0;
		
		while(action != 10){
			System.out.println("�������� ��������:");
			System.out.println("   1 - ������� ����.");
			System.out.println("   2 - ����� �� �����.");
			action = Bank.scanInt(action);
			switch(action){
			case 1: if(Bank.createAccountBank() == true)
				System.out.print("���� ������, ������� �� ����� ������ �����.");
			else
				System.out.print("��������� ������, ���������� ��� ���.");break;
			case 2:action = 10;break;
			default: action = 0;System.out.println("�� ����� �������� �������.");break;
			}
		}
	}
	
	@SuppressWarnings("deprecation")
	static boolean createAccountBank(){
		Random random = new Random();
		
		int typeAccount = 0;
		int id = 0;
		int pas = 0;
		boolean temp = false; 
	
		System.out.print("�������� ��� �������� ������� �� �� ������ �������:\n");
		System.out.print("    1 - �hecking Account\n");
		System.out.print("    2 - Saving Account\n");
		System.out.print("    3 - Timed Manuturity Account\n");
		System.out.print("    4 - Overdraft Account\n");
		typeAccount = scanInt(typeAccount);
		if(typeAccount >= 4 && typeAccount <=1)
			return false;
		
		while(temp == false){
			id = random.nextInt(99999);
			pas = random.nextInt(9999);
			if(ReadXML.initialize(id, pas) == null);
				temp = true;
		}
		System.out.println("��� �� ����� - " + id);
		System.out.println("��� ������ -" + pas);
		
		Date d1 = new Date();
		int dateY = d1.getYear()%100;
		int dateM = d1.getMonth();
		
		WrightXML.createAccountXML(id, pas, 0, dateY, dateM, typeAccount);
		return true;
	}
}
