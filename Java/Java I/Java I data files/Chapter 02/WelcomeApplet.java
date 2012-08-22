/*
	Chapter 2:	My day app
	Programmer: Michael Brown
	Date:		March 25, 2009
	Filename:	WelcomeApplet.java
	Purpose:	This displays the system time, user name , and my day info
*/
import java.util.Date;
import java.awt.*;
import java.applet.*;

public class WelcomeApplet extends Applet
{
	/**
	 * This program is for the purpose of displaying the My Day Application in
	 * either applet form or in the Console form.
	 * This will be used by every user to display thier daily tasks. It will
	 * display the date, the user's name, and the text "Welcome to my day!"
	 */
	public void paint(Graphics g)
	{
		Date currentDate = new Date(); //Date constructor
		g.drawString("Welcome to my day!", 200,70);
		g.drawString("Daily planner for Linda Nunez", 200,100);
		g.drawString(currentDate.toString(), 200,130);
		Image smile; //declare and Image obkect
		smile = getImage(getDocumentBase(), "Smile.gif");
		g.drawImage (smile,10,10,this);
		setBackground(Color.cyan);

	}
}