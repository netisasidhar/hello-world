import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class Spawner extends Thread
{
    GP a;
    public Spawner(GP q){
        a=q;
    }
    public void run()
    {short t = 5000;
        while(true)
    {
        try{Thread.sleep(t);
        }catch(Exception e){}
        t-=10;
        short x = -1, y= -1;
        do{
            x = (short)(Math.random()*a.getWidth());
            y = (short)(Math.random()*a.getHeight());
        }
        while((x>a.getWidth())&&(y>a.getHeight())&&(x >= a.m.x-1)&&(x <= a.m.x+30)&&(y>=a.m.y-1)&&(y<= a.m.y+30));//searching stops when 
        //place found
        byte vx = (byte)(Math.random()*3),vy = (byte)(Math.random()*3);
        P p = new P();
        p.x = x;
        p.y =y;
        p.vx = vx;
        p.vy = vy;
        a.z.add(p);
    }
    }
}
