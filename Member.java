import java.util.ArrayList;
public class Member {
  String name;
  String rank;
  ArrayList<String> availability; // 1 means yes, -1 is no, 0 is if need be
  int numShifts;
  
  public Member(String thisName, String thisRank,ArrayList<String> thisAvailability) {
    name = thisName;
    rank = thisRank;
    availability = thisAvailability;
    numShifts=0;
    }
  public void plusShifts(){
    numShifts++;
  }
}  
