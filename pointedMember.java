import java.util.ArrayList

public class pointedMember{
  String name;
  double points;

public pointedMember(String s){
  name = s;
  return;
}

public void addPoints(pointedMember m, double toAdd){
  m.points = (m.points + toAdd);
  return;
}

public void subtractPoints(pointedMember m, double toSubtract){
  m.points = (m.points - toSubtract);
  return;
}





}
