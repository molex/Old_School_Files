/*
	Chapter 5:	Reserve a Party Room
	Programmer:	Mike Brown
	Date:		March 30, 2009
	Filename:	Reservations.java
	Purpose:	This Program creates a windowed application to reserve a party room.
			It calls an external class named Rooms.
*/

import javax.swing.JOptionPane;
import java.awt.*;
import java.awt.event.*;

public class Reservations extends Frame implements ActionListener
{
	Color lightRed = new Color(255,90,90);
	Color lightGreen = new Color(140,215,40);

	Rooms room = new Rooms(5,3);

	Panel roomPanel = new Panel();
		TextArea roomDisplay[] = new TextArea[9];

	Panel buttonPanel = new Panel();
		Button bookButton = new Button("Book Room");

	Panel inputPanel = new Panel();
		Label custNameLabel = new Label ("Name");
		TextField nameField = new TextField(15);
		Label custPhoneLabel = new Label("Phone Number");
		TextField phoneField = new TextField(15);
		Label numLabel = new Label("Number in party:");
		Choice numberOfGuests = new Choice();
		CheckboxGroup options = new CheckboxGroup();
			Checkbox nonSmoking = new Checkbox("Nonsmoking", false, options);
			Checkbox smoking = new Checkbox("Smoking", false, options);
			Checkbox hidden = new Checkbox("", true, options);

	public Reservations()
	{
		//set Layouts for frame and three panels
		this.setLayout(new BorderLayout());
			roomPanel.setLayout(new GridLayout(2,4,10,10));
			buttonPanel.setLayout(new FlowLayout());
			inputPanel.setLayout(new FlowLayout());

		//add components to room panel
		for (int i=1; i<9; i++)
		{
			roomDisplay[i] = new TextArea(null,3,5,3);
			if(i<6)
				roomDisplay[i].setText("Room " + i + " Nonsmoking");
			else
				roomDisplay[i].setText("Room " + i + " Smoking");
			roomDisplay[i].setEditable(false);
			roomDisplay[i].setBackground(lightGreen);
			roomPanel.add(roomDisplay[i]);
		}

		//add components to button panel
		buttonPanel.add(bookButton);

		//add components to input panel
		inputPanel.add(custNameLabel);
		inputPanel.add(nameField);
		inputPanel.add(custPhoneLabel);
		inputPanel.add(phoneField);
		inputPanel.add(numLabel);
		inputPanel.add(numberOfGuests);
			for(int i=8; i<=20; i++)
				numberOfGuests.add(String.valueOf(i));
		inputPanel.add(nonSmoking);
		inputPanel.add(smoking);

		//add panels to frame
		add(buttonPanel, BorderLayout.SOUTH);
		add(inputPanel, BorderLayout.CENTER);
		add(roomPanel, BorderLayout.NORTH);

		bookButton.addActionListener(this);

		//overriding the windowClosing() method will allow the user to click the Close button
		addWindowListener(
			new WindowAdapter()
			{
				public void windowClosing(WindowEvent e)
				{
					System.exit(0);
				}
			}
		);
	}//end of constructor method

	public static void main(String[] args)
	{
		Reservations f = new Reservations();
		f.setBounds(200,200,600,300);
		f.setTitle("Reserve a Party Room");
		f.setVisible(true);
	}//end of main

	public void actionPerformed(ActionEvent e)
	{
		if (hidden.getState())
		{
			JOptionPane.showMessageDialog(null, "You must select Nonsmoking or Smoking.", "Error", JOptionPane.ERROR_MESSAGE);
		}
		else
		{
			int available = room.bookRoom(smoking.getState());

			if(available > 0) //room is available
			{
				roomDisplay[available].setBackground(lightRed); //display room as occupied
				roomDisplay[available].setText(
												roomDisplay[available].getText() +
												"\n" +
												nameField.getText() +
												" " +
												phoneField.getText() +
												"\nparty of " +
												numberOfGuests.getSelectedItem()
											); //display info in room
				clearFields();
			}
			else //room is not available
			{
				if(smoking.getState())
					JOptionPane.showMessageDialog(null, "Smoking is full.", "Error", JOptionPane.INFORMATION_MESSAGE);
				else
					JOptionPane.showMessageDialog(null, "NonSmoking is full.", "Error", JOptionPane.INFORMATION_MESSAGE);
				hidden.setState(true);
			}//end of else block that checks the available room number
		}//end of else block that checks the state of the hidden option button
	}//end of the actionPerformed() method

	//reset the text fields and choice component
	void clearFields()
	{
		nameField.setText("");
		phoneField.setText("");
		numberOfGuests.select(0);
		nameField.requestFocus();
		hidden.setState(true);
	}//end of clearFields() method

}//end of Reservation class