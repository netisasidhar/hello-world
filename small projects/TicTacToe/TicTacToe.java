import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * plays tictactoe
 *
 * @author (Sasidhar)
 * @version (3)
 */
class TTT extends JFrame implements ActionListener
{  JButton[] b = new  JButton[10];
   JFrame f = new JFrame();
   String inp=JOptionPane.showInputDialog(f,"x or o?"),xo=(inp.equals("x")||inp.equals("o"))?inp:"x";
    ImageIcon nil = new ImageIcon("buttoncover.PNG"), U = new ImageIcon((xo.charAt(0)=='x')?"X.PNG":"O.PNG"), M = new ImageIcon((xo.charAt(0)=='x')?"O.PNG":"X.PNG");
    short[] winpos = {(short)0b000000111,(short)0b001001001,(short)0b100010001,(short)0b010010010,(short)0b001010100,(short)0b100100100,(short)0b000111000,(short)0b111000000};
    short mypos = 0,uspos = 0,bp=0;//board positions occupied
    byte nm = 0;
    public void play()
    {    
        this.setTitle("TicTacToe");
        this.setSize(200,210);
        this.setResizable(false);
        this.setLayout(new GridLayout(3,3));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        JMenuBar m = new JMenuBar();
        m.add(new JLabel("click the position of your next move"));
        this.setJMenuBar(m);
        for(int x = 0; x<9;x++)
        {   
            b[x] = new JButton();
            b[x].setText(" ");
            b[x].addActionListener(this);
            b[x].setIcon(nil);
            this.add(b[x]);
        }
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {
        for(int m =0; m<9;m++){
            if((e.getSource()==b[m])&&((bp&(1<<m))==0)){//(1<<m)&bp gives 0 if the position is empty
                b[m].setIcon(U);
                nm++;
                uspos|=1<<m;
                bp|=uspos;
                perfmov();
            }
        }
    }

    private void perfmov()
    {
        boolean nw = true;
        if(w(uspos)){JOptionPane.showMessageDialog(f,"You won!");this.dispose();System.exit(0);}
        if(nm==9){JOptionPane.showMessageDialog(f,"Tie/Draw");this.dispose();System.exit(0);}
        while(nw){
            byte x =(byte)(Math.random()*8);//possible position to place
            if(((1<<x)&bp)==0){//the position is empty
                b[x].setIcon(M);
                nm++;
                mypos|=(1<<x);//store my move
                bp|=mypos;
                nw=false;
            }
        }
        if(w(mypos)){JOptionPane.showMessageDialog(f,"You lose");this.dispose();System.exit(0);}
    }

    private boolean w(short bordpos)
    {
        for(int x = 0; x<8;x++){
            if((bordpos&winpos[x])==winpos[x])
            {
                return true;
            }
        }
        return false;
    }
}  
public class TicTacToe
{
    public static void main(String args[])
    {
        TTT x = new TTT();
        x.play();
    }
}