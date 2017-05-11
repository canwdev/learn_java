import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainClass {
	public static void main(String[] args) {
		Window win = new Window("Action1", 100, 100, 300, 200);
	}
}

class Window extends JFrame {
	public Window(String s, int x, int y, int w, int h) {
		setTitle(s);
		setBounds(x, y, w, h);
		setLayout(new FlowLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		myObjects();
		
		setVisible(true);
	}
	
	void myObjects() {
		JTextField text = new JTextField(10);
		add(text);
		myListener hear = new myListener();
		text.addActionListener(hear);
	}
}

class myListener implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		String str = e.getActionCommand();
		System.out.println("["+ str.length() +"] "+ str);
	}
}