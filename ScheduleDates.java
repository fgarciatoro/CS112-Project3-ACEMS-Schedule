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
        
        String startDoW;
        int startD;
        int startM;
        int startY;
        
        System.out.println("On what day of the week does the schedule start? (Ex: Monday) ");
        startDoW = keyboard.nextLine();
        System.out.println();
        
        System.out.println("On what day of the month does the schedule start? (Ex: 1 for Monday, Dec. 1st) ");
        startD = keyboard.nextInt();    
        System.out.println();
        
        System.out.println("During what month does the schedule begin? ");
        System.out.println("Enter the month's number. (Ex: For January, enter '1' ");
        startM = keyboard.nextInt();    
        System.out.println();
        
        System.out.println("During what year does the schedyle start? (Ex: 2017)");
        startY = keyboard.nextInt();    
        System.out.println();
        
    }
    
    //This asks for and records the day, month, year, and day of the week that the schedule ends
    public static void ScheduleEnd(){
        Scanner keyboard = new Scanner(System.in); 
        
        String endDoW;
        int endD;
        int endM;
        int endY;
        
        System.out.println("On what day of the week does the schedule end? (Ex: Friday) ");
        endDoW = keyboard.nextLine();
        System.out.println();
        
        System.out.println("On which day of the month does the schedule end? (Ex: Enter '14' for Monday, Dec. 14th) ");
        endD = keyboard.nextInt();    
        System.out.println();
        
        System.out.println("During what month does the schedule begin? ");
        System.out.println("Enter the month's number. (Ex: For January, enter '1' ");
        endM = keyboard.nextInt();    
        System.out.println();
        
        System.out.println("During what year does the schedule end? (Ex: 2018)");
        endY = keyboard.nextInt();    
        System.out.println();
        
    }
    
}
