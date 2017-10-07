import java.util.Scanner;

interface account {
	double salary = 10000;
	void caozuo();
}
class user implements account{
	double s_salary;
	user() {
		s_salary = salary;
	}
	void behaviour(account k) {
		k.caozuo();
	}
	public void caozuo() {
		
	}
}
public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		user u = new user();
		
		int s = -1;
		while (s!=0) {
			System.out.print("\n1.存款 2.取款 3.查询余额，请输入：");
		s = in.nextInt();
		switch (s) {
			case 1: {
					u.behaviour( new account() {
					public void caozuo() {
					System.out.print("【存款】请输入存款金额：");
					double s = in.nextDouble();
					u.s_salary += s;
					}
				}
				);
			} break;
			case 2: {
				u.behaviour ( new account() {
					public void caozuo() {
						System.out.print("【取款】请输入取款金额：");
						double s = in.nextDouble();
						u.s_salary -= s;
					}
				}
				);
			} break;
			case 3: {
						System.out.println("【余额】：" + u.s_salary);
			} break;
			default :{
				System.out.println("No selection");
			}
		}
		}
	}
}