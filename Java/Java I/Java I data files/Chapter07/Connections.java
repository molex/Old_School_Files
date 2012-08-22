/*
	Chapter 7:	Connections
	Programmer:
	Date:
	Filename:	Connections.java
	Purpose:	This program creates a Swing interface Modem Connections
*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.*;

public class Connections extends JFrame implements ActionListener
{
 	//construct components
  	JComboBox firstCombo = new JComboBox();
  	JComboBox secondCombo = new JComboBox();
	JTextPane textPane = new JTextPane();

 	//construct instance of Connections
  	public Connections()
   	{
 	}

	//create the menu system
	public JMenuBar createMenuBar()
	{
		//create an instance of the menu
		setJMenuBar(mnuBar);

		//construct and populate the File menu
		JMenu mnuFile =new JMenu("File", true);
			mnuFile.setDisplayedMnemonicIndex(0);
			mnuBar.add(mnuFile);

			JMenuItem mnuFileExit = new JMenuItem("Exit");
				mnuFileExit.setDisplayedMnemonicIndex(1);
				mnuFile.add(mnuFileExit);
				mnuFileExit.setActionCommand("Exit");
				mnuFileExit.addActionListener(this);

		//construct and populate the Edit menu
		JMenu mnuEdit = new JMenu("Edit", true);
			mnuEdit.setDisplayedMnemonicIndex(0);
			mnuBar.add(mnuEdit);

			JMenuItem mnuEditInsert = new JMenuItem("Insert New Connections");
				mnuEditInsert.setDisplayedMnemonicIndex(0);
				mnuEdit.add(mnuEditInsert);
				mnuEditInsert.setActionCommand("Insert");
				mnuEditInsert.addActionListener(this);

			JMenu mnuEditSearch = new JMenu("Search");
					mnuEditSearch.setDisplayedMnemonicIndex(3);
					mnuEdit.add(mnuEditSearch);

				JMenuItem mnuEditSearchByConnection = new JMenuItem("by Connection");
					mnuEditSearchByConnection.setDisplayedMnemonicIndex(3);
					mnuEditSearch.add(mnuEditSearchByConnection);
					mnuEditSearchByConnection.setActionCommand("title");
					mnuEditSearchByConnection.addActionListener(this);

				JMenuItem mnuEditSearchBySpeed = new JMenuItem("by Speed");
					mnuEditSearchBySpeed.setDisplayedMnemonicIndex(3);
					mnuEditSearch.add(mnuEditSearchBySpeed);
					mnuEditSearchBySpeed.setActionCommand("studio");
					mnuEditSearchBySpeed.addActionListener(this);

				JMenuItem mnuEditSearchByProtocol = new JMenuItem("by Protocol");
					mnuEditSearchByProtocol.setDisplayedMnemonicIndex(3);
					mnuEditSearch.add(mnuEditSearchByProtocol);
					mnuEditSearchByProtocol.setActionCommand("year");
					mnuEditSearchByProtocol.addActionListener(this);

		return mnuBar;
	}

	//create the content pane
	public Container createContentPane()
	{
		//populate the JComboBox
		fieldCombo.addItem("Dial-Up");
		fieldCombo.addItem("DSL");
		fieldCombo.addItem("Cable");
				fieldCombo.addItem("Satellite");

		fieldCombo.addActionListener(this);
		fieldCombo.setToolTip("Click the drop down arrow to display connection types.");

		//populate the JComboBox
		secondCombo.addItem("57600");
		secondCombo.addItem("2304000");
		secondCombo.addItem("460800");
				secondCombo.addItem("921600");

		secondCombo.addActionListener(this);
		secondCombo.setEditable(true);

		//construct and populate the north panel
		JPanel northPanel = new JPanel();
			northPanel.setLayout(new FlowLayout());
			//northPanel.add(sortPrompt);
			northPanel.add(fieldCombo);
			northPanel.add(secondCombo);

		//create the JTextPane and center panel
		JPanel centerPanel = new JPanel();
			setTabsAndStyles(textPane);
			JTextPane internalTextPane = addTextToTextPane();
			JScrollPane paneScrollPane = new JScrollPane(internalTextPane);
				paneScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
				paneScrollPane.setPreferredSize(new Dimension(500, 200));
			centerPanel.add(paneScrollPane);

		//create Container and set attributes
		Container c = getContentPane();
			c.setLayout(new BorderLayout(10,10));
			c.add(northPanel,BorderLayout.NORTH);
			c.add(centerPanel,BorderLayout.CENTER);

		return c;
	}

	//method to create tab stops and set font styles
	protected void setTabsAndStyles(JTextPane textPane)
	{
		//create Tab Stops
		TabStop[] tabs = new TabStop[2];
			tabs[0] = new TabStop(200, TabStop.ALIGN_LEFT, TabStop.LEAD_NONE);
			tabs[1] = new TabStop(350, TabStop.ALIGN_LEFT, TabStop.LEAD_NONE);
		TabSet tabset = new TabSet(tabs);

		//set Tab Style
		StyleContext tabStyle = StyleContext.getDefaultStyleContext();
		AttributeSet aset =
				tabStyle.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.TabSet, tabset);
		textPane.setParagraphAttributes(aset, false);

		//set Font Style
		Style fontStyle =
				StyleContext.getDefaultStyleContext().getStyle(StyleContext.DEFAULT_STYLE);

		Style regular = textPane.addStyle("regular", fontStyle);
		StyleConstants.setFontFamily(fontStyle, "SansSerif");

		Style s = textPane.addStyle("italic", regular);
		StyleConstants.setItalic(s, true);

		s = textPane.addStyle("bold", regular);
		StyleConstants.setBold(s, true);

		s = textPane.addStyle("large", regular);
		StyleConstants.setFontSize(s, 16);
	}

	//method to add new text to the JTextPane
   	public JTextPane addTextToTextPane()
   	{
   		Document doc = textPane.getDocument();
   		try
   		{
			//clear previous text
			doc.remove(0,doc.getLength());

			//insert title
			doc.insertText(0,"\nCONNECTIONS\tNUMBERS\t PROTOCOLS\n", textPane.getStyle("regular"));

  }
   		catch (BadLocationException ble)
   		{
   			System.err.println("Couldn't insert text.");
   		}

   		return textPane;
   	}

	//event to process user clicks
   	public void actionPerformed(ActionEvent e)
   	{

}
	//main method executes at run time
  	public static void main(String args[])
   	{
		JFrame.setDefaultLookAndFeelDecorated(true);
      	Connections f = new Connections();
      	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
		f.setJMenuBar(f.createMenuBar());
		f.setContentPane(f.createContentPane());
	    f.setSize(600,375);
      	f.setVisible(true);
   	}
}