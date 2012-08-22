import java.util.Scanner; // program uses Scanner

 

public class PayrollProgram

{

            private String employeeName; // Employee Name

 

 

            // constructor start

            public PayrollProgram( String name ) 

            {

            employeeName = name; // initializes

            } // end constructor

 

 

            // method to store the employee name

            public void setEmployeeName( String name )

            {

            employeeName = name;

            } // end method setEmployeeName

 

 

            // method to retrieve the employee name

            public String getEmployeeName()

            {

            return employeeName;

            } // end method getEmployeeName

 

 

    public void displayMessage()

            {

            System.out.println( "\nWelcome to the Payroll Program.\n" );

            System.out.printf( "Please enter the employee name or \"stop\" to quit the program: ");       

            }

 

 

            public void determineWeeklyRate()

            {

                        // create Scanner to obtain input from command window

                        Scanner input = new Scanner( System.in );

                        

                        double hourlyRate;

                        double hoursForWeek;

                        double sum;

            

                        while (input.hasNext( ))

                        {

                        employeeName = input.nextLine();

                        

                                    if (!employeeName.equals("stop")) 

                                    {

                                                                        

                                                // Hourly rate

                                                System.out.print( "Please enter the employee\'s hourly rate: " );

                                                hourlyRate = input.nextDouble(); // input rate

                                                

                                                if (hourlyRate >= 0);

                                                else

                                                {

                                                            System.out.println( "Hourly rate must be a positive value." );

                                                            System.out.printf( "Please enter the employee\'s hourly rate: " );

                                                            hourlyRate = input.nextDouble(); // input rate

                                                }

                                                

                                                // Hours worked per week

                                                System.out.print( "Please enter the employee\'s number of hours worked for that week: " );

                                                hoursForWeek = input.nextDouble(); // input hours for week

                                                            

                                                if (hoursForWeek >= 0);

                                                else

                                                {

                                                            System.out.println( "Hours worked for that week must be a positive value." );

                                                            System.out.print( "Please enter the employee\'s number of hours worked for that week: " );

                                                            hoursForWeek = input.nextDouble(); // input hours for week

                                                }

                                                

                                                sum = hourlyRate * hoursForWeek; // Calculate

 

                                                // Print employee's name and weekly pay amount.

                                                            System.out.printf( employeeName ); // insert employee name

                                                            System.out.printf( " made a total of " );

                                                            System.out.printf( "\u0024" ); // insert unicode for $

                                                            System.out.printf( " %.2f", sum ); // display sum

                                                            System.out.printf( " for that week.\n\n" );

                                                            System.out.printf( "Please enter the employee name or \"stop\" to quit the program: " );

                                                            employeeName = input.nextLine();

                                                

                                    }

                                    else 

                                    {

                                                System.out.println( "Bye.\n" );

                                                break;

                                    }

 

                        }

            } // end method

} // end class


