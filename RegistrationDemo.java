
/**
 * Application reads customers information about car registraion from a file and
 * determines whose registraion is expired and whose is almost expired and 
 * writes that information to an output file.
 *
 * @author Jordan Byrne
 * @version v1.0
 * @since 5/20/25
 */
public class RegistrationDemo
{
    public static void main(String[] args) throws Exception{
      int size = 0;
      RegistrationMethods dmv = new RegistrationMethods();
      dmv.setFileNames();
      size = dmv.getArraySize();
      CarOwner[] ltState = new CarOwner[size];
      dmv.processTextToArray(ltState);
      dmv.printArrayToFile(ltState, "List of Car Owners");
      CarOwner[] overdue = dmv.flagOverdueOwners(ltState);
      dmv.printArrayToFile(overdue, "Owners with Expired Registration");
      CarOwner[] almostDue = dmv.flagAlmostDueOwners(ltState);
      dmv.printArrayToFile(almostDue, "Owners with registration expiring in three months or less");
      System.out.println("The output file is located at: " + dmv.getOutputFileName());
    }
}
