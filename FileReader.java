import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * Write a description of class Test here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class FileReader
{    
    public static void main(String args[]){
       File file = new File (getFile());
       try{
           Scanner sc = new Scanner(file);  //This will not compile w/o the try-catch
           sc.useDelimiter(",");
           
           printToScreen(sc);

       }catch (FileNotFoundException exception){
       }
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
    
    public static void printToScreen(Scanner sc){
        String nextValue = "";
        int counter = 0;
        while(sc.hasNext()){
            nextValue = sc.next();
            if (nextValue.contains("(OK)")){
                System.out.print("Maybe | ");
            }else
            if (nextValue.contains("OK")){
                System.out.print(" Yes  | ");
            }else
            if (nextValue == ""){
               System.out.print(" No  | ");
            }else
            if (nextValue.contains("Scheduling") || nextValue.contains("Poll") || nextValue.contains("doodle")){
            }else
            if (nextValue.contains("Count")){
                return;
            }else{
                System.out.print(nextValue);
            }
        }
    }
}
