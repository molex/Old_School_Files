import java.awt.*;
import java.awt.event.*;

public class MessageBox extends Dialog implements ActionListener
{
	private String result;
	private Button OKButton;

	public MessageBox(Frame frame, String title, String messageString)
	{
		// call dialog's constructor
		super(frame, title, true);

		// determine the size of the message box
		Rectangle bounds = frame.getBounds();
		setBackground(Color.white);
		setLocation(bounds.x+bounds.width/3, bounds.y+bounds.height/3);

		// create a panel to hold the message
		Panel messagePane = new Panel();
		Label message = new Label(messageString);
		messagePane.add(message);
		add(messagePane, BorderLayout.CENTER);

		// create a panel to hold the button
		Panel buttonPane = new Panel();
		OKButton = new Button("  OK  ");
		buttonPane.add(OKButton);
		add(buttonPane, BorderLayout.SOUTH);

		// add the Action Listener to the button
		OKButton.addActionListener(this);

		// reorganize internal components to fit window
		pack();
	}

	public void actionPerformed(ActionEvent e)
	{
		setVisible(false);
	}

} // end class MessageBox