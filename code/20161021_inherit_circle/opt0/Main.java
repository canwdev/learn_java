

public class Main {
	public static void main(String[] args) {
		double area = 0.00;
		/*
		circle c = new circle(5);
		area = c.area();
		System.out.println("area: " + area);
		*/
		yuanzhu yzhu = new yuanzhu(5,5);
		area = yzhu.area();
		System.out.println("area: " + area);
		
		yuanzhui yzhui = new yuanzhui(5,5);
		area = yzhui.area();
		System.out.println("area: " + area);

	}
}