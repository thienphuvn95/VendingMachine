package vendingmachine;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class VendingMachine {
	static Scanner scan = new Scanner(System.in);
	static Money money= new Money( 50, 0);
	static String aaa;
	static BufferedReader reader= new BufferedReader(new InputStreamReader(System.in));
	private static List<Inventory> listItems = new ArrayList<>();
	private static List<Inventory> listCoins = new ArrayList<>();
	public VendingMachine() {
		listItems.add(new Inventory( "SNACK", 1.25, 10 ));
		listItems.add(new Inventory( "COCA", 3.0, 15));
		listItems.add(new Inventory("GUM", 1.75, 20));
		//coin
		listCoins.add(new Inventory("25", 0.25, 20));
		listCoins.add(new Inventory("100", 1.0, 10));
		listCoins.add(new Inventory("5", 0.05, 30));
		listCoins.add(new Inventory("10", 0.1, 20));
	}
	public static void display() {
		// TODO Auto-generated method stub
		System.out.println("Welcome to Vending Machine: ");
		getmoney(0);
		showItems();
	}
	public static void getmoney(double num) {
		System.out.println("Please insert  only Quarter or One Dollar or Press 0 to Restock: ");
		double insert=scan.nextDouble();
		scan.nextLine();
		if (insert ==0) {
			restock();
		}
		else {
		money.setInsertmoney(insert+num+money.getInsertmoney());;
		System.out.println("Your money: $" + money.getInsertmoney());
		}
}
	public static void showItems() {
		System.out.println("Items are shown below");
		for (int i=0; i<listItems.size();i++) {
			System.out.println(listItems.get(i).getName());
		}
		System.out.println("Enter a number starting from 0 to get item: ");
		int num=scan.nextInt();
		if (num<=listItems.size()-1) {
			getinfo(num);
		}
		else {
			System.out.println("Invalid item, please try again: ");
			showItems();
		}
	}
	public static void getinfo(int num) {
		if (listItems.get(num).getQuant() > 0 ) {
			System.out.println("You chose " + listItems.get(num).getName());
			System.out.println("The price is $" + listItems.get(num).getPrice());
			System.out.println("There are " + listItems.get(num).getQuant() + " left");
		}
		else {
			System.out.println("Sold Out, Please buy another item");
			showItems();
		}
		if (listItems.get(num).getPrice()<=money.getInsertmoney()) {
			System.out.println("Here your item and balance $" + (money.getInsertmoney()-listItems.get(num).getPrice()));
			listItems.get(num).deduct();
			money.setTotal(money.getTotal()+ money.getInsertmoney());
			money.setInsertmoney(money.getInsertmoney()-listItems.get(num).getPrice());
			System.out.println("---------------------------");
			display();
		}
		else {
			System.out.println("Insufficient money. Please insert more coin");
			getmoney(money.getInsertmoney());
			showItems();
		}
	}
	
	public static void addingItems() {
		System.out.println("Enter the name of item you want to add: ");
		aaa=scan.nextLine();
		String name=scan.nextLine();
		System.out.println("Enter quantity: ");
		int quantity=scan.nextInt();
		System.out.println("Enter price: ");
		double price=scan.nextDouble();
		listItems.add(new Inventory(name, price, quantity));
		System.out.println("Do you want to add more item? Press 0 to add, 1 to collecting money or 2 to back to screen ");
		int num=scan.nextInt();
		if (num ==0) {
			addingItems();
		}
		else if (num ==1)
			collectingmoney();
		display();
		getmoney(0);
		showItems();
	}
	public static void collectingmoney() {
		System.out.println("Your total money is: "+ money.getTotal());
		System.out.println("To add money. Enter number for coin value, 5 for Nickel, 10 for Dime, 25 for Quarter, 100 for one Dollar: ");
		aaa=scan.nextLine();
		String name=scan.nextLine();
		System.out.println("Enter quantity: ");
		int quantity=scan.nextInt();
		System.out.println("Enter price: ");
		double price=scan.nextDouble();
		listItems.add(new Inventory(name, price, quantity));
		money.setTotal(money.getTotal()+ price*quantity);
		System.out.println("Press 0 to add coin or 1 to remove money, 2 to back to screen ");
		int num=scan.nextInt();
		if (num ==0) {
			collectingmoney();
		}
		else if(num ==1) {
			System.out.println("Enter amount you want to remove ");
			double remove=scan.nextDouble();
			money.setTotal(money.getTotal()-remove);
			System.out.println("Your balance in storage is: " + money.getTotal());
		}
		display();
		getmoney(0);
		showItems();
	}
	public static void restock(){
		System.out.println("Input Passwords to add item or to collect or remove money from Storage: ");
		int num=scan.nextInt();
			//Password is 6789 for adding item, 9876 for removing money;
		if (num == 6789) {
			addingItems();
		}
		else if (num == 9876){
			collectingmoney();
			}
		System.out.println("Press 0 to reinput password");
	}
}

	