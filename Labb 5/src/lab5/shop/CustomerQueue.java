package lab5.shop;

import java.util.NoSuchElementException;
import lab5.FIFO;

public class CustomerQueue extends FIFO {

	public CustomerQueue() {
		
	}
	
	public Customer getNextCustomer() throws NoSuchElementException {

        if (isEmpty()) {

            throw new NoSuchElementException();

        }
        
        return (Customer) first();

    }
	
}
