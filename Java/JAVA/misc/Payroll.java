//Mike Brown
//Payroll.java

import java.util.Scanner;//prepare for scanner use

public class Payroll//class name
{
	private String employeeName;//employee name for payroll
	
	public Payroll(String name)
	{//start constructor
	
	employeeName = name; // start constructor

    } // end constructor
    
     public void setEmployeeName( String name )//store employee name

            {//start set

            employeeName = name;

            } // end set EmployeeName
            
      public String getEmployeeName()

            {//start get

      return employeeName;

            } // end getEmployeeName
            
     public void displayMessage()

            {//start display

            System.out.println( "\nWelcome to the Payroll Program!\n" );

            System.out.printf( "Please enter the employee name or type \"stop\" to quit the program: ");       

            }//end display
            
     public void determineWeeklyRate()

            {//start weekly rate

                     
                        Scanner input = new Scanner( System.in );//create scanner to get user info
            
	
	 					double hoursWorked;
	 					double hourlyWage;
	 					double sum;
	 					
	 					 while (input.hasNext( ))

                        {//start loop

                        employeeName = input.nextLine();

                        

                                    if (!employeeName.equals("stop")) 

                                    {//start if
                                    	
                                    	System.out.print( "Please enter the employee\'s hourly rate:$ " );//input hourly rate

                                                hourlyWage = input.nextDouble(); 
                                                	
                                                if (hourlyWage >= 0);

                                                else

                                                {//start else

                                                            System.out.println( "Please enter a positive number." );

                                                            System.out.printf( "Please enter the employee\'s hourly rate:$ " );

                                                            hourlyWage = input.nextDouble();

                                                }//end else
                                                
 										System.out.print( "Please enter the number of hours that the employee has worked: " );
 		

                                                hoursWorked = input.nextDouble(); // input hours worked

                                                            

                                                if (hoursWorked >= 0);
                                                
                                                
												else

                                                {//start else

                                                            System.out.println( "Please enter a positive number." );

                                                            System.out.print( "Please enter the number of hours that the employee has worked: " );

                                                            hoursWorked = input.nextDouble(); // input hours worked

                                                }//end else
                                                
                                                
                                        sum = hourlyWage * hoursWorked; // Calculate the gross pay

 

                                                

                                                            System.out.printf( employeeName ); // insert employee name

                                                            System.out.printf( "'s Weekly pay amount is: " );

                                                            System.out.printf( "$ %.2f", sum ); // display sum

                                                            System.out.printf( " for that week.\n\n" );

                                                            System.out.printf( "Please enter the employee name or type \"stop\" to quit the program: " );

                                                            employeeName = input.nextLine();

                                                

                                    }//end if 
                                  
                                    
												 else 

                                    {//start else

                                                System.out.println( "Goodbye!\n" );

                                                break;

                                    }//end else

 

                        }//end while
	

	
	
	} //end method
	
}//end class