package ab;

public class b {
	public static void main(String[] args) {
		System.out.print("I'm b_class, extends a_class: ");
		b_class b1 = new b_class();
		System.out.println(b1.n1+", "+b1.n2+", "+b1.n3+", "/*+b1.n4*/);
		System.out.println("b.java:11: error: n4 has private access in a_class");
	}
}
