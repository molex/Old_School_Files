import java.util.Arrays;//import array



public class ProductList //begin class
        
        
        
{
    
    public static void main( String args[] )  //begin main
    
    
    
    {
        
        
        
        final int arrayLength = 2; //declaration of a constant
        
        
        
        int productNum[] = new int[ arrayLength ];
        
        
        
        String productName[] = new String[] { "DVD" , "CD"};
        
        
        
        int productUnits[] = { 100,300  };
        
        
        
        double productPrice[] = { 10.00, 5.00};
        
        
        
        double productValue[] = new double[ arrayLength ];
        
        
        
        sortProductName( productName );//calls sort info by product name
        
        
        
        for ( int counter = 0 ; counter < productNum.length;counter++ )
            
            
            
            System.out.println( "\nProduct number: " + (productNum[counter ] = 1 + counter) +
                    
                    "\nProduct name: " + productName[ counter ] +
                    
                    "\nUnits in stock: " + productUnits[ counter ] +
                    
                    "\nPrice per unit: \u0024" + productPrice[ counter ] +
                    
                    "\nProduct value: \u0024" + (productValue[ counter ] = productUnits[counter ] * productPrice[ counter ]) );
        
        
        outputTotalValue( productValue );
        
        
        
    }
    
    
    
    public static void outputTotalValue( double productValue[] )
    
    
    
    {
        
        
        
        double totalProductValue = 0;
        
        for ( int counter = 0; counter < productValue.length; counter++ )
            
            
            
            totalProductValue += productValue[ counter ];// creates total inventory amount
        
        
        
        System.out.printf( "\nTotal value for all products: \u0024" + totalProductValue + "\n\n" );
        
        
        
    }
    
    
    
    
    
    
    
    public static void sortProductName( String productName[] )    //sorts productName by array
    
    
    
    {
        
        
        
        Arrays.sort( productName );
        
        
        
        
        
    }
    
    
    
}

