public class column extends circle {
	double h;
	
	column() {
		System.out.println("[ column ]");
	}
	
	column(double h, double r) {
		System.out.println("[ column ]");
		this.h=h;
		this.r=r;
	}
	
	double comp() {
		return Math.PI*r*r*h;
	}
}