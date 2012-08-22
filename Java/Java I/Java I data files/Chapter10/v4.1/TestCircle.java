import java.text.DecimalFormat;

public class TestCircle
{
	public static void main(String[] args)
	{
		DecimalFormat showTwoDecimals = new DecimalFormat( "0.00" );
		Circle c1 = new Circle(2.5, 22, 44);

		System.out.println("This shape is a " + c1.getName() +
               			   "\nlocated at " + c1.getLocation() +
               			   "\nRadius is " + c1.getRadius());

        System.out.println("The shape area is: " + showTwoDecimals.format(c1.area())+"\n");

        c1.setRadius(4.25);

        System.out.println("\nThe changed shape is:\n" +
        					c1 + "\nArea is " + showTwoDecimals.format(c1.area())+"\n");
   }
}