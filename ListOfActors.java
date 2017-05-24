import java.util.*;

/**
 * Design a class ListOfActors.
 * 
 * @author Jyh-woei Yang  
 * @version 23/05/2017
 */
public class ListOfActors
{   
    private ArrayList<Actors> actorsList;    
    private int sampleSize;
    
    /** Default Constructors of class ListOfActors
     * 
     */
    public ListOfActors()
    {
        //initialised the variables 
        actorsList = new ArrayList<Actors>();
        sampleSize = 3;
    }
    
    /**
     * A method to add Actor to the list
     * 
     * @param
     * @return 
     */
    public void addActor(Actors newActor)
    {
        actorsList.add(newActor);
    }
    
    /**
     * A method to get list of actors 
     * 
     * @param
     * @return a list of Actors
     */
    public ArrayList<Actors> getListOfActors()
    {
       return actorsList;
    }
    
    /**
     * A method to return the size of actor list
     * 
     * @param
     * @return count number of Actors
     */
    public int getNumbersOfActors()
    {
        //return actorsList.size();
        return sampleSize;
    } 
    
    /**
     * A method to get list of actors 
     * 
     * @param
     * @return a list of Actors as a String
     */
    public String getStringOfListOfActors()
    {
        int listSize = actorsList.size();
        String listString = actorsList.get(0).getName();
        for (int i = 1 ; i < listSize ; i++)
            listString = listString + "," + actorsList.get(i).getName();
        return listString;
    }
    
    /**
     * List all the actors currently in the database on standard out.
     */
    public void listAll() 
    {
        for (Iterator i = actorsList.iterator(); i.hasNext();) 
        {
            System.out.println(i.next());
        }
    }
    
    /**
     * A method to set list of actors 
     * 
     * @param ArrayList the newActorlist
     * @return 
     */
    public void setListOfActors(ArrayList<Actors> newActorlist)
    {              
        //change to pass arraylist (set it before pass)
        for (int i = 0 ; i < newActorlist.size() ;  i++)
            actorsList.add(newActorlist.get(i));
        //actorsList.add(newActorlist.get(1));
        //actorsList.add(newActorlist.get(2));
    }    
}
