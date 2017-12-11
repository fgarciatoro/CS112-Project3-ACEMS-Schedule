import java.util.Scanner;
import java.util.ArrayList;

/**
 * VIPMember allows users to input the names of ACEMS members that will be prioritized for busy shifts
 * 
 * @author Fernando Garcia Toro
 * @version 12/6/2017
 */
public class VIPMember
{ 
    /**This method takes in the names of the people to be prioritized and returns their names
     * in an Arraylist of Strings. The method ends when 'stop' is typed.
    */
    public static ArrayList<String> getPriorityBS(){   
        Scanner keyboard = new Scanner(System.in);
        
        ArrayList<String> vipMembers = new ArrayList<String>();
        
        Boolean stop = false;
        
        System.out.println("The people you enter will be prioritized for busy shifts.");
        System.out.println("Enter 'Stop' to stop entering names.");
        
        while(!stop){
            String name;
            
            System.out.println("Enter a name:");
            name = keyboard.nextLine();
            System.out.println();
            
            if(name.equals("Stop") || name.equals("stop")){
                stop = true;
                return vipMembers;
            }else{
                vipMembers.add(name);
            }
        }     
        return vipMembers;
    }
    
    //This method prints the ArrayList, it used for debugging
    public static void printArrayList(ArrayList<String> aList){
        int counter = 0;
        
        while (counter < aList.size()){
            System.out.println( aList.get(counter) );
            counter++;
        }
    }
     //The main method is here exclusively to test the functionality of all other methods in the class
    public static void main(String args[]){
       printArrayList(getPriorityBS());
    }
}
