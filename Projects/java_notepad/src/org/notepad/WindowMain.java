package org.notepad;

import java.awt.Font;
import java.awt.event.InputEvent;
import java.util.Enumeration;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

@SuppressWarnings("serial")
public class WindowMain extends JFrame {
	//	ImageIcon imageIcon = new ImageIcon(getClass().getResource("/img/icon.png"));
	NimbusLookAndFeel nlaf = new NimbusLookAndFeel();

	JMenuBar menuBar;
	JMenu menuFile;
	JMenu menuEdit;
	JMenu menuStyle;
	JMenu menuHelp;
	JTextArea mainTextArea;

	ListenerMenu listenerMenu;

	String fontName = "Sansserif"; // 字体名称

	public WindowMain() {
//		setIconImage(imageIcon.getImage());
		setSize(800, 600);
		setLocationRelativeTo(null);
		setTitle("无标题 - 记事本");
		changeLookFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel"); // 设置窗口样式
		Init();
		setVisible(true);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	}

	/**
	 * 用循环添加项目到菜单
	 *
	 * @param menuItems
	 *            设置一个二维数组用于存储菜单项的名称、快捷键(JAVA键盘的KeyCode)、实际值
	 * @param menu
	 *            要添加进的菜单对象
	 * @param listener
	 *            设置监听器
	 */
	public void addMenuItems(String[][] menuItems, JMenu menu, ListenerMenu listener) {
		for (int i = 0; i < menuItems[0].length; i++) {
			JMenuItem item = new JMenuItem(menuItems[0][i]);
			if (Integer.parseInt(menuItems[1][i]) != 0)
				item.setAccelerator(KeyStroke.getKeyStroke(Integer.parseInt(menuItems[1][i]), InputEvent.CTRL_MASK));
			item.setActionCommand(menuItems[2][i]);
			item.addActionListener(listener);
			menu.add(item);
		}
	}

	/**
	 * 设置每个菜单的值
	 */
	public void MenuFile() {
		String[][] menuItems = { { "新建", "打开...", "保存", "另存为...", "退出" }, { "78", "79", "83", "112", "87" },
				{ "1001", "1002", "1003", "1004", "1005" } };
		addMenuItems(menuItems, menuFile, listenerMenu);
	}

	public void MenuEdit() {
		String[][] menuItems = { { "全选", "复制", "剪切", "粘贴" }, { "65", "67", "88", "86" },
				{ "2001", "2002", "2003", "2004" } };
		addMenuItems(menuItems, menuEdit, listenerMenu);
	}

	public void MenuStyle() {
		String[][] menuItems = { { "切换自动换行", "字体放大", "字体缩小", "背景颜色" }, { "0", "91", "93", "0" },
				{ "3001", "30020", "30021", "3003" } };
		addMenuItems(menuItems, menuStyle, listenerMenu);
	}

	public void MenuAbout() {
		String[][] menuItems = { { "关于" }, { "120" }, { "9001" } };
		addMenuItems(menuItems, menuHelp, listenerMenu);
	}

	public void Init() {
		initGlobalFontSetting(new FontUIResource(fontName, Font.PLAIN, 13)); // Sansserif

		menuBar = new JMenuBar();
		menuFile = new JMenu("文件");
		menuEdit = new JMenu("编辑");
		menuStyle = new JMenu("格式");
		menuHelp = new JMenu("帮助");
		mainTextArea = new JTextArea();
		mainTextArea.setFont(new Font(fontName, Font.PLAIN, 16));
		listenerMenu = new ListenerMenu();

		listenerMenu.setWindowFrame(this);
		listenerMenu.setTextArea(mainTextArea);
		listenerMenu.setWindowClose();
		listenerMenu.setFontName(fontName);
		MenuFile();
		MenuEdit();
		MenuStyle();
		MenuAbout();
		menuBar.add(menuFile);
		menuBar.add(menuEdit);
		menuBar.add(menuStyle);
		menuBar.add(menuHelp);

		setJMenuBar(menuBar);
		add(new JScrollPane(mainTextArea));
	}

	/**
	 * 设置全局显示字体
	 *
	 * @param font
	 */
	public void initGlobalFontSetting(Font font) {
		FontUIResource fontRes = new FontUIResource(font);
		for (Enumeration keys = UIManager.getDefaults().keys(); keys.hasMoreElements();) {
			Object key = keys.nextElement();
			Object value = UIManager.get(key);
			if (value instanceof FontUIResource)
				UIManager.put(key, fontRes);
		}
		UIManager.put("swing.boldMetal", Boolean.FALSE); // 在swing里面关闭默认样式的粗体显示
	}

	/**
	 * 更新风格外观
	 *
	 * @param className
	 */
	void changeLookFeel(String className) {
		try {
			UIManager.setLookAndFeel(className);
		} catch (Exception e) {
			System.out.println(e);
		}
		SwingUtilities.updateComponentTreeUI(this);
	}
}
