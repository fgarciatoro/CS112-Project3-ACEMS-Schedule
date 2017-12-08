import java.util.ArrayList;

public class algorithmACEMS{
  static ArrayList<ArrayList<pointedMember>> allPointedMembers = new ArrayList<ArrayList<pointedMember>>();
  static ArrayList<String> BSmembers = new ArrayList<String>();
  
  //each ArrayList<pointedMember> will be a list ranking all the members for a specific shift
  //and allPointedMembers will be an arraylist of all those lists (i.e. one list for every shift in order)
  
  //all the double pointsToAdd values are realtive to how many members there are (Shift.allMembers.size())
  
public algorithmACEMS(){

}

public static void main(String args[]){
  //so nothing actually needs to happen in here, so do we actually need a main?...
 
  }//end bracket for Main()
	
public static ArrayList<pointedMember> getSortedShifts(String startDow){
	//this is the only method that will be called in calGraph and it will return the proper list for the shifts. This method also calls all the other computational methods in this program
	//as of now, we will be calling this method/doing this 3 times (once for each rank) 
  defineAllPointedMembers();
  
  prioritizeShiftsWithFewMembers();
  
  prioritizeMembersWithFewShifts();
  
  prioritizeBusyShifts(startDow);
	
  ArrayList<pointedMember> sortedShifts = new ArrayList<pointedMember>();
	
  for(int i = 0; i < allPointedMembers.size(); i++){
		sortedShifts.add( allPointedMembers.get(i).get(0) );
		
		for(int j = 0; j < allPointedMembers.get(0).size(); j++){
			
			if(sortedShifts.get(i).points < allPointedMembers.get(i).get(j).points){
			sortedShifts.set(i, allPointedMembers.get(i).get(j) );
			}
		
		}//end of j for loop
	}//end of i for loop
	
	return sortedShifts;
}
	
public static void defineAllPointedMembers(){
    
    Shift.defineMembers(FileReader.output());
  
        String tempName = "";
        for(int i = 0; i < Shift.allMembers.size(); i++){
        tempName = Shift.allMembers.get(i).name;

        for(int j = 0; j < Shift.allMembers.get(0).availability.size(); j++){

	    pointedMember temp = new pointedMember(tempName, 0);

          if( Shift.allMembers.get(i).availability.get(j).equals("1") ){
            double pointsToAdd = (Shift.allMembers.size());
            temp.addPoints(pointsToAdd);
          }
          if( Shift.allMembers.get(i).availability.get(j).equals("0") ){
            double pointsToAdd = (Shift.allMembers.size()/2);
            temp.addPoints(pointsToAdd);
          }
          allPointedMembers.get(j).add(temp);

        }//end bracket for inner j for loop

      }//end bracket for outer i for loop
    
    //so after these for loops, we should have a pointedMember for each member with their name and an initial point value for each shift
 
    return;
  }

  public static void prioritizeShiftsWithFewMembers(){ 
    //this assigns additional points to members on shifts where there are relatively few members that can take the shift 
    //Note: This method DOES take into account the ifNeedBe members for each shift, so if theres 2 yesses and 1 ifNeedBe, the person with the ifNeedBe will still get some bonus points
    
   for(int j = 0; j < Shift.allMembers.get(0).availability.size(); j++){

      double numWithPoints = 0.0;
	 
      for(int i = 0; i < Shift.allMembers.size(); i++){
   
        if( Shift.allMembers.get(i).availability.get(j).equals("1") ){
       
	    numWithPoints = numWithPoints + 1;
        }
        if( Shift.allMembers.get(i).availability.get(j).equals("0") ){
       	   
	     numWithPoints = numWithPoints + .5;
        }
       
      }//end of i for loop

   
      for(int k = 0; k < allPointedMembers.get(0).size(); k++){

	  if( Shift.allMembers.get(k).availability.get(j).equals("1") || Shift.allMembers.get(k).availability.get(j).equals("0") ){
         double pointsToAdd = (Shift.allMembers.size()/numWithPoints );
         allPointedMembers.get(j).get(k).addPoints( pointsToAdd ); 
        }//end of if statement
	
      }//end of k for loop
      
      
     }//end of j for loop
    
    return;
  }
  
  public static void prioritizeMembersWithFewShifts(){
    //Note: this method does not take into account hte ifNeedBe shifts, it only counts the number of shifts that a member can take ("1") and assigns according to that
    
    for(int i = 0; i < Shift.allMembers.size(); i++){
      
      double numShifts = 0;
      for(int j = 0; j < Shift.allMembers.get(i).availability.size(); j++){
        if( Shift.allMembers.get(i).availability.get(j).equals("1") ){
          numShifts++;
        }
      }//end of j1 for loop
      
      for(int j = 0; j < Shift.allMembers.get(i).availability.size(); j++){
        if( Shift.allMembers.get(i).availability.get(j).equals("1") ){
          double pointsToAdd = (allPointedMembers.size()/numShifts);
          allPointedMembers.get(j).get(i).addPoints( pointsToAdd );
        }
      }//end of j2 for loop
      
    }//end of i for loop
    
   return; 
  }
  
  public static void prioritizeBusyShifts(String startDow){
    
	  BSmembers = VIPMember.getPriorityBS();

	  int fridayPM = 0;
	  int saturdayPM = 0;


	  
    if(startDow.equals("Sunday")){
        fridayPM = 12;
        saturdayPM = 14;
      }
    if(startDow.equals("Monday")){
        fridayPM = 10;
        saturdayPM = 12;
      }
    if(startDow.equals("Tuesday")){
        fridayPM = 8;
        saturdayPM = 10;
      }
    if(startDow.equals("Wednesday")){
        fridayPM = 6;
        saturdayPM = 8;
      }
    if(startDow.equals("Thursday")){
        fridayPM = 4;
        saturdayPM = 6;
      }
    if(startDow.equals("Friday")){
        fridayPM = 2;
        saturdayPM = 4;
      }
    if(startDow.equals("Saturday")){
        fridayPM = 14;
        saturdayPM = 2;
      }
  
        for(int j = 0; j < Shift.allMembers.get(0).availability.size(); j++){
          for(int k = 0; k < Shift.allMembers.size(); k++){
            
            if( ( (j == fridayPM) || (j == saturdayPM) ) && Shift.allMembers.get(k).availability.get(j).equals("1") && BSmembers.contains(Shift.allMembers.get(k).name) ){
              
              
              allPointedMembers.get(j).get(k).addPoints(20);
              //this selectsthe right pointedMember because the order of pintedMembers for each shift is in the same order of all the members in Shifts.allMembers()
              //also for right now, I'm adding 20 points for each priority BS person, we can change that though
              
            }//end of if
          }//end of k for loop
          
        }//end of j for loop
  
   
    return;
  }
	

  
}//end bracket for the whole program 
