//Mike Brown
//Inventory.java
import java.util.Arrays;//import the array 
import java.awt.FlowLayout;// layout
import javax.swing.JFrame;//import frame work
import javax.swing.JOptionPane;//import message box
import javax.swing.JButton;//import buttons
import java.awt.event.ActionListener;//event listener
import java.awt.event.ActionEvent;//event handler
import javax.swing.Icon;//import use of icons
import javax.swing.ImageIcon;//import use of images as icons
import javax.swing.JLabel;//import labels...even though I can't get them to work!



public class Inventory extends JFrame//class name

{
	private JButton button1;//declaring buttons 1-5
	private JButton button2;
	private JButton button3;
	private JButton button4;
	private JButton button5;
	private JLabel label1;//declare labels 1-4...even though I couldn't get them to work!
	private JLabel label2;
	private JLabel label3;
	private JLabel label4;
	
			String product1;//declare products 1-3
            String product2;
            String product3;
            double array[]={123456,100,10.00,123457,50,10.00,654321,300,5.00};//declare array variables
			double sum1;//declare total inventory amounts for products 1-3
			double sum2;
			double sum3;
	
	public Inventory()//start button constructor
	{
	
	super("Inventory");
	setLayout( new FlowLayout() );
	
	button1 = new JButton("First");
	add(button1);
	
	button2 = new JButton("Prev.");
	add(button2);
	
	button3 = new JButton("next");
	add(button3);
	
	button4 = new JButton("Last");
	add(button4);
	
	Icon logo = new ImageIcon( getClass().getResource( "logo.gif" ) );
	
	button5 = new JButton("The Molex Group",logo);
	add(button5);
	
	
	
	ButtonHandler handler = new ButtonHandler();//declares button actions
	button1.addActionListener( handler );
	button2.addActionListener( handler );
	button3.addActionListener( handler );
	button4.addActionListener( handler );
	}//end button constructor	
			
	private class ButtonHandler implements ActionListener			
	{
		public void actionPerformed( ActionEvent event )//strart event handling
		{
		
              String string = "";

           
            
     if(event.getSource()== button1)//if statement for how to handle button clicks
            
     {
     
     	
            product1 = "DVD";//DVD category
            sum1 = array[1] * array[2];
            //label1 = new JLabel(); ****THIS IS COMMENTED OUT BECAUSE IT DIDN'T WORK!***
			//label1.setToolTipText("\nproduct Name: " + (product1) +***I LEFT IT IN SO YOU***
            //	"\nProduct number is: " + (array[0]) +***COULD SEE THAT I TRIED TO ***
            //	"\nQuantity: " + (array[1]) +***FIGURE IT OUT***
              //  "\nCost:$ " +	(array[2]) +***IF YOU CAN TELL ME WHAT I DID WRONG***
            	//"\nTotal value of category-DVD:$ " + (sum1));***I WILL FIX IT FOR NEXT***
			//add(label1);***WEEK!!***
            JOptionPane.showMessageDialog(null, "\nproduct Name: " + (product1) +
            	"\nProduct number is: " + (array[0]) +
            	"\nQuantity: " + (array[1]) +
            	"\nCost:$ " +	(array[2]) +
            	"\nTotal value of category-DVD:$ " + (sum1));
     }
      else if(event.getSource()== button2)  
      {
      
      product2 = "Pulp Fiction";
      sum2= (array[4]*array[5]) + ((array[4]*array[5])*.05);
      JOptionPane.showMessageDialog(Inventory.this,String.format( "\nProduct Name: " + (product2) +
      	"\nproduct number is: " + (array[3]) +
      	"\nQuantity: " + (array[4]) +
      	"\nCost:$ " + (array[5]) +
      	"\nTotal value of Sub-category:$ " + (sum2),event.getActionCommand()) );
      	
      }
      
      else if(event.getSource()== button3)
      {
      	product3= "CD's";//CD category
      	sum3 = array[7] * array[8];
      	JOptionPane.showMessageDialog(null, "\nProduct Name: " + (product3) +
      		"\nproduct number is: " + (array[6]) +
      		"\nQuantity: " + (array[7]) +
      	    "\nCost:$ " + (array[8]) +	
      	    "\nTotal value of category:$ " + (sum3) );
      		
      	 }
      	 else if (event.getSource() == button4)
      	 {
      	 	JOptionPane.showMessageDialog(null, "\nTotal inventory for all categories is:$ " + (sum1 + sum2 + sum3));
      	 }//END if statement
     
                        
            }//end method
	}//end class
            
     
     
           
          
      
      		
      	
      
      	
      	 
	
	 
	 
	 			

 }//end class
 
