import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class Worker extends Thread
{
    GP a;
    int points = 0;
    java.util.List<P> b;
    java.util.List<P> z;
    public Worker(GP q){a=q;
        b = a.b;
        z = a.z;
    }
    public void run(){
   worker:  while(true){
                     try{
                         Thread.sleep(100);}catch(Exception e){}
                Graphics mg =a.getGraphics();
                mg.setColor(new Color(0,0,0));
                mg.fillRect(0,0,a.getWidth(),a.getHeight());// flush
                mg.setColor(new Color(255,255,0));//player color
                mg.fillOval(a.m.x,a.m.y,30,30);//drawplayer
                mg.setColor(new Color(255,0,0));//bullet color
                mg.fillOval(a.m.x+10+(20*a.m.gxo),a.m.y+10+a.m.gyo*20,10,10);// how to make the  bullet
                for(int i=0;i<b.size();i++){// handle bullets
                    P cp = b.get(i);
                    if((cp.x == a.getWidth())||(cp.x ==0)){b.remove(cp);}
                    if((cp.y==0)||(cp.y==a.getHeight())){b.remove(cp);}
                     k: for(int j = 0; j<z.size(); j++)// check if the bullet has hit any zombie
                    {
                        P cz = z.get(j);
                        if((cp.x >= cz.x-1)&&(cp.x <= cz.x+10)&&(cp.y>=cz.y-1)&&(cp.y<= cz.y+10)){// if the bullet hit the zombie
                            z.remove(cz);//destroy both
                            b.remove(cp); 
                            points++;
                            continue k;// next bullet
                        }
                    }
                    
                    mg.fillOval(cp.x+=cp.vx,cp.y+=cp.vy,5,5);//bullet size
                }
                mg.setColor(new Color(0,255,0));//zombie color
                for(int  i = 0; i< z.size();i++)//handle zombies
                {
                    P cz = z.get(i);//current zombie
                    if((cz.x <=a.m.x+30)&&(cz.x>a.m.x-1)&&(cz.y <=a.m.y+30)&&(cz.y>=a.m.y-1))
                    {
                        JOptionPane.showMessageDialog(a.x,"you lose\nscore:"+points);
                        break worker;
                    }//if zomble hits me
                    mg.fillOval(cz.x+=cz.vx,cz.y+=cz.vy,10,10);//
                }
            }
            System.exit(0);
        
            }
}
