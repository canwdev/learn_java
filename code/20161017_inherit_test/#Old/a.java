package ab;

public class a {
	public static void main(String[] args) {
		System.out.print("I'm a_class: ");
		a_class a1 = new a_class();
		System.out.println(a1.n1+", "+a1.n2+", "+a1.n3+", "/*+a1.n4*/);
		System.out.println("a.java:14: error: n4 has private access in a_class");
	}
}

