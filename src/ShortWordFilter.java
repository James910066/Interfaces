public class ShortWordFilter implements Filter
{   String word = "";
    boolean returnValue = false;
    @Override
     public boolean accept(Object x)
    {
        if(x instanceof String)
        {
            word = (String) x;
            return word.length() < 5;
        }
        return returnValue;
    }
public ShortWordFilter(){} //default constructor
}
