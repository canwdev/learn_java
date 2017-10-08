package org.notepad;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class ListenerMenu implements ActionListener {
	JFrame windowFrame;
	JTextArea mainTextArea = new JTextArea();

	String filePath = null; // 文件的路径名
	String fontName = null; // 字体名称
	boolean fileOpened = false; // 是否打开文件的标志
	JFileChooser chooser = new JFileChooser(); // 文件选择器

	public void setWindowFrame(JFrame wFrame) {
		windowFrame = wFrame;
	}

	public void setTextArea(JTextArea jArea) {
		mainTextArea = jArea;
	}

	public void setFontName(String string) {
		fontName = string;
	}

	// 设置窗口关闭行为
	public void setWindowClose() {
		windowFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				confirmExit();
			}
		});
	}

	public void actionPerformed(ActionEvent event) {
		int menuNumber = Integer.parseInt(event.getActionCommand());

		switch (menuNumber) {
			case 1001:
				newFile();
				break;
			case 1002:
				openFile();
				break;
			case 1003:
				saveFileIfExist();
				break;
			case 1004:
				saveAsFile();
				break;
			case 1005:
				confirmExit();
				break;
			case 2001:
				mainTextArea.selectAll();
				break;
			case 2002:
				mainTextArea.copy();
				break;
			case 2003:
				mainTextArea.cut();
				break;
			case 2004:
				mainTextArea.paste();
				break;
			case 3001:
				changeWordWrap();
				break;
			case 30020:
				changeFontSize(true);
				break;
			case 30021:
				changeFontSize(false);
				break;
			case 3003:
				changeBgColor();
				break;
			case 9001:
				JOptionPane.showMessageDialog(windowFrame, "版本：201612", "关于“记事本”",
						JOptionPane.INFORMATION_MESSAGE);
				break;
			default:
				JOptionPane.showMessageDialog(windowFrame, "功能开发中...", "功能编号" + String.valueOf(menuNumber),
						JOptionPane.ERROR_MESSAGE);
				break;
		}

	}

	/**
	 * 新建文件
	 */
	public void newFile() {
		if (fileOpened || !"".equals(mainTextArea.getText())) {
			int n = JOptionPane.showConfirmDialog(windowFrame, "是否保存以下文件？\n" + filePath, "可能有未保存的文件",
					JOptionPane.YES_NO_CANCEL_OPTION);
			switch (n) {
				case JOptionPane.YES_OPTION:
					saveFile();
					chooser = new JFileChooser();
					fileOpened = false;
					break;
				case JOptionPane.NO_OPTION:
					chooser = new JFileChooser();
					fileOpened = false;
					break;
				case JOptionPane.CANCEL_OPTION:
					break;
				default:
					break;
			}
		}
		if (!fileOpened) {
			mainTextArea.setText(null);
			windowFrame.setTitle("无标题 - 记事本");
		}
	}

	/**
	 * 打开文件
	 */
	public void openFile() {
		if (fileOpened || !"".equals(mainTextArea.getText())) {
			int n = JOptionPane.showConfirmDialog(windowFrame, "是否保存以下文件？\n" + filePath, "可能有未保存的文件",
					JOptionPane.YES_NO_CANCEL_OPTION);
			switch (n) {
				case JOptionPane.YES_OPTION:
					saveFileIfExist();
					chooser = new JFileChooser();
					fileOpened = false;
					break;
				case JOptionPane.NO_OPTION:
					chooser = new JFileChooser();
					fileOpened = false;
					break;
				case JOptionPane.CANCEL_OPTION:
					break;
				default:
					break;
			}
		}
		if (!fileOpened) {
			mainTextArea.setText(null);
			windowFrame.setTitle("无标题 - 记事本");
			int chooseResult = chooser.showOpenDialog(windowFrame);
			if (chooseResult == JFileChooser.APPROVE_OPTION) {
				filePath = chooser.getSelectedFile().getPath();
				windowFrame.setTitle(filePath + " - 记事本");
				File file = chooser.getSelectedFile();
				try {
					InputStream inputStream = new FileInputStream(file);
					Reader reader = new InputStreamReader(inputStream, "gbk");
					BufferedReader bufferedReader = new BufferedReader(reader);
					String line = null;
					while ((line = bufferedReader.readLine()) != null) {
						mainTextArea.append(line + "\n");
					}
				} catch (Exception e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(windowFrame, e);
				}
				fileOpened = true;

			} else {
				chooser = new JFileChooser();

				// JOptionPane.showMessageDialog(windowFrame, "并没有选择文件");
			}
		}

	}

	/**
	 * 保存（如果已打开文件，否则另存为）
	 */
	public void saveFileIfExist() {
		if (chooser.getSelectedFile() != null) {
			saveFile();
		} else {
			saveAsFile();
		}
	}

	/**
	 * 直接保存文件
	 */
	public void saveFile() {
		File file = chooser.getSelectedFile();
		try {
			FileWriter fWriter = new FileWriter(file);
			fWriter.write(mainTextArea.getText());
			fWriter.close();
			fileOpened = true;
			filePath = chooser.getSelectedFile().getPath();
			windowFrame.setTitle(filePath + " - 记事本");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(windowFrame, e);
		}
	}

	/**
	 * 另存为文件
	 */
	public void saveAsFile() {
		int result = chooser.showSaveDialog(windowFrame);
		if (result == JFileChooser.APPROVE_OPTION) {
			saveFile();
		}
	}

	/**
	 * 确认退出
	 */
	public void confirmExit() {
		if (fileOpened || !"".equals(mainTextArea.getText())) {
			int n = JOptionPane.showConfirmDialog(windowFrame, "是否保存以下文件？\n" + filePath, "退出:可能有未保存的文件",
					JOptionPane.YES_NO_CANCEL_OPTION);
			switch (n) {
				case JOptionPane.YES_OPTION:
					saveFileIfExist();
					System.exit(0);
					break;
				case JOptionPane.NO_OPTION:
					System.exit(0);
					break;
				case JOptionPane.CANCEL_OPTION:
					break;
				default:
					break;
			}
		} else {
			System.exit(0);
		}

	}

	public void changeBgColor() {
		Color color = JColorChooser.showDialog(windowFrame, "Palette", windowFrame.getContentPane().getBackground());
		if (color != null) {
			mainTextArea.setForeground(Color2Contrary2(color));
			mainTextArea.setBackground(color);
		}
	}

	/**
	 * 实现颜色反色
	 *
	 * @param c
	 * @return
	 */
	public static int CC(int c) {
		int cc = 255 - c;
		if (cc > 64 && cc < 128)
			cc -= 64;
		else if (cc >= 128 && cc < 192)
			cc += 64;
		return cc;
	}

	public static Color Color2Contrary2(Color color) {
		return new Color(CC(color.getRed()), CC(color.getGreen()), CC(color.getBlue()));
	}

	boolean wordWrapFlag = false;

	public void changeWordWrap() {
		if (wordWrapFlag == false) {
			wordWrapFlag = true;
			mainTextArea.setLineWrap(true); // 激活自动换行功能
			mainTextArea.setWrapStyleWord(true); // 激活断行不断字功能
		} else {
			wordWrapFlag = false;
			mainTextArea.setLineWrap(false);
			mainTextArea.setWrapStyleWord(false);
		}
	}

	int mainFontSize = 16;

	public void changeFontSize(Boolean status) {
		if (status) {
			mainFontSize += 5;
			mainTextArea.setFont(new Font(fontName, Font.PLAIN, mainFontSize));
		} else {
			mainFontSize -= 5;
			mainTextArea.setFont(new Font(fontName, Font.PLAIN, mainFontSize));
		}
	}
}