/*
   Java II     	   GUI Mortgage calculator
   Programmer:	   Mike Brown
   Date:		   May 15, 2009
   Program Name:   MortgageClassy.java
   Version:		   1.0 (previously version 4.0 of original Mortgage program)
   Purpose:		   Calculate loan information in GUI.
*/

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.*;

import java.text.*;

public class MortgageClassy extends JPanel implements ActionListener {

    //Default values for the text fields
    private double amount = 0;
    private double rate = .00;
    private int numPeriods = 0;

    //Labels to identify the fields
    private JLabel amountLabel;
    private JLabel rateLabel;
    private JLabel numPeriodsLabel;
    private JLabel paymentLabel;

    //Button for Calculation
    private JButton calcButton;

    //Strings for the labels & Button
    private static String amountString = "Loan Amount: ";
    private static String rateString = "Interest Rate(%): ";
    private static String numPeriodsString = "Term: ";
    private static String paymentString = "Monthly Payment: ";
    private static String buttonString = "Calculate Payment";

    //Fields for data entry
    private JFormattedTextField amountField;
    private JFormattedTextField rateField;
    private JFormattedTextField numPeriodsField;
    private JFormattedTextField paymentField;

    //Formats to format and parse numbers
    private NumberFormat amountDisplayFormat;
    private NumberFormat amountEditFormat;
    private NumberFormat percentDisplayFormat;
    private NumberFormat percentEditFormat;
    private NumberFormat paymentFormat;

    public MortgageClassy() {
        super(new BorderLayout());
        setUpFormats();
        double payment = computePayment(amount,
                                        rate,
                                        numPeriods);

        //Create the labels.
        amountLabel = new JLabel(amountString);
        rateLabel = new JLabel(rateString);
        numPeriodsLabel = new JLabel(numPeriodsString);
        paymentLabel = new JLabel(paymentString);

        //create the Button
        calcButton = new JButton(buttonString);

        //Create the text fields
        amountField = new JFormattedTextField(
                      new DefaultFormatterFactory(
                      new NumberFormatter(amountDisplayFormat),
                      new NumberFormatter(amountDisplayFormat),
                      new NumberFormatter(amountEditFormat)));
        amountField.setValue(new Double(amount));
        amountField.setColumns(10);


        NumberFormatter percentEditFormatter =
                new NumberFormatter(percentEditFormat) {
            public String valueToString(Object o)
                  throws ParseException {
                Number number = (Number)o;
                if (number != null) {
                    double d = number.doubleValue() * 100.0;
                    number = new Double(d);
                }
                return super.valueToString(number);
            }
            public Object stringToValue(String s)
                   throws ParseException {
                Number number = (Number)super.stringToValue(s);
                if (number != null) {
                    double d = number.doubleValue() / 100.0;
                    number = new Double(d);
                }
                return number;
            }
        };
        rateField = new JFormattedTextField(
                             new DefaultFormatterFactory(
                             new NumberFormatter(percentDisplayFormat),
                             new NumberFormatter(percentDisplayFormat),
                             percentEditFormatter));
        rateField.setValue(new Double(rate));
        rateField.setColumns(10);


        numPeriodsField = new JFormattedTextField();
        numPeriodsField.setValue(new Integer(numPeriods));
        numPeriodsField.setColumns(10);


        paymentField = new JFormattedTextField(paymentFormat);
        paymentField.setValue(new Double(payment));
        paymentField.setColumns(10);
        paymentField.setEditable(false);

        //Set label/textfield pairs.
        amountLabel.setLabelFor(amountField);
        rateLabel.setLabelFor(rateField);
        numPeriodsLabel.setLabelFor(numPeriodsField);
        paymentLabel.setLabelFor(paymentField);

        //Add labels to the JPanel
        JPanel labelPane = new JPanel(new GridLayout(0,1));
        labelPane.add(amountLabel);
        labelPane.add(rateLabel);
        labelPane.add(numPeriodsLabel);
        labelPane.add(paymentLabel);


        //Add text fields to the JPanel
        JPanel fieldPane = new JPanel(new GridLayout(0,1));
        fieldPane.add(amountField);
        fieldPane.add(rateField);
        fieldPane.add(numPeriodsField);
        fieldPane.add(paymentField);

        //Add button to the JPanel
        JPanel buttonPane = new JPanel(new GridLayout(0,1));
        buttonPane.add(calcButton);
        calcButton.addActionListener(this);

        //Add all the Panes to the main Panel
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(labelPane, BorderLayout.CENTER);
        add(fieldPane, BorderLayout.LINE_END);
        add(buttonPane, BorderLayout.SOUTH);
    }

    public void actionPerformed(ActionEvent e){

		 amount = ((Number)amountField.getValue()).doubleValue();
		 rate = ((Number)rateField.getValue()).doubleValue();
		 numPeriods = ((Number)numPeriodsField.getValue()).intValue();
		 double payment = computePayment(amount, rate, numPeriods);
		 paymentField.setValue(new Double(payment));
	}

     //Create the GUI and show it.

    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("Mortgage Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Add frame to the window.
        frame.add(new MortgageClassy());

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {

        //creating and showing this GUI.
        SwingUtilities.invokeLater(new Runnable() {

            public void run() {

                createAndShowGUI();
            }
        });
    }

    //Compute the monthly payment based on the loan amount,
    //Interest Rate, and term of loan.
    double computePayment(double loanAmt, double rate, int numPeriods) {

        double interest, principal, monthlyInterest, payEachMonth;

        numPeriods *= 12;        //get number of months from total years
        if (rate > 0.001) {
            interest = rate / 12.0;         //get monthly rate from annual interest
            principal = Math.pow((1 + interest), (0.0 - numPeriods));
            monthlyInterest = (1 - principal) / interest;
        } else { //rate ~= 0
            monthlyInterest = numPeriods;
        }

        payEachMonth = (-1 * loanAmt) / monthlyInterest;
        return -(payEachMonth);
    }

    //Format and parse numbers
    private void setUpFormats() {
        amountDisplayFormat = NumberFormat.getCurrencyInstance();
        amountDisplayFormat.setMinimumFractionDigits(0);
        amountEditFormat = NumberFormat.getNumberInstance();

        percentDisplayFormat = NumberFormat.getPercentInstance();
        percentDisplayFormat.setMinimumFractionDigits(2);
        percentEditFormat = NumberFormat.getNumberInstance();
        percentEditFormat.setMinimumFractionDigits(2);

        paymentFormat = NumberFormat.getCurrencyInstance();
    }
}
