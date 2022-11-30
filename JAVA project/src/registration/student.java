package registration;
import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;
import java.awt.*;
import javax.swing.*;

//import GUI.listener;
public class student  implements studentInterface{

	
			 		 JPanel panel=new JPanel();
			 		 Container c;
			 		 JLabel title;
			 		 JLabel name;
			 		 JTextField tname;
			 		 JLabel mno;
			 		 JTextField tmno;
			 		 JCheckBox term;
			 		 JButton sub;
			 		 JButton reset;
			 		 JButton remove;
			 		 JButton withdraw;
			 		 JButton view;
			 		
			 		
			 		 JPanel leftPanel;
			 		 JPanel rightPanel;
			 		
			 		  JTable table;
			 		
			 				 		
			 		JLabel res;

		 		 JPanel viewcourse;
				 JLabel userlabel;
				 JTextField usertext;
				 JLabel passlabel;
				 JPasswordField passtext;
				 JButton loginB;
				 JLabel successlabel;
				 JPanel studentchoice;
				
				 JLabel stmenulabel;
				 JButton allcoursesb;
	 			JButton availableb;
	 			JButton registerb;
	 			JButton withdrawb;
	 			JButton registeredb;
	 			listener l;
	 			JLabel label;
	 			JTable jTable;
	 			JButton backb;
	 			 JButton continueb;
	 			JFrame frame,stframe;
		 		 
		 		final String connectionstring="jdbc:sqlserver://LAPTOP-T23BOQMU:1433;Database=university;encrypt=true;trustServerCertificate=true"	;
				final String user="sa";
				final String pass="1234";
				Scanner s =new Scanner(System.in); 
				validation valid=new validation();
				
			public void login() {
				frame=new JFrame();
				panel=new JPanel();  
	 			 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 			frame.setSize(450,250);
	 			frame.setLocationRelativeTo(null); 
	 				
	 			
	 			
				Color c1=new Color(255,102,102);
				panel.setBackground(c1);
	 				panel.setLayout(null);
	 			
	 				userlabel =new JLabel("SID");
	 				userlabel.setFont(new Font("Serif", Font.PLAIN, 24));
	 				userlabel.setBounds(80,20,80,25);
	 				panel.add(userlabel);
	 				
	 				usertext=new JTextField(20);
	 				usertext.setFont(new Font("Serif", Font.BOLD, 22));
	 				usertext.setBounds(170,20,165,25);
	 				panel.add(usertext);
	 				
	 				passlabel =new JLabel("Password");
	 				passlabel.setFont(new Font("Serif", Font.PLAIN, 22));
	 				passlabel.setBounds(80,60,185,25);
	 				panel.add(passlabel);
	 				
	 				passtext=new JPasswordField(20);
	 				passtext.setFont(new Font("Serif", Font.BOLD, 22));
	 				passtext.setBounds(170,60,165,25);
	 				panel.add(passtext);
	 				
	 				successlabel =new JLabel();
	 				successlabel.setFont(new Font("Serif", Font.PLAIN, 15));
	 				successlabel.setLocation(170, 200);
	 				panel.add(successlabel);
	 				frame.add(panel);
	 				
	 				loginB=new JButton("LOGIN");
	 				loginB.addActionListener(new ActionListener() {
	 			
	 				
	 				public void actionPerformed(ActionEvent e) {
			 			
			 			
			 			try {
			 				try(Connection connection=DriverManager.getConnection(connectionstring,user,pass)){
			 				
			 					String user=usertext.getText();
			 			String password=passtext.getText();
			 			System.out.println(user+password);
			 					
			 				 Statement st=connection.createStatement();
			 					
			 					
			 					
			 					 ResultSet results = st.executeQuery("select sid,password from student");
			 					
			 					int i=0;
			 					while (results.next()) {
			 						
			 						if(user.equals(String.valueOf(results.getInt(1)))&& password.equals(results.getString(2)))
						 			{
						 				successlabel.setText("login successful");
						 				panel.removeAll();
						 				frame.dispose();
						 				
						 				stmenu();		
						 				break;
						 			}
						 			
			 						 }
			 					successlabel.setText("login unsuccessful");
		 				      frame.setVisible(true);				
			 					
			 					
			 				connection.close();
			 				st.close();
			 				results.close();
			 			

			 					}
			 				
			 			}catch(SQLException a) {
			 				System.out.println("error");
			 				a.printStackTrace();
			 			}		

			 			
			 		
			 		
			 		

			 	}});
	 				
	 				loginB.setBounds(170, 100, 110, 25);
	 				panel.add(loginB);
	 				
	 				
	 				frame.add(panel);
	 				 backb=new JButton("Back");
	 	 			backb.setBounds(185, 135, 90, 25);
	 	 			panel.add(backb);
	 	 			
	 	 				backb.addActionListener(z -> {
	 	 			         frame.dispose();
	 	 					new user();
	 	 					//
	 	 			      });
	 				
	 				frame.setVisible(true);

			}
			public void stmenu() {
				
				frame=new JFrame();
 				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 				
 				frame.setVisible(false);
 			
 			frame.setSize(280,400);
 			frame.setLocationRelativeTo(null); 
 			 
 			 
 			 stmenulabel=new JLabel("Student menu");
 			 stmenulabel.setFont(new Font("Serif", Font.PLAIN, 24));
 			stmenulabel.setBounds(70,30,160,25);
 				panel.add(stmenulabel,BorderLayout.NORTH);
 			 
 			allcoursesb=new JButton("view all courses");
 			allcoursesb.setBounds(55, 90, 180, 25);
				panel.add(allcoursesb);
				l = new listener(this);
				allcoursesb.addActionListener(l);
 			 
				availableb=new JButton("view all available courses");
				availableb.setBounds(50, 135, 180, 25);
				panel.add(availableb);
				l = new listener(this);
				availableb.addActionListener(l);
 			
				
				registerb=new JButton("Register for a course");
				registerb.setBounds(55, 180, 180, 25);
				panel.add(registerb);
				l = new listener(this);
				registerb.addActionListener(l);
				
				withdrawb=new JButton("Withdraw form a course");
				withdrawb.setBounds(50, 225, 180, 25);
				panel.add(withdrawb);
				l = new listener(this);
				withdrawb.addActionListener(l);
				
				registeredb=new JButton("View registered courses");
				registeredb.setBounds(50, 270, 180, 25);
				panel.add(registeredb);
				l = new listener(this);
				registeredb.addActionListener(l);
				frame.add(panel);
				
				 backb=new JButton("Back");
	 	 			backb.setBounds(90, 320, 90, 25);
	 	 			panel.add(backb);
	 	 				l = new listener(this);
	 	 				backb.addActionListener(z -> {
	 	 			         frame.dispose();
	 	 			         login();
	 	 					//new user();
	 	 					//
	 	 			      });
	 				
				
 			 
				frame.setVisible(true);
				
				
 		
			}

		
	
	public void studentViewAllCourses() {
		
	
		try {
			try(Connection connection=DriverManager.getConnection(connectionstring,user,pass)){
			
				
			 Statement st=connection.createStatement();
				int countrow=0;
				
				String query="select count(*) from course"; 
				ResultSet results = st.executeQuery(query);
				
				while(results.next()) {
					 countrow = results.getInt(1);
					 break;
				}
				System.out.println(countrow);
				String [][] row=new String [countrow][5];
				String[] column={"Course ID", "Course Name", "maximum number of students","number of students","Lecturer"};
				
				
				System.out.println("course ID \t course name\t maximum number of students \t number of students");
				int i=0;
				results = st.executeQuery("select distinct * from course left join teacher on course.tid=teacher.tid");
				while (results.next()) {
					 int id = results.getInt(1);
					 row[i][0]= String.valueOf(id); 
					 String coursename = results.getString(2);
					 row[i][1]=coursename;
					 int maxst=results.getInt(3);
					 row[i][2]=String.valueOf(maxst);
					 int nost=results.getInt(4);
					 row[i][3]=String.valueOf(nost);
					String teachername=results.getString(7);
					 row[i][4]=teachername;
					 i++;
					 
					 
					 System.out.println( id + "\t\t" + coursename+ "\t\t" +maxst+ "\t\t" +nost);	
					 }
				
				
				 frame = new JFrame();
			      JPanel panel = new JPanel();
		      label = new JLabel("ALL THE COURSES", SwingConstants.CENTER);
			      panel.add(label);
			      jTable = new JTable(row,column);
			
			      panel.add(new JScrollPane(jTable));
			      frame.add(panel);
			      frame.setSize(750, 400);
			     
			      backb=new JButton("Back");
	 			backb.setBounds(50, 50, 50, 50);
	 				panel.add(backb);
	 				l = new listener(this);
	 				backb.addActionListener(e -> {
	 			         frame.dispose();
	 			      });
	 				frame.setLocationRelativeTo(null); 
			      frame.setVisible(true);				
				
				
			connection.close();
			st.close();
			results.close();
		

				}
			
		}catch(SQLException e) {
			System.out.println("error");
			e.printStackTrace();
		}		
	}
	public void viewAvailableCourses() {
	
	try {
		try(Connection connection=DriverManager.getConnection(connectionstring,user,pass)){
		
			
			
			String[] column={"Course ID", "Course Name", "availabe places"};
			
			Statement st=connection.createStatement();	
			int countrow=0;
			
			String query="select count(*) from course where maxstudents!=numberofstudents"; 
			ResultSet results = st.executeQuery(query);
			
			while(results.next()) {
				 countrow = results.getInt(1);
				 break;
			}
			String [][] row=new String [countrow][3];
			 results = st.executeQuery("select * from course where maxstudents!=numberofstudents");
			System.out.println("course ID \t course name\t availabe places");
			int i=0;
			while (results.next()) {
				 int id = results.getInt(1);
				 row[i][0]= String.valueOf(id); 
				 String coursename = results.getString(2);
				 row[i][1]=coursename;
				 int maxst=results.getInt(3);
				 int NoSt=results.getInt(4);
				 int available=maxst-NoSt;
				 row[i][2]= String.valueOf(available);
				 
				 i++;
				 System.out.println( id + "\t\t" + coursename+ "\t\t\t"+ "\t" +available);	}
			
			frame = new JFrame();
			
		      JPanel panel = new JPanel();
		      frame.setLocationRelativeTo(null); 
		      label = new JLabel("ALL THE AVAILABLE COURSES", SwingConstants.CENTER);
		      panel.add(label);
		      jTable = new JTable(row,column);
		      panel.add(new JScrollPane(jTable));
		      frame.add(panel);
		      frame.setSize(550, 400);
		     
		      backb=new JButton("Back");
			backb.setBounds(50, 50, 50, 50);
				panel.add(backb);
				l = new listener(this);
				backb.addActionListener(e -> {
			         frame.dispose();
			       //  frame.removeAll();
			      });
				frame.setLocationRelativeTo(null); 
		      frame.setVisible(true);
		      
			connection.close();
		st.close();
	

			}
		
	}catch(SQLException e) {
		System.out.println("error");
		e.printStackTrace();
	}		
}
	public void registerToCourse() {
	
		frame=new JFrame();
		   frame.setTitle("");
		   frame.setBounds(400, 90, 900, 600);
		   frame.setSize(1000, 600);
		   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		   frame.setResizable(false);

		    c = frame.getContentPane();
		    c.setLayout(null);

		    title = new JLabel("Registration to course");
		    title.setFont(new Font("Arial", Font.PLAIN, 30));
		    title.setSize(300, 30);
		    title.setLocation(300, 30);
		    c.add(title);

		    name = new JLabel("Enter course Name");
		    name.setFont(new Font("Arial", Font.PLAIN, 13));
		    name.setSize(190, 20);
		    name.setLocation(80, 200);
		    
		    c.add(name);

		    tname = new JTextField();
		    tname.setFont(new Font("Arial", Font.PLAIN, 15));
		    tname.setSize(190, 20);
		    tname.setLocation(200, 200);
		    c.add(tname);
		   
		   mno = new JLabel("Enter Student ID");
		    mno.setFont(new Font("Arial", Font.PLAIN, 13));
		    mno.setSize(100, 20);
		    mno.setLocation(80, 250);
		    c.add(mno);
		    
		    
		    
		    tmno = new JTextField();
		    tmno.setFont(new Font("Arial", Font.PLAIN, 15));
		    tmno.setSize(150, 20);
		    tmno.setLocation(200, 250);
		    c.add(tmno);
		    

		    sub = new JButton("Register");
		    sub.setFont(new Font("Arial", Font.PLAIN, 15));
		    sub.setSize(100, 20);
		    sub.setLocation(150, 450);
		    l = new listener(this);
			sub.addActionListener(l);
		    c.add(sub);		    
			 

		    reset = new JButton("Reset");
		    reset.setFont(new Font("Arial", Font.PLAIN, 15));
		    reset.setSize(100, 20);
		    reset.setLocation(270, 450);
		    l = new listener(this);
			reset.addActionListener(l);
			c.add(reset);
			
			 backb=new JButton("Back");
	 			backb.setBounds(220, 490, 90, 20);
	 			c.add(backb);
	 				l = new listener(this);
	 				backb.addActionListener(z -> {
	 			         frame.dispose();
	 			       
	 			      });

		    res = new JLabel("Enter the course name you want to register for  and your Student ID ");
		    res.setFont(new Font("Arial", Font.PLAIN, 15));
		    res.setSize(500, 25);
		    res.setLocation(5, 150);
		    c.add(res);
		    
		    String connectionstring="jdbc:sqlserver://LAPTOP-T23BOQMU:1433;Database=university;encrypt=true;trustServerCertificate=true"	;
		    String user="sa";
		    String pass="1234";
		    try {
		    	try(Connection connection=DriverManager.getConnection(connectionstring,user,pass)){
		    		
		    		Statement st=connection.createStatement();	
		    		String query="use university select count (*) from course where maxstudents!=numberofstudents";
		   		ResultSet results = st.executeQuery(query);
		   		
		    
		   int countrow=0;
		    while(results.next()) {
				 countrow = results.getInt(1);
				 break;
			}
			String [][] row=new String [countrow][3];
			
		    String[] column={"Course ID", "Course Name", "availabe places"};
		    int i=0;
		    query="use university select * from course where maxstudents!=numberofstudents";
		     results = st.executeQuery(query);
		    while (results.next()) {
				
				 int id = results.getInt(1);
				 row[i][0]= String.valueOf(id); 
				 String coursename = results.getString(2);
				 
				 row[i][1]=coursename;
				 int maxst=results.getInt(3);
				 int NoSt=results.getInt(4);
				 int available=maxst-NoSt;
				 row[i][2]= String.valueOf(available);
				 
				 i++;
		    }
		    JTable table=new JTable(row,column);
		    
		    panel= new JPanel();
		    panel.add(new Label("AVAILABLE COURSES"));
		    frame.setLayout(null);
		    panel.setBounds(470, 65, 500, 400);
		    table.setBounds(470, 65,400, 200);
		    panel.add(new JScrollPane(table));
		    frame.add(panel);
		   
		    frame.setVisible(true);
		    connection.close();
		    st.close();
		    //preparedStmt.close();
		    results.close();}




		    }catch(SQLException a) {
		    System.out.println("error");
		    a.printStackTrace();
		    	
		    }	

		    frame.setVisible(true);

		    try {
		     connectionstring="jdbc:sqlserver://LAPTOP-T23BOQMU:1433;Database=university;encrypt=true;trustServerCertificate=true"	;
		     user="sa";
		     pass="1234";
		    	try(Connection connection=DriverManager.getConnection(connectionstring,user,pass)){
		    		
		    		Statement st=connection.createStatement();	
		    		
		    		
		    		String query="select count(*) from course where maxstudents!=numberofstudents"; 
		    		ResultSet results = st.executeQuery(query);
		    		
		    		 query="select * from course where maxstudents!=numberofstudents";
		    		 results = st.executeQuery(query);
		    		System.out.println("Available courses are ");
		    		System.out.println("course ID \t course name\t availabe places");
		    		
		    		while (results.next()) {
		    			int id = results.getInt(1);
		    			 String coursename = results.getString(2);
		    			 int maxst=results.getInt(3);
		    			 int NoSt=results.getInt(4);
		    			 int available=maxst-NoSt;
		    			 
		    			 System.out.println( id + "\t\t" + coursename+ "\t\t" + "\t\t" +available);	}
		    		
		    		connection.close();
		    		st.close();
		    		//preparedStmt.close();
		    		results.close();}




		    		}catch(SQLException a) {
		    		System.out.println("error");
		    		a.printStackTrace();
		    			
		    		}	


	}

	public void withdrawFromCourse() {
		
		frame = new JFrame();
        frame.setTitle("withdraw course");
        frame.setResizable(false);

        //This creates one row and two equally divided columns
        GridLayout gridLayout = new GridLayout(0, 2);
        frame.setLayout(gridLayout);
        gridLayout.layoutContainer(frame);

        leftPanel = new JPanel();
        leftPanel.add(new Label());
        //frame.add(leftPanel);
        leftPanel.setLayout(null);

         rightPanel = new JPanel();
         rightPanel.add(new Label());
       // m.frame.add(m.rightPanel);

        frame.setSize(800, 500);
         frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        
       JLabel title = new JLabel("Withdrawing from course");
	    title.setFont(new Font("Arial", Font.PLAIN, 15));
	    title.setSize(300, 30);
	    title.setLocation(10, 30);
	   leftPanel.add(title);

	   mno = new JLabel("Enter Student ID");
	   mno.setFont(new Font("Arial", Font.PLAIN, 13));
	   mno.setSize(100, 20);
	   mno.setLocation(80, 250);
	    leftPanel.add(mno);
	    backb=new JButton("Back");
			backb.setBounds(275, 320, 70, 20);
				leftPanel.add(backb);
				l = new listener(this);
				backb.addActionListener(z -> {
			         frame.dispose();
					//viewAllRegisteredCourses();
			      });
	    
	    
	    
	    tmno = new JTextField();
	    tmno.setFont(new Font("Arial", Font.PLAIN, 15));
	    tmno.setSize(150, 20);
	    tmno.setLocation(200, 250);
	    leftPanel.add(tmno);

	    continueb = new JButton("continue");
	    continueb.setFont(new Font("Arial", Font.PLAIN, 15));
	    continueb.setSize(100, 20);
	    continueb.setLocation(270, 280);
	     //l = new listener(this);
	    leftPanel.add(continueb);
	   continueb.addActionListener(e->{
				String Id=tmno.getText();
				validation v=new validation ();
				if(v.validateSID(Id))
				{	 int id = Integer.parseInt(Id);
					
					System.out.println("yes");
					continueb.setVisible(false);
				     mno.setVisible(false);
				    tmno.setVisible(false);
				    
				    leftPanel.setLayout(null);
				  
				    
				   name = new JLabel("Enter course Name");
				   name.setFont(new Font("Arial", Font.PLAIN, 13));
				   name.setSize(190, 20);
				   name.setLocation(80, 200);
				   leftPanel.add(name);
				
				   tname = new JTextField();
				   tname.setFont(new Font("Arial", Font.PLAIN, 15));
				   tname.setSize(190, 20);
				   tname.setLocation(200, 200);
				   leftPanel.add(tname);
				    
				   
				    
				   frame.add(leftPanel);
				   frame.setVisible(true);
					contwithdraw();
				
				}
				else {
					
					leftPanel.add(new JLabel("Your ID is not available "));
					frame.add(leftPanel);
					leftPanel.setVisible(true);
					frame.setVisible(true);
					
				}
			});
	    
	     
			frame.add(leftPanel);
			frame.setVisible(true);
		    
		}
	
	void contwithdraw() {
		System.out.println("hello");
		 String connectionstring="jdbc:sqlserver://LAPTOP-T23BOQMU:1433;Database=university;encrypt=true;trustServerCertificate=true"	;
		    String user="sa";
		    String pass="1234";

		    try {
		    	try(Connection connection=DriverManager.getConnection(connectionstring,user,pass)){
		    		
		    		Statement st=connection.createStatement();	
		    		String query="select distinct count (*)  from courses_taken left join course on courses_taken.cid=course.cid ";
		   		ResultSet results = st.executeQuery(query);
		   		String Id=tmno.getText();
		   		int countrow=0;
		    while(results.next()) {
				 countrow = results.getInt(1);
				 break;
			}
			
		   		String [][] row=new String [countrow][2];
		   		String[] column={"Course ID", "Course Name"};
		   	    int i=0;
		   		int id = 0;
		   		int cid=0;

		   	    query="select  * from courses_taken left join course on courses_taken.cid=course.cid ";
		   	    results = st.executeQuery(query);
		   	    validation v=new validation();
		   	   if(v.validateSID(Id)) { 
		   	 while (results.next()) {
		   		 
		   		
		   		 id = Integer.parseInt(Id);
		   			if(results.getInt(1)==id) {
		   				 cid = results.getInt(2);
		   				 row[i][0]=String.valueOf(cid);
		   				String coursename = results.getString(5);
		   				row[i][1]=coursename;
		   				System.out.println(cid+coursename);
		   				i++;
		   		}
		   			
		   			
		   		}
		   	   }
		   	   System.out.println(cid +""+ id);
		   	   if(cid==0) {
		   		   
		   		   
		   	   }
		   	 table=new JTable(row,column);
		     
		  
		   	 rightPanel.add(new Label("THE COURSES YOU ARE TAKING"));
		     frame.setSize(1000,500);
		    // rightPanel.setBounds(470, 65, 500, 400);
		   	 //rightPanel.setLayout(null);
		     frame.setLayout(null);
			    rightPanel.setBounds(470, 0, 500, 400);
			    table.setBounds(470,0,100, 50);
		     //table.setBounds(0, 0,50, 50);
		     rightPanel.add(new JScrollPane(table));
		     frame.add( rightPanel);
		     
		   
		    withdraw = new JButton("Withdraw");
			withdraw.setFont(new Font("Arial", Font.PLAIN, 15));
			withdraw.setSize(100, 20);
			withdraw.setLocation(270, 280);
			     //l = new listener(this);
			 l = new listener(this);
			 withdraw.addActionListener(l);
			 leftPanel.add(withdraw);
			 
			 
			
			 


	}


	}	catch(SQLException e) {
		System.out.println("error");
		e.printStackTrace();
	}	
	}
	
	public void viewAllRegisteredCourses() {
		try {
			try(Connection connection=DriverManager.getConnection(connectionstring,user,pass)){
				
				frame=new JFrame();
				leftPanel =new JPanel();
				JLabel title=new JLabel("View registered Course");
				 title.setFont(new Font("Arial", Font.PLAIN, 15));
				title.setBounds(55, 55, 250, 100);
				leftPanel.add(title);
				frame.setSize(800,499);
				leftPanel.setLayout(null);
				frame.setLocale(null);
				leftPanel.setBounds(50, 50, 50, 50);
				 mno = new JLabel("Enter Student ID");
				   mno.setFont(new Font("Arial", Font.PLAIN, 13));
				   mno.setSize(100, 20);
				   mno.setLocation(80, 220);
				    leftPanel.add(mno);
				    
				    
				    
				    tmno = new JTextField();
				    tmno.setFont(new Font("Arial", Font.PLAIN, 15));
				    tmno.setSize(150, 20);
				    tmno.setLocation(200, 220);
				    leftPanel.add(tmno);
				    
				    view = new JButton("view");
				view.setFont(new Font("Arial", Font.PLAIN, 15));
				view.setSize(100, 20);
				view.setLocation(270, 250);
					     //l = new listener(this);
					 l = new listener(this);
					 view.addActionListener(l);
					 
					 backb=new JButton("Back");
			 			backb.setBounds(275, 280, 90, 20);
			 			leftPanel.add(backb);
			 				//l = new listener(this);
			 				backb.addActionListener(z -> {
			 			         frame.dispose();
			 			       
			 			      });
					 leftPanel.add(view);
					 
					 frame.add(leftPanel);
					 
					 
				    
					 
frame.setVisible(true);

				}
			
		}catch(SQLException e) {
			System.out.println("error");
			e.printStackTrace();
		}		

		
		
	}
	
	
}

