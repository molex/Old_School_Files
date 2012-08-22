/*
	Chapter 2:	Programming Assignment 1
	Programmer: Mike Brown
	Date:		March 26, 2009
	Filename:	DoiliesApplet.java
	Purpose:	This project displays a the name, address and
				web page address as a console application.
*/
import java.awt.*;
import java.applet.*;

public class DoiliesApplet extends Applet{
	public void paint(Graphics g){
		g.drawString("Comming soon...!", 100,70);
		g.drawString("Order doilies online at", 100,100);
		g.drawString("www.DonnasDutchDoilies.com", 100,130);
		setBackground(Color.yellow);
	}
}