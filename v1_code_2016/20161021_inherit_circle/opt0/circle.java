//	import java.lang.Math;

public class circle {
	int r;
	circle() {
		System.out.println("[ circle  ]");
	}
	
	circle(int r) {
		System.out.println("[ circle  ]");
		this.r = r;
	}
	
	double area() {
		return Math.PI*r*r; 
	}
}