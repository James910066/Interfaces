import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import static java.nio.file.StandardOpenOption.CREATE;

public class ShortLister
{
    private static ArrayList<String> Objects = new ArrayList<>();

    public static void main(String[] args) {
        ShortWordFilter shortWords = new ShortWordFilter();
        JFileChooser fileChooser = new JFileChooser();
        File chosenFile;
        String readLine = "";
        String str = "";
        try {
            File workingDirectory = new File(System.getProperty("user.dir"));
            fileChooser.setCurrentDirectory(workingDirectory);
            if(fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
            {
                chosenFile = fileChooser.getSelectedFile();
                Path file = chosenFile.toPath();
                InputStream stream = new BufferedInputStream(Files.newInputStream(file, CREATE));
                BufferedReader fileReader = new BufferedReader(new InputStreamReader(stream));
                System.out.println(str);
                while(fileReader.ready())
                {
                    readLine = fileReader.readLine();
                    Objects.add(readLine);
                }
                fileReader.close();
                //Read the words in arraylist
                System.out.println("These are the short words in the arraylist");
                for (int counter = 0; counter < Objects.size(); counter++)
                {
                    if(shortWords.accept(Objects.get(counter))== true)
                    {
                        //shortWords.add(collectAll());
                        System.out.println(Objects.get(counter));
                    }
                }
                System.out.println(); //blank line
                System.out.println("These are all the words in text file including words over 5 in length");
                for (int counter = 0; counter < Objects.size(); counter++)
                {
                        System.out.println(Objects.get(counter));
                }
                System.out.println("\n\nData file has been opened and read!");
            }

            else
            {
                System.out.println("Failed to choose a file to process");
                System.out.println("Run the program again!");
                System.exit(0);
            }
        } catch (FileNotFoundException e)
        {
            System.out.println("File not found!!!");
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    private static ArrayList<Object> collectAll(ArrayList<Object> words, ShortWordFilter shortWordFilter)
    {
        return words;
    }
    public  ArrayList<Object> CollectAll(Filter obs, Object[] words)
    {
        ArrayList<Object> objects = new ArrayList<>();
        for (Object x: words)
        {
            if (obs.accept(x))
            {
                objects.add(x);
            }
        }
        return objects;
    }
}