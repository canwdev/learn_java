import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class WindowMenu extends JFrame {
	FlowLayout flow = new FlowLayout();
	
	public WindowMenu() {}
	public WindowMenu(String s, int x,int y,int w,int h) {
		init(s);
		setLocation(x, y);
		setSize(w, h);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container con = getContentPane();
		con.setBackground(Color.gray);
		setLayout(flow);
		add(new JButton("OK"));
		add(new JButton("OK"));
		add(new JButton("OK"));
	}
	void init(String s) {
		setTitle(s);
		JMenuBar menubar = new JMenuBar();;
		JMenu menu1 = new JMenu("��ʽ");
		JMenu menu2 = new JMenu("����");
		
		JMenuItem item2_1 = new JMenuItem("�μ��");
		JMenuItem item2_2 = new JMenu("����");
		
		menubar.add(menu1);
		menu1.add(new JMenuItem("������ɫ"));
		menu1.add(new JMenuItem("�����С"));
		menu1.add(new JMenuItem("������ʽ"));
		
		menubar.add(menu2);
		menu2.add(item2_1);
		menu2.add(item2_2);
		item2_2.add(new JMenuItem("������"));
		item2_2.add(new JMenuItem("������"));
		item2_2.add(new JMenuItem("��������"));
		item2_2.add(new JMenuItem("��������"));
		
		setJMenuBar(menubar);
	}
}

public class MainClass {
	public static void main(String[] args) {
		WindowMenu win = new WindowMenu("Window", 20, 20, 300, 300);
	}
}