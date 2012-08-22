import java.util.Arrays;//import array
import javax.swing.SwingConstants;
import javax.swing.JFrame;
import javax.swing.JButton; 
import javax.swing.JOptionPane;
import java.awt.FlowLayout;
public class SubInventoryFrame extends JFrame
{//start subcalss Inventory
final int arrayLength = 2; 
String title;
double array[]={3,50,10.00};
double sum;
private JButton button1;
private JButton button2;
private JButton button3;
private JButton button4;
	
	public SubInventoryFrame()
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
	}	

public void outputTotalValue1()
{


 			int productNum[] = new int[ arrayLength ];

 

            String productName[] = new String[] { "DVD" , "CD"};

 

            int productUnits[] = { 300,100  };

 

            double productPrice[] = { 5.00, 10.00}; 

 

            double productValue[] = new double[ arrayLength ];

 

            sortProductName( productName );//calls sort info by product name

 

            for ( int counter = 0 ; counter < productNum.length;counter++ )

 

           JOptionPane.showMessageDialog(null, "\nProduct number: " + (productNum[counter ] = 1 + counter) +
   
   "\nProduct name: " + productName[ counter ] +
   
   "\nUnits in stock: " + productUnits[ counter ] +
   
   "\nPrice per unit: \u0024" + productPrice[ counter ] +
   
   "\nProduct value: \u0024" + (productValue[ counter ] = productUnits[counter ] * productPrice[ counter ]) );
}
   
    public void outputtotalvalue2()
    {
       
        title = "Pulp Fiction";
        sum = (array[1]*array[2]) + ((array[1]*array[2])*.05);
        JOptionPane.showMessageDialog(null, "\nProduct number: " + (array[0]) +
        	"\nProduct Name: "+ (title) +
        	"\nUnits In Stock: " + (array[1]) +
        	"\nPrice Per Unit:\u0024" + (array[2]) +
        	"\nProduct Value:\u0024" + (sum));
        
        
        }
        
        
        	
         public void outputTotalValue3(double productValue[] )

 

            {

 

            double totalProductValue = 0;

    for ( int counter = 0; counter < productValue.length; counter++ )

 

                        totalProductValue += productValue[ counter ];// creates total inventory amount

 

                        //System.out.printf( "\nTotal value for all products: \u0024" + totalProductValue + "\n\n" );
						JOptionPane.showMessageDialog(null,"\nTotal value for all products: \u0024" + totalProductValue + "\n\n" );
 

            }

 

           

 

            public static void sortProductName( String productName[] )    //sorts productName by array

 

            {

 

            Arrays.sort( productName );

           
 

            }

 

}

        
