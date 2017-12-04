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
    
    //Jason  wrote this new method so that Josh can get your arraylist stuff :) 
    public static ArrayList<ArrayList> joshCallThis(){
        
        return fillArrayList(sc);
     
    }
    
    
    //This method will get us the name of the file
    public static String getFile(){
       Scanner keyboard = new Scanner(System.in); 
       
       System.out.println("What is the name of the file");
       String fileName = keyboard.nextLine() + ".csv";
       System.out.println();
       
       return fileName;
    }
    
    //This method checks for the month in the header
    public static boolean checkMonth(String s){
        boolean monthFound = false;
        
        if (s.contains("January") || s.contains("February")|| s.contains("March") || s.contains("April") ||
        s.contains("May") || s.contains("June") || s.contains("July") || s.contains("August") ||
        s.contains("September") || s.contains("October") || s.contains("November") || s.contains("December")){
                monthFound = true;
            }
        return monthFound;
    }
    
    //This method checks for days in the header
    public static boolean checkDay(String s){
        boolean dayFound = false;
        
        if (s.contains("Sun") || s.contains("Mon")|| s.contains("Tue") || s.contains("Wed") ||
        s.contains("Thu") || s.contains("Fri") || s.contains("Sat") || s.contains("August")){
                dayFound = true;
            }
        return dayFound;
    }
    
    //This method prints out the file's data to the screen
    public static void printToScreen(Scanner sc){
        String nextValue = "";
        int counter = 0;
        while(sc.hasNext()){
            nextValue = sc.next();
            if(nextValue.contains("AM") || nextValue.contains("PM")){
                System.out.print(" " + nextValue + " |");
                counter++;
            }else
            if (nextValue.contains("(OK)")){
                System.out.print("Maybe | ");
            }else
            if (nextValue.contains("OK")){
                System.out.print(" Yes  | ");
            }else
            if (nextValue.equals("") && counter != 0){
               System.out.print(" No  | ");
            }else
            if (nextValue.contains("Scheduling") || nextValue.contains("Poll") || nextValue.contains("doodle")){
            }else
            if (nextValue.contains("Count")){
                System.exit(0);
            }else
            if (checkMonth(nextValue)){
                System.out.print(nextValue + " | ");
            }else
            if (checkDay(nextValue)){
                System.out.print(nextValue + " | ");
            }else
            {
                System.out.print(nextValue);
            }
        }
    }
    
    //This method creates an ArrayList and fills it with the .csv file's data
    public static ArrayList<ArrayList> fillArrayList(Scanner sc){ 
        ArrayList<ArrayList> list = new ArrayList<ArrayList>();
        
        //ArrayList<String> fileData = new ArrayList<String>();
        
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
            if ( nextValue.contains("Med-13") ){                          
                //list.add(fileData);
                
                fileData = list.get(counter - 1);
         
                fileData.add("13");

            }else
            if (nextValue.contains("Med-15") ){                     
               //list.add(fileData);
               
               fileData = list.get(counter - 1);
            
               fileData.add("15"); 
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
