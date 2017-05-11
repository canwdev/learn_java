class circle {
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

class column extends circle {
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

class taper extends column {
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

public class Main {
	public static void main(String[] args) {
		circle c1 = new circle(5);
		System.out.println("circle's area: "+c1.comp());
		
		column c2 = new column(5,5);
		System.out.println("column's volume: "+c2.comp());
		
		taper c3 = new taper(5,5);
		System.out.println("taper's volume: "+c3.comp());
	}
}