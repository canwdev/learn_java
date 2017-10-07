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
	boolean log(user u,String log_name,String log_pswd) {
		if (log_name.equals(u.name) && log_pswd.equals(u.pswd)) {
			System.out.println("Login Success\n");
			return true;
		} else {
			System.out.println("Login Failed\n");
			return false;
		}
	}
}

class Alpha extends Exception {
	
}

public class MainClass {
	public static void main(String[] args) {
		user u1 = new user();
		login L = new login();
		
		int count = 3;
		while(count > 0) {
		Scanner in = new Scanner(System.in);
		System.out.print("UserName: ");
		String log_name = in.next();
		System.out.print("Password: ");
		String log_pswd = in.next();
		if (!L.log(u1, log_name, log_pswd))
		count--;
		else break;
		} 
		
	}
}