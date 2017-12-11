import java.util.ArrayList;

/**
 * Write a description of class RankSorter here.
 * 
 * @author Fernando Garcia Toro
 * @version 12/9/2017
 */
public class RankSorter
{
    static ArrayList<ArrayList<String>> rank10s = new ArrayList<ArrayList<String>>();
    static ArrayList<ArrayList<String>> rank12s = new ArrayList<ArrayList<String>>();
    static ArrayList<ArrayList<String>> rank13s = new ArrayList<ArrayList<String>>();
    
    public static void sortByRank(ArrayList<ArrayList<String>> list)
    {
        list = FileReader.output();
        
        int counter = 0;
        
        while(counter < list.size()){
            ArrayList<String> fileData = new ArrayList<String>();
            
            if (list.get(counter).get(1).equals("10")){
                fileData = list.get(counter);
                
                rank10s.add(fileData);
            }
            if (list.get(counter).get(1).equals("12")){
                fileData = list.get(counter);
                
                rank12s.add(fileData);
            }
            if (list.get(counter).get(1).equals("13")){
                fileData = list.get(counter);
                
                rank13s.add(fileData);
            }
        }
    }
    
    
    public static void printArrayList(ArrayList<ArrayList<String>> fileData){
        int counter = 0;
        
        while (counter < fileData.size()){
            System.out.println( fileData.get(counter) );
            counter++;
        }
    }  
        
    public static void main(String args[]){
      printArrayList(rank10s);
      printArrayList(rank12s);
      printArrayList(rank13s);
    }
}
