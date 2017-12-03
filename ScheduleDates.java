import java.util.Scanner;
/**
 * Class ScheduleDates
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ScheduleDates
{

    /**
     * Constructor for objects of class ScheduleStart
     */
    public static void main(String args[])
    {
        ScheduleStart();
        ScheduleEnd();
    }
    
    //This asks for and records the day, month, year, and day of the week that the schedule begins
    public static void ScheduleStart(){
        Scanner keyboard = new Scanner(System.in); 
        
        String DoW;
        int day;
        int month;
        int year;
        
        System.out.println("On what day of the week does the schedule begin? (Ex: Monday) ");
        DoW = keyboard.nextLine();
        System.out.println();
        
        System.out.println("On which day of the month does this day fall? (Ex: 1 for Monday, Dec. 1st) ");
        day = keyboard.nextInt();    
        System.out.println();
        
        System.out.println("On which month does the schedule begin? ");
        System.out.println("Enter the month's number. (Ex: For January, enter '1' ");
        month = keyboard.nextInt();    
        System.out.println();
        
        System.out.println("What year is it?");
        year = keyboard.nextInt();    
        System.out.println();
        
    }
    
    //This asks for and records the day, month, year, and day of the week that the schedule ends
    public static void ScheduleEnd(){
        Scanner keyboard = new Scanner(System.in); 
        
        String DoW;
        int day;
        int month;
        int year;
        
        System.out.println("On what day of the week does the schedule end? (Ex: Friday) ");
        DoW = keyboard.nextLine();
        System.out.println();
        
        System.out.println("On which day of the month does this day fall? (Ex: Enter '14' for Monday, Dec. 14th) ");
        day = keyboard.nextInt();    
        System.out.println();
        
        System.out.println("On which month does the schedule begin? ");
        System.out.println("Enter the month's number. (Ex: For January, enter '1' ");
        month = keyboard.nextInt();    
        System.out.println();
        
        System.out.println("What year is it?");
        year = keyboard.nextInt();    
        System.out.println();
        
    }
    
}
