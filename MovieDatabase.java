import java.util.*;
import java.io.*;

/**
 * Write a description of class MovieDatabase here.
 * 
 * @author Jyhwoei Yang 
 * @version 23/05/2017
 */
public class MovieDatabase
{    
    private ArrayList<Movie> movieList; // should be private
    
    /** Default Constructor of Class MovieDatabase
     * 
     */
    public MovieDatabase()
    {
        //initialise the variables
        movieList = new ArrayList<Movie>();
    }
    
    /**
     * A method to add Movie to the list
     * 
     * @param Movie the Movie Object
     * @return 
     */
    public void addMovie(Movie newMovie)
    {
        movieList.add(newMovie);
    }
    
    /**
     * A method to add new Movie to the list
     * 
     * @param
     * @return 
     */
    public void addNewMovie(String movieDetails)
    {
        //movieList.add(newMovie);
        //add movie to the list
        Movie newMovie = new Movie(); 
        String[] elements = movieDetails.split(",");
        
        ListOfActors newActorList = new ListOfActors();

        newMovie.setTitle(elements[0]);
        newMovie.setDirector(elements[1]);
        
        //actor list , using for loop to handle it
        //use movie.getNumbersOfElement() to replace 6, 6 - 3 + 2 = 5 
        for (int i = 2 ; i < ( newMovie.getNumbersOfElements() - 3 ) + 2 ; i++ )
        {
            Actors newActor = new Actors();
            newActor.setName(elements[i]);
            newActorList.addActor(newActor);
        }
        
        newMovie.setActorList(newActorList.getListOfActors());
        
        //use MovieSystem's convert method to do String to int
        MovieSystem convert = new MovieSystem();
        //use movie.getNumbersOfElement() to replace 6, 6 - 1 = 5
        newMovie.setRating(convert.convertStringtoInt(elements[ newMovie.getNumbersOfElements() - 1 ]));
        
        //outprint to testing
        newMovie.displayMovieRecord();

        //add to Movie List
        addMovie(newMovie);
    }
    
    /**
     * A method to delete Movie to the list
     * 
     * @param delMovieName the name of delete movie
     * @return 
     */
    public void deleteMovie(String delMovieName)
    {        
        //remove()
        boolean isDeleted = false;
        for (int i = 0 ; i < getNumbersOfMovies() ; i++)
        {
            if(getMovieList().get(i).getTitle().equals(delMovieName))
            {
                System.out.println(getMovieList().get(i).getTitle() + " are deleted.");
                getMovieList().remove(i);
                isDeleted = true;
            }                        
        }        
        if (! isDeleted)
        {
            System.out.println(" No matched movies are deleted."); 
        }
    } 
    
    /**
     * A method to edit Movie to the list
     * 
     * @param editMovieName the name of delete movie
     * @return 
     */
    public void editMovie(String editMovieName, ArrayList<Actors> editActorList, int editRating)
    {        
        //remove()
        boolean isEdited = false;
        for (int i = 0 ; i < getNumbersOfMovies() ; i++)
        {
            if(getMovieList().get(i).getTitle().equals(editMovieName))
            {
                System.out.println(getMovieList().get(i).getTitle() + " are edited.");
                getMovieList().get(i).cleanListOfActors();
                getMovieList().get(i).setActorList(editActorList);
                getMovieList().get(i).setRating(editRating);
               
                isEdited = true;
            }                        
        }        
        if (! isEdited)
        {
            System.out.println(" No matched movies are Edited."); 
        }
    }
    
    /**
     * A method to return elements from the movie list
     * 
     * @param index the index
     * @return elements in the movieList
     */
    public Movie getMovie(int index)
    {
        return movieList.get(index);
    }
    
    /**
     * A method to return the whole movie list
     * 
     * @param 
     * @return the whole movieList
     */
    public ArrayList<Movie> getMovieList()
    {
        return movieList;
    }
    
    /**
     * A method to return the size of movie list
     * 
     * @param
     * @return count number of Movies
     */
    public int getNumbersOfMovies()
    {
        return movieList.size();
    }   
    
    /**
     * List all the movies currently in the database on standard out.
     */
    public void listAll() 
    {
        //for (Iterator i = movieList.iterator(); i.hasNext();) 
        //{
            //print Object Movie memoery site
            //System.out.println(i.next());            
        //}
        for (int j = 0 ; j < movieList.size() ; j++)
        
            movieList.get(j).displayMovieRecord();        
    }
    
    /**
     * A method to search movie
     * 
     * @param searchTitle
     * @return resultList
     */
    public ArrayList<Movie> searchMovie(String searchTitle) //not case-sensitive source.toLowerCase().contains(target.toLowerCase())
    {
        ArrayList<Movie> resultList = new ArrayList<Movie>();
        
        for (int i = 0 ; i < getNumbersOfMovies(); i++)
        {
            if(getMovieList().get(i).getTitle().toLowerCase().contains(searchTitle))
                resultList.add(getMovieList().get(i));
            
        }
                
        return resultList;
    }
    
    /**
     * A method to search movie
     * 
     * @param searchDirector
     * @return resultList
     */
    public ArrayList<Movie> searchByDirector(String searchDirector) //not case-sensitive source.toLowerCase().contains(target.toLowerCase())
    {
        ArrayList<Movie> resultList = new ArrayList<Movie>();
        
        for (int i = 0 ; i < getNumbersOfMovies(); i++)
        {
            if(getMovieList().get(i).getDirector().toLowerCase().contains(searchDirector))
                resultList.add(getMovieList().get(i));
            
        }
                
        return resultList;
    }
    
    /**
     * A method to set movie Name
     * 
     * @param movieName the movieName, index the index
     * @return 
     */
    public void setMovie(Movie insertedMovie, int index)
    {
        movieList.set(index, insertedMovie);
    }
    
    /**
    * Method to check Movie Name repeatation
    * 
    * @param MovieName the Name
    * @return the boolean of Movie Name repeatation
    */
    public boolean validMovieName(String movieName) //method to check Movie Name repeatation
    {
        //check if movie title is not in database , and return false to break while loop
        for (int i = 0 ; i < getNumbersOfMovies() ; i++ )
        {
            if (movieName.equals(getMovieList().get(i).getTitle()))
                return true;
        }
        return false;        
    }
}   
    