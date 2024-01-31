package Madelbrot;

public class Complex {
	double Re, Im;
	
	public Complex() {
		Re = 0;
		Im = 0;	
	};
	public Complex(double re, double im) {
		Re = re;
		Im = im;
	};
	
	public static Complex square(Complex Z) {
		Complex out = new Complex();
		out.Re = Z.Re*Z.Re-Z.Im*Z.Im;
		out.Im = 2*Z.Re*Z.Im;
		return out;
	}
	public static Complex add(Complex Z1, Complex Z2) {
		Complex out = new Complex();
		out.Re = Z1.Re + Z2.Re;
		out.Im = Z1.Im + Z2.Im;
		return out;
	}
	
	public void printComplex() {
		System.out.println(this.Re + "+" + this.Im + "i");
	}
}
