import java.util.Scanner;
//	import java.lang.Math;

public class circle {
	public int r;

	circle() {
		Scanner in = new Scanner(System.in);
		System.out.print("[ circle  ]\tInput r: ");
		r = in.nextInt();
	}
	
	double area() {
		return Math.PI*r*r; 
	}
}