import java.util.Scanner;

public class Scan2Array {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int[][] arr = new int[3][4];
		for (int i=0; i<3; i++)
			for (int j=0; j<4; j++) {
				System.out.print("����"+(i+1)+"��"+(j+1)+"�е�����: ");
				arr[i][j]=in.nextInt();
			}
		System.out.println("��������: ");
		for (int a[]:arr)
			for (int b:a) {
				System.out.print(b+"\t");
			}
	}
}