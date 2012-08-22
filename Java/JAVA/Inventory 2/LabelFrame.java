import javax.swing.JOptionPane;//import gui ability
import java.awt.FlowLayout; // specifies how components are arranged
import javax.swing.JFrame; // provides basic window features
import javax.swing.JLabel; // displays text and images
import javax.swing.JButton;
import javax.swing.SwingConstants; // common constants used with Swing
import javax.swing.Icon; // interface used to manipulate images
import javax.swing.ImageIcon; // loads images

public class LabelFrame extends JFrame
{
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
}