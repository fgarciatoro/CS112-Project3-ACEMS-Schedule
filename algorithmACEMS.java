import java.util.ArrayList;

public class algorithmACEMS{
  static ArrayList<ArrayList<pointedMember>> allPointedMembers = new ArrayList<pointedMember>();
  //each ArrayList<pointedMember> will be a list ranking all the members for a specific shift
  //and allPointedMembers will be an arraylist of all those lists (i.e. one list for every shift in order)
  
  //all the double pointsToAdd values are realtive to how many members there are (Shift.allMembers.size())
  
public algorithmACEMS(){

}

public static void assignPoints(){
  
}

//so we call Shift(int shiftNum) with the variable shiftNum, so we need to use that s the index for the ith availability of all the members and put that into an ArrayList<ArrayList<String memberName>> so that for each shift we know which members can take it
  
  //Then, we will parse through that double arraylist and for each shift, the people who are amrked yes get ( 1000/numPeopleWhoCanTakeThisShift ) (becuase even if like 20 people can take the shift, they'll all still get something which relatively will make it so that the one with the most points gets it, I think...) and maybe people get like 10 points or something  

public static void main(String args[]){
  //this main is probably going to go but like for now, this will just be wear the bulk of the arguments is 
  
  defineAllPointedMembers();
  
  prioritizeFewMembers();
  
  prioritizeFerShifts();
  
 
  }//end bracket for Main()
  
  public static void defineAllPointedMembers(){
    
    Shift.defineMembers(FileReader.output());
  
        String tempName = "";
        for(int i = 0; i < Shift.allMembers.size(); i++){
        tempName = Shift.allMembers.get(i).name;

        for(int j = 0; j < Shift.allMembers.get(0).availability.size(); j++){

          pointedMember temp = new pointedMember(tempName, 0);

          if( Shift.allMembers.get(i).availability.get(j).equals("1") ){
            double pointsToAdd = (Shift.allmembers.size());
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

  public static void prioritizeFewMembers(){ 
    //this assigns additional points to members on shifts where there are relatively few members that can take the shift 
    //Note: This method DOES take into account the ifNeedBe members for each shift, so if theres 2 yesses and 1 ifNeedBe, the person with the ifNeedBe will still get some bonus points
    
    //this is the new way im doing it:
     ArrayList<double> numWithPoints = new ArrayList<double>;
     for(int i = 0; i < Shift.allMembers.size(); i++){
   
      for(int j = 0; j < Shift.allMembers.get(i).availability.size(); j++){
        double temp = numWithPoints.get(i);
        if( Shift.allMembers.get(j).availavility.get(i).equals("1") ){
         temp = temp + 1;
        }
        if( Shift.allMembers.get(j).availavility.get(i).equals("0") ){
         temp = temp + .5;
        }
        numWithPoints.set(i, temp);
      }//end of j1 for loop 
     }//end of i for loop
     //now each index of numWithPoints is a double for each shift (by formula yes =+1 ifNeedBe =+.5)
    
    for(int i = 0; i < allPointedMembers.size(); i++){
      for(int j = 0; j < allPointedMembers.get(0).size(); j++){
        if( Shift.allMembers.get(j).availability.get(i).equals("1") || Shift.allMembers.get(j).availability.get(i).equals("0") ){
         double pointsToAdd = (Shift.allMembers.size()/numWithPoints.get(i) );
         allPointedMembers.get(i).get(j).addPoints( pointsToAdd ); 
        }//end of if statement
      }//end of j2 for loop
     }//end of i2 for loop
    
    
    
    
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
  
  public static void prioritizeFewShifts(){
    //Note: this method does not take into account hte ifNeedBe shifts, it only counts the number of shifts that a member can take ("1") and assigns according to that
    
    for(int i = 0; i < Shift.allMembers.size(); i++){
      
      double numShifts = 0;
      for(int j = 0; j < Shift.allMembers.get(i).availability.size(); j++){
        if( Shift.allMembers.get(i).availability.get(j).equals("1") ){
          numShifts++;
        }
      }//end of j1 for loop
      
      for(int j = 0; j < Shift.allmembers.get(i).availability.size(); j++){
        if( Shift.allMembers.get(i).availability.get(j).equals("1") ){
          double pointsToAdd = (allPointedMembers.size()/numShifts);
          allPointedMembers.get(j).get(i).addPoints( pointsToAdd );
        }
      }//end of j2 for loop
      
    }//end of i for loop
    
   return; 
  }
  
}//end bracket for the whole program 
