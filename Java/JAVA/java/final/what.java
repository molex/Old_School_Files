import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class FileEditor
 {
 RandomAccessFile file; // reference to the file
 Scanner input = new Scanner( System.in );
 // open the file
 public FileEditor( String fileName ) throws IOException
 {
 	
 
 file = new RandomAccessFile( fileName, "rw" );
 }
 public void closeFile() throws IOException
{
 if ( file != null )
 file.close();

 } // end method closeFile
 