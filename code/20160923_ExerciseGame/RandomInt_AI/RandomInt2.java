import java.util.Scanner;
import java.util.Random;

class RandomInt2 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Random r = new Random();
		AI a = new AI();
		int num,temp,count=0;
		
		//temp = r.nextInt(100)+1;
		//System.out.println("���������һ��1~100��������");
		//System.out.println("debug��ʾ("+temp+")");
		
		do {
			++count;
			
			temp = r.nextInt(100)+1;
			System.out.print("���������һ��1~100��������");
			System.out.println("debug��ʾ("+temp+")");
			
			System.out.print("�������");
			//num = in.nextInt();
			num = a.guess();
			
			if (num > temp)
				System.out.println("\t\t�´��ˣ�");
			else if (num < temp)
				System.out.println("\t\t��С�ˣ�");
			else
				System.out.println("\t\t�¶��ˣ�");
		}while(num!=temp);
		
		System.out.println("һ������ "+count+" �Σ�");
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

