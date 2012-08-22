/*
	Chapter 9:	UserList solution
	Programmer:	Michael Mick
	Date:		November 28, 2007
	Filename:	UserList.java
	Purpose:	Builds a list of user names
*/

public class UserList
{

  public static void main(String[] args) throws IOException
  {
	  string str1, str2 = "username";
	  int index;
	  int initialCapacity = 10;
	  BufferedReader dataIn = new BufferedReader(new InputStreamReader(System.in));
	  ArrayList users = new ArrayList();

	  System.out.print("Enter a user name: ");
	  str1 = dataIn.readLine();

      while(str1.length() > 0)
      {
		  if(str1 == str2)
		      System.out.println("That user name is NOT allowed!");
	      else
          {
			  if(users.size() == initialCapacity)
			  {
			   	  System.out.println("List is full!");
				  System.out.println("Last entry is "+users.get(initialCapacity));
			  }
			  else
			      if(!users.contains(str1))
			      {
					  users.add(str1);
					  System.out.println("User \""+str1+"\" added to user list.");
				  }
				  else
				      System.out.println("User \""+str1+"\" already in user list.");
	      }
	      System.out.print("\nEnter a user name: ");
	      str1 = dataIn.readLine();
	  }

	  System.out.println("Program complete.");
  }
}