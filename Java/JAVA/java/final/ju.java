import java.io.FileNotFoundException;
import java.lang.SecurityException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CreateTextFile
{
	private Formatter output;
	
public void openFile()

{
	try
	{
		output = new Formatter( "c:\data\inventory.dat" );
	}
	
		catch ( SecurityException securityException )
	{
		System.err.println("You do not have write access to this file." );
        System.exit( 1 );
	}
	catch ( FileNotFoundException filesNotFoundException )
{
 System.err.println( "Error creating file." );
 System.exit( 1 );
 } // end catch
 } // end method openFile
}
try // read records
 {
 // open file to read from beginning



input = new Scanner( new File( "c:\data\inventory.dat" ) );