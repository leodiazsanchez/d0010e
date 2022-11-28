package lab5.shop;

import lab5.random.UniformRandomStream;

public class PickUpTimeCalc extends TimeCalc {

	UniformRandomStream stream;
	
	public PickUpTimeCalc(double lower, double upper, long seed) {

		stream = new UniformRandomStream(lower, upper, seed);

	}
	
	public PickUpTimeCalc(double lower, double upper) {

		stream = new UniformRandomStream(lower, upper);
		
	}
	
	public double next() {
		return stream.next();
	}
}
