public class taper extends column {
	/*
	taper() {
		System.out.println("[ taper  ]");
	}
	*/
	
	taper(double h, double r) {
		super(0,0);
		System.out.println("[ taper  ]");
		this.h=h;
		this.r=r;
	}
	
	double comp() {
		return Math.PI*r*r*h/3;
	}
}