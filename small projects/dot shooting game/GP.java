import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
/**
 * Write a description of class GP here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GP extends JPanel implements KeyListener
{
    java.util.List<P> b = new LinkedList();
    java.util.List<P> z = new LinkedList();
    static JFrame x = new JFrame();
    Hero m = new Hero();
    P gun = new P();
    public void paint(Graphics g){
        m.x = 0;
        m.y =0;
    }

    public static void main(String args[])
    {
        GP game = new GP();
        Worker w = new Worker(game);
        Spawner sp = new Spawner(game);
        w.start();
        sp.start();
        x.add(game);
        x.addKeyListener(game);
        x.setVisible(true);
    }

    public void keyReleased(KeyEvent e)
    {

    }

    public void keyPressed(KeyEvent e)
    {
        switch(e.getKeyCode()){
            case KeyEvent.VK_UP:
            m.gyo = ((m.gyo == 1)||(m.gyo == 0))?m.gyo-1:m.gyo;//gxo and gyo determine the gun offset to (x+15 and y+15 respectively)
            m.y-=10;
            break;
            case KeyEvent.VK_DOWN:
            m.gyo = ((m.gyo == -1)||(m.gyo == 0))?m.gyo+1:m.gyo;
            m.y+=10;
            break;
            case KeyEvent.VK_LEFT:
            m.gxo = ((m.gxo == 1)||(m.gxo == 0))?m.gxo-1:m.gxo;
            m.x-=10;
            break;
            case KeyEvent.VK_RIGHT:
            m.gxo = ((m.gxo == -1)||(m.gxo == 0))?m.gxo+1:m.gxo;
            m.x+=10;
            break;
            default:
            //try{Thread.sleep(1000);}catch(Exception d){}
            P a =new P();
            a.x=m.x+10+(20*m.gxo);
            a.y=m.y+10+m.gyo*20;
            a.vx=m.gxo*2;
            a.vy=m.gyo*2;

            b.add(a);
        }
    }

    public void keyTyped(KeyEvent e)
    {

    }
}

class P
{
    int x, y,vx,vy;

}
