import java.lang.*;
import java.util.*;
import java.io.*;

/**
 * Create a class for Movie System.
 * 
 * @author Jyh-woei Yang 
 * @version 23/05/2017
 */
public class MovieSystem
{
    // instance variables - replace the example below with your own
    private MovieDatabase newMovieList;

    /**
     * Default Constructor for objects of class Movie System
     */
    public MovieSystem()
    {
        // initialise instance variables
        newMovieList = new MovieDatabase();
    }    

    /**
     * A method to add movie to the database system
     * 
     * @param
     * @return 
     */
    private void addMovie()
    {
        //input
        Scanner input = new Scanner(System.in);

        System.out.println("=== Add Movie ===");
        System.out.println("Please insert movie name :");        
        String newMovieName = input.nextLine();

        //valid addMovieName if existed , Error message
        while (validMovieName(newMovieName))
            newMovieName = input.nextLine();                  

        //valid addMovie if blank , Error message    
        while (validBlank(newMovieName,"Movie Name"))
        {
            newMovieName = input.nextLine();
            //valid addMovieName if existed , Error message
            while (validMovieName(newMovieName))
                newMovieName = input.nextLine(); 
        }        
        System.out.println("Please insert director name :");

        //input Director's name
        String newDirectorName = input.nextLine();

        while (validBlank(newDirectorName,"Director Name"))
            newDirectorName = input.nextLine();

        System.out.println("Please insert actor1 name :");

        //input Actor1's name
        String newActor1Name = input.nextLine();

        while (validBlank(newActor1Name,"Actor1 Name"))
            newActor1Name = input.nextLine();

        System.out.println("Please insert actor2 name :");
        //input Actor2's name
        String newActor2Name = input.nextLine();

        while (validSpace(newActor2Name))
            newActor2Name = input.nextLine();

        System.out.println("Please insert actor3 name :");
        //input Actor3's name
        String newActor3Name = input.nextLine();

        while (validSpace(newActor3Name))
            newActor3Name = input.nextLine();

        System.out.println("Please insert rating :");
        //input
        String newRating = input.nextLine();

        while (validBlank(newRating,"new Rating"))
            newRating = input.nextLine();

        //Convert String newRating to int newRatingInt
        int newRatingInt = convertStringtoInt(newRating);

        //validRating(int rating)
        while (validRating(newRatingInt))
        { 
            newRating = input.nextLine();

            while (validBlank(newRating,"new Rating"))
                newRating = input.nextLine();

            newRatingInt = convertStringtoInt(newRating);
        }
        
        //?1
        //Generate a String pass to handle
        String movieDetails = newMovieName + "," + newDirectorName + "," + newActor1Name + "," + newActor2Name + "," + newActor3Name + "," + newRatingInt;
        //add movie to the list
        newMovieList.addNewMovie(movieDetails);
    }

    /**
     * Method to convert from String to Integer
     * 
     * @param a String of input
     * @return the Integer of out
     * @throws NumberFormatException if input is a non-number format
     */
    public int convertStringtoInt(String input) //method to convert String to Integer
    {
        //intialised variables
        String S = input;
        int i = 0;

        try
        {
            // the String to int conversion happens here
            i = Integer.parseInt(input.trim());

            // print out the value after the conversion
            //System.out.println("int i = " + i);
        }
        catch (NumberFormatException nfe)
        {
            System.out.println("NumberFormatException: " + nfe.getMessage() + ", please input an integer!");
        }
        return i;
    }

    /**
     * A method to delete movie from the database system
     * if there are above two movies appearing on the search result
     * provide choosing options
     * 
     * @param
     * @return 
     */
    private void deleteMovie()
    {
        System.out.println("Delete Movie :");        
        //input
        Scanner input = new Scanner(System.in);

        //search by title
        System.out.println("=== Search Movie to delete : ===");
        System.out.println("Search Movie , please insert keyword of title:");

        String delKeyword = input.nextLine().toLowerCase();

        while (validBlank(delKeyword,"Title keyword"))
            delKeyword = input.nextLine().toLowerCase();

        ArrayList<Movie> delResultList = newMovieList.searchMovie(delKeyword);

        //display Movie details
        System.out.println("Search Result");
        for (int j = 0 ; j < delResultList.size() ; j++)
        {
            System.out.print( (j + 1) + ") ");
            delResultList.get(j).displayMovieRecord();
        }

        int size = delResultList.size();

        //selection
        if (size != 0)
        {
            System.out.println("Please insert which option number you would select to delete, press 0 to quit :");
            String delMovieSelection = input.nextLine();
            int index = convertStringtoInt(delMovieSelection);

            if (index == 0)
                size = 0;
            //validDelSelection (index, delresultList.size());
            while (validDelSelection (index, size))
            {

                delMovieSelection = input.nextLine();
                index = convertStringtoInt(delMovieSelection);
                if (index == 0)
                    size = 0;
                while (validBlank(delMovieSelection,"Selection"))
                {    
                    delMovieSelection = input.nextLine();
                    index = convertStringtoInt(delMovieSelection);
                    if (index == 0)
                        size = 0;
                }
            }
            System.out.println(delMovieSelection);

            String delMovieName;

            if (size != 0)
                delMovieName = delResultList.get(index -1).getTitle();
            else
                delMovieName = "";

            //System.out.println("Delete Movie , please insert delete title:");
            //String delMovieName = input.nextLine();
            newMovieList.deleteMovie(delMovieName);
        }
        else
            System.out.println("No matched movies");
    }

    /**
     * A method to display Favourate movie
     * 
     * allows the user to display a list of movies according to ratings. 
     * The user should be asked for a number (1-10) representing a rating 
     * (higher number indicating better rating), 
     * and a list of movies having that rating or higher should be displayed.
     * 
     * @param
     * @return 
     */
    private void displayFavourateMovie()
    {
        System.out.println("Display Favourite Movie");

        Scanner input = new Scanner(System.in);

        System.out.println("Please insert rating :");
        //input
        String newRating = input.nextLine();

        while (validBlank(newRating,"new Rating"))
            newRating = input.nextLine();

        //Convert String newRating to int newRatingInt
        int newRatingInt = convertStringtoInt(newRating);

        //validRating(int rating)
        while (validRating(newRatingInt))
        { 
            newRating = input.nextLine();

            while (validBlank(newRating,"new Rating"))
                newRating = input.nextLine();

            newRatingInt = convertStringtoInt(newRating);
        }

        //display above newRatingInt
        for (int i = 0 ; i < newMovieList.getNumbersOfMovies(); i++)
        {
            if (newMovieList.getMovieList().get(i).getRating() >= newRatingInt)
            {
                if (i != newMovieList.getNumbersOfMovies() - 1)
                    System.out.print(newMovieList.getMovieList().get(i).getTitle() + ",");
                else
                    System.out.println(newMovieList.getMovieList().get(i).getTitle());
            }
        }
    }

    /**
     * A method to display Menu
     * 
     * @param
     * @return 
     */

    private void displayMenu()
    {
        //interface
        System.out.println("");
        System.out.println("=====================");
        System.out.println("(1) Search movies");
        System.out.println("(2) Add Movie");
        System.out.println("(3) Delete Movie");
        System.out.println("(4) Display Favourite Movies");
        System.out.println("(5) Edit Movie (Actors and Rating)");
        System.out.println("(6) Exit System");
        System.out.print("Choose an option :");
    }

    /**
     * A method to edit movie from the database system
     * if there are above two movies appearing on the search result
     * provide choosing options
     * 
     * @param
     * @return 
     */
    private void editMovie()
    {
        System.out.println("Edit Movie :");        
        //input
        Scanner input = new Scanner(System.in);

        //search by title
        System.out.println("=== Search Movie to edit : ===");
        System.out.println("Search Movie , please insert keyword of title:");

        String editKeyword = input.nextLine().toLowerCase();

        while (validBlank(editKeyword,"Title keyword"))
            editKeyword = input.nextLine().toLowerCase();

        ArrayList<Movie> editResultList = newMovieList.searchMovie(editKeyword);

        //display Movie details
        System.out.println("Search Result");
        for (int j = 0 ; j < editResultList.size() ; j++)
        {
            System.out.print( (j + 1) + ") ");
            editResultList.get(j).displayMovieRecord();
        }

        int size = editResultList.size();

        //selection
        if (size != 0)
        {
            System.out.println("Please insert which option number you would select to delete, press 0 to quit :");
            String editMovieSelection = input.nextLine();
            int index = convertStringtoInt(editMovieSelection);

            if (index == 0)
                size = 0;
            //validDelSelection (index, delresultList.size());
            while (validDelSelection (index, size))
            {

                editMovieSelection = input.nextLine();
                index = convertStringtoInt(editMovieSelection);
                if (index == 0)
                    size = 0;
                while (validBlank(editMovieSelection,"Selection"))
                {    
                    editMovieSelection = input.nextLine();
                    index = convertStringtoInt(editMovieSelection);
                    if (index == 0)
                        size = 0;
                }
            }
            System.out.println(editMovieSelection);

            String editMovieName;

            if (size != 0)
                editMovieName = editResultList.get(index - 1).getTitle();
            else
                editMovieName = "";

            if (size !=0)
            {
                System.out.println("==== Edit Movie ====");

                System.out.println("Please insert actor1 name :");        
                //input Actor1's name
                String newActor1Name = input.nextLine();

                while (validBlank(newActor1Name,"Actor1 Name"))
                    newActor1Name = input.nextLine();

                System.out.println("Please insert actor2 name :");    
                //input Actor2's name
                String newActor2Name = input.nextLine();

                while (validSpace(newActor2Name))
                    newActor2Name = input.nextLine();

                System.out.println("Please insert actor3 name :");
                //input Actor3's name
                String newActor3Name = input.nextLine();

                while (validSpace(newActor3Name))
                    newActor3Name = input.nextLine();

                System.out.println("Please insert rating :");
                //input
                String newRating = input.nextLine();

                while (validBlank(newRating,"new Rating"))
                    newRating = input.nextLine();

                //Convert String newRating to int newRatingInt
                int newRatingInt = convertStringtoInt(newRating);

                //validRating(int rating)
                while (validRating(newRatingInt))
                { 
                    newRating = input.nextLine();

                    while(validBlank(newRating,"new Rating"))
                        newRating = input.nextLine();

                    newRatingInt = convertStringtoInt(newRating);
                }

                ArrayList<String> editActorStringList = new ArrayList<String>();
                editActorStringList.add(newActor1Name);
                editActorStringList.add(newActor2Name);
                editActorStringList.add(newActor3Name);
                
                ArrayList<Actors> editActorList = new ArrayList<Actors>();
                //using for loop to handle it
                for (int i = 0 ; i < editActorStringList.size(); i++)
                {
                    Actors actor = new Actors();
                    actor.setName(editActorStringList.get(i)); 
                    editActorList.add(actor);
                }
                    int editRating = newRatingInt;
                    //String editMovieName = input.nextLine();
                    newMovieList.editMovie(editMovieName,editActorList,editRating);
               
            }
        }
        else
            System.out.println("No matched movies");
    }

    /**
     * A method to exit the system
     * 
     * @param
     * @return a boolean to make isOperating = false and break the while loop
     */
    private boolean exitSystem()
    {
        System.out.println("Exit System");
        //write into file
        writeFile();

        //reset all the attributes
        newMovieList = new MovieDatabase();

        return false;
    }

    /**
     * A method to read from file
     * 
     * @param  
     * @return
     * @throws FileNotFoundException if file is not found
     * @throws IOException while exception during I/O actions
     */
    private void readFile()
    {
        String filename = ("myvideos.txt");
        String videos;
        Movie loadFromFile;
        // put your code here
        try
        {
            FileReader inputFile = new FileReader(filename);
            Scanner parser = new Scanner(inputFile);
            int linecount = 0;
            while (parser.hasNextLine())
            {
                loadFromFile = new Movie(); 
                videos = parser.nextLine();
                String[] attribute = videos.split(",");

                for (int i = 0 ; i < attribute.length ; i++)
                {
                    System.out.println (attribute[i]);

                    //numbers of Movies
                    //for (int k = 0 ; k < loadFromFile.getNumbersOfElements() ; k++)
                    //{
                    //attributes of Movies
                    //}
                }

                System.out.println ("Movie"+ linecount);
                loadFromFile.setTitle(attribute[0]);
                loadFromFile.setDirector(attribute[1]);
                
                //add movie to the list
                Movie newMovie = new Movie(); 
                ListOfActors newActorList = new ListOfActors();
                //handle String
                ArrayList<String> loadFromFileActorStringList = new ArrayList<String>();
                
                //for loop to handle attribute[2] - attribute[4] 
                for (int i = 0 ; i < (attribute.length - 3) ; i++) 
                {
                    loadFromFileActorStringList.add(attribute[ i + 2 ]);
                    //String newActor2Name = attribute[3];
                    //String newActor3Name = attribute[4];
                }
               
                //actor list (using for loop to handle it)
                ArrayList<Actors> loadFromFileActorList = new ArrayList<Actors>();
                for (int i = 0 ; i < loadFromFileActorStringList.size() ; i++)
                {
                    Actors actor = new Actors();
                    //using loadFromFileActorStringList.get(i) to replace newActorName
                    actor.setName(loadFromFileActorStringList.get(i)); 
                    loadFromFileActorList.add(actor);
                }
                loadFromFile.cleanListOfActors();
                loadFromFile.setActorList(loadFromFileActorList);                               
                                
                //use movie.getNumbersOfElement() to replace 6, 6 - 1 = 5
                loadFromFile.setRating(convertStringtoInt(attribute[ loadFromFile.getNumbersOfElements() - 1 ]));
                //loadFromFile.displayMovieRecord();
                loadFromFile.displayMovieRecord();
                newMovieList.addMovie(loadFromFile);
                linecount++;
            }
            inputFile.close();
        }
        catch(FileNotFoundException exception)
        {
            System.out.println(filename + " not found");
        }
        catch(IOException exception)
        {
            System.out.println("Unexpected I/O error occured");
        }
    }

    /**
     * A method to select search by movie title or movie director
     * 
     * @param
     * @return
     */
    private void searchCase() //validBlank and validDelSelection to valid case option are between (1) and (2)
    {
        Scanner input = new Scanner(System.in);

        System.out.println("Press (1) To search by Movie Title or (2) To search by Movie Director");        
        String iobuffer = input.nextLine();
        char option = ' '; 

        while(validBlank(iobuffer.trim(),"Options"))
            iobuffer = input.nextLine();

        while(validDelSelection(convertStringtoInt(iobuffer.trim()), 2))
        {
            iobuffer = input.nextLine();
            //validate Option is blank
            while(validBlank(iobuffer.trim(),"Options"))    
                iobuffer = input.nextLine();
        }
        option = iobuffer.charAt(0);

        switch (option)
        {
            case '1':                        
            //search Movie from the list
            searchMovie();
            break;

            case '2':
            //search Movie from the list by director
            searchByDirector();
            break;                                
        }
    }

    /**
     * A method to search movie
     * 
     * @param
     * @return 
     */
    private void searchMovie() //not case-sensitive source.toLowerCase().contains(target.toLowerCase())
    {
        System.out.println("=== Search Movie ===");
        //input
        Scanner input = new Scanner(System.in);
        System.out.println("Search Movie , please insert a keyword to search by title:");
        String newMovieName = input.nextLine().toLowerCase();

        while(validBlank(newMovieName,"Movie Name"))
            newMovieName = input.nextLine().toLowerCase();

        //searchMovie()
        ArrayList<Movie> resultList = newMovieList.searchMovie(newMovieName);

        //display Movie details
        System.out.println("Search Result");
        for (int j = 0 ; j < resultList.size() ; j++)
        {
            resultList.get(j).displayMovieRecord();
        }

        if (resultList.size() == 0)
            System.out.println("No matched result");
    }

    /**
     * A method to search movie by director
     * 
     * @param
     * @return 
     */
    private void searchByDirector() //not case-sensitive source.toLowerCase().contains(target.toLowerCase())
    {
        System.out.println(" ");
        System.out.println("=== Search Movie by Director ===");
        //input
        Scanner input = new Scanner(System.in);
        System.out.println("Search Movie , please insert a keyword to search by director:");
        String newMovieName = input.nextLine().toLowerCase();

        while(validBlank(newMovieName,"Director Name"))
            newMovieName = input.nextLine().toLowerCase();

        //searchByDirector()
        ArrayList<Movie> resultList = newMovieList.searchByDirector(newMovieName);

        //display Movie details
        System.out.println("Search Result");
        for (int j = 0 ; j < resultList.size() ; j++)
        {
            resultList.get(j).displayMovieRecord();
        }

        if (resultList.size() == 0)
            System.out.println("No matched result");
    }

    /**
     * A method to start operating the system
     * 
     * @param
     * @return 
     */
    public void start()
    {
        //Scanner
        Scanner input = new Scanner(System.in);
        Boolean isOperating = true;

        //read from file
        readFile();

        while (isOperating)
        {                        
            //display menu 
            displayMenu();

            //insert case
            String iobuffer = input.nextLine(); 
            System.out.println("");

            //check console.nextLine() is not null or blank
            if (validBlank(iobuffer,"Option"))
            { 
                char option = iobuffer.charAt(0);

                //if option not in 1,2,3,4,5 Error message: please insert from (1) to (5)!
                if (validOption(option))
                {
                    switch (option)
                    {
                        case '1':
                        searchCase();
                        break;
                        case '2':
                        //add Movie to the list
                        addMovie();
                        break;
                        case '3':
                        //delete Movie from the list
                        deleteMovie();
                        break;
                        case '4':
                        //display Favourate Movie
                        displayFavourateMovie();    
                        break;
                        case '5':
                        //Edit Movie from the list (Actors and Rating) (HD)
                        editMovie();
                        break;
                        case '6':
                        //Exit system, and reset variables
                        isOperating = exitSystem();
                        break;
                    }
                }

                if (!isOperating)
                {
                    System.out.println("");
                    System.out.println("Thank you for using Movie Database System, Goodbye!");
                }
            }
        }
    }

    /**
     * Method to check insert any emptys or blank
     * 
     * @param iobuffer the iobuffer
     * @param subject the subject
     * @return the boolean of checkBlank
     */
    private boolean validBlank(String iobuffer,String subject) //method to check insert any empties or blanks
    {
        if (subject.equals("Option"))
        {
            //if iobuffer isEmpty or iobuffer.length() > 1 , Error : please insert from (1) to (5)! and return false to break if condition
            if (iobuffer.isEmpty() || iobuffer.length() > 1)
            {
                System.out.println("Error : please insert from (1) to (6)!");
                return false;
            }
            return true;
        }
        else
        {    
            //iobuffer.trim().isEmpty(), "Error: subject's name shouldn't be blank! Please enter the name again:" and return true to keep while condition
            if (iobuffer.trim().isEmpty())
            {
                System.out.println("Error: " + subject + " shouldn't be blank! Please enter the name again:");
                return true;
            }
        }
        return false;
    }

    /**
     * Method to check Delete selection is from 1 to size
     * 
     * @param index the index to be validated, the size
     * @return the boolean of checkDelSelection
     */
    private boolean validDelSelection(int index, int size) //method to check int index
    {
        //check if rating is from 1 to size  and return false to break while loop
        if (index < 0 || index > size)
        {
            System.out.println("Error : please insert from (1) to (" + size +")!");
            System.out.print("Please insert :");
            return true;
        }
        return false;
    }

    /**
     * Method to check Movie Name repeatation
     * 
     * @param MovieName the Name
     * @return the boolean of Movie Name repeatation
     */
    private boolean validMovieName(String movieName) //method to check Movie Name repeatation
    {
        //check if movie title is not in database , and return false to break while loop

        boolean isRepeated = newMovieList.validMovieName(movieName);
        if (isRepeated)
        {
            System.out.println("Error : Title name existed , please insert another Movie Title!");
            return isRepeated;
        }
        return false;
    }

    /**
     * Method to check char option
     * 
     * @param option the option
     * @return the boolean of checkOption
     */
    private boolean validOption(char option) //method to check char option
    {
        //check if option is in 1,2,3,4,5,6 , and return false to break if condition , 6 for (HD)
        if (option < '1' || option > '6')
        {
            System.out.println("Error : please insert from (1) to (6)!");
            return false;
        }
        return true;        
    }

    /**
     * Method to check rating is between 1 and 10
     * 
     * @param rating the rating
     * @return the boolean of checkRating
     */
    private boolean validRating(int rating) //method to check int rating
    {
        //check if rating is in 1,2,3,4,5,6,7,8,9,10  and return false to break while loop
        if (rating < 1 || rating > 10)
        {
            System.out.println("Error : please insert from (1) to (10)!");
            System.out.print("Please insert :");
            return true;
        }
        return false;
    }

    /**
     * Method to check insert any space
     * 
     * @param iobuffer the iobuffer
     * @return the boolean of checkBlank
     */
    private boolean validSpace(String iobuffer) //method to check insert any space characters only on Actor2 or Actor3
    {
        //Actor2 or Actor3.charAt(0) == ' ', "Error: subject's name shouldn't be space only! Please enter the name again:" and return true to keep while condition
        if (iobuffer.isEmpty())
            return false;
        else if (iobuffer.charAt(0) == ' ')
        {
            System.out.println("Error: Actor2 or Actor3's name shouldn't be space only or start by space character! Please enter the name again:");
            return true;
        }
        return false;
    }

    /**
     * A method to write to file
     * 
     * @param  
     * @return
     * @throws IOException while exception during I/O actions
     */
    private void writeFile()
    {
        String filename = ("myvideos.txt");
        //use movie.getNumbersOfElement() to replace 6
        String[] videos = new String[6];
        Scanner input = new Scanner(System.in);
        String line = "";
        int numberOfVideos;
        MovieDatabase toWriteMovieList = new MovieDatabase();
        
        // put your code here
        System.out.println("How many movies your want to insert :");
        //numberOfVideos = convertStringtoInt(input.nextLine());
        numberOfVideos = newMovieList.getNumbersOfMovies();
        System.out.println(numberOfVideos + "");
        try
        {
            PrintWriter outputFile = new PrintWriter (filename);

            for (int i = 0 ; i < numberOfVideos ; i++ )
            {
                //System.out.println("Please insert Videos " + (i + 1) + "'s Title :");
                videos[0] = newMovieList.getMovieList().get(i).getTitle();
                //System.out.println("Please insert Videos" + (i + 1) + "'s Director :");
                videos[1]  = newMovieList.getMovieList().get(i).getDirector();

                //for loop to replace 2,3,4
                for (int j = 2 ; j < newMovieList.getMovieList().get(i).getActorList().getNumbersOfActors() + 2 ; j++ )
                {
                    //videos[index] = newMovieList.getMovieList().get(i).getActorList().getListOfActors().get(j - 2).getName()
                    videos[j]  = newMovieList.getMovieList().get(i).getActorList().getListOfActors().get(j - 2).getName();
                }

                videos[newMovieList.getMovieList().get(i).getNumbersOfElements() - 1]  = newMovieList.getMovieList().get(i).getRating() + "";

                //combine elements into a line
                for (int k = 0 ; k < newMovieList.getMovieList().get(i).getNumbersOfElements() ; k++ )
                {   
                    //line = videos[0] + "," + videos[1] + "," + videos[2] + "," + videos[3] + "," + videos[4] + "," + videos[5];
                    if (k != (newMovieList.getMovieList().get(i).getNumbersOfElements() - 1))
                        line = line + videos[k] + ",";
                    else
                        line = line + videos[k];
                }
                //display a message about write line
                System.out.println("");
                System.out.println("Write a message in line to a file");
                System.out.println("");

                outputFile.println(line);
                //reset line
                line = "";
            }
            outputFile.close();    
        }
        catch(IOException exception)
        {
            System.out.println("Unexpected I/O error occured");
        }
    }
}