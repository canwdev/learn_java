import java.util.*;
public class MainClass {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		double sum = 0;
		int m = 0;
		System.out.println("����ɼ��س�������������ַ���ֹ��");
		while(in.hasNextDouble()) {
			double x = in.nextDouble();
			assert x>0&&x<100:"�Ƿ��ɼ�����";
			m += 1;
			sum += x;
		}
		System.out.printf("%d �����ĺ�Ϊ %f\n",m,sum);
		System.out.printf("%d ������ƽ��ֵ�� %f\n",m,sum/m);
	}
}