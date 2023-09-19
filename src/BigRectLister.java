import java.util.ArrayList;
import java.awt.*;

public class BigRectLister
{
    private static ArrayList<Rectangle> rectangleLists = new ArrayList<>();

    private static Filter sizeFilter = (Filter) new BigRectangleFilter();

    public static ArrayList<Rectangle> collectAll()
    {
        ArrayList<Rectangle> bigRectangles = new ArrayList<Rectangle>();

        for(Rectangle BigPerimeterRectangle : rectangleLists)
        {
            boolean accepted = sizeFilter.accept(BigPerimeterRectangle);

            if(accepted) bigRectangles.add(BigPerimeterRectangle);
        }

        return  bigRectangles;
    }

    public static void main(String[] args)
    {
        rectangleLists.add(new Rectangle(3, 2));
        rectangleLists.add(new Rectangle(1, 4));
        rectangleLists.add(new Rectangle(2, 2));
        rectangleLists.add(new Rectangle(3, 8));
        rectangleLists.add(new Rectangle(6, 10));
        rectangleLists.add(new Rectangle(9, 12));
        rectangleLists.add(new Rectangle(3, 14));
        rectangleLists.add(new Rectangle(6, 16));
        rectangleLists.add(new Rectangle(9, 18));
        rectangleLists.add(new Rectangle(6, 20));
        System.out.println("These are all of the Rectangles width and height and perimeter: ");

        for(Rectangle Rects : rectangleLists)
        {
            String RectMeasurement = "";

            RectMeasurement += "Width: " + Rects.width + "; ";
            RectMeasurement += "Height: " + Rects.height + "; ";
            RectMeasurement += "Perimeter: " + 2 * (Rects.width + Rects.height);

            System.out.println(RectMeasurement);
        }
        System.out.println(); //add line space
        ArrayList<Rectangle> LargeRectangles = collectAll();

        System.out.println("These rectangles have a perimeter larger than 10:");

        for(Rectangle LargePerimeterRects : LargeRectangles)
        {
            String RectSize = "";
            RectSize += "Rectangle: Width = " + LargePerimeterRects.width + "; ";
            RectSize += "Height = " + LargePerimeterRects.height + "; ";
            RectSize += "Perimeter = " + (2 * (LargePerimeterRects.width + LargePerimeterRects.height));

            System.out.println(RectSize);
        }
    }
}