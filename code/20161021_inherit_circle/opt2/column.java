public class column extends circle {
	double h;
	
	/*
	column() {
		System.out.println("[ column ]");
	}
	*/
	
	column(double h, double r) {
		super(0);
		System.out.println("[ column ]");
		this.h=h;
		this.r=r;
	}
	
	double comp() {
		return Math.PI*r*r*h;
	}
}