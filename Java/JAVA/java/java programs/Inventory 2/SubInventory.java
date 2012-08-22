import javax.swing.JOptionPane;//import gui ability
class SubInventory extends Inventory {//start subcalss Inventory
    String title;
    double array[]={3,50,10.00};
    double sum;
    
    
    public void outputtotalvalue() {
        
        title = "Pulp Fiction";
        sum = (array[1]*array[2]) + ((array[1]*array[2])*.05);
        JOptionPane.showMessageDialog(null, "\nProduct number: " + (array[0]) +
                "\nProduct Name: "+ (title) +
                "\nUnits In Stock: " + (array[1]) +
                "\nPrice Per Unit:\u0024" + (array[2]) +
                "\nProduct Value:\u0024" + (sum));
        
        
    }
}
