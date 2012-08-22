/**
 * Class PasswordDemo used to test class Password
 *
 * @author Michael Mick
 * @version 1.0
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PasswordDemo
{
    public static void main(String[] argv)
    {
		int width = 400;
		int height = 130;
        final demoFrame f = new demoFrame("PasswordDemo");

        f.pack();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	f.setSize(width, height);
    	f.centerOnScreen(width, height);
    	f.setVisible(true);
    }
}

class demoFrame extends JFrame implements ActionListener
{
    Password password = null;
    String pswd, newPswd;

    JPasswordField pswdField;
    JPasswordField newPswdField;
    JButton jbtAddPswd, jbtChangePswd, jbtUsePswd;

    public demoFrame(String title)
    {
        super(title); // call super (JFrame) constructor

        JLabel label1 = new JLabel("Current Password:");
        pswdField = new JPasswordField(20);
        pswdField.setEchoChar('*');

        JLabel label2 = new JLabel("New Password:", JLabel.RIGHT);
        newPswdField = new JPasswordField(20);
        newPswdField.setEchoChar('*');

        jbtAddPswd = new JButton("Add password");
        jbtChangePswd = new JButton("Change password");
        jbtUsePswd = new JButton("Use password");

        jbtAddPswd.addActionListener(this);
        jbtChangePswd.addActionListener(this);
        jbtUsePswd.addActionListener(this);

        JPanel pswdPanel= new JPanel(new BorderLayout(10,10));
        pswdPanel.add(label1,BorderLayout.WEST);
        pswdPanel.add(pswdField,BorderLayout.EAST);

        JPanel newPswdPanel= new JPanel(new BorderLayout(19,19));
        newPswdPanel.add(label2,BorderLayout.WEST);
        newPswdPanel.add(newPswdField,BorderLayout.EAST);

        JPanel buttonPanel= new JPanel(new FlowLayout());
        buttonPanel.add(jbtAddPswd);
        buttonPanel.add(jbtChangePswd);
        buttonPanel.add(jbtUsePswd);

        JPanel contentPanel= new JPanel(new FlowLayout());
        contentPanel.add(pswdPanel);
        contentPanel.add(newPswdPanel);
        contentPanel.add(buttonPanel);
        setContentPane(contentPanel);

		// Enable Enter key for each JButton so user can tab to button
		// and press the Enter key, rather than click button with mouse
		InputMap map;
		map = jbtAddPswd.getInputMap();
		if (map != null){
			map.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER,0,false), "pressed");
			map.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER,0,true), "released");
		}
		map = jbtChangePswd.getInputMap();
		if (map != null){
			map.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER,0,false), "pressed");
			map.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER,0,true), "released");
		}
		map = jbtUsePswd.getInputMap();
		if (map != null){
			map.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER,0,false), "pressed");
			map.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER,0,true), "released");
		}
    }

  	public void centerOnScreen(int width, int height)
  	{
  	  int top, left, x, y;

  	  // Get the screen dimension
  	  Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

  	  // Determine the location for the top left corner of the frame
  	  x = (screenSize.width - width)/2;
  	  y = (screenSize.height - height)/2;
  	  top = (x < 0) ? 0 : x;
  	  left = (y < 0) ? 0 : y;

  	  // Set the frame to the specified location
  	  this.setLocation(top, left);
  	}

    public void actionPerformed(ActionEvent e)
    {
		String msg;
		String title;
		int optionType;
		try
        {
			if(e.getSource() == jbtUsePswd)		// user clicked Use password
            {
			    pswd = new String(pswdField.getPassword());   // get current pswd entered
				password.validate(pswd);

               	if(password.isExpiring())
               	{
               	   msg = "Password use successful; " + password.getRemainingUses()+" use(s) remaining.";
               	   title = "Success";
                   optionType = JOptionPane.WARNING_MESSAGE;
		    	}
               	else
				{
               	   msg = "Password use successful";
               	   title = "Success";
                   optionType = JOptionPane.INFORMATION_MESSAGE;
		    	}
            }
            else if(e.getSource() == jbtChangePswd)		// user clicked Change password
            {
		    	newPswd = new String(newPswdField.getPassword());
		        password.set(newPswd);

               	msg = "Password changed.";
               	title = "Success";
                optionType = JOptionPane.INFORMATION_MESSAGE;
            }
            else if(e.getSource() == jbtAddPswd)		// user clicked Add password
            {
			    newPswd = new String(newPswdField.getPassword());
   			    password = new Password(newPswd,5); // auto expires after 5 additional uses

				if(password.getAutoExpires())
               		msg = "Success! Password added with "+password.getRemainingUses()+" remaining uses.";
               	else
				    msg = "Success! Password added - not set to expire.";

               	title = "Success";
                optionType = JOptionPane.INFORMATION_MESSAGE;
	        }
            else	// can never happen
            {
               	msg = "Please choose a valid action.";
               	title = "Invalid Action";
                optionType = JOptionPane.WARNING_MESSAGE;
			}

            JOptionPane.showMessageDialog(this, msg, title, optionType);
			pswdField.setText("");
			newPswdField.setText("");
			pswdField.requestFocus();

        }// end of try
        catch (NullPointerException ex)
        {
            JOptionPane.showMessageDialog(this,"No Password yet created",
                                               "Invalid password. Try again.",
                						       JOptionPane.ERROR_MESSAGE);
        }
        catch (Exception ex)
        {
            JOptionPane.showMessageDialog(this, ex.getMessage(),
                                                "Invalid password. Try again.",
                                                JOptionPane.ERROR_MESSAGE);
        }
    }
}