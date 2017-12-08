import java.util.ArrayList;

public class pointedMember{
  String name;
  double points;

public pointedMember(String s, double d){
  name = s;
  points = d;
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
