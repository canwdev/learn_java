

public class Main {
	public static void main(String[] args) {
		double area = 0.00;
		
		//circle c = new circle();
		//area = c.area();
		
		yuanzhu yzhu = new yuanzhu();
		area = yzhu.area();
		
		System.out.println("area: " + area);
		
		yuanzhui yzhui = new yuanzhui();
		area = yzhui.area();
		
		System.out.println("area: " + area);
	}
}