import java.util.Random;
public class RollDie
{
	public static void main (String[] args)
		 {
		 	Random randomNumbers = new Random();
		 	int frequency1 = 0;
		 	int frequency2 = 0;
			int frequency3 = 0;
			int frequency4 = 0;
			int frequency5 = 0;
			int frequency6 = 0;
			
			int face;
				for ( int roll = 1; roll <= 6000; roll++)
{
	face = 1 + randomNumbers.nextInt( 6 );
// determine roll value 1-6 and increment
				switch ( face)
{
				case 1:
			++frequency1; // increment the 1s
			break;
case 2:
++frequency2; // increment the 2s
break;
case 3:
++frequency3; // increment the 3s
break;
case 4:
++frequency4; // increment the 4s
break;
case 5:
++frequency5;
break;
case 6:
++frequency6;
}
}
System.out.println( "Face\tFrequency" ); // output headers
System.out.printf( "1\t%d\n2\t%d\n3\t%d\n4\t%d\n5\t%d\n6\t%d\n",
frequency1, frequency2, frequency3, frequency4,
frequency5, frequency6 );
			
}
}