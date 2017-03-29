package inClassAssignments.chapter2;

public class Exponentiation
{
	public static int count = 0;
	public static int countMultiply = 0;
    public static boolean isEven( int n )
    {
		count+=3;
        return n % 2 == 0;
    }

    public static long pow( long x, int n )
    {
        if( n == 0 )
        {
			count++;
            return 1;
		}
        if( n == 1 )
        {
			count++;
            return x;
		}
        if( isEven( n ) )
        {
			count+=3;
			countMultiply++;
            return pow( x * x, n / 2 );
		}
        else
        {
			count+=4;
			countMultiply+=2;
            return pow( x * x, n / 2 ) * x;
		}
    }

    // Test program
    public static void main( String [ ] args )
    {
		count = 0;
		countMultiply = 0;
        System.out.println( "2^2 = " + pow( 2, 2 ) );
        System.out.println( "Multiply Operations:"+countMultiply);
        System.out.println( "Total Operations:"+count + "\n");
		count = 0;
		countMultiply = 0;
        System.out.println( "2^21 = " + pow( 2, 21 ) );
        System.out.println( "Multiply Operations:"+countMultiply);
        System.out.println( "Total Operations:"+count + "\n");
        count = 0;
		countMultiply = 0;
        System.out.println( "2^50 = " + pow( 2, 50 ) );
        System.out.println( "Multiply Operations:"+countMultiply);
        System.out.println( "Total Operations:"+count + "\n");
    }
}
