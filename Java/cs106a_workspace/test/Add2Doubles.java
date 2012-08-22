import acm.program.*;

public class Add2Doubles extends DialogProgram{
	
	public void run(){
		println("This program adds two numbers.");
		double n1 = readDouble("Enter n1: ");
		double n2 = readDouble ("Enter n2 : ");
		double total = n1 + n2;
		println("The total is" + total + ".");
	}
}
