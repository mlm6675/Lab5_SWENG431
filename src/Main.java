import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {

        /**
         * Using scanner to open the input file
         */
        Scanner scanner;

        try{
            scanner = new Scanner(new File("Eq.txt"));
        }
        catch(Exception e)
        {
            System.out.print("file not found");

            return;
        }


        /**
         * Storing arguments into an object, storing objects into an arraylist
         */

        String dingus;
        ArrayList<Argument> inputArguments = new ArrayList<>();
        int lineCounter = 1; //this is going to essentially count the inputs;

        do {
            Argument newArg = new Argument();

            dingus = scanner.next();
            dingus = dingus.substring(0, dingus.length()-1);
            newArg.lowerBound = Integer.parseInt(dingus);
            newArg.argumentNumber = lineCounter;

            dingus = scanner.next(); //NOTE: Only doing this the second time because these numbers always come in pairs
            if(!dingus.contains(";"))
            {
                lineCounter++; //don't try to parse, just increment the line
            }
            else
            {
                dingus = dingus.substring(0, dingus.length()-1); //if it does contain this, just parse and don't increment
            }

            newArg.upperBound = Integer.parseInt(dingus);

            System.out.println(newArg);

            inputArguments.add(newArg);
        }
        while (scanner.hasNext());

    }


    void foo()
    {
        /**
         * This function has k integers as input arguments (i.e. foo(int n2, int n2, ..., int nk))
         * Each argument belongs to a different equivalence class, stored in Eq.txt
         *
         * This function computes the sum of the returned values by the check function for all input arguments
         */
    }
}
