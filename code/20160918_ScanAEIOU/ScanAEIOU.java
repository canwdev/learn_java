import java.util.Scanner;
public class ScanAEIOU {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		String str;
		char ch=' ';
		int count=0;
		do{
			System.out.print("����һ����ĸ, ����\'w\'�˳�: ");
			str = in.nextLine();
			ch = str.charAt(0);
			if ( ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u')
			++count;
		}while(ch != 'w');
		System.out.println("����ԭ����ĸ�Ĵ���: "+count);
	}
}