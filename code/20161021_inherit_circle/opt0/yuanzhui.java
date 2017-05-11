public class yuanzhui extends yuanzhu {
	yuanzhui(){
		System.out.println("[ yuanzhui]");
	}
	
	yuanzhui(int r,int h) {
		System.out.println("[ yuanzhui]");
		this.r = r;
		this.h = h;
	}
	
	double area() {
		return Math.PI*r*r*h/3;
	}
}