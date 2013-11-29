package first;

import java.util.Scanner;

public class Main {
	
	static int scanInt(int name){
		@SuppressWarnings("resource")
		Scanner sc1 = new Scanner(System.in);
		name = sc1.nextInt();
		return name;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		/*WrightXML.modifyAccountXML(10000, 1000, 0, 13, 7, 1);
		WrightXML.modifyAccountXML(10001, 1001, 500, 13, 5, 2);
		WrightXML.modifyAccountXML(10002, 1002, 0, 12, 7, 1);
		WrightXML.modifyAccountXML(10003, 1003, 8, 13, 3, 2);
		WrightXML.modifyAccountXML(10004, 1004, 0, 9, 7, 3);
		WrightXML.modifyAccountXML(10005, 1005, 4, 13, 8, 1);
		WrightXML.modifyAccountXML(10006, 1006, 0, 11, 6, 2);
		WrightXML.modifyAccountXML(10007, 1007, 10, 13, 7, 3);
		WrightXML.modifyAccountXML(10008, 1008, 0, 10, 1, 1);
		WrightXML.modifyAccountXML(10009, 1009, 20, 13, 7, 1);*/
		int action = 0;
		
		while(action != 10){
			System.out.println("Здравствуйте, вас привестствует программа эмуляции сберегательных счетов.");
			System.out.println("  Вам доступны следующие действия:");
			System.out.println("	1 - Пойти в банк.");
			System.out.println("	2 - Подойти к банкомату.");
			System.out.println("	3 - Завершить использование программы.");
			action = Main.scanInt(action);
			switch(action){
			case 1: Bank.emulateBank(); break;
			case 2: ATM.emuleteATM(); break;
			case 3: action = 10; break;
			default: action = 0;System.out.println("Вы ввели неверную команду.");break;
			}
		}
		System.out.println("Спасибо за использование программы!");
	}

}