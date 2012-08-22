import acm.graphics.*;
import acm.program.*;

public class DrawRobot extends GraphicsProgram{
	public void run(){
		add(new GOval(205,0,80,80));
		add(new GOval(170,82,150,150));
		add(new GOval(135,232,200,200));
		add(new GOval(230,5,10,10));
		add(new GOval(250,5,10,10));
		add(new GOval(240,50,15,15));
		add(new GLabel("v"), 243,40);
	}
}
