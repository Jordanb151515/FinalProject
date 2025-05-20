import java.util.*;
import java.io.*;

/**
 * RegistrationMethods class contains methods to read information from a file 
 * and test whose has registration that is expired or almost expired. Also
 * writes output to an output file.
 *
 * @author Jordan Byrne
 * @version v1.0
 * @since 5/20/25
 */
public class RegistrationMethods
{
    private String inputFileName;
    private String outputFileName;
    public static final int REG_MONTH = 4;
    public static final int REG_YEAR = 2025;

    /**
     * An example of a method - replace this comment with your
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void setFileNames()
    {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("What is the location of the registration file: ");
        inputFileName = keyboard.nextLine();
        File file;
        file = new File(inputFileName);
        while(!(file.exists())){
            System.out.print("Does not exist. Enter a new location: ");
            inputFileName = keyboard.nextLine();
            file = new File(inputFileName);
        }

        System.out.print("What is the location of the output file: ");
        outputFileName = keyboard.nextLine();
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public int getArraySize() throws IOException
    {
        int counter = 0;
        File file = new File(inputFileName);
        Scanner input = new Scanner(file);
        input.nextLine();
        while(input.hasNextLine()){
            counter++;
            input.nextLine();
        }
        input.close();
        return counter;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void processTextToArray(CarOwner[] inArray) throws IOException
    {
        File file = new File(inputFileName);
        Scanner input = new Scanner(file);
        input.nextLine();
        int index = 0;
        while(input.hasNextLine()){
            String line = input.nextLine();
            String[] tokens = line.split(",");
            int month = Integer.parseInt(tokens[3]);
            int year = Integer.parseInt(tokens[4]);
            CarOwner temp = new CarOwner(tokens[1],tokens[0],tokens[2],month,year);
            inArray[index] = temp;
            index++;
        }
        input.close();
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void printArrayToFile(CarOwner[] inArray,String inMsg) throws IOException
    {
        FileWriter file = new FileWriter(outputFileName, true);
        PrintWriter output =  new PrintWriter(file);
        output.println(inMsg);
        for(CarOwner item:inArray)
            output.println(item);
        output.println();
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public CarOwner[] flagOverdueOwners(CarOwner[] inArray) throws IOException
    {
        CarOwner[] overDue;
        int monthsTotal = REG_YEAR*12 + REG_MONTH;
        int counter = 0;
        int index = 0;
        for(int i = 0; i < inArray.length; i++){
            if(monthsTotal - (inArray[i].getYear*12+inArray[i].getMonth())>12)
                counter++;
        }
        overDue = new CarOwner[counter];
        for(int i = 0; i < inArray.length; i++){
            if(monthsTotal - (inArray[i].getYear*12+inArray[i].getMonth())>12){
                overDue[index] = inArray[i];
                index++;
            }
        }
        return overDue;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public CarOwner[] flagAlmostDueOwners(CarOwner[] inArray) throws IOException
    {
        CarOwner[] almostDue;
        int monthsTotal = REG_YEAR*12 + REG_MONTH;
        int counter = 0;
        int index = 0;
        for(int i = 0; i < inArray.length; i++){
            if(monthsTotal - (inArray[i].getYear*12+inArray[i].getMonth())>9 &&
            monthsTotal - (inArray[i].getYear*12+inArray[i].getMonth())<=12)
                counter++;
        }
        almostDue = new CarOwner[counter];
        for(int i = 0; i < inArray.length; i++){
            if(monthsTotal - (inArray[i].getYear*12+inArray[i].getMonth())>9 &&
            monthsTotal - (inArray[i].getYear*12+inArray[i].getMonth())<=12){
                almostDue[index] = inArray[i];
                index++;
            }
        }
        return almostDue;
    }
}
