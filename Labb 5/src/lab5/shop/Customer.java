package lab5.shop;

public class Customer {
	
	//TODO Should not be an integer!
	private int id;


	public Customer(CustomerFactory factory) {
		this.id = factory.getId();
	}
	
	public int getId() {
		return id;
	}

}
