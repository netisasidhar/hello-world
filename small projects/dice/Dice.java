import javax.swing.*;
import java.awt.*;
import  java.awt.event.*;
public class Dice extends JFrame implements ActionListener
{
    JButton r = new JButton();
    ImageIcon[] n = new ImageIcon[6];
    public Dice()
    {
        this.setSize(125,140);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        JMenuBar t = new JMenuBar();
        t.add(new JLabel("Dice: click to roll"));
        this.setJMenuBar(t);
        this.setTitle("Dice");
        this.r.setIcon(new ImageIcon("0.png"));
        String[] d = new String[]{"1.png","2.png","3.png","4.png","5.png","6.png"};//{"one.png","two.png","three.png","four.png","five.png","six.png"};
        for(byte x = 0; x<6;x++){
            this.n[x]=new ImageIcon(d[x]);
        }
        this.setLayout(new BorderLayout());
        this.add(r);
        this.r.addActionListener(this);
        this.setVisible(true);
    }
    public void actionPerformed(ActionEvent  e){
        byte c = (byte)((Math.random()*7)-1);
        r.setIcon(n[c]);
    }
    public static void main(String args[]){Dice x = new Dice();}
}
