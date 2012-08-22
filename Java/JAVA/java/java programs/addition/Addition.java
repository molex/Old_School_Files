import java.util.Scanner;

public class Addition
{
	public static void main (String[] args)
		
	{Scanner input = new Scanner(System.in);
	int hourlyRate;
    int hoursWorked;
    int  netPay;
    
	System.out.print( "Enter Hourly Rate: ");
	hourlyRate = input.nextInt();
	System.out.print( "Enter Hours Wroked: ");
	hoursWorked = input.nextInt();
	netPay = hourlyRate * hoursWorked;
	System.out.printf( "Pay amount is $%d\n" , netPay );
	} 
}