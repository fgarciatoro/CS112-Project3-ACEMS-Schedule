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

	g.setColor(new Color(0, 100, 100));
		   g.fillRect(100,100, 400, 500);
		   //I used this website to learn how to make new colors (so cool!!) http://www.otherwise.com/Lessons/ColorsInJava.html


	//make the color behind the skeleton of the calendar
	//month is the variable that will be inputed by the user/scanner as the start of the calendar/end of it
	//also, I need to edit the paintMonth(String s) method to be a paintDay(String s) method so that I call it for each individual day as I go through and make the Strings for the day of the  week with the date and month and such 
	String month = "test";
	paintMonth(month);
	

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

	//print days of week at top
	g.setColor(Color.BLACK);
	g.drawString("Sunday", 130, 57);

	
    }
    
    public static void main(String args[]){
        JFrame frame = new JFrame("DrawToScreen");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new calGraph());
        frame.pack();
        frame.setVisible(true);
    }

    public static void paintMonth(String s){


	//figure out how to do a string comparison with s and the names of months

	
	/*
	if(s.equals('September')){
	    for(int i = 0; i < 5; i++){
		//these following three are the AM shift colored background 
		g.setColor(Color.YELLOW);
		g.fillRect(150, 59+152*i, 1050, 19 );
	       	g.setColor(Color.BLUE);
		g.fillRect(150, 78+152*i, 1050, 19 );		
		g.setColor(Color.YELLOW);
		g.fillRect(150, 97+152*i, 1050, 19 );
		//these following three are the PM shift colored background 
		g.setColor(Color.YELLOW);
		g.fillRect(150, 116+152*i, 1050, 19 );
	       	g.setColor(Color.BLUE);
		g.fillRect(150, 135+152*i, 1050, 19 );
      		g.setColor(Color.YELLOW);
		g.fillRect(150, 154+152*i, 1050, 19 );
	    }
	    	}
	    
      	if(s.equals('October')){
	    for(int i = 0; i < 5; i++){
		//these following three are the AM shift colored background 
		g.setColor(Color.ORANGE);
		g.fillRect(150, 59+152*i, 1050, 19 );
	       	g.setColor(Color.ORANGE);
		g.fillRect(150, 78+152*i, 1050, 19 );		
		g.setColor(Color.ORANGE);
		g.fillRect(150, 97+152*i, 1050, 19 );
		//these following three are the PM shift colored background 
		g.setColor(Color.ORANGE);
		g.fillRect(150, 116+152*i, 1050, 19 );
	       	g.setColor(Color.ORANGE);
		g.fillRect(150, 135+152*i, 1050, 19 );
      		g.setColor(Color.ORANGE);
		g.fillRect(150, 154+152*i, 1050, 19 );
	    }
	}
	
	if(s.equals('November')){
	    for(int i = 0; i < 5; i++){
		//these following three are the AM shift colored background 
		g.setColor(Color.RED);
		g.fillRect(150, 59+152*i, 1050, 19 );
	       	g.setColor(Color.YELLOW);
		g.fillRect(150, 78+152*i, 1050, 19 );		
		g.setColor(Color.RED);
		g.fillRect(150, 97+152*i, 1050, 19 );
		//these following three are the PM shift colored background 
		g.setColor(Color.ORANGE);
		g.fillRect(150, 116+152*i, 1050, 19 );
	       	g.setColor(Color.YELLOW);
		g.fillRect(150, 135+152*i, 1050, 19 );
      		g.setColor(Color.ORANGE);
		g.fillRect(150, 154+152*i, 1050, 19 );
	    }
	}

	if(s.equals('December')){
	    for(int i = 0; i < 5; i++){
		//these following three are the AM shift colored background 
		g.setColor(Color.WHITE);
		g.fillRect(150, 59+152*i, 1050, 19 );
	       	g.setColor(Color.WHITE);
		g.fillRect(150, 78+152*i, 1050, 19 );		
		g.setColor(Color.WHITE);
		g.fillRect(150, 97+152*i, 1050, 19 );
		//these following three are the PM shift colored background 
		g.setColor(Color.BLUE);
		g.fillRect(150, 116+152*i, 1050, 19 );
	       	g.setColor(Color.BLUE);
		g.fillRect(150, 135+152*i, 1050, 19 );
      		g.setColor(Color.BLUE);
		g.fillRect(150, 154+152*i, 1050, 19 );
	    }
	 }

	  if(s.equals('February')){
	    for(int i = 0; i < 5; i++){
		//these following three are the AM shift colored background 
		g.setColor(Color.PINK);
		g.fillRect(150, 59+152*i, 1050, 19 );
	       	g.setColor(Color.PINK);
		g.fillRect(150, 78+152*i, 1050, 19 );		
		g.setColor(Color.PINK);
		g.fillRect(150, 97+152*i, 1050, 19 );
		//these following three are the PM shift colored background 
		g.setColor(Color.RED);
		g.fillRect(150, 116+152*i, 1050, 19 );
	       	g.setColor(Color.RED);
		g.fillRect(150, 135+152*i, 1050, 19 );
      		g.setColor(Color.RED);
		g.fillRect(150, 154+152*i, 1050, 19 );
	    }
	  }
	
	  if(s.equals('March')){
	    for(int i = 0; i < 5; i++){
		//these following three are the AM shift colored background 
		g.setColor(Color.GREEN);
		g.fillRect(150, 59+152*i, 1050, 19 );
	       	g.setColor(Color.YELLOW);
		g.fillRect(150, 78+152*i, 1050, 19 );		
		g.setColor(Color.GREEN);
		g.fillRect(150, 97+152*i, 1050, 19 );
		//these following three are the PM shift colored background 
		g.setColor(Color.GREEN);
		g.fillRect(150, 116+152*i, 1050, 19 );
	       	g.setColor(Color.YELLOW);
		g.fillRect(150, 135+152*i, 1050, 19 );
      		g.setColor(Color.GREEN);
		g.fillRect(150, 154+152*i, 1050, 19 );
	    }
	  }
 
	  if((s.equals('April')){
	    for(int i = 0; i < 5; i++){
		//these following three are the AM shift colored background 
		g.setColor(Color.YELLOW);
		g.fillRect(150, 59+152*i, 1050, 19 );
	       	g.setColor(Color.GREEN);
		g.fillRect(150, 78+152*i, 1050, 19 );		
		g.setColor(Color.YELLOW);
		g.fillRect(150, 97+152*i, 1050, 19 );
		//these following three are the PM shift colored background 
		g.setColor(Color.PINK);
		g.fillRect(150, 116+152*i, 1050, 19 );
	       	g.setColor(Color.GREEN);
		g.fillRect(150, 135+152*i, 1050, 19 );
      		g.setColor(Color.PINK);
		g.fillRect(150, 154+152*i, 1050, 19 );
	    }
	 }
	*/
	
	  return;	
    }

    
}
