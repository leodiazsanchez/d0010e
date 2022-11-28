package lab5;

import java.util.NoSuchElementException;
import java.util.ArrayList;

public class FIFO extends Object {

    private ArrayList<Object> queue;
    private int maxSize = 0;
    
    public FIFO() {
    	this.queue = new ArrayList<Object>();
    }

    public void add(Object item) {

        this.queue.add(item);

        if (this.queue.size() > this.maxSize()) {
            
            this.maxSize = this.queue.size();

        }

    }

    public void set(int index, Object obj) throws NoSuchElementException {

        if (index > this.size()) {
            
            throw new NoSuchElementException();

        }

        this.queue.set(index, obj);

    }

    public Object get(int index) {

        return this.queue.get(index);
    
    }

    public Object first() throws NoSuchElementException {
        if (this.isEmpty()) {
            throw new NoSuchElementException();
        } else {
            return this.queue.get(0);
        }
    }

    public boolean isEmpty() {
        return this.size() == 0;
    }

    public int maxSize() {
        return this.maxSize;
    }

    public void removeFirst() throws NoSuchElementException {
        
        if (this.isEmpty()) {

            throw new NoSuchElementException();

        } else {

            this.queue.remove(0);

        }

    }

    public int size() {
        return queue.size();
    }

    public boolean equals(Object f) {

        boolean sameClass = f.getClass().equals(this.getClass());

        // Check if f is same class
        if (!sameClass) {
            
            throw new ClassCastException();

        }

        // Check if they have the same size
        if (((FIFO) f).size() != this.size()) {

            return false;

        }

        boolean equals = true;

        for (int i = 0; i < this.size(); i++) {

            Object obj1 = this.queue.get(i);
            Object obj2 = ((FIFO)f).queue.get(i);
            
            if (obj1 == obj2) continue;
            if (obj1 == null || obj2 == null && obj1 != obj2) {
                return false;
            } else if (!obj1.equals(obj2) && obj1 != obj2) {
                return false;
            }

        }

        return equals;

    }

    public String toString() {

        String output = "[";

        for (Object element : this.queue) {

            output += String.valueOf(element) + ", ";

        }
        
        output += "]";

        return output;

    }

}