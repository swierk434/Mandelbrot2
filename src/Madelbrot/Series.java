package Madelbrot;

public class Series {
	Complex element, c;
	int iteration;
	
	public Series() {
		element = new Complex(0,0);
		c = new Complex(0,0);
		iteration = 0;
	}
	public Series(Complex C) {
		element = new Complex(0,0);
		c = C;
		iteration = 0;
	}
	
	public void nextElement() {
		element = Complex.add(Complex.square(element), c);
		iteration++;
	}
	public void printElement(){
		System.out.println(element.Re + "+" + element.Im + "i ,n=" + iteration);
	}
}
