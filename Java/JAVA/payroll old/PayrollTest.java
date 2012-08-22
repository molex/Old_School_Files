//Mike Brown
//PayrollTest.java

import java.util.Scanner;//prepare scanner for use

public class PayrollTest
{
	public static void main (String[] args)
	{
	
	Scanner input = new Scanner(System.in);//creates scanner for user input
	
	
		
    	
			Payroll myPayroll = new Payroll();//stores instance variables
			
			while(true)
		{	
	System.out.printf("Please enter the employee name:");
	String theName = input.nextLine();
	myPayroll.setEmployeeName(theName);
		
	System.out.print( "Enter Hourly Rate:$");
	double theWage = input.nextDouble();
	myPayroll.setHourlyWage(theWage);
	System.out.print( "Enter Hours Worked: ");
	double theHours = input.nextDouble();
	myPayroll.setHoursWorked(theHours);
	
	
	myPayroll.displayMessage();}//displays the employees net pay from user input

	   
	  
	}//end main   
	
}//end class