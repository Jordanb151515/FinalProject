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
     * Method asks user for name of input file and tests to see if it exists.
     * Also asks for name of output file.
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
     * Method counts the number of lines in the file to determine array size.
     *
     * @return    counter   integer array size
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
     * Method splits each line into parts and uses the information to create
     * a CarOwner object and add that to a new array. 
     *
     * @param  inArray  the empty array that the objects are being added to
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
     * Method prints out the items of the array of Car Owners to the output file.
     *
     * @param  inArray  the array of CarOwner objects
     * @param  inMsg    header for the car owner information
     */
    public void printArrayToFile(CarOwner[] inArray,String inMsg) throws IOException
    {
        FileWriter file = new FileWriter(outputFileName, true);
        PrintWriter output =  new PrintWriter(file);
        output.println(inMsg);
        for(CarOwner item:inArray)
            output.println(item);
        output.println();
        output.close();
    }

    /**
     * Method uses object registration dates to see which owners have expired
     * registrations and adds them to a new array.
     *
     * @param   inArray  the array of all car owners
     * @return  overDue  the array of only overdue car owners
     */
    public CarOwner[] flagOverdueOwners(CarOwner[] inArray) throws IOException
    {
        CarOwner[] overDue;
        int monthsTotal = REG_YEAR*12 + REG_MONTH;
        int counter = 0;
        int index = 0;
        for(int i = 0; i < inArray.length; i++){
            if(monthsTotal - (inArray[i].getYear()*12+inArray[i].getMonth())>12)
                counter++;
        }
        overDue = new CarOwner[counter];
        for(int i = 0; i < inArray.length; i++){
            if(monthsTotal - (inArray[i].getYear()*12+inArray[i].getMonth())>12){
                overDue[index] = inArray[i];
                index++;
            }
        }
        return overDue;
    }

    /**
     * Method uses object registration dates to see which owners have almost 
     * expired registrations and adds them to a new array.
     *
     * @param   inArray  the array of all car owners
     * @return  almostDue  the array of only almost overdue car owners
     */
    public CarOwner[] flagAlmostDueOwners(CarOwner[] inArray) throws IOException
    {
        CarOwner[] almostDue;
        int monthsTotal = REG_YEAR*12 + REG_MONTH;
        int counter = 0;
        int index = 0;
        for(int i = 0; i < inArray.length; i++){
            if(monthsTotal - (inArray[i].getYear()*12+inArray[i].getMonth())>9 &&
            monthsTotal - (inArray[i].getYear()*12+inArray[i].getMonth())<=12)
                counter++;
        }
        almostDue = new CarOwner[counter];
        for(int i = 0; i < inArray.length; i++){
            if(monthsTotal - (inArray[i].getYear()*12+inArray[i].getMonth())>9 &&
            monthsTotal - (inArray[i].getYear()*12+inArray[i].getMonth())<=12){
                almostDue[index] = inArray[i];
                index++;
            }
        }
        return almostDue;
    }
    
    /**
     * Method is a getter for the name of the output file.
     *
     * @return   outputFileName
     */
    public String getOutputFileName() 
    {
        return outputFileName;
    }
}
