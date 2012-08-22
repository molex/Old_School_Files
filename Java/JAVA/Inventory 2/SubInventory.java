import javax.swing.JOptionPane;//import gui ability
import java.awt.FlowLayout; // specifies how components are arranged
import javax.swing.JFrame; // provides basic window features
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class SubInventory extends JFrame
{//start subcalss Inventory
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JButton button4;
	
	public SubInventory()
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

String title;
double array[]={3,50,10.00};
double sum;
   
   
    public void outputtotalvalue()
    {
       
        title = "Pulp Fiction";
        sum = (array[1]*array[2]) + ((array[1]*array[2])*.05);
        JOptionPane.showMessageDialog(null, "\nProduct number: " + (array[0]) +
        	"\nProduct Name: "+ (title) +
        	"\nUnits In Stock: " + (array[1]) +
        	"\nPrice Per Unit:\u0024" + (array[2]) +
        	"\nProduct Value:\u0024" + (sum));
        
        
        }
        }
