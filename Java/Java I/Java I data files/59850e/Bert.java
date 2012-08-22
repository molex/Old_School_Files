/*
   Project 2       Inputting Data
   Programmer:	   Joy Starks
   Date: 	   October 9, 2001
   Program Name:   BertIO
*/

import java.io.*;

public class Bert
{
   public static void main(String[] args) throws IOException
   {

   BufferedReader dataIn = new BufferedReader(new InputStreamReader(System.in));

   //Declaring Variables
   String custName;
   int price;
   int downPayment;
   int tradeIn;
   int months;
   double annualInterest;
   double interest;
   int loanAmt;
   double payment;
   String strPrice;
   String strDownPayment;
   String strTradeIn;
   String strMonths;
   String strAnnualInterest;

   //Get Input from User
   System.out.print("What is your name? ");
      custName = dataIn.readLine();
   System.out.print("\nWhat is the price of the car? ");
      strPrice = dataIn.readLine();
   System.out.print("\nWhat is the downpayment? ");
      strDownPayment = dataIn.readLine();
   System.out.print("\nWhat is the trade-in value? ");
      strTradeIn = dataIn.readLine();
   System.out.print("\nFor how many months is the loan? ");
      strMonths = dataIn.readLine();
   System.out.print("\nWhat is the decimal interest rate? ");
      strAnnualInterest = dataIn.readLine();

   //Conversions
   price = Integer.parseInt(strPrice);
   downPayment = Integer.parseInt(strDownPayment);
   tradeIn = Integer.parseInt(strTradeIn);
   months = Integer.parseInt(strMonths);
   annualInterest =Double.parseDouble(strAnnualInterest);

   //Calculations
   interest = annualInterest/12;
   loanAmt = price-downPayment-tradeIn;
   payment=loanAmt/((1/interest)-(1/(interest*Math.pow(1+interest,months))));

   //Output
   System.out.print("\nThe monthly payment for " + custName + " is $");
   System.out.println(Math.round(payment));
   System.out.println();
   }
}