import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * Class FileReader reads a .csv (Comma Separated Value) file.
 * 
 * The following sources were used/referenced in the making of this file:
 *      -https://stackoverflow.com/questions/14274259/read-csv-with-scanner
 *      -https://stackoverflow.com/questions/14721397/checking-if-a-string-is-empty-or-null-in-java
 *      -http://www.dummies.com/programming/java/use-array-lists-in-java/
 *      
 * @author Fernando Garcia Toro 
 * @version 12/05/2017
 */

public class FileReader
{          
    //This method will get us the name of the file
    public static String getFile(){
       Scanner keyboard = new Scanner(System.in); 
       
       System.out.println("What is the name of the file");
       String fileName = keyboard.nextLine() + ".csv";
       System.out.println();
       
       return fileName;
    }
        
    //This is the method that should be called in order to retrieve the ArrayList filled with data
    public static ArrayList<ArrayList<String>> output(){
       ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>(); //creates an ArrayList of String ArraayLists
        
       File file = new File (getFile());  //gives us the name of the file to use
       
       //It is necessary to catch an exception in case the file cannot be found
        try{
           Scanner sc = new Scanner(file);
           sc.useDelimiter(",");             //we are using .csv (comma separated value) files exclusively
             
           list = fillArrayList(sc);        //fills the ArrayList
           
           return list;                     //outputs the ArrayList
       }catch (FileNotFoundException exception){
       }
       return list;
    }
    
    //This method creates an ArrayList and fills it with the .csv file's data
    public static ArrayList<ArrayList<String>> fillArrayList(Scanner sc){ 
        ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
        
        String nextValue = "";
        
        boolean nameNext = false;   //This will let us know when a name is coming up
        int counter = 0;            //This will lead us through list
        
        while(sc.hasNext()){
            ArrayList<String> fileData = new ArrayList<String>(); //creates ArrayList of Strings that we will populate
            nextValue = sc.next();
            
            //"EST" is found in every data value preceding a name, this checks for it
            if ( nextValue.contains("EST") ){
                nameNext = true;
            }
            
            //Only true for the data value after the timestamp, this data value will always be the name
            if ( nameNext && !nextValue.contains("EST") ){
                list.add(fileData);             //adds new Arraylist to list
                
                String name = nextValue.replace('"',' '); //gets rid of quotation marks that GooglForms adds to names
                fileData.add(name);              //fileData gets its first data value   
                
                nameNext = false;                //resets for the next name value
                
                counter++;
            }else
            
            //These check for and record responses, No = -1, Maybe = 0, Yes = 1
            if ( nextValue.contains("Maybe") ){               
                fileData = list.get(counter - 1);  //Gives fileData the previous values in its index in list

                fileData.add("0"); 
            }else
            if ( nextValue.contains("Yes") ){            
                fileData = list.get(counter - 1);

                fileData.add("1");
            }else
            if (nextValue.contains("No") ){  
               fileData = list.get(counter - 1);

               fileData.add("-1");
            }else
            
            //These check for and record rank
            if ( nextValue.contains("Med-10") ){            
                fileData = list.get(counter - 1);
                
                fileData.add("10");
            }else
            if ( nextValue.contains("Med-12") ){                                   
                fileData = list.get(counter - 1);
         
                fileData.add("12");
            }else
            if (nextValue.contains("Med-13") ){                                  
               fileData = list.get(counter - 1);
            
               fileData.add("13"); 
            }
        }       
        return list;
    }
        
    
    //This method prints the ArrayList, it used for debugging
    public static void printArrayList(ArrayList<ArrayList<String>> fileData){
        int counter = 0;
        
        while (counter < fileData.size()){
            System.out.println( fileData.get(counter) );
            counter++;
        }
    }  
    
    //The main method is used for testing the functionality of all methods in the class
    public static void main(String args[]){
       File file = new File (getFile());
       
       //This will not compile w/o the try-catch
       try{
           Scanner sc = new Scanner(file);  
           sc.useDelimiter(",");
           
           printArrayList( fillArrayList(sc) );
           
           System.out.println();
           
           printArrayList( output() );

       }catch (FileNotFoundException exception){
       }
    }
}
