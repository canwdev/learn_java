public class yuanzhu extends circle {
	int h;
	
	yuanzhu(){
		System.out.println("[ yuanzhu ]");
	}
	
	yuanzhu(int r, int h) {
		System.out.println("[ yuanzhu ]");
		this.r = r;
		this.h = h;
	}
	
	double area() {
		return Math.PI*r*r*h;
	}
}