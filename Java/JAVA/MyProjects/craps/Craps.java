import java.util.Random;
public class Craps
{
	private Random randomNumbers = new Random();
	
	private enum Status { CONTINUE, WON, LOST };
	
	private final static int SNAKE_EYES = 2;
	private final static int TREY = 3;
	private final static int SEVEN = 7;
	private final static int YO_LEVEN = 11;
	private final static int BOX_CARS = 12;
	
		public void play()
		{
			int myPoint = 0;
			Status gameStatus;
			
			int sumOfDice = rollDice();
			
			switch ( sumOfDice )
			{
				
			
				case SEVEN: // win with 7 
				case YO_LEVEN: // win with 11
					gameStatus = Status.WON;
						break;
				case SNAKE_EYES: // lose with 2
				case TREY: // lose with 3 
				case BOX_CARS: // lose with 12
				gameStatus = Status.LOST;
					break;
					
					default:
						gameStatus = Status.CONTINUE;
						myPoint = sumOfDice;
						System.out.printf( "Point is %d\n", myPoint );
						break;
			}
			while (gameStatus == Status.CONTINUE)
			{
				sumOfDice = rollDice();
				if ( sumOfDice == myPoint )
					gameStatus = Status.WON;
				else
					if ( sumOfDice == SEVEN )
						gameStatus = Status.LOST;	
			}
			
			if (gameStatus == Status.WON)
				System.out.println( "Player wins" );
			else
				System.out.println( "Player loses" );	
		}
		
		public int rollDice()
		{
			int die1 = 1 + randomNumbers.nextInt( 6 );
			int die2 = 1 + randomNumbers.nextInt( 6 );
			int sum = die1 + die2;
			System.out.printf( "Player rolled %d + %d = %d\n" ,die1, die2, sum );
			return sum;
		}
}