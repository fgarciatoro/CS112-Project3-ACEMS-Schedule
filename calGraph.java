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
             
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, BOX_WIDTH, BOX_HEIGHT);




	//make the color behind the skeleton of the calendar
	//month is the variable that will be inputed by the user/scanner as the start of the calendar/end of it
	//also, I need to edit the paintMonth(String s) method to be a paintDay(String s) method so that I call it for each individual day as I go through and make the Strings for the day of the  week with the date and month and such 

	String month = "October";

	paintMonth(g, month);

	paintCalSkeleton(g);
	
	paintDateStrings(g, month);

        
    
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

    public static void paintDateStrings(Graphics g, String startM){

	//all of these values will actually be passed in/pulled form other parts of the program, but for now I am initializing them so I can run the program

	String startDow = "Tuesday";
	int startD = 2;
	int endD = 29;
	int endY = 2017;
		
	//print date for each day
	// startDow (start day of week) is a string variable that is passed in for the start of the schdeyle. I will need a user input at the beginning of the program that says the schedule goes from Monday November 27 2017 to Tuesday December 13 2017 for example
	int currentDow = 0;
        if(startDow.equals("Sunday"))
	   currentDow = 1;
	if(startDow.equals("Monday"))
	   currentDow = 2;
	if(startDow.equals("Tuesday"))
	   currentDow = 3;
      	if(startDow.equals("Wednesday"))
	   currentDow = 4;
	if(startDow.equals("Thursday"))
	   currentDow = 5;
	if(startDow.equals("Friday"))
	   currentDow = 6;
	if(startDow.equals("Saturday"))
	   currentDow = 7;

	//changeAt is the variable I use to know when the date counter should change at the end of the month
	int changeAt = 0;
        if(startM.equals("January"))
	   changeAt = 31;
	if(startM.equals("February")){
	   changeAt = 28;
	   if( (endY + 2016)%4 ==0 )
	       changeAt = 29;
	}
	if(startM.equals("March"))
	   changeAt = 31;
        if(startM.equals("April"))
	   changeAt = 30;
        if(startM.equals("May"))
	   changeAt = 31;
        if(startM.equals("June"))
	   changeAt = 30;
	if(startM.equals("July"))
	   changeAt = 31;
        if(startM.equals("August"))
	   changeAt = 31;
	if(startM.equals("September"))
	   changeAt = 30;
        if(startM.equals("October"))
	   changeAt = 31;
        if(startM.equals("November"))
	   changeAt = 30;
	if(startM.equals("December"))
	   changeAt = 31;

	   int daysInSched = 0;
	   daysInSched = (changeAt - startD) + endD;        
	
	   int j = 0;
	   int currentDom = startD;
	   for(int i = 0; i < daysInSched; i++){
	       
	       //I also need to add the date and the month to the print stmt, also I need to add a counter so that I can chang ethe y-coordinate fo rhe prints to change weeks, and I need to add more too...
	       
	       if( (i + currentDow)%7== 1){
	       g.setColor(Color.BLACK);
	       g.drawString("Sunday "+startM + " "+currentDom, 120, 57+152*j);
	       currentDom++;
	       }
	       if( (i + currentDow)%7== 2){
	       g.setColor(Color.BLACK);
	       g.drawString("Monday "+startM + " "+currentDom, 270, 57+152*j);
	       currentDom++;
	       }
	       if( (i + currentDow)%7== 3){
	       g.setColor(Color.BLACK);
	       g.drawString("Tuesday "+startM + " "+currentDom, 420, 57+152*j);
	       currentDom++;
	       }
	       if( (i + currentDow)%7== 4){
	       g.setColor(Color.BLACK);
	       g.drawString("Wednesday "+startM + " "+currentDom, 570, 57+152*j);
	       currentDom++;
	       }
	       if( (i + currentDow)%7== 5){
	       g.setColor(Color.BLACK);
	       g.drawString("Thursday "+startM + " "+currentDom, 720, 57+152*j);
	       currentDom++;
	       }
	       if( (i + currentDow)%7== 6){
	       g.setColor(Color.BLACK);
	       g.drawString("Friday "+startM + " "+currentDom, 870, 57+152*j);
	       currentDom++;
	       }
	       if( (i + currentDow)%7== 0){
	       g.setColor(Color.BLACK);
	       g.drawString("Saturday "+startM + " "+currentDom, 1020, 57+152*j);
	       currentDom++;
	       j+=1;
	       }

	       if(currentDom ==changeAt){
		   currentDom = 1;

		   if(startM.equals("December"))
		       startM = "January";
		   if(startM.equals("November"))
		       startM = "December";
		   if(startM.equals("October"))
		       startM = "November";
		   if(startM.equals("September"))
		       startM = "October";
		   if(startM.equals("August"))
		       startM = "September";
		   if(startM.equals("July"))
		       startM = "August";
		   if(startM.equals("June"))
		       startM = "July";
		   if(startM.equals("May"))
		       startM = "June";
		   if(startM.equals("April"))
		       startM = "May";
		   if(startM.equals("March"))
		       startM = "April";
		   if(startM.equals("February"))
		       startM = "March";		
		   if(startM.equals("January"))
		       startM = "February";		  		 
		   
	       }


	   }

	
	   

    }
    
    

    

     public static void main(String args[]){
        JFrame frame = new JFrame("DrawToScreen");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new calGraph());
        frame.pack();
        frame.setVisible(true);
    }

    
}
