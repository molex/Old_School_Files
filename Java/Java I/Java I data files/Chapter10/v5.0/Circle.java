public class Circle extends Shape
{
	private int x=0, y=0; // coordinates of the center
	private double radius;

    // Constructors
    public Circle()
    {
		setRadius(0);
    }

    public Circle(double r, int x, int y)
    {
      x = x;
      y = y;
      setRadius(r);
    }

    // Get radius of Circle
    public double getRadius()
    {
		return radius;
	}

    // Set radius of Circle
    public void setRadius(double r)
    {
		radius = ( r >= 0 ? r : 0 );
	}

    // Calculate area of Circle
    public double area()
    {
		return Math.PI * radius * radius;
	}

    // convert the Circle to a String
    public String toString()
    {
		return "Circle with center at (" + x + ", " + y + ")" +
               " and radius = " + radius;
    }

    // return the class name
    public String getName()
    {
		return "Circle";
	}

    // return the center location
    public String getLocation()
    {
		return "X = " + X + ", Y = " + Y;
	}
}