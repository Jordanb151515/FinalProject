
/**
 * CarOwner classes holds information regarding the license number and the 
 * month and year of the registration.
 *
 * @author Jordan Byrne
 * @version v1.0
 * @since 5/20/25
 */
public class CarOwner extends Citizen
{
    private String license;
    private int month;
    private int year;

    /**
     * No-args Constructor for objects of class CarOwner.
     */
    public CarOwner()
    {
        super();
        license = "Not Assigned";
        month = 0;
        year = 0;
    }
    
    /**
     * Constructor for objects of class CarOwner.
     * 
     * @param  inFirst  inputted first name of citizen
     * @param  inLast   inputted last name of citizen
     * @param  inLicense  inputted license number
     * @param  inMonth  month of registration
     * @param  inYear   year of registration
     */
    public CarOwner(String inFirst, String inLast, String inLicense, int inMonth, int inYear)
    {
        super(inFirst, inLast);
        license = inLicense;
        month = inMonth;
        year = inYear;
    }

    /**
     * Method is a setter for license field.
     *
     * @param  inLicense  inputted license number
     */
    public void setLicense(String inLicense)
    {
        license = inLicense;
    }
    
    /**
     * Method is a getter for the license field.
     *
     * @return    license number
     */
    public String getLicense()
    {
        return license;
    }
    
    /**
     * Method is a setter for the month field.
     *
     * @param  inMonth  inputted month of registration
     */
    public void setMonth(int inMonth)
    {
        month = inMonth;
    }
    
    /**
     * Method is a getter for the month field.
     *
     * @return    month of registration
     */
    public int getMonth()
    {
        return month;
    }
    
    /**
     * Method is a setter for the year field.
     * 
     * @param  inYear  inputted year for registration 
     */
    public void setYear(int inYear)
    {
        year = inYear;
    }
    
    /**
     * Method is a getter for the year field.
     * 
     * @return   the registration year
     */
    public int getYear()
    {
        return year;
    }
    
    /**
     * Method is a toString for the CarOwner class.
     *
     * @return   str   information containing first name, last name, license number,
     *                 month and year of registration
     */
    @Override
    public String toString()
    {
        String str = super.toString() + "\t" + license + "\t" + month + "/" + year;
        return str;
    }
}
