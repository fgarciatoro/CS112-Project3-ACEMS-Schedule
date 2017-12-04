import java.awt.Color;
import java.awt.Graphics;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.util.ArrayList;

import java.util.Scanner;
//unclear if this is the correct scanner import statement

public class calGraph  extends JPanel{
    public static final int BOX_WIDTH = 1400;
    public static final int BOX_HEIGHT = 800;
    

    public calGraph(){
        this.setPreferredSize(new Dimension(BOX_WIDTH, BOX_HEIGHT));
    }
    
   
        
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);            
        
	//this makes the color behind the skeleton of the calendar     
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, BOX_WIDTH, BOX_HEIGHT);

	
	//also, I need to edit the paintMonth(String s) method to be a paintDay(String s) method so that I call it for each individual day as I go through and make the Strings for the day of the  week with the date and month and such 

	    
	
	     
	String startDow = ScheduleDates.getStartDow();
        int startD = ScheduleDates.getStartD();
        int startM = ScheduleDates.getStartM();
        int startY = ScheduleDates.getStartY();
	    
	String endDow = ScheduleDates.getEndDow();
        int endD = ScheduleDates.getEndD();
        int endM = ScheduleDates.getEndM();
        int endY = ScheduleDates.getEndY();
	    
	//startDow means 1 = sun, 2=mon, 3=tues, etc.
        int startDowInt = getDowInt(startDow); 
	String startMstring = getMstring(startM);
	String endMstring = getMstring(endM);
	int changeAt = getDaysInM(startM, startY);
	
	paintMonth(g, endMstring);

	paintCalSkeleton(g);
	
	paintDateStrings(g, startDowInt, startM, startMstring, changeAt, startD, startDow, startY, endM, endD, endY);

	ArrayList<Shift> joshList = new ArrayList<Shift>();

	joshList = Shift.jasonCallThisMethod();

	printShifts(g, joshList, startDowInt);
    
    }
   

    public static void paintMonth(Graphics g, String month){

	//I used this website to learn how to make new colors (so cool!!) http://www.otherwise.com/Lessons/ColorsInJava.html
		
       	if(month.equals("September")){
	    for(int i = 0; i < 5; i++){
		//these following three are the AM shift colored background 
		g.setColor(Color.YELLOW);
		g.fillRect(100, 59+152*i, 1050, 19 );
	       	g.setColor(Color.BLUE);
		g.fillRect(100, 78+152*i, 1050, 19 );		
		g.setColor(Color.YELLOW);
		g.fillRect(100, 97+152*i, 1050, 19 );
		//these following three are the PM shift colored background 
		g.setColor(Color.YELLOW);
		g.fillRect(100, 116+152*i, 1050, 19 );
	       	g.setColor(Color.BLUE);
		g.fillRect(100, 135+152*i, 1050, 19 );
      		g.setColor(Color.YELLOW);
		g.fillRect(100, 154+152*i, 1050, 19 );
	    }
         }
	    
      	if(month.equals("October")){
	    for(int i = 0; i < 5; i++){
		//these following three are the AM shift colored background 
		g.setColor(Color.ORANGE);
		g.fillRect(100, 59+152*i, 1050, 19 );
	       	g.setColor(Color.ORANGE);
		g.fillRect(100, 78+152*i, 1050, 19 );		
		g.setColor(Color.ORANGE);
		g.fillRect(100, 97+152*i, 1050, 19 );
		//these following three are the PM shift colored background 
		g.setColor(Color.ORANGE);
		g.fillRect(100, 116+152*i, 1050, 19 );
	       	g.setColor(Color.ORANGE);
		g.fillRect(100, 135+152*i, 1050, 19 );
      		g.setColor(Color.ORANGE);
		g.fillRect(100, 154+152*i, 1050, 19 );
	    }
	}
	
	if(month.equals("November")){
	    for(int i = 0; i < 5; i++){
		//these following three are the AM shift colored background 
		g.setColor(Color.RED);
		g.fillRect(100, 59+152*i, 1050, 19 );
	       	g.setColor(Color.YELLOW);
		g.fillRect(100, 78+152*i, 1050, 19 );		
		g.setColor(Color.RED);
		g.fillRect(100, 97+152*i, 1050, 19 );
		//these following three are the PM shift colored background 
		g.setColor(Color.ORANGE);
		g.fillRect(100, 116+152*i, 1050, 19 );
	       	g.setColor(Color.YELLOW);
		g.fillRect(100, 135+152*i, 1050, 19 );
      		g.setColor(Color.ORANGE);
		g.fillRect(100, 154+152*i, 1050, 19 );
	    }
	}

	if(month.equals("December")){
	    for(int i = 0; i < 5; i++){
		//these following three are the AM shift colored background 
		g.setColor(Color.WHITE);
		g.fillRect(100, 59+152*i, 1050, 19 );
	       	g.setColor(Color.WHITE);
		g.fillRect(100, 78+152*i, 1050, 19 );		
		g.setColor(Color.WHITE);
		g.fillRect(100, 97+152*i, 1050, 19 );
		//these following three are the PM shift colored background 
		g.setColor(Color.BLUE);
		g.fillRect(100, 116+152*i, 1050, 19 );
	       	g.setColor(Color.BLUE);
		g.fillRect(100, 135+152*i, 1050, 19 );
      		g.setColor(Color.BLUE);
		g.fillRect(100, 154+152*i, 1050, 19 );
	    }
	 }

	  if(month.equals("February")){
	    for(int i = 0; i < 5; i++){
		//these following three are the AM shift colored background 
		g.setColor(Color.PINK);
		g.fillRect(100, 59+152*i, 1050, 19 );
	       	g.setColor(Color.PINK);
		g.fillRect(100, 78+152*i, 1050, 19 );		
		g.setColor(Color.PINK);
		g.fillRect(100, 97+152*i, 1050, 19 );
		//these following three are the PM shift colored background 
		g.setColor(Color.RED);
		g.fillRect(100, 116+152*i, 1050, 19 );
	       	g.setColor(Color.RED);
		g.fillRect(100, 135+152*i, 1050, 19 );
      		g.setColor(Color.RED);
		g.fillRect(100, 154+152*i, 1050, 19 );
	    }
	  }
	
	  if(month.equals("March")){
	    for(int i = 0; i < 5; i++){
		//these following three are the AM shift colored background 
		g.setColor(Color.GREEN);
		g.fillRect(100, 59+152*i, 1050, 19 );
	       	g.setColor(Color.YELLOW);
		g.fillRect(100, 78+152*i, 1050, 19 );		
		g.setColor(Color.GREEN);
		g.fillRect(100, 97+152*i, 1050, 19 );
		//these following three are the PM shift colored background 
		g.setColor(Color.GREEN);
		g.fillRect(100, 116+152*i, 1050, 19 );
	       	g.setColor(Color.YELLOW);
		g.fillRect(100, 135+152*i, 1050, 19 );
      		g.setColor(Color.GREEN);
		g.fillRect(100, 154+152*i, 1050, 19 );
	    }
	  }
 
	  if(month.equals("April")){
	    for(int i = 0; i < 5; i++){
		//these following three are the AM shift colored background 
		g.setColor(Color.YELLOW);
		g.fillRect(100, 59+152*i, 1050, 19 );
	       	g.setColor(Color.GREEN);
		g.fillRect(100, 78+152*i, 1050, 19 );		
		g.setColor(Color.YELLOW);
		g.fillRect(100, 97+152*i, 1050, 19 );
		//these following three are the PM shift colored background 
		g.setColor(Color.PINK);
		g.fillRect(100, 116+152*i, 1050, 19 );
	       	g.setColor(Color.GREEN);
		g.fillRect(100, 135+152*i, 1050, 19 );
      		g.setColor(Color.PINK);
		g.fillRect(100, 154+152*i, 1050, 19 );
	    }
	 }

      }

    public static void paintCalSkeleton(Graphics g){

	//draw skeleton for the calendar
	for(int i = 0; i < 41; i++){
	    g.setColor(Color.GRAY);
	    g.drawLine(0, 40+19*i, 1150, 40+19*i);	    
	}	
	for(int j = 0; j < 8; j++){
		g.setColor(Color.GRAY);
		g.drawLine(100+150*j , 40, 100+150*j , 800);
	}

	//draw  Med 10,12,13 labels on the left side
	for(int i = 0; i < 5; i++){
	    g.setColor(Color.BLACK);
	    g.drawString("Med-10 AM", 20, 76 + 152*i);
	    g.drawString("Med-12 AM", 20, 95 + 152*i);
	    g.drawString("Med-13 AM", 20, 114 + 152*i);

	    g.drawString("Med-10 PM", 20, 133 + 152*i);
	    g.drawString("Med-12 PM", 20, 152 + 152*i);
	    g.drawString("Med-13 PM", 20, 171 + 152*i);    
	}

	//draw black rectangle rows seperating weeks
	for(int i = 0; i < 5; i++){
	    g.setColor(Color.BLACK);
	    g.fillRect(0, 173 +152*i, 1150, 19);
	}

    }

    public static void paintDateStrings(Graphics g, int startDowInt, int startM, String startMstring, int changeAt, int startD, String startDow, int startY, int endM, int endD, int endY){

	   int daysInSched = 0;
	   daysInSched = (changeAt - startD) + endD;        
	
	   int j = 0;
	   int currentDom = startD;
	   for(int i = 0; i < (daysInSched+1); i++){
	       
	       
	       if( (i + startDowInt)%7== 1){
	       g.setColor(Color.BLACK);
	       g.drawString("Sunday "+startMstring + " "+currentDom, 120, 57+152*j);
	       currentDom++;
	       }
	       if( (i + startDowInt)%7== 2){
	       g.setColor(Color.BLACK);
	       g.drawString("Monday "+startMstring + " "+currentDom, 270, 57+152*j);
	       currentDom++;
	       }
	       if( (i + startDowInt)%7== 3){
	       g.setColor(Color.BLACK);
	       g.drawString("Tuesday "+startMstring + " "+currentDom, 420, 57+152*j);
	       currentDom++;
	       }
	       if( (i + startDowInt)%7== 4){
	       g.setColor(Color.BLACK);
	       g.drawString("Wednesday "+startMstring + " "+currentDom, 570, 57+152*j);
	       currentDom++;
	       }
	       if( (i + startDowInt)%7== 5){
	       g.setColor(Color.BLACK);
	       g.drawString("Thursday "+startMstring + " "+currentDom, 720, 57+152*j);
	       currentDom++;
	       }
	       if( (i + startDowInt)%7== 6){
	       g.setColor(Color.BLACK);
	       g.drawString("Friday "+startMstring + " "+currentDom, 870, 57+152*j);
	       currentDom++;
	       }
	       if( (i + startDowInt)%7== 0){
	       g.setColor(Color.BLACK);
	       g.drawString("Saturday "+startMstring + " "+currentDom, 1020, 57+152*j);
	       currentDom++;
	       j+=1;
	       }

	       if(currentDom ==(changeAt+1) ){
		   currentDom = 1;

		   if(startMstring.equals("December"))
		       startMstring = "January";
		   if(startMstring.equals("November"))
		       startMstring = "December";
		   if(startMstring.equals("October"))
		       startMstring = "November";
		   if(startMstring.equals("September"))
		       startMstring = "October";
		   if(startMstring.equals("August"))
		       startMstring = "September";
		   if(startMstring.equals("July"))
		       startMstring = "August";
		   if(startMstring.equals("June"))
		       startMstring = "July";
		   if(startMstring.equals("May"))
		       startMstring = "June";
		   if(startMstring.equals("April"))
		       startMstring = "May";
		   if(startMstring.equals("March"))
		       startMstring = "April";
		   if(startMstring.equals("February"))
		       startMstring = "March";		
		   if(startMstring.equals("January"))
		       startMstring = "February";		  		 
		   
	       }


	   }

	
	   

    }
    
    public static void printShifts(Graphics g, ArrayList<Shift> joshList, int startDow){

	int j = 0;
	int Dow = startDow;
	for(int i = 0; i < joshList.size(); i++){
	    
	       g.setColor(Color.BLACK);
	       g.drawString( joshList.get(i).getMed10() , 120+ (150*Dow) , 76+152*j);

	       g.setColor(Color.BLACK);
	       g.drawString( joshList.get(i).getMed12() , 120+ (150*Dow) , 95+152*j);

	       g.setColor(Color.BLACK);
	       g.drawString( joshList.get(i).getMed13() , 120+ (150*Dow) , 114+152*j);
	      

	       Dow++;
	       
	       if(Dow==7){
		   j++;
	       }
	}

    }
    
   public static int getDowInt(String stringDow){
	  int dow = 0;
	   if(stringDow.equals("Sunday") ){
		   dow = 1;
	   }
	   if(stringDow.equals("Monday") ){
		   dow = 2;
	   }
	   if(stringDow.equals("Tuesday") ){
		   dow = 3;
	   }
	   if(stringDow.equals("Wednesday") ){
		   dow = 4;
	   }
	   if(stringDow.equals("Thursday") ){
		   dow = 5;
	   }
	   if(stringDow.equals("Friday") ){
		   dow = 6;
	   }
	   if(stringDow.equals("Saturday") ){
		   dow = 7;
	   }
	   
	   return dow;
   }

	
	
	public static String getMstring(int startM){
		String startMstring = "";
		
		if(startM==1){
	   	startMstring = "January";
		}
		if(startM==2){
          	 startMstring = "February";
		}
		if(startM==3){
           	startMstring = "March";
		}
     	 	if(startM==4){
	 	startMstring = "April";
		}
        	if(startM==5){
	   	startMstring = "May";	
		}
        	if(startM==6){
	   	startMstring = "June";	
		}
		if(startM==7){
	        startMstring = "July";	
		}
      	        if(startM==8){
	        startMstring = "August";	
		}
		if(startM==9){
	   	startMstring = "September";	
		}
        	if(startM==10){
	        startMstring = "October";	
		}
        	if(startM==11){
	 	startMstring = "November";	
		}
		if(startM==12){
	  	startMstring = "December";	
		}
	return startMstring;	
		
	}
	
	public static int getDaysInM(int startM, int y){
		int changeAt = 0;
		
		if(startM==1){
	   	changeAt = 31;
		}
		if(startM==2){
          	changeAt = 31;
			if( (y + 2016)%4 ==0 ){
	        	changeAt = 29;
			}
		}
		if(startM==3){
           	changeAt = 31;
		}
     	 	if(startM==4){
	 	changeAt = 30;
		}
        	if(startM==5){
	   	changeAt = 31;	
		}
        	if(startM==6){
	   	changeAt = 30;	
		}
		if(startM==7){
	        changeAt = 31;	
		}
      	        if(startM==8){
	        changeAt = 31;	
		}
		if(startM==9){
	   	changeAt = 30;	
		}
        	if(startM==10){
	        changeAt = 31;	
		}
        	if(startM==11){
	 	changeAt = 30;	
		}
		if(startM==12){
	  	changeAt = 31;	
		}
			
		return changeAt;
	}
	
	
	
    

     public static void main(String args[]){
        JFrame frame = new JFrame("DrawToScreen");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new calGraph());
        frame.pack();
        frame.setVisible(true);
    }

    
}

