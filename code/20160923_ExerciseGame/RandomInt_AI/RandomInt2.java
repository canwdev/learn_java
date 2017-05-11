import java.util.Scanner;
import java.util.Random;

class RandomInt2 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Random r = new Random();
		AI a = new AI();
		int num,temp,count=0;
		
		//temp = r.nextInt(100)+1;
		//System.out.println("已随机生成一个1~100的整数。");
		//System.out.println("debug提示("+temp+")");
		
		do {
			++count;
			
			temp = r.nextInt(100)+1;
			System.out.print("已随机生成一个1~100的整数。");
			System.out.println("debug提示("+temp+")");
			
			System.out.print("请猜数：");
			//num = in.nextInt();
			num = a.guess();
			
			if (num > temp)
				System.out.println("\t\t猜大了！");
			else if (num < temp)
				System.out.println("\t\t猜小了！");
			else
				System.out.println("\t\t猜对了！");
		}while(num!=temp);
		
		System.out.println("一共猜了 "+count+" 次！");
	}
}

class AI {
	Random r = new Random();
	int guess() {
		int g = r.nextInt(100)+1;
		System.out.print(g);
		return g;
	}
}

