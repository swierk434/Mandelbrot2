package Madelbrot;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.lang.Math;

public class Image extends BufferedImage{
	double Re1, Re2, Im1, Im2;	
	int sizex, sizey, maxiterations;
	
	public Image(int sizeX, int sizeY, double x1, double x2, double y1, double y2, int max) {
		super(sizeX, sizeY, BufferedImage.TYPE_INT_RGB);
		sizex = sizeX; sizey = sizeY;
		Re1 = x1; Re2 = x2; Im1 = -y2; Im2 = -y1;
		maxiterations = max;
	}
	
	public Complex getc(int x, int y) {
		return new Complex(Re1 + (Re2-Re1)*x/sizex, Im1 + (Im2-Im1)*y/sizey);
	}
	
	public void colorPixel(int x, int y) {
		Series s1 = new Series(getc(x, y));
		while(s1.iteration < maxiterations && Math.abs(s1.element.Re) < 2) {
			s1.nextElement();
		}
		int col = new Color(0,s1.iteration,0).getRGB();
		this.setRGB(x, y, col);
	}
}
