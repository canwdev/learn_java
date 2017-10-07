import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainClass {
	public static void main(String[] args) {
		Window win = new Window("Action2.0", 100, 100, 300, 200);
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
		JTextField inText = new JTextField(10);
		JButton button = new JButton("OK");
		JTextArea outText = new JTextArea(6,20);
		add(inText);
		add(button);
		add(new JScrollPane(outText));
		
	}
}

//class myListener implements ActionListener {
	
//}