public class circle {
	double r;
	/*
	circle() {
		System.out.println("[ circle ]");
	}
	*/
	
	circle(double r) {
		System.out.println("[ circle ]");
		this.r = r;
	}
	
	double comp() {
		return Math.PI*r*r;
	}
}