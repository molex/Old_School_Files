import java.awt.*;
import javax.swing.*;
//
//
// this class provides the frame and the scrolling text area for the
// amortization schedule
//
class AmortizeFrame extends JFrame
{
	private JTextArea amortText;
	private JScrollPane amortScroll;
	private String sTitle = "Classy Mortgage";
	final String sTitle2 = " Amortization Schedule";

	// default constructor
	public AmortizeFrame()
	{
		initWindow();
	}

	// constructor that takes parameter (such as week number)
	// to add extra info to title on frame of window
	public AmortizeFrame(String week)
	{
		sTitle = sTitle + " " + week;
		initWindow();
	}// end constructor
	
	// helper method that initialized GUI
	private void initWindow()
	{
		setTitle(sTitle + sTitle2);
		setBounds(200,200,550,400);
		Container contentPane=getContentPane();

		amortText = new JTextArea(7,100);
		amortScroll= new JScrollPane(amortText);
		contentPane.add(amortScroll,BorderLayout.CENTER);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	// method to get the text area for users of
	// this frame.  They can then add whatever text they want from the outside
	public JTextArea getAmortText()
	{
		return amortText;
	}
}// end amortizeFrame
