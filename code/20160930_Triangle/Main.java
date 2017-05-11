public class Main {
	public static void main(String[] args) {
		Point p1 = new Point(1,2);
		Point p2 = new Point(4,2);
		Point p3 = new Point(3,3);
		//p1.Show();p2.Show();p3.Show();
		
		Triangle t = new Triangle(p1,p2,p3);
		t.V();
	}
}