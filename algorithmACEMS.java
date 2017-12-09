import java.util.ArrayList;

public class algorithmACEMS{
  static ArrayList<ArrayList<Member>> allPointedMembers = new ArrayList<ArrayList<Member>>();
  static ArrayList<String> BSmembers = new ArrayList<String>();
  
  //each ArrayList<pointedMember> will be a list ranking all the members for a specific shift
  //and allPointedMembers will be an arraylist of all those lists (i.e. one list for every shift in order)
  
  //all the double pointsToAdd values are realtive to how many members there are (Shift.allMembers.size())
  
public algorithmACEMS(){

}

	
public static ArrayList<Member> getSortedShifts(String startDow, String rank1){
	//this is the only method that will be called in calGraph and it will return the proper list for the shifts. This method also calls all the other computational methods in this program
	//as of now, we will be calling this method/doing this 3 times (once for each rank) 
  
  prioritizeShiftsWithFewMembers();
  
  prioritizeMembersWithFewShifts();
  System.out.println("For Med-" + rank1 + "s:");
  prioritizeBusyShifts(startDow);

	
  ArrayList<Member> sortedShifts = new ArrayList<Member>();
	
  for(int i = 0; i < allPointedMembers.size(); i++){
	  for(int k = 0; k < allPointedMembers.get(i).size(); k++) {
		if(allPointedMembers.get(i).get(k).rank.equals(rank1)) {
		  sortedShifts.add( allPointedMembers.get(i).get(k) );
      break;
		}
	  }
	
		for(int j = 0; j < allPointedMembers.get(0).size(); j++){
			
			if(allPointedMembers.get(i).get(j).rank.equals(rank1)) {
				
			if((sortedShifts.get(i).points < allPointedMembers.get(i).get(j).points)){
			sortedShifts.set(i, allPointedMembers.get(i).get(j) );
			}
			}
		
		}//end of j for loop
	}//end of i for loop

  System.out.println(sortedShifts.size());


	return sortedShifts;
}
	
public static void defineAllPointedMembers(){
    
    Shift.defineMembers(FileReader.output());

    for(int i = 0; i < Shift.allMembers.get(0).availability.size(); i++){

	 ArrayList<Member> tempAL = new ArrayList<Member>();	  
	  allPointedMembers.add(tempAL);

    }

        String tempName = "";
	String tempRank = "";
	
     for(int j = 0; j < Shift.allMembers.get(0).availability.size(); j++){
       
        for(int i = 0; i < Shift.allMembers.size(); i++){

	    tempName = Shift.allMembers.get(i).name;
		
		tempRank = Shift.allMembers.get(i).rank;
	    
	    Member temp = new Member(tempName, tempRank, Shift.allMembers.get(i).availability);

          if( Shift.allMembers.get(i).availability.get(j).equals("1") ){
            double pointsToAdd = (Shift.allMembers.size()+0.0);
            temp.addPoints(pointsToAdd);
          }
          if( Shift.allMembers.get(i).availability.get(j).equals("0") ){
            double pointsToAdd = (Shift.allMembers.size()/2 + 0.0);
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
    
    //this is the new way im doing it:
    

      

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
     //now each index of numWithPoints is a double for each shift (by formula yes =+1 ifNeedBe =+.5)
    
 
    
      

    
    
    
    
    //Below was my first attempt at this, but I think the above set up is better and actually works
   /* 
    for(int i = 0; i < allPointedMembers.size(); i++){
    double numWithPoints;
      for(int j = 0; j < allPointedMembers.get(0).size(); j++){
        if(allPointedMembers.get(i).get(j).points > 0){
         numWithPoints++; 
        }
      
      }//end of j1 for loop 
      for(int j = 0; j < allPointedMembers.get(0).size(); j++){
        if(allPointedMembers.get(i).get(j).points > 0){
         double pointsToAdd = (Shift.allMembers.size()/numWithPoints);
         allPointedMembers.get(i).get(j).addPoints( pointsToAdd ); 
        }
      }//end of j2 for loop
    }//end of i for loop 
    
    //do some if < 2 then put in the if need b estuff as well
    
    */
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
