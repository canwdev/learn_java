import java.util.Scanner;

public class yuanzhu extends circle {
	int h;
	yuanzhu() {
		Scanner in = new Scanner(System.in);
		System.out.print("[ yuanzhu ]\tInput r h: ");
		r = in.nextInt();
		h = in.nextInt();
	}
	
	double area() {
		return Math.PI*r*r*h;
	}
}