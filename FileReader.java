import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * Class FileReader reads a .cvs (Comma Separated Value) file.
 * 
 * The following sources were used/referenced in the making of this file:
 *      -https://stackoverflow.com/questions/14274259/read-csv-with-scanner
 *      -https://stackoverflow.com/questions/14721397/checking-if-a-string-is-empty-or-null-in-java
 *      -http://www.dummies.com/programming/java/use-array-lists-in-java/
 *      
 * @author Fernando Garcia Toro 
 * @version 11/29/2017
 */

public class FileReader
{    
    public static void main(String args[]){
       File file = new File (getFile());
       
       //This will not compile w/o the try-catch
       try{
           Scanner sc = new Scanner(file);  
           sc.useDelimiter(",");
           
           printArrayList( fillArrayList(sc) );
           //printToScreen(sc);

       }catch (FileNotFoundException exception){
       }
    }
    
    public static ArrayList<ArrayList> JoshCallThis (){
       ArrayList<ArrayList> list = new ArrayList<ArrayList>();
        
       File file = new File (getFile());
        
        try{
           Scanner sc = new Scanner(file);  
           sc.useDelimiter(",");
           
          
           list = fillArrayList(sc);
           
           return list;
       }catch (FileNotFoundException exception){
       }
       return list;
    }
    
    //This method will get us the name of the file
    public static String getFile(){
       Scanner keyboard = new Scanner(System.in); 
       
       System.out.println("What is the name of the file");
       String fileName = keyboard.nextLine() + ".csv";
       System.out.println();
       
       return fileName;
    }
    
    //This method creates an ArrayList and fills it with the .csv file's data
    public static ArrayList<ArrayList> fillArrayList(Scanner sc){ 
        ArrayList<ArrayList> list = new ArrayList<ArrayList>();
        
        String nextValue = "";
        
        boolean nameNext = false; //This will let us know when a name is coming up
        int counter = 0;       //This will lead us through list
        
        while(sc.hasNext()){
            ArrayList<String> fileData = new ArrayList<String>(); //creates ArrayList of Strings that we will populate
            nextValue = sc.next();
            
            if ( nextValue.contains("EST") ){
                nameNext = true;
            }
            
            if ( nameNext && !nextValue.contains("EST") ){
                list.add(fileData);             //adds new Arraylist to list
 
                fileData.add(nextValue);        //fileData gets its first data value   
                
                nameNext = false;
                
                counter++;
            }else
            if ( nextValue.contains("Maybe") ){
                //list.add(fileData);
                
                fileData = list.get(counter - 1);  //Gives fileData the previous values in it's index in list

                fileData.add("0"); 
            }else
            if ( nextValue.contains("Yes") ){   
                //list.add(fileData);
                
                fileData = list.get(counter - 1);

                fileData.add("1");
            }else
            if (nextValue.contains("No") ){  
               //list.add(fileData);
               
               fileData = list.get(counter - 1);

               fileData.add("-1");
            }else
            
            if ( nextValue.contains("Med-10") ){  
                //list.add(fileData);
                
                fileData = list.get(counter - 1);
                
                fileData.add("10");
            }else
            if ( nextValue.contains("Med-12") ){                          
                //list.add(fileData);
                
                fileData = list.get(counter - 1);
         
                fileData.add("13");

            }else
            if (nextValue.contains("Med-13") ){                     
               //list.add(fileData);
               
               fileData = list.get(counter - 1);
            
               fileData.add("13"); 
            }
        }
        
        return list;
    }
    
    //This method prints an ArrayList
    public static void printArrayList(ArrayList<ArrayList> fileData){
        int counter = 0;
        
        while (counter < fileData.size()){
            System.out.println( fileData.get(counter) );
            counter++;
        }
    }
}
