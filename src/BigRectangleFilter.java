import java.awt.Rectangle;
public class BigRectangleFilter implements Filter
{
    public boolean accept(Object x)
    {
        final double sizeLimit = 10;
        Rectangle rt = (Rectangle) x;
        double perimeter = 2 * (rt.height + rt.width);
        if (perimeter > sizeLimit)
        {
            return true;
        }
        return false;
    }
}
