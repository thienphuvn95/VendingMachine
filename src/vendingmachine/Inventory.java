package vendingmachine;

public class Inventory {
	private String name; //e.g., SNACK, COCA,...
	private double price;
	private int quant;
	
	
	public Inventory(String name, double price, int  quant) {
		this.name = name;
		this.price = price;
		this.quant = quant;
			
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuant() {
		return quant;
	}
	public void setQuant(int quant) {
		this.quant = quant;
	}
	public void deduct() {
		this.quant -=1;
	}
	

}
