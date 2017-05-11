import java.util.Scanner;
import java.util.Random;

class RandomInt {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Random r = new Random();
		int num,temp;
		
		temp = r.nextInt(100)+1;
		System.out.println("已随机生成一个1~100的整数。");
		//System.out.println("debug提示("+temp+")");
		
		do {
			System.out.print("请猜数：");
			num = in.nextInt();
			if (num > temp)
				System.out.println("猜大了！");
			else if (num < temp)
				System.out.println("猜小了！");
			else
				System.out.println("猜对了！");
		}while(num!=temp);
	}
}
