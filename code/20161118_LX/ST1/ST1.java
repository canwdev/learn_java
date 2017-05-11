import java.util.*;

public class ST1 {
	public static void main(String[] args) {
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		c1.set(2012, 8, 1);
		c2.set(2016, 6, 1);
		System.out.println("First date:");
		System.out.println(c1.get(Calendar.YEAR)+"/"+(c1.get(Calendar.MONTH)+1)+"/"+c1.get(Calendar.DAY_OF_MONTH));
		
		System.out.println("Second date:");
		System.out.println(c2.get(Calendar.YEAR)+"/"+(c2.get(Calendar.MONTH)+1)+"/"+c2.get(Calendar.DAY_OF_MONTH));
		
		long k1 = c1.getTimeInMillis();
		long k2 = c2.getTimeInMillis();
		System.out.println("\n"+Math.abs((k1-k2)/1000/60/60/24)+" Days");
	}
}

//20120901 20160701