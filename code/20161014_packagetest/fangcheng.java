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
		if(a!=0)			//�ж��Ƿ�ΪһԪ���η���
			boo=true;
		else
			boo=false;
	}
	
	public void show() {
		System.out.println("a="+a+" b="+b+" c="+c);
	}
	public void compute() {
		if(boo) {
			System.out.println("��һԪ���η��̡�");
			double disk = b*b-4*a*c;
			if(disk>=0) {
				root1=(-b+Math.sqrt(disk))/(2*a);
				root2=(-b-Math.sqrt(disk))/(2*a);
				System.out.println("���̵ĸ���"+root1+", "+root2);
			}
			else
				System.out.println("����û��ʵ����");
		}
		else
			System.out.println("����һԪ���η��̡�");
	}
}








