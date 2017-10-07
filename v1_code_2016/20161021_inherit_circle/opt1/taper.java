public class taper extends column {
	taper() {
		System.out.println("[ taper  ]");
	}
	
	taper(double h, double r) {
		System.out.println("[ taper  ]");
		this.h=h;
		this.r=r;
	}
	
	double comp() {
		return Math.PI*r*r*h/3;
	}
}