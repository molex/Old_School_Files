//Mike Brown
//InventoryTest.java
import javax.swing.JFrame;//import JFrame useage

public class InventoryTest//class name

{

            

            public static void main( String args[] )//main argument

            {
            	 

                        Inventory inventory = new Inventory();//call class inventory
						inventory.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );//standard window
						inventory.setSize( 500, 200 ); // set frame size
						inventory.setVisible( true ); // display JFrame
						inventory.createFile();
                        

            } // end main method  

            

} // end class

