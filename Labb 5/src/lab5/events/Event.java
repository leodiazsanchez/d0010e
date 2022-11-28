package lab5.events;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import lab5.simulator.SimState;

public abstract class Event {

	protected SimState state;
	protected EventQueue queue;
	protected String description;

	public Event(SimState state, EventQueue queue) {

		this.state = state;
		this.queue = queue;
		
		queue.addEvent(this);
		
	}

	abstract public void effect();

	abstract public double getTime();
	
	 public String toString() {
	 	return String.format("%.2f\t %-10s", state.getTime(),description);
	 }

}
