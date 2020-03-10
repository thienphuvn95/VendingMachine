package vendingmachine;

public class Money {
	private double insertmoney;
	private double total;
	
	public Money(double total, double insert) {
		this.total=total;
		this.insertmoney=insert;
		// TODO Auto-generated constructor stub
	}
	public double getInsertmoney() {
		return insertmoney;
	}
	public void setInsertmoney(double coin) {
		this.insertmoney = coin;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	
}
