import java.util.*;

public class ST2 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Input a string: ");
		String str = in.next();
		str = str.replaceAll("[\\p{Digit}]+","");
		System.out.print("Output string without number: "+str);
	}
}