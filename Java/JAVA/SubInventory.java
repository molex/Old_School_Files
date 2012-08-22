public class SubInventory extends Inventory
{//start subcalss Inventory
String title;
double array[]={3,50,10.00};
double sum;
    
    
    public void outputtotalvalue()
    {
        
        title = "Pulp Fiction";
        sum = (array[1]*array[2]) + (array[1]*array[2]*.05);
        JOptionPane.showMessageDialog(null,"\ntitle: " + " \nSub-category of DVD's" + "\nProduct number is: %.0f\n",(array[0])" +
        	"\nQuantity: %.0f\n", array[1]" +
        	"\nCost:$ %.2f\n", array[2]"	+
        	"Total value of sub-category-Pulp Fiction plus 5 percent restocking fee:$ %.2f\n", sum );
       // System.out.println(title);
        //System.out.println("Sub-category of DVD's");
        //System.out.printf("Product number is: %.0f\n",array[0]);//display item number
        //System.out.printf("Quantity: %.0f\n", array[1]);//display quantity
       // System.out.printf("Cost:$ %.2f\n", array[2]);	//display cost
		//System.out.printf("Total value of sub-category-Pulp Fiction plus 5 percent restocking fee:$ %.2f\n", sum);//display inventory amount
       // System.out.println(); 
    }
}