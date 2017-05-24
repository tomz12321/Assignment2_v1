
/**
 * Design a class Actors.
 * 
 * @author Jyh-woei Yang
 * @version 23/05/2017
 */
public class Actors
{
    // instance variables - replace the example below with your own
    private String name;

    /**
     * Constructor for objects of class Actors
     */
    public Actors()
    {
        // initialise instance variables
        name = "";
    }

    /**
     * a method to get Actor's name 
     * 
     * @param  
     * @return actors name a String 
     */
    public String getName()
    {
        // put your code here
        return name;
    }
    
    /**
     * a method to get Actor's name 
     * 
     * @param  newName an actors name as a String
     * @return 
     */
    public void setName(String newName)
    {
        // put your code here
        name = newName;
    }
}
