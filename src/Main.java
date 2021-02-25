import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.exit;

public class Main {
    private static FileWriter file;
    private static ArrayList<Variable> variables;
    public static void main(String[] args)
    {

        /*
         * Using scanner to open the input file
         */
        variables = new ArrayList<>();
        try(Scanner input = new Scanner(new File("2d.txt"))){
            while (input.hasNext()){
                variables.add(new Variable(input.nextLine()));
            }
        }
        catch(Exception e)
        {
            System.out.print(e.getMessage());
            exit(1);
        }

        //show the contents for the peace of mind
        for (Variable v: variables) {
            System.out.println(v);
        }

        //Prepare to run test cases
        File output = new File("output.txt");
        try{
            if(output.exists())
                output.delete();
            output.createNewFile();
        }catch (IOException ioExc){
            exit(2);
        }
        try(FileWriter out = new FileWriter(output)){
            file = out;
            runStrongNormalTests(variables);
            file = null;
        }catch(IOException ioExc){
            exit(3);
        }
    }

    private static void runStrongNormalTests(ArrayList<Variable> variables, int... inputs){
        //Base case
        if(variables.size() == 0){
            generateOutput(inputs);
            return;
        }
        Variable current = variables.get(0);
        ArrayList<Integer> old = new ArrayList<>();
        for(int val : inputs){
            old.add(val);
        }
        for(int i = 0; i != current.getNumberOfEqClasses(); i++){
            //Add a new input to the list
            ArrayList<Integer> newInputs = new ArrayList<>(old);
            newInputs.add(current.getInputFromEqClassNumber(i+1));
            //Recursive call
            runStrongNormalTests(new ArrayList<>(variables.subList(1, variables.size())), convertToArray(newInputs));
        }
    }

    private static void generateOutput(int[] inputs) {
        int exp = 0;
        for (int i=0; i!=inputs.length; i++) {
            exp += variables.get(i).check(inputs[i]); //get equivalence class of an input from a variable
        }
        StringBuilder result = new StringBuilder();
        result.append("Calling foo() with <");
        for (int input:inputs) {
            result.append(input);
            result.append(',');
        }
        result.deleteCharAt(result.length()-1); //remove last coma
        result.append("> | Expected: "+ exp + " Result: " + foo(inputs) + '\n');
        try{
            file.write(result.toString()+'\n');
        }catch (IOException exception){
            exit(4);
        }
    }

    private static int[] convertToArray(ArrayList<Integer> newInputs) {
        int size = newInputs.size();
        int[] arr = new int[size];
        for(int i = 0; i != size; i++){
            arr[i] = newInputs.get(i);
        }
        return arr;
    }

    public static int foo(int... inputs)
    {
        /*
         * This function has k integers as input arguments (i.e. foo(int n2, int n2, ..., int nk))
         * Each argument belongs to a different equivalence class, stored in Eq.txt
         *
         * This function computes the sum of the returned values by the check function for all input arguments
         */
        int result = 0;
        for(int i = 0; i != inputs.length; i++){
            result+=variables.get(i).check(inputs[i]); //get the eq. class of the variable and add it to the result
        }
        return result;
    }
}
