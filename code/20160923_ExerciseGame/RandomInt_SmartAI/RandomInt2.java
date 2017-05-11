import java.util.Scanner;
import java.util.Random;

class RandomInt2 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Random r = new Random();
		SmartAI a = new SmartAI();
		int num,temp,count=0;
		
		temp = r.nextInt(100)+1;
		System.out.println("已随机生成一个1~100的整数。");
		System.out.println("debug提示("+temp+")");
		
		do {
			++count;
			
			System.out.print("请猜数：");
			//num = in.nextInt();
			num = a.guess();
			
			if (num > temp) {
				System.out.println("\t\t猜大了！");
				a.flag = 2;
			}
			else if (num < temp) {
				System.out.println("\t\t猜小了！");
				a.flag = 1;
			}
			else {
				System.out.println("\t\t猜对了！");
			}
			
			if (count == 100) {
				System.out.println("猜不出!"+temp);
				break;
			}
				
		}while(num!=temp);
		
		System.out.println("一共猜了 "+count+" 次！");
	}
}

class SmartAI {
	int g=1,temp=100;
	int flag=-1;	//判断：大了(2)还是小了(1)
	int guess() {
		if (flag == 1) {
			temp /= 2;
			if (temp == 0) temp =1;	//防止归零
			g += temp;
		}
		else if (flag == 2) {
			
			g -= temp;
		}
		else {
			flag =1;
		}
		System.out.print(g);
		return g;
	}
}

