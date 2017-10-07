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
		JMenu menu1 = new JMenu("格式");
		JMenu menu2 = new JMenu("段落");
		
		JMenuItem item2_1 = new JMenuItem("段间距");
		JMenuItem item2_2 = new JMenu("缩进");
		
		menubar.add(menu1);
		menu1.add(new JMenuItem("字体颜色"));
		menu1.add(new JMenuItem("字体大小"));
		menu1.add(new JMenuItem("字体样式"));
		
		menubar.add(menu2);
		menu2.add(item2_1);
		menu2.add(item2_2);
		item2_2.add(new JMenuItem("左缩进"));
		item2_2.add(new JMenuItem("右缩进"));
		item2_2.add(new JMenuItem("首行缩进"));
		item2_2.add(new JMenuItem("悬挂缩进"));
		
		setJMenuBar(menubar);
	}
}

public class MainClass {
	public static void main(String[] args) {
		WindowMenu win = new WindowMenu("Window", 20, 20, 300, 300);
	}
}