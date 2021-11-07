//a really simple calculator
import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Calculator extends JFrame
{
    private static int cp;
    private static Character ch = new Character(' ');
    private static String f;
    private JTextArea t= new JTextArea()
        {
            boolean pp,ml;//pp= pi printed, ml= mem loaded to avoid doing those 2 times every press
            public void processKeyEvent(KeyEvent e)
            {
                int k = e.getKeyCode();
                if(k==e.VK_ENTER)//calculate
                {
                    res.setText(""+Calculator.solve(getText()));
                }else if(k==e.VK_S)//mem store
                {
                    mem=Double.parseDouble(res.getText());
                }
                else if(k==e.VK_L)//mem load
                {
                    if(!ml){
                        append(Double.toString(mem));
                        ml=true;
                    }
                    else
                    {
                        ml=false;
                    }
                }
                else if(k==e.VK_P)//get PI
                {
                    if(!pp){
                        append(Double.toString(Math.PI));
                        pp=true;
                    }
                    else
                    {
                        pp=false;
                    }
                }
                else
                super.processKeyEvent(e);
            }
        }
    ;
    private JLabel res= new JLabel();
    private JLabel a = new JLabel("Result");
    private JLabel b = new JLabel("Expression");
    public double mem;

    public static void main(String args[])
    {
        Calculator c = new Calculator();
    }
    
    public Calculator()
    {
        t.setLineWrap(true);
        getContentPane().setLayout(null);
        getContentPane().add(a);
        getContentPane().add(res);
        getContentPane().add(b);
        getContentPane().add(t);
        res.setHorizontalAlignment(JLabel. CENTER);
        setSize(240,300);
        a.setBounds(0,0,230,15);
        res.setBounds(0,15,230,50);
        b.setBounds(0,65,230,15);
        t.setBounds(0,80,230,220);
        t.setEditable(true);
        t.setFont(new Font("Consolas", Font.PLAIN, 14));
        setTitle("Calculator");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

    public static double p()
    {
        double r = 0;
        char c;
        int flen = f.length();
        boolean pn=true;
        double d=10;
        c=f.charAt(cp);
        if(c=='(')
        {
            return solveBracket();
        }
        parser:
        for(;cp!=flen;cp++)
        {
            c=f.charAt(cp);
            if(pn&&ch.isDigit(c))
            {
                r*=10;
                r+=(c-'0');
            }
            else{ 
                if(ch.isDigit(c)){
                    r+=((c-'0')/d);
                    d*=10;
                }
                else{
                    if(pn&&(c=='.'))//a number cannot have two points
                    {
                        pn=false;
                    }
                    else
                    {
                        cp--;
                        break parser;
                    }
                }
            }
        }
        return r;
    }

    public static double solve(String a)
    {
        f=a;
        cp=0;
        return solveBracket();
    }

    public static double solveBracket()// sets op2 to the result, cp must be set to the index of the first character after the bracket
    {
        char c;
        double myop1=0,myop2=0;
        char myop='+';//initially
        int fl = f.length();
        for(;cp<fl;cp++)
        {
            c=f.charAt(cp);
            if(c=='(')
            {
                cp++;
                myop2 = solveBracket();//whatever is in the bracket will be considered to be one number
                myop1 = c(myop1,myop2,myop);
            }
            else if(c==')')
            {
                return myop1;
            }
            else if(ch.isDigit(c))
            {
                myop2 = p();
                myop1= c(myop1, myop2,myop);
            }
            else if(c==' ')
            {}
            else
            {
                myop= c;
                cp++;
                myop2=p();
                myop1=c(myop1, myop2,myop);
            }
        }
        return myop1;
    }

    static double c(double op1, double op2, char op)
    {
        switch(op)
        {
            case '+':
            return op1+op2;
            case '-':
            return op1-op2;
            case '*':
            return op1*op2;
            case '/':
            return op1/op2;
            case '%':
            return op1%op2;
            case '^':
            return Math.pow(op1,op2);
            default:
            return op1;//stub
        }
    }
}

