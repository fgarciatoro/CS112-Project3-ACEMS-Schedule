import java.util.ArrayList;
Public Class Member {
  String name;
  String rank;
  ArrayList<String> availability; // 1 means yes, -1 is no, 0 is if need be
  int numShifts;
  
  public Member(String name, String rank,ArrayList<String> availability) {
    name = this.name;
    rank = this.rank;
    availability = this.availability;
    numShifts=0;
    }
  public void plusShifts(){
    numShifts++;
  }
}  
