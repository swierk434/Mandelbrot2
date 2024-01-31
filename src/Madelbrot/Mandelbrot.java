package Madelbrot;

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Mandelbrot {
	public static void main(String[] args) throws IOException {
		int sizes[] = {16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192};
		Image I[] = new Image[sizes.length];
		//double x1 = -0.742643135; double y1 = 0.131825963;	
		//Image I = new Image(sizex, sizey, -2.1, 0.6, -1.2, 1.2, 200);
		System.out.print('[');
		for(int n = 0; n < sizes.length; n++) {
			//I[n] = new Image(sizes[n], sizes[n], x1-0.002, x1+0.0005, y1-0.002, y1+0.0005 ,200);
			I[n] = new Image(sizes[n], sizes[n], -2.1, 0.6, -1.2, 1.2, 200);
			System.out.print('[');
			for(int m = 0; m < 10; m++){
				long start = System.nanoTime();
				for(int x = 0; x < sizes[n]; x++) {
					//System.out.println(x);
					for(int y = 0; y < sizes[n]; y++) {
						I[n].colorPixel(x,y);
					}
				}
			long end = System.nanoTime();
			System.out.print((end - start) / 1000000000.0 + ", ");
			ImageIO.write(I[n], "png", new File("Mandelbrot" + sizes[n] + "px.png"));
			}
			System.out.println(']');
		}
		System.out.println(']');
	}
}
