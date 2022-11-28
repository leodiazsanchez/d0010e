package lab5.shop;

import lab5.random.ExponentialRandomStream;

public class ArrivalTimeCalc extends TimeCalc {
	
	ExponentialRandomStream stream;
	
	public ArrivalTimeCalc(double lambda, long seed) {

		stream = new ExponentialRandomStream(lambda, seed);
	
	}
	
	public ArrivalTimeCalc(double lambda) {
	
		stream = new ExponentialRandomStream(lambda);
	
	}
	
	public double next() {

		return stream.next();
	
	}
}
