package sunZoo;

public class Plan {
	private String title;
	private int discount;
	
	//Constructor
	public Plan(String name, int discount) {
		super();
		this.title = name; 
		this.discount = discount;
	}

	public String getName() {
		return title;
	}

	public void setName(String name) {
		this.title = name;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}
	
	
	
}
