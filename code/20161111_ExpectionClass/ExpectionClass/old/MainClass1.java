import java.util.*;
	
class user {
	String name;
	String pswd;
	user() {
		name = "abcdef";
		pswd = "123456";
	}
}

class login {
	Scanner in = new Scanner(System.in);
	void log(user u) {
		int count = 3;
		while(count > 0) {
		System.out.print("UserName: ");
		String log_name = in.next();
		System.out.print("Password: ");
		String log_pswd = in.next();
		if (log_name.equals(u.name) && log_pswd.equals(u.pswd)) {
			System.out.println("Login Success");
			break;
		} else {
			System.out.println("Login Failed "+ --count +" times remaining\n");
		}
		}
	}
}

class Alpha extends Exception {

}

public class MainClass {
	public static void main(String[] args) {
		user u1 = new user();
		login L = new login();
		L.log(u1);
	}
}