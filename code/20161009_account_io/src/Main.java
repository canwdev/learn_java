import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		account zs = new account();
		zs.show();
		System.out.println("How many to save: ");
		double x;
		x = in.nextDouble();
		zs.in(x);
		zs.show();
		System.out.println("How many to export: ");
		x = in.nextDouble();
		zs.out(x);
		zs.show();
		System.out.println("Query OK");
	}
}

class account {
	double salary=10000;
	void in(double x) {
		if (x>=0)
		salary = salary+x;
		else
			System.out.println("Input error, negative not allowed.");
	}
	void out(double x) {
		if (x>salary)
			System.out.println("Insufficient funds, error.");
		else if (x>=0)
			salary = salary-x;
		else
			System.out.println("Input error, negative not allowed.");
	}
	void show() {
		System.out.println("Money stored in bank: "+salary);
	}
}
