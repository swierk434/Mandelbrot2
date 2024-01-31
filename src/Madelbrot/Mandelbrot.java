package Madelbrot;

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Mandelbrot {
	public static void main(String[] args) throws IOException {
		double sizes[] = {16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192};
        double cores = Runtime.getRuntime().availableProcessors();
		Image I[] = new Image[sizes.length];
		System.out.print('[');
		for(int n = 0; n < sizes.length; n++) {
			I[n] = new Image((int) sizes[n], (int) sizes[n], -2.1, 0.6, -1.2, 1.2, 200);
			System.out.print('[');
			for(int m = 0; m < 1; m++){
				long start = System.nanoTime();
				MyThread[] Threads = new MyThread[(int) cores];
				for(double x = 0; x < Runtime.getRuntime().availableProcessors(); x++){
                	int xmin = (int) Math.ceil((x*(sizes[n]/cores)));
                	int xmax = (int) Math.ceil((x+1)*(sizes[n]/cores));  
                	//System.out.println(xmin + " " + xmax);
					Threads[(int)x] =  new MyThread(String.valueOf((int)x),I[n], xmin, xmax, 0, (int) sizes[n]);
            	} 	
				for(MyThread t : Threads){
					t.start();
				}
				for(MyThread t : Threads){
					try {
						t.join();
					} catch (InterruptedException e) {}	
				}
			long end = System.nanoTime();
			System.out.print((end - start) / 1000000000.0 + ", ");
			ImageIO.write(I[n], "png", new File("Mandelbrot" + (int)sizes[n] + "px.png"));
			}
			System.out.println(']');
		}
		System.out.println(']');
	}
}
