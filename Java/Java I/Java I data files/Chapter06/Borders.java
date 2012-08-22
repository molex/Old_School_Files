/*
	Chapter 6:	Borders
	Programmer:
	Date:
	Filename:	Borders.java
	Purpose:
*/

import java.awt.*;
import java.awt.event.*;

public class Borders extends Frame
{
	public Borders()
	{
		//set the layout
		setLayout(new BorderLayout());

      	//Add buttons
      	Button north = new Button("North");
      	Button south = new Button("South");
      	Button east = new Button("East");
      	Button west = new Button("West");
      	Button center = new Button("Center");

		add(north, BorderLayout.NORTH);
		add(south, BorderLayout.SOUTH);
		add(east, BorderLayout.EAST);
		add(west, BorderLayout.WEST);
		add(center, BorderLayout.CENTER);

		//override the windowClosing event
		addWindowListener(
			new WindowAdapter()
				{
				public void windowClosing(WindowEvent e)
					{
					   System.exit(0);
					}
				}
		);

	}

   	public static void main(String[] args)
   	{
	   	// set frame properties
		Borders f = new Borders();
      	f.setTitle("Border Application");
      	f.setBounds(200,200,300,300);
	    f.setVisible(true);
   }
}