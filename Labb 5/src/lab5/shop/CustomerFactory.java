package lab5.shop;

public class CustomerFactory {
	
	//TODO Should not be an integer!
	private int count = 0;
	
	public int getId() {
		int id = count;
		count++;
		return id;
	}
	
}
