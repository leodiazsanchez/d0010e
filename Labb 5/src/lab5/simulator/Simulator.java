package lab5.simulator;

import lab5.simulator.Simulator;
import lab5.events.EventQueue;
import lab5.events.Event;

public class Simulator {

	protected SimView view;
	protected SimState state;
	protected EventQueue queue;

	public Simulator(SimView view, SimState state, EventQueue queue) {

		this.view = view;
		this.state = state;
		this.queue = queue;
		
		state.addObserver(view);
	
	}

	public void run() {  
		
		while (state.isRunning() && !queue.isEmpty()) {
			Event event = queue.getNextEvent();
			event.effect();
			state.setTime(event.getTime());
			state.setEvent(event);
			
		}


	}

}
