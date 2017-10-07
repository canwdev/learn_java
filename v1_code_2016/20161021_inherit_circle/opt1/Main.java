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