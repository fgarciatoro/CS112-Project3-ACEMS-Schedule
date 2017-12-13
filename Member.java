import java.util.ArrayList;
public class Member {
  String name;
  String rank;
  ArrayList<String> availability; // 1 means yes, -1 is no, 0 is if need be; FileReader assigns these to an ArrayList
  int numShifts;
  double points;
  
  // Constructor, initializing points to 0 and assuming each member starts with 0 shifts
  public Member(String thisName, String thisRank,ArrayList<String> thisAvailability) {
    name = thisName;
    rank = thisRank;
    availability = thisAvailability;
    numShifts=0;
    points = 0.0;
    }
  public void plusShifts(){
    numShifts++;
    return;
  }
  public void addPoints(double toAdd){
    points = points + toAdd;
  return;
}

public void subtractPoints(double toSubtract){
    points = points - toSubtract;
  return;
}

}  
