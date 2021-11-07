public class AGeom
{
    public static double regFigAr(long n, double l)
    //returns the area of a regular figure with n sides and
    //l length of each side
    {
        return (n*l*l*Math.tan((Math.PI*(n-2))/(2*n)))/4;
    }
    public static double regFigAng(long n)//returns the internal angle in degrees 
    //of a regular figure with n sides
    {
        return 180*(n-2)/n;
    }
}
