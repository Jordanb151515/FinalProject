
/**
 * Citizen class takes input of and holds values for the first and last name
 * of a citizen.
 *
 * @author Jordan Byrne
 * @version v1.0
 * @since 5/20/25
 */
public class Citizen
{
    private String firstName;
    private String lastName;

    /**
     * No-args Constructor for objects of class Citizen. Sets first and last 
     * name to no name.
     */
    public Citizen()
    {
        firstName = "No name";
        lastName = "No name";
    }
    
    /**
     * Constructor for objects of class Citizen. 
     * 
     * @param  inFirst  inputted value for first name of the citizen
     * @param  inLast   inputted value for the last name of the citizen
     */
    public Citizen(String inFirst, String inLast)
    {
        firstName = inFirst;
        lastName = inLast;
    }
    
    /**
     * Method is a setter for the firstName field.
     *
     * @param  inFirst  inputted first name of the citizen
     */
    public void setFirstName(String inFirst)
    {
        firstName = inFirst;
    }
    
    /**
     * Method is a getter for the firstName field.
     *
     * @return   firstName  of the citizen
     */
    public String getFirstName()
    {
        return firstName;
    }
    
    /**
     * Method is a setter for the lastName field.
     *
     * @param  inLast  inputted last name of the citizen
     */
    public void setLastName(String inLast)
    {
        lastName = inLast;
    }
    
    /**
     * Method is a getter for the lastName field.
     *
     * @return   lastName  of the citizen
     */
    public String getLastName()
    {
        return lastName;
    }

    /**
     * Method is a toString for the Citizen class.
     *
     * @return   str   information containing first and last name
     */
    public String toString()
    {
        String str = firstName + " " + lastName;
        return str;
    }
}
