//mike brown
import java.util.Scanner;

public class GradeBookTest
{
	public static void main( String args[] )
	{
		Scanner input = new Scanner(System.in);
		
	
 // display a welcome message to the GradeBook user

	GradeBook myGradeBook = new GradeBook();
	
	System.out.println("Please enter the course name: ");
	String nameOfCourse = input.nextLine();
	System.out.println();

	myGradeBook.displayMessage( nameOfCourse);

 } // end method displayMessage

 } // end class GradeBook