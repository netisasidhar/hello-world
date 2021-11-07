//finds the electronic configuration from atomic number
import java.util.Scanner;
public class AtomicStruct
{   byte z =0, c =0,n=0,s=2,d=10,p=6,f=14;
    Scanner sc = new Scanner(System.in);//remove this when you are not using main()
    Orbit[] y = new Orbit[9];
    public static void main(String args[])
    {
        System.out.print("Enter the atomic number ofany  element to know its electronic configuration: ");
        AtomicStruct a = new AtomicStruct();//each new instance has its own stuff
        a.findElecConf(a.sc.nextByte());//let the function modify a's variables
        a.sc.close();
    }
    public void findElecConf(byte k){
        for(byte q =0;q<8;q++)
        {
            y[q] = new Orbit((byte)(q-1));
        }
        z = k;
        n = 1;
        while(true)// fill the orbits
        {
            fill(y[n-1],f);//if possible
            fill(y[n+1],s);
            fill(y[n],d);
            fill(y[n+1],p);
            n++;
        }
    }

    public void fill(Orbit x,  byte ne)
    {
        if((z>ne)&&(x.fillable>=ne))
        {
            z-=ne;
            x.fillable-=ne;
            x.n+= ne;
        }
        else if(z==0)
        {
            terminate();
        }
        else if((z<ne)&&(x.fillable>=ne))
        {
            x.n+=z;//fill in the remaining..
            terminate();
        }
    }

    public void terminate()//this is called when the job is done. do whatever you want here
    {              
        System.out.print("Electronic configuration:\n( "+y[2].n);
        for(int qw = 3; qw <8; qw ++)
        {
            System.out.print(" , "+y[qw].n);
        }
        System.out.println(")");
        sc.close();
        System.exit(0);
    }
}
class Orbit
{
    byte n, fillable;
    public Orbit(byte no){
        fillable = (no<5)?(byte)(2*no*no):32;
    }
}
