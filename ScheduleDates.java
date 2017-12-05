import java.util.Scanner;

/**
 * Class ScheduleDates asks for and records the day, month, year, and day of the week that schedules start and end
 * 
 * @author Fernando Garcia Toro, Jason Greenfield
 * @version 12/5/2017
 */
public class ScheduleDates
{    
    static Scanner keyboard = new Scanner(System.in); //Creates scanner to be used in all methods
    
    //This method asks for and records day of the week that the schedule begins
    public static String getStartDow(){        
        String startDow = "";
        boolean acceptable = false;
        
        while(!acceptable){
            System.out.println("On what day of the week does the schedule start? (Ex: Monday) ");
            startDow = keyboard.nextLine();     //records answer
            System.out.println();               //adds spacing for legibility
            
            //Checks to see if answer is acceptable
            if (startDow.equals("Sunday") || startDow.equals("Monday") ||startDow.equals("Tuesday") ||startDow.equals("Wednesday") ||
                    startDow.equals("Thursday") || startDow.equals("Friday") || startDow.equals("Saturday")){
                 acceptable = true;
            }else{
                System.out.println("That answer is unacceptable, try again.");
            }
        }      
        return startDow;
    }    
    //This method asks for and records the day of the month that the schedule begins
    public static int getStartD(){
        int startD = 0;
        boolean acceptable = false;
        
        while(!acceptable){
            System.out.println("On what day of the month does the schedule start? (Ex: Enter '1' for Dec. 1st) ");
            startD = keyboard.nextInt();    
            System.out.println();
            
            if (startD <= 31 && startD > 0){
                acceptable = true;
            }else{
                System.out.println("That answer is unacceptable, try again.");
            }
        }    
        return startD;
    }    
    //This method asks for and records the month that the schedule begins
    public static int getStartM(){  
        int startM = 0;
        boolean acceptable = false;
        
        while(!acceptable){
            System.out.println("During what month does the schedule begin? ");
            System.out.println("Enter the month's number. (Ex: For January, enter '1') ");
            startM = keyboard.nextInt();    
            System.out.println();
        
            if (startM <=12 && startM > 0){
                acceptable = true;
            }else{
                System.out.println("That answer is unacceptable, try again.");
            } 
        }
        return startM;
    }                
    //This method asks for and records year that the schedule begins
    public static int getStartY(){
        int startY;
        
        System.out.println("During what year does the schedule start? (Ex: 2017)");
        startY = keyboard.nextInt();    
        System.out.println();
        
        return startY;      
    }
        
    
    //This method asks for and records the day of the week that the schedule ends
    public static String getEndDow(){        
        String endDow = "";
        boolean acceptable = false;
        
        while(!acceptable){
            System.out.println("On what day of the week does the schedule end? (Ex: Friday) ");
            endDow = keyboard.nextLine();
            System.out.println();
        
            if (endDow.equals("Sunday") || endDow.equals("Monday") ||endDow.equals("Tuesday") ||endDow.equals("Wednesday") ||
                    endDow.equals("Thursday") || endDow.equals("Friday") || endDow.equals("Saturday")){
                 acceptable = true;
            }else{
                System.out.println("That answer is unacceptable, try again.");
            }
        }
        return endDow;
    }
    //This method asks for and records the day of the month that the schedule ends
    public static int getEndD(){
        int endD = 0;
        boolean acceptable = false;
        
        while(!acceptable){
            System.out.println("On which day of the month does the schedule end? (Ex: Enter '14' for Monday, Dec. 14th) ");
            endD = keyboard.nextInt();    
            System.out.println();
            
            if(endD <= 31 && endD > 0){
                acceptable = true;
            }else{
                System.out.println("That answer is unacceptable, try again.");
            }
        }
        return endD;
    }     
    //This method asks for and records the month that the schedule ends
    public static int getEndM(){
        int endM = 0;
        boolean acceptable = false;
        
        while(!acceptable){ 
            System.out.println("During what month does the schedule end? ");
            System.out.println("Enter the month's number. (Ex: For January, enter '1')");
            endM = keyboard.nextInt();    
            System.out.println();
            
            if(endM <= 12 && endM > 0){
                acceptable = true;
            }else{
                System.out.println("That answer is unacceptable, try again.");
            }   
        }
        return endM;
    }   
    //This method asks for and records year that the schedule ends
    public static int getEndY(){
        int endY;
        
        System.out.println("During what year does the schedule end? (Ex: 2018)");
        endY = keyboard.nextInt();    
        System.out.println();
        
        return endY;
    }  
    
    
    //The main method is here exclusively to test the functionality of all other methods in the class
    public static void main(String args[])
    {
       getStartDow();
       getStartD();
       getStartM();
       getStartY();
       
       getEndDow();
       getEndD();
       getEndM();
       getEndY();
    }
}