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
       // ScheduleStart();
        //ScheduleEnd();
    }
    
    //These asks for and records the day, month, year, and day of the week that the schedule begins
    public static String getStartDow(){
        Scanner keyboard = new Scanner(System.in); 
        
        String startDow = "";
       
        System.out.println("On what day of the week does the schedule start? (Ex: Monday) ");
        startDow = keyboard.nextLine();
        System.out.println();
        
        return startDow;
    }
    
    public static int getStartD(){
        Scanner keyboard = new Scanner(System.in);  
        int startD;
        
        System.out.println("On what day of the month does the schedule start? (Ex: 1 for Monday, Dec. 1st) ");
        startD = keyboard.nextInt();    
        System.out.println();
        
        return startD;
    }
        
        
    public static int getStartM(){
        Scanner keyboard = new Scanner(System.in);     
        int startM;
        
        System.out.println("During what month does the schedule begin? ");
        System.out.println("Enter the month's number. (Ex: For January, enter '1' ");
        startM = keyboard.nextInt();    
        System.out.println();
        
        return startM;
    }
        
        
    public static int getStartY(){
        Scanner keyboard = new Scanner(System.in); 
        int startY;
        
        System.out.println("During what year does the schedyle start? (Ex: 2017)");
        startY = keyboard.nextInt();    
        System.out.println();
        
        return startY;      
    }
    
    //These asks for and records the day, month, year, and day of the week that the schedule ends
    public static String getEndDow(){
        Scanner keyboard = new Scanner(System.in); 
        
        String endDow = "";
        
        System.out.println("On what day of the week does the schedule end? (Ex: Friday) ");
        endDow = keyboard.nextLine();
        System.out.println();
        
        return endDow;
    }
        
    public static int getEndD(){
        Scanner keyboard = new Scanner(System.in); 
        int endD;
        
        System.out.println("On which day of the month does the schedule end? (Ex: Enter '14' for Monday, Dec. 14th) ");
        endD = keyboard.nextInt();    
        System.out.println();
        
        return endD;
    }
      
    public static int getEndM(){
        Scanner keyboard = new Scanner(System.in);
        int endM;
        
        System.out.println("During what month does the schedule begin? ");
        System.out.println("Enter the month's number. (Ex: For January, enter '1' ");
        endM = keyboard.nextInt();    
        System.out.println();
        
        return endM;
    }
    
    public static int getEndY(){
        Scanner keyboard = new Scanner(System.in);
        int endY;
        
        System.out.println("During what year does the schedule end? (Ex: 2018)");
        endY = keyboard.nextInt();    
        System.out.println();
        
        return endY;
    }
        
    
    
}
