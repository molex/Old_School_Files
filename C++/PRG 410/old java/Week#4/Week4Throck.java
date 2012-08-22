/* 	Individual Assignment Week 4
	Susan Throckmorton
	May 29, 2009
	Purpose:

	Code downloaded from PRG-421 from author Brian Enochson(Date: Nov 22,2005)


Program-Filename: Week3.java


Purpose: Individual Assignment # 4 - Modify the mortgage program for Week Three to read the interest rates to fill the array from a sequential file.
Insert comments in the program to document the program.
The file should have the rates 7 year at 5.35%, 15 year at 5.5 %, and 30 year at 5.75% in a file,
each rate/year pair on a separate line.  You can format the file to have fixed length for the fields or be comma separated.
It is important you use them to fill and array and then use this array to populate you JComboBox.
In other words, if I change the input file and then restart the application I should see the new value I entered.
Do not hard code the values being added to the JComboBox.
Important will be doing the proper exception and error handling so that errors
such as file not found, improper format and invalid data type (i.e. non numeric).


The Amortization Schedule was constructed with my own class called AmortFrame
that extends JFrame and a JTextArea that was added to a JScrollPane.
 */

// Imports needed libraries
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import java.io.*;		// imports Java input and output
import java.util.*;		// imports utilities
import java.lang.*;		// import Java language
import java.text.*;		// import java text

// Event handling:implements listener interface for receiving action events.
public class Week4Throck implements ActionListener {
	// used to get rid of pesky warning
	static final long serialVersionUID = 2l;

	// GUI Components
	JFrame calculatorFrame;
	JPanel calculatorPanel;
	AmortizeFrame amortFrame; // local class for amortization schedule

	// user input fields
	// Loan amount entered as user text input from keyboard
	// Term (in years) selected from a combo box
	// Rate (%) selected from a combo box
	//
	NumericTextField loan;
	JComboBox rate;
	JComboBox term;

	 private NumericTextField  	loanAmountTextField,
	    						monthlyPaymentTextField,
    							amortTextField;


	// set up arrays for the selectable term and rate
	//

	int[] lengthYrs = new int[3];
	double[] intRate = new double[3];
	String[] timeStrings = new String[3];
	String[] rateStrings = new String[3];


	//int[] loanTerm = new int[3];
	//String[] loanTermString = new String[3];
	//double[] loanRate = new double[3];
	//String[] loanRateString = new String[3];

	// static variables, belong to class on not an instance
	static String sWindowTitle = "Susan's Building and Trust Week 4 - Mortgage Calculator";
	static String scolHeader = "Payment#\tPayment\tInterest\tCumInterest\tPrincipal\tBalance\n";
	static String slineOut = "________\t_______\t________\t___________\t_________\t_______\n";
	static String sfinalInstructions1 = "\nYou can leave windows open and enter new value or close either window to exit\n";

	JLabel loanLabel, termLabel, rateLabel, pmtLabel;
	JButton calculate;

	public Week4Throck() {

		// Before progressing, read in the data
		//
		if (readData()) {
			// Create and set up the window.
			calculatorFrame = new JFrame(sWindowTitle);
			calculatorFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			// Set size of user input frame;
			calculatorFrame.setBounds(0, 0, 200, 200);

			// Create and set up the panel with 4 rows and 4 columns.
			calculatorPanel = new JPanel(new GridLayout(4, 4));

			// Add the widgets.
			addWidgets();

			// Set the default button.
			calculatorFrame.getRootPane().setDefaultButton(calculate);

			// Add the panel to the window.
			calculatorFrame.getContentPane().add(calculatorPanel,
					BorderLayout.CENTER);

			// Display the window.
			calculatorFrame.pack();
			calculatorFrame.setVisible(true);
		}// good data read
	}// end constructor

	//
	//

	/**
	* Create a method called displayError that writes an error to the console using System.out.println()
	*
	*/

	public void displayError(String displayError)
	{
		System.out.println(displayError);
	}


	private boolean readData()    {

	       // flag is successful reading, be optimistic and

	       // set to true.

	       boolean isValid = true;



	        String sFileName = "Week4_Data.txt";

	              // open file

	       File rateYearsFile = new File(sFileName);



	       // if it was found then proceed

	       if(rateYearsFile.exists()) {



	              // wrap in a try ... catch block

	              try {



	                     // used BufferedReader, could use new Scanner class also

	                     BufferedReader br = new BufferedReader (new FileReader (rateYearsFile));

	                     String tempStr;

	                     StringTokenizer st;

	                     int count = 0;

	                     String s1;

	                     String s2;

	                     while((tempStr = br.readLine()) != null) {

	                           // remove trailing spaces.

	                           tempStr = tempStr.trim();

	                           // this little check is in case there are blank lines at the end.

	                           if(tempStr.length() < 3)

	                                  continue;

	                           st = new StringTokenizer (tempStr, ",");

	                           s1 = st.nextToken();

	                           s2 = st.nextToken();



	                           lengthYrs[count] = Integer.parseInt(s1);

	                           intRate[count] = Double.parseDouble(s2);

	                           timeStrings[count] = s1 + " years";

	                           rateStrings[count] = s2 + "%";

	                           count++;

	                     } // end while

	                     br.close();

	              } // end try

	              catch(Exception ex)  {



	                  System.out.println (ex.toString());

	                     displayError("Error reading " + rateYearsFile.getAbsolutePath() +

	                                  "\n   Check format of file");



	                  isValid = false;

	              } // end catch

	       } // end if (rateYearsFile.exists())

	       else {

	                     displayError("Could not find input file at " + rateYearsFile.getAbsolutePath());

	                     isValid = false;

	       }

	       return isValid;

       }// end readData


	// Creates and adds the widgets to the user input frame.
	private void addWidgets() {
		// NumericTextField is a JTextField with some error checking for
		// non numeric values.
		loan = new NumericTextField();
		rate = new JComboBox(loanRateString);
		term = new JComboBox(loanTermString);

		loanLabel = new JLabel("Loan Amount", SwingConstants.LEFT);
		termLabel = new JLabel(" Term ", SwingConstants.LEFT);
		rateLabel = new JLabel("  Interest Rate ", SwingConstants.LEFT);
		calculate = new JButton("Calculate");
		pmtLabel = new JLabel("Monthly Payment", SwingConstants.LEFT);

		// Listen to events from the Calculate button.
		calculate.addActionListener(this);

		// Add the widgets to the container.
		calculatorPanel.add(loan);
		calculatorPanel.add(loanLabel);
		calculatorPanel.add(term);
		calculatorPanel.add(termLabel);
		calculatorPanel.add(rate);
		calculatorPanel.add(rateLabel);
		calculatorPanel.add(calculate);
		calculatorPanel.add(pmtLabel);

		// set label border size
		loanLabel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		pmtLabel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
	} // end addWidgets

	// Event handling method invoked when an action occurs.
	// Processes each of the fields and includes error checking
	// to make sure each field has data in it and then calculates
	// actual payment.
		public void actionPerformed(ActionEvent event) {
		double tamount = 0; // provides floating point for total amount of the
							// loan
		int term1 = 0; // provides int for the term
		double rate1 = 0; // provides floating point for the percentage rate.

		// get string to test that user entered
		String testit = loan.getText(); // get user entered loan amount

		// if string is present
		if (testit.length() != 0) {
			tamount = (double) (Double.parseDouble(testit)); // convert to
																// double

			// first value valid - check second one, term value
			// get the index of the item the user selected
			// then get the actual value of the selection from the
			// loanTerm array
			int boxIndex = term.getSelectedIndex();
			if (boxIndex != -1) {
				term1 = loanTerm[boxIndex];
				// second value valid - check third one, interest rate
				// get the index of the item the user selected
				// then get the actual value of the selection from the
				// loanRate array
				boxIndex = rate.getSelectedIndex();

				// if something is selected in rate combo box
				if (boxIndex != -1) {
					rate1 = loanRate[boxIndex];
					//
					// all three values were good so calculate the payment
					double payment = ((tamount * (rate1 / 1200)) / (1 - Math
							.pow(1 + rate1 / 1200, -term1 * 12)));

					// format string using a mask
					java.text.DecimalFormat dec = new java.text.DecimalFormat(
							",###.00");
					String pmt = dec.format(payment);

					// change foreground color of font for this label
					pmtLabel.setForeground(Color.green); //

					// set formatted payment
					pmtLabel.setText(pmt);

					// generate the amortization schedule
					amortize(tamount, rate1 * .01, term1 * 12, payment);
				} else // third value was bad
				{
					Toolkit.getDefaultToolkit().beep(); // invokes audible beep
					pmtLabel.setForeground(Color.red); // sets font color
					pmtLabel.setText("Missing Field or bad value"); // Error
																	// Message
				}// end validate third value

			} else // second value was bad
			{
				Toolkit.getDefaultToolkit().beep();
				pmtLabel.setForeground(Color.red);
				pmtLabel.setText("Missing Field or bad value");
			}// end validate second value

		} else // first value was bad
		{
			Toolkit.getDefaultToolkit().beep();
			pmtLabel.setForeground(Color.red);
			pmtLabel.setText("Missing Field or bad value");
		}// end validate first value

	}// end actionPerformed

	//
	// calculate the loan balance and interest paid for each payment over the
	// term of the loan and list it in a separate window - one line per payment.
	//
		public void amortize(double principal, double APR, int term,
			double monthlyPayment) {
		double monthlyInterestRate = APR / 12;
		// double totalPayment = monthlyPayment * term;
		int payment = 1;
		double balance = principal;
		int num = 0;
		double monthlyInterest;
		double cumInterest = 0;

		// if the frame for the amortization schedule has not been created
		// yet, create it.
		if (amortFrame == null) {
			amortFrame = new AmortizeFrame();
		}

		// obtain a reference to our text area in our frame
		// and update this as we go through
		JTextArea amortText = amortFrame.getAmortText();

		// formatting mask
		java.text.DecimalFormat df = new java.text.DecimalFormat(",###.00");

		// set column header
		amortText.setText(scolHeader);
		amortText.append(slineOut);

		// loop through our amortization table and add to
		// JTextArea
		while (num < term) {
			monthlyInterest = monthlyInterestRate * balance;
			cumInterest += monthlyInterest;
			principal = monthlyPayment - monthlyInterest;
			balance -= principal;

			// Show Amortization Schedule
			amortText.append(String.valueOf(payment));
			amortText.append("\t ");
			amortText.append(df.format(monthlyPayment));
			amortText.append("\t ");
			amortText.append(df.format(monthlyInterest));
			amortText.append("\t ");
			amortText.append(df.format(cumInterest));
			amortText.append("\t ");
			amortText.append(df.format(principal));
			amortText.append("\t ");
			amortText.append(df.format(balance));
			amortText.append("\n");
			payment++;
			num++;
		}

		// print the headers one more time at the bottom
		amortText.append(slineOut);
		amortText.append(scolHeader);
		amortText.append(sfinalInstructions1);

	}// end amortize

	/**
	 * Create the GUI and show it. For thread safety, this method should be
	 * invoked from the event-dispatching thread.
	 */
	private static void createAndShowGUI() {
		// Make sure we have nice window decorations.
		// Note this next line only works with JDK 1.4 and higher
		JFrame.setDefaultLookAndFeelDecorated(true);
		new Week4Throck();
	}

	// main method
	//
	public static void main(String[] args) {
		// allow user to set a different file from
		// command line

		// Schedule a job for the event-dispatching thread:
		// creating and showing this application's GUI.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}
}// end class

