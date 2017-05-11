import java.util.*;
public class MainClass {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		double sum = 0;
		int m = 0;
		System.out.println("输入成绩回车，输入非数字字符终止。");
		while(in.hasNextDouble()) {
			double x = in.nextDouble();
			assert x>0&&x<100:"非法成绩数据";
			m += 1;
			sum += x;
		}
		System.out.printf("%d 个数的和为 %f\n",m,sum);
		System.out.printf("%d 个数的平均值是 %f\n",m,sum/m);
	}
}