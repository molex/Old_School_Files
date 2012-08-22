/*
 * This is a control that subclasses the
 * JTextField class and through a keyboard
 * listener only allows numeric input, decimal point
 * and backspace into the text field.
 * 
 * Known Problems!!!: 
 * 1) It will not catch if the user
 *    enters two decimal points
 */


import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTextField;


/*
   A JTextField subclass component that
   only allowing numeric input.   
*/
class NumericTextField extends JTextField
{
    private void setUpListener()
	 {
        addKeyListener(new KeyAdapter() {

            public void keyTyped(KeyEvent e)
            {
				    char c = e.getKeyChar();
                if(!Character.isDigit(c) && c != '.' && c != '\b' && c != '\n' && c != '\177')
                {
                    Toolkit.getDefaultToolkit().beep();
                    e.consume();
                }
            }

        });
	 }
    
    public NumericTextField(int i)
	 {
	    super(i);
		 setUpListener();
    }
	 
    public NumericTextField()
    {
    	 setUpListener();
    }
}
