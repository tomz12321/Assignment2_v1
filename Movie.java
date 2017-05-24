import java.util.*;

/**
 * Design a class Movie
 * 
 * @author Jyh-woei Yang 
 * @version 23/05/2017
 */
public class Movie
{
    // instance variables - replace the example below with your own
    private String title;
    private String director;
    private int rating;
    private ListOfActors actorList;

    /**
     * Default Constructor for objects of class Record
     */
    public Movie()
    {
        // initialise instance variables
        title = "";
        director = "";
        actorList = new ListOfActors();
        rating = 0;
    }

    /**
     * A method to clean list of Actors
     * 
     * @param
     * @return 
     */
    public void cleanListOfActors()
    {
        actorList = new ListOfActors();
    }
    
    /**
     * A method to test displaying object displayMovie attibutes
     * 
     * @param
     * @return 
     */
    public void displayMovieRecord()
    {
        //method to test displaying attributes of the movie
        System.out.print(title + ",");
        System.out.print(director + ",");
        System.out.print(actorList.getStringOfListOfActors() + ",");
        System.out.println(rating);
    }
    
    /**
     * A method to return actorList
     * 
     * @param
     * @return actor list the movie director 
     */
    public ListOfActors getActorList()
    {
        //method to get director name
        return actorList;
    }
        
    /**
     * A method to return director
     * 
     * @param
     * @return director the movie director 
     */
    public String getDirector()
    {
        //method to get director name
        return director;
    }
   
    /**
     * A method to return numbers of movie elements 
     * 
     * @param
     * @return numbers of movie elements  
     */
    public int getNumbersOfElements()
    {
        //method to get director name
        return actorList.getNumbersOfActors() + 3;
    }
    
    /**
     * A method to return rating
     * 
     * @param
     * @return rating the movie rating 
     */
    public int getRating()
    {
        // method to get movie rating
        return rating;
    }
            
    /**
     * A method to return title
     * 
     * @param  
     * @return title the movie title
     */
    public String getTitle()
    {
        //method to get movie title
        return title;
    }
    
     /**
     * A method to set actorList
     * 
     * @param ArrayList<Actors> newActorlist
     * @return  
     */
    public void setActorList(ArrayList<Actors> newActorlist)
    {
        //method to set Actor List
        actorList.setListOfActors(newActorlist);
    }
    
    /**
     * A method to set director
     * 
     * @param  movieDirector the movie director
     * @return 
     */
    public void setDirector(String movieDirector)
    {
        //method to set director
        director = movieDirector;
    }
    
    /**
     * A method to set rating
     * 
     * @param  movieRating the movie rating
     * @return  
     */
    public void setRating(int movieRating)
    {
        //method to set a movie rating
        rating = movieRating;
    }
    
    /**
     * A method to set title
     * 
     * @param  movieTitle the movie title
     * @return      
     */
    public void setTitle(String movieTitle)
    {
        //method to set title
        title = movieTitle;
    }
        
}
