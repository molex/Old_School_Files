//Mike Brown
//Payroll.java
public class Payroll//class name
{
	private String employeeName;//employee name for payroll
	private double hoursWorked;
	private double hourlyWage;
	
	
	public void setEmployeeName(String name)
	{
		employeeName = name;
	}//end set for employeeName
	public void setHoursWorked(double hours)
	{
		hoursWorked = hours;
	}//end set for hours worked
	public void setHourlyWage(double wage)
	{
		hourlyWage = wage;
	}//end set for hourly wage
	
	public String getEmployeeName()
	{
		return employeeName;
	}//end get
	public double getHoursWorked()
	{
		return hoursWorked;
	}//end get
	public double getHourlyWage()
	{
		return hourlyWage;
	}//end get

	public void displayMessage()//display of net pay
	{
		System.out.printf( " \n%s's\n", getEmployeeName());
		System.out.printf( "Pay amount is: $%.2f\n" , getHourlyWage()* getHoursWorked() );
		
	
	} //end method display message
}//end class