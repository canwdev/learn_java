import java.util.Scanner;
import java.util.Random;

class RandomInt {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Random r = new Random();
		int num,temp;
		
		temp = r.nextInt(100)+1;
		System.out.println("���������һ��1~100��������");
		//System.out.println("debug��ʾ("+temp+")");
		
		do {
			System.out.print("�������");
			num = in.nextInt();
			if (num > temp)
				System.out.println("�´��ˣ�");
			else if (num < temp)
				System.out.println("��С�ˣ�");
			else
				System.out.println("�¶��ˣ�");
		}while(num!=temp);
	}
}
