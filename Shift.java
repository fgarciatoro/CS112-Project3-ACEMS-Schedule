import java.util.ArrayList;
import java.util.Random;
public class Shift { 
  Member med10;
  Member med12;
  Member med13;
  //int shiftNum;
  static ArrayList<Member> allMembers = new ArrayList<Member>();  // This will be defined later on
  // this method is called once, in the allShifts() method, and defines a list of members with name, rank and availability
  // this list is allMembers, a static arrayList we defined earlier
 public static void defineMembers(ArrayList<ArrayList<String>> readMe){
  Member newMember;
  for(int j = 0; j < readMe.size(); j++) {
     ArrayList<String> eachMember = readMe.get(j);
     String newName = eachMember.get(0);
    String newRank = eachMember.get(1);
    eachMember.remove(0);
    eachMember.remove(0);
    // eachMember is now only the availability, since we removed the name and rank
     newMember = new Member(newName, newRank, eachMember);
    allMembers.add(newMember);
    }
  }
  
  //This is the constructor; when we make shifts, which we do in the allShifts() method, it finds 3 members and has an associated number
  public Shift(Member mem1, Member mem2, Member mem3) {
    med10 = mem1;
    med12 = mem2;
    med13 = mem3;
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
}
