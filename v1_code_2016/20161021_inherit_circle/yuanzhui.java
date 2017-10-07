import java.util.Scanner;

public class yuanzhui extends yuanzhu {
	yuanzhui() {
		Scanner in = new Scanner(System.in);
		System.out.print("[ yuanzhui]\tInput r h: ");
		r = in.nextInt();
		h = in.nextInt();
	}
	
	double area() {
		return Math.PI*r*r*h/3;
	}
}