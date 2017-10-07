package my.test;
import java.util.Scanner;

public class fangcheng {
	double root1,root2;
	int a,b,c;
	boolean boo;
	Scanner in = new Scanner(System.in);
	public fangcheng() {
		System.out.print("Input value of a b c:");
		a=in.nextInt();
		b=in.nextInt();
		c=in.nextInt();
		if(a!=0)			//判断是否为一元二次方程
			boo=true;
		else
			boo=false;
	}
	
	public void show() {
		System.out.println("a="+a+" b="+b+" c="+c);
	}
	public void compute() {
		if(boo) {
			System.out.println("是一元二次方程。");
			double disk = b*b-4*a*c;
			if(disk>=0) {
				root1=(-b+Math.sqrt(disk))/(2*a);
				root2=(-b-Math.sqrt(disk))/(2*a);
				System.out.println("方程的根："+root1+", "+root2);
			}
			else
				System.out.println("方程没有实根。");
		}
		else
			System.out.println("不是一元二次方程。");
	}
}








