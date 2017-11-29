import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * Class FileReader reads a .cvs (Comma Separated Value) file.
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
    
    //This method checks for days in the header
    public static boolean checkDay(String s){
        boolean dayFound = false;
        
        if (s.contains("Sun") || s.contains("Mon")|| s.contains("Tue") || s.contains("Wed") ||
        s.contains("Thu") || s.contains("Fri") || s.contains("Sat") || s.contains("August")){
                dayFound = true;
            }
        return dayFound;
    }
    //This method prints out the file's data to the screen/calendar
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
            if (nextValue.equals("") && counter != 0){ //This isn't working
               System.out.print(" No  | ");
            }else
            if (nextValue.contains("Scheduling") || nextValue.contains("Poll") || nextValue.contains("doodle")){
            }else
            if (nextValue.contains("Count")){
                return;
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
}
