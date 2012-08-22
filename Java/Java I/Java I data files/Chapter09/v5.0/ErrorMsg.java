
public class ErrorMsg
{

    private final int minSize;
    private boolean found = true;

    private ArrayList objList;


    public ErrorMsg()
    {
		minSize = 12;
		objList = new ArrayList(minSize);
    }

    public ErrorMsg(int newMinSize) throws Exception
    {
		minSize = newMinSize;
		objList = new ArrayList(minSize);
    }



}