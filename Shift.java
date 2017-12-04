import java.util.ArrayList;
import java.util.Random;
public class Shift { // will define the number of shifts in the main method when I call it
  Member med10;
  Member med12;
  Member med13;
  int shiftNum;
  static ArrayList<Member> allMembers;
  public Member findMember(int memRank) {
    Random rand = new Random();
    //for(int i = 0; i < allMembers.size(); i++);
      //if(allMembers.get(i).numShifts < 4 && allMembers.get(i).availability.get(shiftNum) == 1 && allMembers.get(i).rank == memRank) {
        //Member toReturn = allMembers.get(i);
        //allMembers.get(i).plusShifts();
        //break;
      //}
    Member toReturn =  allMembers.get(rand.nextInt(allMembers.size()));
    //}
    return toReturn;
  }
public static void defineMembers(ArrayList<ArrayList> readMe){ //call this one before jasonCallThisMethod, as it makes the allMembers array list have things in it
  Member newMember;
  for(int j = 0; j < readMe.size(); j++) {
     ArrayList<String> eachMember = readMe.get(j);
     String newName = eachMember.get(0);
    String newRank = eachMember.get(1);
    eachMember = eachMember.remove(0);
    eachMember = eachMember.remove(0);
     newMember = new Member(newName, newRank, eachMember);
    allMembers.add(newMember);
    }
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
  public Shift(int shiftNum) {
    med10 = find10();
    med12 = find12();
    med13 = find13();
    shiftNum=this.shiftNum;
  }
   public String getMed10() {
     return med10.name;
   }
   public String getMed12() { 
     return med12.name;
   }
   public String getMed13() {
     return med13.name;
   }

public static ArrayList<Shift> jasonCallThisMethod() {
  defineMembers(FileReader.joshCallThis());
  ArrayList<Shift> shifts;
  Shift newShift;
  for(int i = 0; i < allMembers.get(0).availability.length(); i++) { //this is the number of shifts
    newShift = new Shift(i);
    shifts.add(newShift);
  }
  return shifts;
}
}
