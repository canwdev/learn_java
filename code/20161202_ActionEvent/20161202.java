import java.awt.*;//getItem(int n)
import javax.swing.*;
import java.awt.event.*;
class win extends JFrame
{ 
  JMenuBar m1=new JMenuBar();
  JMenu m2=new JMenu("º∆À„");
  JMenuItem m3=new JMenuItem("/");
 JMenuItem m4=new JMenuItem("*");
JLabel b1=new JLabel("+");
//shixian1 w1=new shixian1();
//shixian2 w2=new shixian2();
 win()
{ setLayout(new FlowLayout());
setVisible(true);
  setDefaultCloseOperation(EXIT_ON_CLOSE);
   m2.add(m3);m2.add(m4);
  m1.add(m2);
add(b1);
  setJMenuBar(m1);
//w1.set(m2);
//w2.set(m2);
//w1.set1(b1);
//w2.set1(b1);
  //m3.addActionListener(w1);
 //m4.addActionListener(w2);
}
}

class a
{public static void main(String args[])
{ win k1=new win();}

}
class shixian1 implements ActionListener
{ JMenu y1;JLabel y2;
  void set(JMenu k){ y1=k;}
  void set1(JLabel k){y2=k;}
  public void actionPerformed(ActionEvent e)
 {  y2.setText("/");}
}


class shixian2 implements ActionListener
{JMenu y1;JLabel y2;
  void set(JMenu k){ y1=k;}
void set1(JLabel k){y2=k;}
public void actionPerformed(ActionEvent e)
 {  y2.setText("*");}
}