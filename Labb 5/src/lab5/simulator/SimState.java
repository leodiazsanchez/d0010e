package lab5.simulator;

import java.util.Observable;
import lab5.events.Event;

public abstract class SimState extends Observable {
    
    protected boolean running = true;
    protected double time = 0;
    protected double lambda;
    protected Event event;
    protected Long seed;
    
    public SimState(Long seed, double lambda) {

        this.seed = seed;
        this.lambda = lambda;

    }
    
    public void pause() {

        running = false;

    }

    public void resume() {

        running = true;

    }

    public boolean isRunning() {

        return running;

    }
    
    public void setTime(double time) {

    	this.time = time;
    
    }

    public Long getSeed() {

		return seed;
	
    }

    public double getLambda() {
	
        return lambda;
	
    }
    
    public double getTime() {

    	return time;
    
    }

    public void setEvent(Event event) {

		this.event = event;
        
		this.setChanged();
		this.notifyObservers();
	
	}

	public Event getEvent(){
		return event;
	}

}
