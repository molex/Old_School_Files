import java.util.Random;
/**
 * @(#)RandomNumbers.java
 *
 * RandomNumbers application
 *
 * @author 
 * @version 1.00 2007/10/9
 */
 
public class RandomNumbers 
{
    
    public static void main(String[] args)
    	 {
    	
    Random randomNumbers = new Random();
    int face;
    
    	
    	for ( int counter = 1; counter <= 20; counter++ )
    	{
    	
    face = 1 + randomNumbers.nextInt( 6 );
    System.out.printf( "%d ", face );
    if ( counter % 5 == 0 )
    	System.out.println();
    	
    	}
    }
}
