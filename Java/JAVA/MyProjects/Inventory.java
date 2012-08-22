//Mike Brown
//Inventory.java



public class Inventory//class name
{
			String product1;
            String product2;
            double array[]={123456,100,10.00,654321,300,5.00};
			double sum1;
			double sum2;	

	
     public void displayMessage()

            {//start display

            System.out.println( "\nWelcome to the Inventory Program!\n" );//welcome message for Inventory program

                 

            }//end display
            
     public void determineInventoryStatus1()//declare variables and determint inventory ststus

            {//start status1
            
			
			
            product1 = "DVD";//DVD category
            sum1 = array[1] * array[2];
            System.out.println(product1);//display title
            System.out.printf("Product number is: %.0f\n",array[0]);//display item number
            System.out.printf("Quantity: %.0f\n", array[1]);//display quantity
            System.out.printf("Cost:$ %.2f\n", array[2]);	//display cost
			System.out.printf("Total value of category-DVD:$ %.2f\n", sum1);//display inventory amount
            System.out.println();         
                        
            }//end product1
          
      public void determineInventoryStatus2()//declare and determine product2
      
      {//start ststus2
      		product2= "CD's";//CD category
      		sum2 = array[4] * array[5];
      		System.out.println(product2);//display title
            System.out.printf("Product number is: %.0f\n",array[3]);//display item number
            System.out.printf("Quantity: %.0f\n", array[4]);//display quantity
            System.out.printf("Cost:$ %.2f\n", array[5]);	//display cost
			System.out.printf("Total value of category-CD's:$ %.2f\n", sum2);//display inventory amount
			System.out.println();
      		
      }   //end status2  
      	
      	 
	 public void determineTotalInventory()//display total inventory amount
	 {//start total inv method
	 
	 	System.out.printf("Total inventory for both categories is:$ %.2f\n", sum1 + sum2 );
	 }	//end total method				

                       
                        
                        
                       

                     
          

	
	
	
	
}//end class