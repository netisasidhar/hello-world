//tool for checking if a number is circular prime
import java.util.Scanner;
public class CircularPrimeFinder
{
    
    public static void main(String args[])
    {
        Scanner user = new Scanner(System.in);
        System.out.println("Enter a number");
        long x = user.nextLong();//input
        System.out.println(
        x+
        " is"+
        (isCircularPrime(x)?"":" not")+
        " a circular prime number"
        );
        user.close();
    }
    
    public static boolean isCircularPrime(long n)
    {
        long backup = n;
        long p=1;
        n/=10;//to atop counting units digits also in the ten's power
        while(n!=0)
        {
            p*=10;
            n/=10;
        }
        n = backup;
        do//the fist one needs to run, the last iteration's number will not be checked, as we know it is prime
        {
            if(!isPrime(n))
            return false;
            byte cd = (byte)(n%10);
            n/=10;
            n+=cd*p;
        }
        while(n!=backup);
        return true;
    }
    
    public static boolean isPrime(long n)
    {
        if((n==2)||(n==3))
        return true;//prime
        long c = 3;
        long sqrtish = Math.round(Math.sqrt(n));
        while(c<=sqrtish)
        {
            if(n%c==0)
                return false;//not a prime
            c+=2;
            /*
             *if n is not divisible by 2, it wont be
             *by any even number. Ignore all even 
             *numbers and make the execution time half
             */
        }
        if(n%2==0)
            return false;//not a prime
        return true;//it IS a prime
    }
}
