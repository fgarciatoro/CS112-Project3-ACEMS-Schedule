import java.util.ArrayList;
Public Class Member {
  int rank;
  ArrayList<Integer> availability; // 0 means not available, 1 is if needed, 2 is available
  int numShifts;
  
  public Member(int rank,ArrayList<Integer> availability) {
    rank = this.rank;
    availability = this.availability;
    numShifts=0;
    Shift.allMembers+=this();
    }
  public void plusShifts(){
    numShifts++;
  }
}  
