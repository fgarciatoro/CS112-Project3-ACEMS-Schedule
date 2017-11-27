import java.util.ArrayList;
public class Shift { // will define the number of shifts in the main method when I call it
  Member med10;
  Member med12;
  Member med13;
  static ArrayList<Member> allMembers;
  public Member findMember(int memRank) {
    for(int i = 0; i < allMembers.size(); i++);
      if(allMembers.get(i).numShifts < 4 && allMembers.get(i).availability.get(shiftNum) == 2 && allMembers.get(i).rank == memRank) {
        Member toReturn = allMembers.get(i);
        allMembers.get(i).plusShifts();
        break;
      }
    }
    return toReturn;
  }
  public Member find10() {
    return findMember(10);
  }
  public Member find12() {
    return findMember(12);
  }
  public Member find13() {
    return findMember(13);
  }
  public Shift() {
    med10 = find10();
    med12 = find12();
    med13 = find13();
    
