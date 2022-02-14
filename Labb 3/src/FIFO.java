import java.util.ArrayList;
import java.util.NoSuchElementException;

public class FIFO implements Queue {

	private ArrayList<Object> queue = new ArrayList<>();
	private int counter= 0;


	public void add(Object item) {
		queue.add(item);
		if(this.size() > counter) {
			counter++;
		}

	}

	public Object first() throws NoSuchElementException {
		if (isEmpty()) {
			throw new NoSuchElementException("No such element exists");
		} else {
			return queue.get(0);
		}
	}

	public void removeFirst() throws NoSuchElementException {
		if (isEmpty()) {
			throw new NoSuchElementException("No such element exists");
		} else {
			queue.remove(0);
		}
	}

	public boolean isEmpty() {
		if (queue.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

	public int size() {
		return queue.size();
	}

	public int maxSize() {
		return counter;
	}
	
	@Override
	public String toString() {
		String str = "";
		for (Object obj : queue) {
			str += "(" + obj + ") ";
		}
		return "Queue: " + str;
	}

	public boolean equals(Object f) throws ClassCastException {
		if (!(this.getClass() == f.getClass())) {
			throw new ClassCastException("Not the same type");
		} else if (!((this.size()) == ((FIFO) f).size())) {
			return false;
		}

		for (int i = 0; i < this.size(); i++) {
			Object obj1 = this.queue.get(i);
			Object obj2 = ((FIFO) f).queue.get(i);

			if (obj1 == null && obj2 == null) {
				continue;
			} else if (obj1 == null && obj2 != null || obj1 != null && obj2 == null) {
				return false;
			} else if (!(obj1.equals(obj2))) {
				return false;
			}
		}

		return true;

	}

}
