import java.util.ArrayList;

public class ToRun {
ArrayList<Shift> shifts;
public static void main(String args[]) {
  Shift newShift;
  for(int i = 0; i < Shift.allmembers.get(0).availability.length(); i++) {
    newShift = new Shift(i);
    shifts.add(newShift);
