/*
   Java 1      	   Employee records
   Programmer:	   Mike Brown
   Date:		   April 16, 2009
   Program Name:   Employee.java
   Version:		   1.0
   Purpose:		   Create an ArrayList of Employees
*/



public class Employee
{
	//declare and initialize variables
	private String socialSecurityNumber,lastName, firstName, middleInitial, sex,zipCode;


	//constructors for objects of class Employee
	public Employee(String sSN, String lN, String fN)
	{
		socialSecurityNumber = sSN;
		lastName = lN;
		firstName = fN;
	}

	public Employee(String sSN,String lN, String fN, String mI)
	{
		socialSecurityNumber = sSN;
		lastName = lN;
		firstName = fN;
		middleInitial = mI;
	}

	public Employee(String sSN,String lN, String fN, String mI, String s)
	{
		socialSecurityNumber = sSN;
		lastName = lN;
		firstName = fN;
		middleInitial = mI;
		sex = s;
	}

	public Employee(String sSN,String lN, String fN, String mI, String s,String zip)
	{
		socialSecurityNumber = sSN;
		lastName = lN;
		firstName = fN;
		middleInitial = mI;
		sex = s;
		zipCode = zip;
	}

	public String getSocialSecurityNumber()
	{
		return socialSecurityNumber;
	}

	public void setSocialSecurity(String newSocialSecurityNumber)
	{
		socialSecurityNumber = newSocialSecurityNumber;

	}//end setSocialSecurity

	public String getLastName()
	{
		return lastName;
	}//end getLastName

	public void setLastName(String newLastName)
	{
		lastName = newLastName;
	}//end setLastName

	public String getFirstName()
	{
		return firstName;
	}//end getFrstName

	public void setFirstName(String newFirstName)
	{
		firstName = newFirstName;
	}//end setFirstName

	public String getMiddleInitial()
	{
		return middleInitial;
	}//end getMiddleInitial

	public void setMiddleInitial(String newMiddleInitial)
	{
		middleInitial = newMiddleInitial;
	}//end setMiddleInitial

	public String getSex()
	{
		return sex;
	}//end getSex

	public void setSex(String newSex)
	{
		sex = newSex;
	}//end setSex

	public String getZipCode()
	{
		return zipCode;
	}//end getZipCode

	public void setZipCode(String newZipCode)
	{
		zipCode = newZipCode;
	}//end setZipCode

	public String toString()
	{
		return "Social Security Number: " + getSocialSecurityNumber() + "\n" + "Last Name: " + getLastName() + "\n" + "First Name: " + getFirstName() + "\n" + "Middle Initial: " + getMiddleInitial() + "\n" +
		"sex: " + getSex() + "\n" + "Zip Code: " + getZipCode() + "\n";
	}//end toString

}//end class