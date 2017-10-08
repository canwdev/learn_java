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

	String filePath = null; // �ļ���·����
	String fontName = null; // ��������
	boolean fileOpened = false; // �Ƿ���ļ��ı�־
	JFileChooser chooser = new JFileChooser(); // �ļ�ѡ����

	public void setWindowFrame(JFrame wFrame) {
		windowFrame = wFrame;
	}

	public void setTextArea(JTextArea jArea) {
		mainTextArea = jArea;
	}

	public void setFontName(String string) {
		fontName = string;
	}

	// ���ô��ڹر���Ϊ
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
				JOptionPane.showMessageDialog(windowFrame, "�汾��201612", "���ڡ����±���",
						JOptionPane.INFORMATION_MESSAGE);
				break;
			default:
				JOptionPane.showMessageDialog(windowFrame, "���ܿ�����...", "���ܱ��" + String.valueOf(menuNumber),
						JOptionPane.ERROR_MESSAGE);
				break;
		}

	}

	/**
	 * �½��ļ�
	 */
	public void newFile() {
		if (fileOpened || !"".equals(mainTextArea.getText())) {
			int n = JOptionPane.showConfirmDialog(windowFrame, "�Ƿ񱣴������ļ���\n" + filePath, "������δ������ļ�",
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
			windowFrame.setTitle("�ޱ��� - ���±�");
		}
	}

	/**
	 * ���ļ�
	 */
	public void openFile() {
		if (fileOpened || !"".equals(mainTextArea.getText())) {
			int n = JOptionPane.showConfirmDialog(windowFrame, "�Ƿ񱣴������ļ���\n" + filePath, "������δ������ļ�",
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
			windowFrame.setTitle("�ޱ��� - ���±�");
			int chooseResult = chooser.showOpenDialog(windowFrame);
			if (chooseResult == JFileChooser.APPROVE_OPTION) {
				filePath = chooser.getSelectedFile().getPath();
				windowFrame.setTitle(filePath + " - ���±�");
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

				// JOptionPane.showMessageDialog(windowFrame, "��û��ѡ���ļ�");
			}
		}

	}

	/**
	 * ���棨����Ѵ��ļ����������Ϊ��
	 */
	public void saveFileIfExist() {
		if (chooser.getSelectedFile() != null) {
			saveFile();
		} else {
			saveAsFile();
		}
	}

	/**
	 * ֱ�ӱ����ļ�
	 */
	public void saveFile() {
		File file = chooser.getSelectedFile();
		try {
			FileWriter fWriter = new FileWriter(file);
			fWriter.write(mainTextArea.getText());
			fWriter.close();
			fileOpened = true;
			filePath = chooser.getSelectedFile().getPath();
			windowFrame.setTitle(filePath + " - ���±�");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(windowFrame, e);
		}
	}

	/**
	 * ���Ϊ�ļ�
	 */
	public void saveAsFile() {
		int result = chooser.showSaveDialog(windowFrame);
		if (result == JFileChooser.APPROVE_OPTION) {
			saveFile();
		}
	}

	/**
	 * ȷ���˳�
	 */
	public void confirmExit() {
		if (fileOpened || !"".equals(mainTextArea.getText())) {
			int n = JOptionPane.showConfirmDialog(windowFrame, "�Ƿ񱣴������ļ���\n" + filePath, "�˳�:������δ������ļ�",
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
	 * ʵ����ɫ��ɫ
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
			mainTextArea.setLineWrap(true); // �����Զ����й���
			mainTextArea.setWrapStyleWord(true); // ������в����ֹ���
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