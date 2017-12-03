import java.util.ArrayList;
Public Class Member {
  String name;
  String rank;
  ArrayList<String> availability; // 0 means yes, 1 is no, 2 is if need be
  int numShifts;
  
  public Member(String name, String rank,ArrayList<String> availability) {
    name = this.name;
    rank = this.rank;
    availability = this.availability;
    numShifts=0;
    Shift.allMembers+=this();
    }
  public void plusShifts(){
    numShifts++;
  }
}  
