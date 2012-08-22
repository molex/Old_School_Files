import javax.swing.JFrame;

public class Inventory3
 {
 public static void main( String args[] )
 {
 	SubInventoryFrame mySubInventoryFrame = new SubInventoryFrame(  );//calls class subinventory
 	SubInventoryFrame subInventoryFrame = new SubInventoryFrame();
 	subInventoryFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
 	subInventoryFrame.setSize( 325, 100 );
 	subInventoryFrame.setVisible( true );
 	
 	mySubInventoryFrame.outputTotalValue1();
 	mySubInventoryFrame.outputtotalvalue2();
	mySubInventoryFrame.outputTotalValue3( productValue);
   
 	
 //TextFieldFrame textFieldFrame = new TextFieldFrame();
 //textFieldFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
 //textFieldFrame.setSize( 325, 100 ); // set frame size
 //textFieldFrame.setVisible( true ); // display frame
 } // end main
} // end class