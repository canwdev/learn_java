import java.util.Scanner;
import java.util.Random;

class RandomInt2 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Random r = new Random();
		SmartAI a = new SmartAI();
		int num,temp,count=0;
		
		temp = r.nextInt(100)+1;
		System.out.println("���������һ��1~100��������");
		System.out.println("debug��ʾ("+temp+")");
		
		do {
			++count;
			
			System.out.print("�������");
			//num = in.nextInt();
			num = a.guess();
			
			if (num > temp) {
				System.out.println("\t\t�´��ˣ�");
				a.flag = 2;
			}
			else if (num < temp) {
				System.out.println("\t\t��С�ˣ�");
				a.flag = 1;
			}
			else {
				System.out.println("\t\t�¶��ˣ�");
			}
			
			if (count == 100) {
				System.out.println("�²���!"+temp);
				break;
			}
				
		}while(num!=temp);
		
		System.out.println("һ������ "+count+" �Σ�");
	}
}

class SmartAI {
	int g=1,temp=100;
	int flag=-1;	//�жϣ�����(2)����С��(1)
	int guess() {
		if (flag == 1) {
			temp /= 2;
			if (temp == 0) temp =1;	//��ֹ����
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

