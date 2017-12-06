import java.util.ArrayList

public class pointedMember{
  String name;
  int points;

public pointedMember(String s){
  name = s;
  return;
}

public void addPoints(pointedMember m, int toAdd){
  m.points = (m.points + toAdd);
  return;
}

public void subtractPoints(pointedMember m, int toSubtract){
  m.points = (m.points - toSubtract);
  return;
}





}
