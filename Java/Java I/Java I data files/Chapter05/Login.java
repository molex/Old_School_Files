/*
	Chapter 5:	Programming Assignment 4
	Programmer:
	Date:
	Filename:	Login.java

*/


public class Login extends Applet implements ActionListener
{
   //Declaring variables
   String id, password;
   boolean success;

   //Create components for applet
   Label headerLabel = new Label("Please type your ID and Password");

   Label idLabel = new Label("ID:");
      TextField idField = new TextField(8);

   Label passwordLabel = new Label("Password:");
      TextField passwordField = new TextField(8);


   Button loginButton = new Button("Login");

   public void init()
   {
      //Set color, layout, and add components
      setBackground(Color.orange);

      setLayout(new FlowLayout(FlowLayout.LEFT,50,30));

      add(headerLabel);

      add(idLabel);
         add(idField);
         idField.requestFocus();

      add(passwordLabel);
         add(passwordField);
 		 passwordField.setEchoChar('*');

      add(loginButton);
         loginButton.addActionListener(this);
   }

   public void actionPerformed(ActionEvent e)
   {
      success = false;

      //Sequential search

   }
}