/*
   Java 1      	   Employee records
   Programmer:	   Mike Brown
   Date:		   April 16, 2009
   Program Name:   CheckEmployee.java
   Version:		   1.0
   Purpose:		   initializes new employees and prints results
*/

import java.io.*;
import java.util.*;

public class CheckEmployees
{

	public static void main(String [] args)throws IOException
	{
		//initialize variables
		boolean x = true;
		String userNum,checkForEnter;
		int empNum;
		List employeeList = new ArrayList();

		//create multiple objects of class Employee
		employeeList.add(new Employee("123-456-7899","Brown","Mike"));
		employeeList.add(new Employee("555-444-3333","Conn","Angel"));
		employeeList.add(new Employee("222-111-0000","Adams","Grizzly"));
		employeeList.add(new Employee ("999-888-7654","Doe","John"));
		employeeList.add(new Employee("546-879-1234","Flintstone","Wilma","B"));
		employeeList.add(new Employee("147-852-3698","Rubble","Barney","z","M","11789"));
		employeeList.add(new Employee("741-258-8963", "Noir","Guy","M" ));


		BufferedReader dataIn = new BufferedReader(new InputStreamReader(System.in));


			while(x)//while x is true do the following
			{
				//get user input
				System.out.println("Please choose an Employee (#'s 1 - 7):");
				userNum = dataIn.readLine();
				if (userNum.equals(""))// if the user hits the enter key and nothing else
				{
					for(int i=0; i<employeeList.size();++i)
					{
						//prints entire employee list
						Employee currentRecord = (Employee) employeeList.get(i);
						System.out.println("Employee number "+ (i +1)+"\n"+ currentRecord.toString());
						if ((i + 1) % 2 == 0)
						{
							System.out.println();
							System.out.println("Please Press Enter to continue:");
							checkForEnter = dataIn.readLine();
							System.out.println();
						}//end if

					}//end for

					System.out.println("Good Bye!!!");

					//set x to false to end the loop
					x = false;

				}//end if

				//if user chooses any number from 1-7
				else if ((userNum.equals("1")|| (userNum.equals("2"))||(userNum.equals("3"))||(userNum.equals("4"))||(userNum.equals("5"))||
				(userNum.equals("6"))||(userNum.equals("7"))))

				{
					empNum = Integer.parseInt(userNum);
					Employee currentRecord = (Employee) employeeList.get(empNum - 1);//pulls employee data from the Array List
					System.out.println("Employee number "+ empNum +"\n" + currentRecord.toString());//formats data in String form

				}//end else if

				//if user chooses anything else
				else
				{
					System.out.println("Please enter a number between 1 - 7");

				}//end else

			}//end while

	}//end main

}//end class