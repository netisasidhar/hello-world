//prints the factors of a number taken from
//user
import java.util.Scanner;
public class FactPrnt
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number");
        long in = sc.nextLong();
        primeFactors(in);
    }
    static void primeFactors(long t)
    {
        System.out.println("1");//factor of anything
        for(long n = 2; n <= t;)
        {
            if(t%n ==0)
            {
                System.out.println(n);
                t/=n;
            }
            else
            {
                n++;
            }
        }
        System.out.println("done");
    }
}
