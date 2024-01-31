package Madelbrot;

public class MyThread extends Thread{
    int xmin, xmax, ymin, ymax;
    Image I;
    String name;
    public MyThread(String Name , Image image, int Xmin, int Xmax, int Ymin, int Ymax) {
		I = image;
        xmin = Xmin;
        xmax = Xmax;
        ymin = Ymin;
        ymax = Ymax;
        name = Name;
	}

    public void run() {
        //long start = System.nanoTime();
        for(int x = xmin; x < xmax; x++) { 
            for(int y = ymin; y < ymax; y++) {
                I.colorPixel(x,y);
            }
        }
        //long end = System.nanoTime();
        //System.out.print("Thread " + name + ", time: " + (end - start) / 1000000000.0 + ", ");
    }
}
