/*
   Project 8      Stock
   Programmer:    [Type your name here]
   Date:          [Type the date here]
   Program Name:  Stock
*/

import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;

public class Stock extends Frame implements ActionListener
{
   //Declare an input variable
   DataInputStream input;

   //Construct components

   public static void main(String[] args)
   {
      Stock window = new Stock();
      window.setTitle("Yesterday's 10 Hottest Stocks");
      window.setSize(300, 175);
      window.setVisible(true);
   }

   public Stock()
   {
     //Set colors

     //Set layout managers

     //Add components and actionListener to interface

     try
     {
        //Open the file
        input = new DataInputStream(new FileInputStream("hotStocks.dat"));
     }
     catch(IOException ex)
     {
        closeFile();
     }

     //Construct window listener
     addWindowListener(
        new WindowAdapter()
           {
               public void windowClosing(WindowEvent e)
               {
                  closeFile();
               }
           }
      );
   }

   public void actionPerformed(ActionEvent e)
   {
 //     try
      {
         //Read the data into the text fields
      }
  //    catch(IOException e2)
      {
         //Print End of file message and clear fields
      }
   }

   public void closeFile()
   {
      try
      {
         input.close();
      }
      catch(IOException c)
      {
         System.exit(1);
      }
      System.exit(0);
   }
}

