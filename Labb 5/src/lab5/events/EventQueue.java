package lab5.events;

import java.util.NoSuchElementException;
import lab5.FIFO;

public class EventQueue extends FIFO {
    
    public Event getNextEvent() throws NoSuchElementException {

        if (isEmpty()) {

            throw new NoSuchElementException();

        }

        Event event = (Event) first();
        removeFirst();
        
        return event;

    }

    public void addEvent(Event event) {
        
    	
        this.add(event);
        this.sort();

    }

    public void sort() {


         for (int i = 0; i < size(); i++) {

             for (int j = i + 1; j < size(); j++) {
                
                 Event e1 = (Event) get(j);
                 Event e2 = (Event) get(i);

                 if (e1.getTime() < e2.getTime()) {
                	 
                     set(i, e1);
                     set(j, e2);
                     
                 }

             }

        }

    }

}
