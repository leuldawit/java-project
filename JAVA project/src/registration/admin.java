package registration;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.microsoft.sqlserver.jdbc.SQLServerException;

 abstract class admin implements adminInterface {

	Scanner s =new Scanner(System.in); 
	final String connectionstring="jdbc:sqlserver://LAPTOP-T23BOQMU:1433;Database=university;encrypt=true;trustServerCertificate=true"	;
	final String user="sa";
	final String pass="1234";
	validation valid=new validation();
	
	
	 private JPanel panel;
	 private Container c;
	 private JLabel title;
	 private JLabel name;
	 private JTextField tname;
	 private JLabel lname;
	 private JTextField tlname;
	 private JCheckBox term;
	 private JButton sub;
	 private JButton reset;
	 private JButton remove;
	 private JButton withdraw;
	 private JButton view;
	
	
	 private JPanel leftPanel;
	 private JPanel rightPanel;
	
	 private JTable table;
	
			 		
	 private JLabel res;

	 private JPanel viewcourse;
 private JLabel userlabel;
private JTextField usertext;
private JLabel passlabel;
private JPasswordField passtext;
private JButton loginB;
private JLabel successlabel;
private JPanel studentchoice;
private JButton viewallstb;

private JLabel adminmenulabel;
private JButton registerstb;
private JButton createcourseb;
private JButton deletecourseb;
private JButton editCourseb;
private JButton displayACourseb;
private JButton adminviewallb;
private JButton viewfullb;

private JLabel label;
private JLabel gpa;
private JComboBox age;
private JTextField tgpa;
private JTextField tage;
private JTable jTable;
private JButton backb;
private JButton continueb;
 private JFrame frame,stframe;
private JLabel gender ;
private JRadioButton male;
private JRadioButton female;
private ButtonGroup gengp;
 private JComboBox maxstudents;
 private JLabel errorlabel;
 private JTextArea tout;
 


	public void login() {
		frame=new JFrame();
		panel=new JPanel();  
			 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setSize(450,220);
			frame.setLocationRelativeTo(null); 
			Color c1=new Color(102,255,102);
			panel.setBackground(c1);	
				panel.setLayout(null);
			
				userlabel =new JLabel("User");
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
				
				loginB=new JButton("LOGIN");
				loginB.addActionListener(new ActionListener() {
			         public void actionPerformed(ActionEvent e) {
			        	String user =usertext.getText();
			        	String pass=passtext.getText();	
			        	if(user.equals("admin")&pass.equals("admin")) {
			        		panel.removeAll();
			        		frame.dispose();
			        		adminmenu();
			        	 }
			         }
			      });
			
				loginB.setBounds(170, 100, 110, 25);
				panel.add(loginB);
				
				successlabel =new JLabel();
				successlabel.setFont(new Font("Serif", Font.PLAIN, 15));
				successlabel.setBounds(180,120,100,25);
				panel.add(successlabel);
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

	public void adminmenu() {
		
		frame=new JFrame();
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame=new JFrame();
			frame.setVisible(false);
		
		frame.setSize(280,545);
		frame.setLocationRelativeTo(null); 
		 
		 
		 adminmenulabel=new JLabel("admin menu");
		 adminmenulabel.setFont(new Font("Serif", Font.PLAIN, 24));
		adminmenulabel.setBounds(70,30,160,25);
			panel.add(adminmenulabel,BorderLayout.NORTH);
		 
		registerstb=new JButton("register student");
		registerstb.setBounds(55, 90, 180, 25);
		panel.add(registerstb);
		
		registerstb.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	        	 frame.dispose();
	        	 registerStudent();
	         }
	      });
		 
		createcourseb=new JButton("create course");
		createcourseb.setBounds(50, 135, 180, 25);
		panel.add(createcourseb);
		
		createcourseb.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	        	frame.dispose();
	        	 createCourse();
	         }
	      });
		
		JButton addteacherb=new JButton("Add a teacher");
		addteacherb.setBounds(50, 180, 180, 25);
		panel.add(addteacherb);
		
		addteacherb.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	        	frame.dispose();
	        	addteacher();
	         }
	      });
		
		deletecourseb=new JButton("Delete a course");
		deletecourseb.setBounds(55, 225, 180, 25);
		panel.add(deletecourseb);
		
		deletecourseb.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	        	 frame.dispose();
	        	 deleteCourse();
	         }
	      });
		
		editCourseb=new JButton("Edit a course");
		editCourseb.setBounds(50, 270, 180, 25);
		panel.add(editCourseb);
		
		editCourseb.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	        	 frame.dispose();
	        	 editCourse();
	         }
	      });
		
		displayACourseb=new JButton("display a course");
		displayACourseb.setBounds(50, 315, 180, 25);
		panel.add(displayACourseb);
		
		displayACourseb.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	        	 frame.dispose();
	        	 displayACourse();
	         }
	      });
		frame.add(panel);
		adminviewallb=new JButton("view all courses");
		adminviewallb.setBounds(50, 355, 180, 25);
		panel.add(adminviewallb);
		adminviewallb.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	        	 frame.dispose();
	        	 adminViewAllCourses();
	         }
	      });
		
		viewfullb =new JButton("view full courses");
		viewfullb.setBounds(50, 400, 180, 25);
		panel.add(viewfullb);
		viewfullb.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	        	 frame.dispose();
	        	 viewFullCourses();
	         }
	      });
		
		
		viewallstb =new JButton("view all students");
		viewallstb.setBounds(50, 445, 180, 25);
		panel.add(viewallstb);
		viewallstb.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	        	 frame.dispose();
	        	 viewallst();
	         }
	      });
		
		 backb=new JButton("Back");
	 			backb.setBounds(90, 480, 90, 25);
	 			panel.add(backb);
	 				
	 				backb.addActionListener(z -> {
	 			         frame.dispose();
	 			         login();
	 					//new user();
	 					//
	 			      });
				
		
		 
		frame.setVisible(true);
		
		
	
	}

	
	public void registerStudent() {
	
		
		frame=new JFrame();
		   frame.setTitle("Register a student");
		   frame.setBounds(400, 90, 900, 600);
		   frame.setSize(600, 600);
		   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		   frame.setResizable(false);

		    c = frame.getContentPane();
		    c.setLayout(null);

		    title = new JLabel("Register a student");
		    title.setFont(new Font("Serif", Font.PLAIN, 30));
		    title.setSize(300, 40);
		    title.setLocation(150, 30);
		    c.add(title);

		    name = new JLabel("Enter the student first name");
		    name.setFont(new Font("Serif", Font.PLAIN, 17));
		    name.setSize(190, 60);
		    name.setLocation(50, 120);
		    
		    c.add(name);

		    tname = new JTextField();
		    tname.setFont(new Font("Serif", Font.PLAIN, 17));
		    tname.setSize(190, 20);
		    tname.setLocation(240, 140);
		    c.add(tname);
		   
		   lname = new JLabel("Enter Student last name");
		    lname.setFont(new Font("Serif", Font.PLAIN, 17));
		    lname.setSize(160, 60);
		    lname.setLocation(50, 150);
		    c.add(lname);
		    
		    
		    
		    tlname = new JTextField();
		    tlname.setFont(new Font("Serif", Font.PLAIN, 17));
		    tlname.setSize(150, 20);
		    tlname.setLocation(240, 170);
		    c.add(tlname);
		    
		     gender = new JLabel("Gender");
		    gender.setFont(new Font("Serif", Font.PLAIN, 20));
		    gender.setSize(100, 20);
		    gender.setLocation(100, 400);
		    c.add(gender);
		
		    male = new JRadioButton("Male");
		    male.setFont(new Font("Serif", Font.PLAIN, 20));
		    male.setSelected(true);
		    male.setSize(75, 20);
		    male.setLocation(200, 400);
		    c.add(male);
		
		    
		    female = new JRadioButton("Female");
		    female.setFont(new Font("Serif", Font.PLAIN, 17));
		    female.setSelected(false);
		    female.setSize(80, 20);
		    female.setLocation(275, 400);
		    c.add(female);
		    
		
		    gengp = new ButtonGroup();
		    gengp.add(male);
		    gengp.add(female);
		    
		    passlabel =new JLabel("new Password");
			passlabel.setFont(new Font("Serif", Font.PLAIN, 17));
			passlabel.setSize(140,20);
			passlabel.setLocation(50, 200);
			c.add(passlabel);
		    
		    passtext=new JPasswordField(20);
			passtext.setFont(new Font("Serif", Font.BOLD, 17));
			passtext.setSize(150,20);
			passtext.setLocation(240, 200);
			c.add(passtext);
			
			 gpa =new JLabel("GPA from Highschool");
				gpa.setFont(new Font("Serif", Font.PLAIN, 17));
				gpa.setSize(180,20);
				gpa.setLocation(50, 230);
				c.add(gpa);
				
				tgpa = new JTextField();
				tgpa.setFont(new Font("Serif", Font.PLAIN, 17));
				tgpa.setSize(50, 20);
				tgpa.setLocation(240, 230);
			    c.add(tgpa);
			    
			    String ages[]= {"18", "19", "20",
			            "21", "22", "23", "24" };
			    
			    label=new JLabel("Age");
			    label.setFont(new Font("Serif", Font.PLAIN, 17));
				label.setSize(100,20);
				label.setLocation(220, 260);
				c.add(label);
			    
			    
			    age = new JComboBox(ages);
			    age.setFont(new Font("Arial", Font.PLAIN, 15));
			    age.setSize(50, 20);
			   age.setLocation(260, 260);
		        c.add(age);

			   


			  res = new JLabel();
			    res.setFont(new Font("Arial", Font.PLAIN, 15));
			    res.setSize(250, 25);
			    res.setLocation(100, 400);
			    c.add(res);
			
		    sub = new JButton("Register");
		    sub.setFont(new Font("Arial", Font.PLAIN, 15));
		    sub.setSize(100, 20);
		    sub.setLocation(150, 450);
		    
			sub.addActionListener(new ActionListener() {
		         public void actionPerformed(ActionEvent e) {
		        	 String gender;
		        	 String fname=tname.getText();
		        	 String lname=tlname.getText();
		        	 String password=passtext.getText();
		        	 age.getSelectedItem();
		        	if(tname.getText().isEmpty() || tlname.getText().isEmpty() || passtext.getText().isEmpty()|| tgpa.getText().isEmpty()|| !valid.checkgpa(tgpa.getText()) ) {
		        		
		        		res.setText("Invalid entery! Please re-enter");
		        		
		        	} else
		        	{
		        		if (male.isSelected()) {
		        		  gender="M";}
		        	 else {
		        		 gender="F";
		        	 }
		        		
		        	 
		        	 
		        	 try {
		     			try(Connection connection=DriverManager.getConnection(connectionstring,user,pass)){
		     				System.out.println("done");
		     				Statement st=connection.createStatement();	
		     				 String Query=" use university insert into student (firstname, lastname, gender,password)"+"values(?, ?, ?,?)";
		     				 st=connection.createStatement();	 
		     					PreparedStatement preparedStmt = connection.prepareStatement(Query);
		     				     
		     					  preparedStmt.setString (1, fname);
		     				      preparedStmt.setString (2, lname);
		     				      preparedStmt.setString(3, gender);
		     				      preparedStmt.setString(4, password);
		     				      preparedStmt.execute();
		     				    
		     				      int sid=0;
		     				      ResultSet results=st.executeQuery("SELECT sid FROM student ORDER BY sid DESC ");
		     				      while(results.next()) {
		     				    	   sid=results.getInt(1);
		     				    	   break;
		     				    	 
		     				    	  
		     				      }
		     				     String a=(String) age.getSelectedItem();
		     				     int ag=Integer.parseInt(a) ;
		     				
		     				     double dgpa= Double.parseDouble(tgpa.getText());
		     				 
		     				     Query=" use university insert into registeration (sid, age, GPA,DOR) values(?, ?, ?,CONVERT(DATE, GETDATE()))";
			     					 
			     				 preparedStmt = connection.prepareStatement(Query);
			     				     
			     					  preparedStmt.setInt (1,sid );
			     					 
			     				      preparedStmt.setInt (2, ag);
			     				     
			     				      preparedStmt.setDouble(3, dgpa);
			     				     
			     				      preparedStmt.execute();
			     				
		     				      
		     				      res.setText("Successfully registered! ");
		     				   
		     				
		     					
		     				connection.close();
		     				st.close();
		     				

		     				
		     				
		     			}}catch(SQLException a) {
		     				System.out.println("error");
		     				a.printStackTrace();		     			}}
		         }
		      });
		    c.add(sub);		    
			 

		    reset = new JButton("Reset");
		    reset.setFont(new Font("Arial", Font.PLAIN, 15));
		    reset.setSize(100, 20);
		    reset.setLocation(270, 450);
		    
			reset.addActionListener(new ActionListener() {
		         public void actionPerformed(ActionEvent e) {
		    String def = "";
            tname.setText(def);
            tlname.setText(def);
            passtext.setText(def);
            
		         }
		         });
			c.add(reset);
			
			 backb=new JButton("Back");
	 			backb.setBounds(220, 490, 90, 20);
	 			c.add(backb);

	 				backb.addActionListener(z -> {
	 			         frame.dispose();
	 			         adminmenu();
	 			       
	 			      });




		    frame.setVisible(true);	
	}

	@Override
	public void createCourse() {

		frame=new JFrame();
		   frame.setTitle("Register a student");
		   frame.setBounds(400, 90, 900, 600);
		   frame.setSize(600, 600);
		   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		   frame.setResizable(false);

		    c = frame.getContentPane();
		    c.setLayout(null);

		    title = new JLabel("Create a course");
		    title.setFont(new Font("Serif", Font.PLAIN, 30));
		    title.setSize(300, 40);
		    title.setLocation(150, 30);
		    c.add(title);

		    name = new JLabel("Enter the course name");
		    name.setFont(new Font("Serif", Font.PLAIN, 17));
		    name.setSize(190, 60);
		    name.setLocation(50, 120);
		    
		    c.add(name);

		    tname = new JTextField();
		    tname.setFont(new Font("Serif", Font.PLAIN, 17));
		    tname.setSize(190, 20);
		    tname.setLocation(240, 140);
		    c.add(tname);
		   
		   lname = new JLabel("Enter the teacher's ID");
		    lname.setFont(new Font("Serif", Font.PLAIN, 17));
		    lname.setSize(160, 60);
		    lname.setLocation(50, 150);
		    c.add(lname);
		    
		    
		    
		    tlname = new JTextField();
		    tlname.setFont(new Font("Serif", Font.PLAIN, 17));
		    tlname.setSize(150, 20);
		    tlname.setLocation(240, 170);
		    c.add(tlname);

		    String maxst[]
		            = { "1", "2", "3", "4", "5",
		                "6", "7", "8", "9", "10",
		                "11", "12", "13", "14", "15",
		                "16", "17", "18", "19", "20",
		                "21", "22", "23", "24", "25",
		                "26", "27", "28", "29", "30" };
		    
		    label = new JLabel("Maximum number of students");
	        label.setFont(new Font("Arial", Font.PLAIN, 15));
	        label.setSize(200, 20);
	        label.setLocation(50, 250);
	        c.add(label);
		    
		    maxstudents = new JComboBox(maxst);
		    maxstudents.setFont(new Font("Arial", Font.PLAIN, 15));
		    maxstudents.setSize(50, 20);
		    maxstudents.setLocation(260, 250);
	        c.add(maxstudents);
	        
	        errorlabel = new JLabel();
 	        errorlabel.setFont(new Font("Arial", Font.PLAIN, 15));
 	        errorlabel.setSize(200, 20);
 	        errorlabel.setLocation(150, 110);
 	        c.add(errorlabel);
 	        
 	       label = new JLabel();
		    label.setFont(new Font("Arial", Font.PLAIN, 15));
		    label.setSize(200, 25);
		    label.setLocation(100, 350);
		    c.add(label);
		    
	        
	        sub = new JButton("Add");
		    sub.setFont(new Font("Arial", Font.PLAIN, 15));
		    sub.setSize(100, 20);
		    sub.setLocation(150, 450);
		    
			sub.addActionListener(new ActionListener() {
		         public void actionPerformed(ActionEvent e) {
		        	 
		        	
		        	 if(tname.getText().isEmpty() || valid.validatecourseName(tname.getText()) || !valid.checkteacher(tlname.getText())) {
		        		 
		        		 System.out.println("no");
		        	 errorlabel.setText("Your course name is empty or it already exists!");
		 	       
		 	        frame.setVisible(true);
		        	 }
		        	
		        	 
		        	 else{String coursename=tname.getText();
		        	// String lname=tlname.getText();
		        	 String max=(String)maxstudents.getSelectedItem();
		        	 int maxst = Integer.parseInt(max);
	
		        	 
		        	 int tid=Integer.parseInt(tlname.getText()); 
		        	 try {
		     			try(Connection connection=DriverManager.getConnection(connectionstring,user,pass)){
		     				System.out.println("done");
		     				Statement st=connection.createStatement();	
		     				 String Query=" use university insert into course (coursename, maxstudents,numberofstudents,tid)"+"values(?, ?, ?,?)";
		     				 st=connection.createStatement();	 
		     					PreparedStatement preparedStmt = connection.prepareStatement(Query);
		     				     
		     					  preparedStmt.setString (1, coursename);
		     				      preparedStmt.setInt (2, maxst);
		     				      preparedStmt.setInt(3, 0);
		     				     preparedStmt.setInt(4, tid);
		     				      preparedStmt.execute();
		     				    
		     				      label.setText("Successfully registered! ");
		     				   
		     				  
		     					
		     				connection.close();
		     				st.close();
		     				

		     				
		     				
		     			}}catch(SQLException a) {
		     				System.out.println("error");
		     			}
		        	 }
		        	 
		         }
		      });
		    c.add(sub);		    
			 

		    reset = new JButton("Reset");
		    reset.setFont(new Font("Arial", Font.PLAIN, 15));
		    reset.setSize(100, 20);
		    reset.setLocation(270, 450);
		    
			reset.addActionListener(new ActionListener() {
		         public void actionPerformed(ActionEvent e) {
		    String def = "";
            tname.setText(def);
            tlname.setText(def);
           
            
		         }
		         });
			c.add(reset);
			
			 backb=new JButton("Back");
	 			backb.setBounds(220, 490, 90, 20);
	 			c.add(backb);

	 				backb.addActionListener(z -> {
	 			         frame.dispose();
	 			         adminmenu();
	 			       
	 			      });


	        
	        frame.setVisible(true);
	
	}
	
 public void addteacher() {
	 
	 frame=new JFrame();
	   frame.setTitle("Register a teacher");
	   frame.setBounds(400, 90, 900, 600);
	   frame.setSize(600, 600);
	   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   frame.setResizable(false);

	    c = frame.getContentPane();
	    c.setLayout(null);

	    title = new JLabel("Register a teacher");
	    title.setFont(new Font("Serif", Font.PLAIN, 30));
	    title.setSize(300, 40);
	    title.setLocation(150, 30);
	    c.add(title);

	    name = new JLabel("Enter the Teacher's first name");
	    name.setFont(new Font("Serif", Font.PLAIN, 17));
	    name.setSize(250, 60);
	    name.setLocation(50, 130);
	    
	    c.add(name);

	    tname = new JTextField();
	    tname.setFont(new Font("Serif", Font.PLAIN, 17));
	    tname.setSize(190, 20);
	    tname.setLocation(260, 150);
	    c.add(tname);
	   
	   lname = new JLabel("Enter Teacher's last name");
	    lname.setFont(new Font("Serif", Font.PLAIN, 17));
	    lname.setSize(250, 60);
	    lname.setLocation(60, 170);
	    c.add(lname);
	    
	    
	    
	    tlname = new JTextField();
	    tlname.setFont(new Font("Serif", Font.PLAIN, 17));
	    tlname.setSize(150, 20);
	    tlname.setLocation(260, 190);
	    c.add(tlname);
	    
	     gender = new JLabel("Gender");
	    gender.setFont(new Font("Serif", Font.PLAIN, 20));
	    gender.setSize(100, 20);
	    gender.setLocation(100, 400);
	    c.add(gender);
	
	    male = new JRadioButton("Male");
	    male.setFont(new Font("Serif", Font.PLAIN, 20));
	    male.setSelected(true);
	    male.setSize(75, 20);
	    male.setLocation(200, 400);
	    c.add(male);
	
	    
	    female = new JRadioButton("Female");
	    female.setFont(new Font("Serif", Font.PLAIN, 17));
	    female.setSelected(false);
	    female.setSize(80, 20);
	    female.setLocation(275, 400);
	    c.add(female);
	    
	
	    gengp = new ButtonGroup();
	    gengp.add(male);
	    gengp.add(female);
	    
	    label=new JLabel("Age");
	    label.setFont(new Font("Serif", Font.PLAIN, 17));
		label.setSize(100,22);
		label.setLocation(200, 240);
		c.add(label);
	    
		JTextField age=new JTextField();
		age.setFont(new Font("Serif", Font.PLAIN, 17));
	    age.setSize(150, 20);
	    age.setLocation(260, 240);
	    c.add(age);
	    
	    sub = new JButton("Add");
	    sub.setFont(new Font("Arial", Font.PLAIN, 15));
	    sub.setSize(100, 20);
	    sub.setLocation(150, 450);
	    
		sub.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	        	 
	        	 
	        	 try {
	     			try(Connection connection=DriverManager.getConnection(connectionstring,user,pass)){
	     				System.out.println("done");
	     				Statement st=connection.createStatement();
	     				String genders;
						if (male.isSelected()) {  genders="M";}
						else { genders="F";}
						
	     				 String Query=" use university insert into teacher (teacherfname, teacherlname,gender)"+"values(?, ?, ?)";
	     				 st=connection.createStatement();	 
	     					PreparedStatement preparedStmt = connection.prepareStatement(Query);
	     				     
	     					  preparedStmt.setString (1, tname.getText());
	     				      preparedStmt.setString (2, tlname.getText());
	     				      preparedStmt.setString 	(3, genders);
	     				      preparedStmt.execute();
	     				    
	     				      label.setText("Successfully registered! ");
	     				   
	     				  
	     					
	     				connection.close();
	     				st.close();
	     				

	     				
	     				
	     			}}catch(SQLException a) {
	     				System.out.println("error");
	     			}
	        	 }
	        	 
	         
	      });
	    c.add(sub);		    
		 

	    reset = new JButton("Reset");
	    reset.setFont(new Font("Arial", Font.PLAIN, 15));
	    reset.setSize(100, 20);
	    reset.setLocation(270, 450);
	    
		reset.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	    String def = "";
        tname.setText(def);
        tlname.setText(def);
        age.setText(def);
        
	         }
	         });
		c.add(reset);
		
		 backb=new JButton("Back");
 			backb.setBounds(220, 490, 90, 20);
 			c.add(backb);

 				backb.addActionListener(z -> {
 			         frame.dispose();
 			         adminmenu();
 			       
 			      });


        
        frame.setVisible(true);


	    
	    
		
	 
 }

	@Override
	public void deleteCourse() {
		

		frame=new JFrame();
		   frame.setTitle("Delete a course");
		   frame.setBounds(400, 90, 900, 600);
		   frame.setSize(600, 400);
		   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		   frame.setResizable(false);

		    c = frame.getContentPane();
		    c.setLayout(null);

		    title = new JLabel("Delete a course");
		    title.setFont(new Font("Serif", Font.PLAIN, 30));
		    title.setSize(300, 40);
		    title.setLocation(150, 30);
		    c.add(title);

		    name = new JLabel("Enter the course name");
		    name.setFont(new Font("Serif", Font.PLAIN, 17));
		    name.setSize(190, 60);
		    name.setLocation(50, 120);
		    
		    c.add(name);

		    tname = new JTextField();
		    tname.setFont(new Font("Serif", Font.PLAIN, 17));
		    tname.setSize(190, 20);
		    tname.setLocation(240, 140);
		    c.add(tname);
		    
		    label = new JLabel();
		    label.setFont(new Font("Arial", Font.PLAIN, 15));
		    label.setSize(200, 25);
		    label.setLocation(100, 350);
		    c.add(label);
		    
		    errorlabel = new JLabel();
 	        errorlabel.setFont(new Font("Arial", Font.PLAIN, 15));
 	        errorlabel.setSize(200, 20);
 	        errorlabel.setLocation(150, 110);
 	        c.add(errorlabel);
	   
		    sub = new JButton("remove");
		    sub.setFont(new Font("Arial", Font.PLAIN, 15));
		    sub.setSize(100, 20);
		    sub.setLocation(150, 300);
		    
			sub.addActionListener(new ActionListener() {
		         public void actionPerformed(ActionEvent e) {
		        	 
		        	
		        	 if(tname.getText().isEmpty() || !valid.validatecourseName(tname.getText())) {
		        		 
		        		 System.out.println("no");
		        	 errorlabel.setText("Your course name is empty or it doesnt exist!");
		 	       
		 	        
		 	       
		 	        frame.setVisible(true);
		        	 }
		        	
		        	 
		        	 else{
		        		 String coursename=tname.getText();
		        	 
		        	 
		        	 try {
		     			try(Connection connection=DriverManager.getConnection(connectionstring,user,pass)){
		     				System.out.println("done");
		     				Statement st=connection.createStatement();	
		     				
		     				String Query="select cid,coursename from course "; 
		     				ResultSet results = st.executeQuery(Query);
		    				System.out.println("course ID \t course name");
		    				int cid=0; 
		    				while (results.next()) {
		    					 
		    					 if( coursename .equals( results.getString(2))) {
		    						 cid = results.getInt(1);
		    						 break;
		    					 }
		    					
		    				}
		    				 Query="delete from courses_taken where cid=?";
								PreparedStatement preparedStmt = connection.prepareStatement(Query);
							      preparedStmt.setInt(1, cid);
							      preparedStmt.execute();
							
		     				 Query=" use university delete from course where coursename=?";
		     				 st=connection.createStatement();	 
		     					 preparedStmt = connection.prepareStatement(Query);
		     				     
		     					  preparedStmt.setString (1, coursename);
		     				     
		     				      preparedStmt.execute();
		     				    
		     				      label.setText("Successfully removed ! ");
		     				    
		     				    
		     					
		     				connection.close();
		     				st.close();
		     				

		     				
		     				
		     			}}catch(SQLException a) {
		     				System.out.println("error");
		     			}
		        	 }
		        	 
		         }
		      });
		    c.add(sub);		    
			 

		    reset = new JButton("Reset");
		    reset.setFont(new Font("Arial", Font.PLAIN, 15));
		    reset.setSize(100, 20);
		    reset.setLocation(270, 300);
		    
			reset.addActionListener(new ActionListener() {
		         public void actionPerformed(ActionEvent e) {
		    String def = "";
            tname.setText(def);
           
            
		         }
		         });
			c.add(reset);
			
			 backb=new JButton("Back");
	 			backb.setBounds(220, 340, 90, 20);
	 			c.add(backb);

	 				backb.addActionListener(z -> {
	 			         frame.dispose();
	 			         adminmenu();
	 			       
	 			      });


	        
	        frame.setVisible(true);
	


		
	}

	@Override
	public void editCourse() {
//		
				
		frame=new JFrame();
		   frame.setTitle("Edit a course");
		   frame.setBounds(400, 90, 900, 600);
		   frame.setSize(600, 600);
		   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		   frame.setResizable(false);

		    c = frame.getContentPane();
		    c.setLayout(null);

		    title = new JLabel("Edit a course");
		    title.setFont(new Font("Serif", Font.PLAIN, 30));
		    title.setSize(300, 40);
		    title.setLocation(150, 30);
		    c.add(title);

		    JLabel oname = new JLabel("Enter the course name which you want to change ");
		    oname.setFont(new Font("Serif", Font.PLAIN, 17));
		    oname.setSize(340, 60);
		    oname.setLocation(50, 100);
		    
		    c.add(oname);

		    JTextField toname = new JTextField();
		    toname.setFont(new Font("Serif", Font.PLAIN, 17));
		    toname.setSize(190, 20);
		    toname.setLocation(380, 120);
		    c.add(toname);

		    
		    name = new JLabel("Enter the new course name");
		    name.setFont(new Font("Serif", Font.PLAIN, 17));
		    name.setSize(190, 60);
		    name.setLocation(50, 140);
		    
		    c.add(name);

		    tname = new JTextField();
		    tname.setFont(new Font("Serif", Font.PLAIN, 17));
		    tname.setSize(190, 20);
		    tname.setLocation(240, 160);
		    c.add(tname);

		    String maxst[]
		            = { "1", "2", "3", "4", "5",
		                "6", "7", "8", "9", "10",
		                "11", "12", "13", "14", "15",
		                "16", "17", "18", "19", "20",
		                "21", "22", "23", "24", "25",
		                "26", "27", "28", "29", "30" };
		    
		    label = new JLabel("New maximum number of students");
	        label.setFont(new Font("Arial", Font.PLAIN, 15));
	        label.setSize(200, 20);
	        label.setLocation(50, 250);
	        c.add(label);
		    
		    maxstudents = new JComboBox(maxst);
		    maxstudents.setFont(new Font("Arial", Font.PLAIN, 15));
		    maxstudents.setSize(50, 20);
		    maxstudents.setLocation(260, 250);
	        c.add(maxstudents);
	        
	        JLabel label2 = new JLabel("Number of students in the class");
	        label2.setFont(new Font("Arial", Font.PLAIN, 15));
	        label2.setSize(200, 20);
	        label2.setLocation(50, 300);
	        c.add(label2);
		    
		    JComboBox nostudents = new JComboBox(maxst);
		    nostudents.setFont(new Font("Arial", Font.PLAIN, 15));
		    nostudents.setSize(50, 20);
		    nostudents.setLocation(260, 300);
	        c.add(nostudents);
	        
	        sub = new JButton("Renew");
		    sub.setFont(new Font("Arial", Font.PLAIN, 15));
		    sub.setSize(100, 20);
		    sub.setLocation(150, 450);
		    
		    label = new JLabel();
			    label.setFont(new Font("Arial", Font.PLAIN, 15));
			    label.setSize(200, 25);
			    label.setLocation(100, 350);
			    c.add(label);
			    
			    errorlabel = new JLabel();
	 	        errorlabel.setFont(new Font("Arial", Font.PLAIN, 15));
	 	        errorlabel.setSize(200, 20);
	 	        errorlabel.setLocation(150, 110);
	 	        c.add(errorlabel);
		    
		    sub.addActionListener(new ActionListener() {
		         public void actionPerformed(ActionEvent e) {
		        	 
		        	
		        	 if(tname.getText().isEmpty() || !valid.validatecourseName(toname.getText())) {
		        		 
		        		 System.out.println("no");
		        	 errorlabel.setText("Your course name is empty or it already exists!");
		 	        
		 	       
		        	 }
		        	
		        	 
		        	 else{
		        		 String coursename=tname.getText();
		        		 String oldcoursename=toname.getText();
		        	// String lname=tlname.getText();
		        	 String max=(String)maxstudents.getSelectedItem();
		        	 String no=(String)nostudents.getSelectedItem();
		        	 int maxst = Integer.parseInt(max);
		        	 int nost = Integer.parseInt(no);
		        	 
		        	 
		        	 try {
		     			try(Connection connection=DriverManager.getConnection(connectionstring,user,pass)){
		     				System.out.println("done");
		     				Statement st=connection.createStatement();	
		     				 String Query=" use university UPDATE course SET coursename = ?, maxstudents = ?, numberofstudents = ? WHERE coursename=?";
		     				 st=connection.createStatement();	 
		     					PreparedStatement preparedStmt = connection.prepareStatement(Query);
		     				     
		     					  preparedStmt.setString (1, coursename);
		     				      preparedStmt.setInt (2, maxst);
		     				      preparedStmt.setInt(3, nost);
		     				     preparedStmt.setString (4, oldcoursename);
		     				      preparedStmt.execute();
		     				    
		     				     label.setText("successfuly updated!");
		     				    
		     					
		     				connection.close();
		     				st.close();
		     				

		     				
		     				
		     			}}catch(SQLException a) {
		     				System.out.println("error");
		     			}
		        	 }
		        	 
		         }
		      });
		    c.add(sub);		    
			 

		    reset = new JButton("Reset");
		    reset.setFont(new Font("Arial", Font.PLAIN, 15));
		    reset.setSize(100, 20);
		    reset.setLocation(270, 450);
		    
			reset.addActionListener(new ActionListener() {
		         public void actionPerformed(ActionEvent e) {
		    String def = "";
           tname.setText(def);
          
           
		         }
		         });
			c.add(reset);
			
			 backb=new JButton("Back");
	 			backb.setBounds(220, 490, 90, 20);
	 			c.add(backb);

	 				backb.addActionListener(z -> {
	 			         frame.dispose();
	 			         adminmenu();
	 			       
	 			      });


	        
	        frame.setVisible(true);
	

	
		
	}

	@Override
	public void displayACourse() {
		 

		frame=new JFrame();
		   frame.setTitle("View a course");
		   frame.setBounds(400, 90, 900, 600);
		   frame.setSize(800, 400);
		   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		   frame.setResizable(false);

		    c = frame.getContentPane();
		    c.setLayout(null);

		    title = new JLabel("View a course");
		    title.setFont(new Font("Serif", Font.PLAIN, 30));
		    title.setSize(300, 40);
		    title.setLocation(150, 30);
		    c.add(title);

		    name = new JLabel("Enter the course name");
		    name.setFont(new Font("Serif", Font.PLAIN, 17));
		    name.setSize(190, 60);
		    name.setLocation(50, 120);
		    
		    c.add(name);

		    tname = new JTextField();
		    tname.setFont(new Font("Serif", Font.PLAIN, 17));
		    tname.setSize(190, 20);
		    tname.setLocation(240, 140);
		    c.add(tname);
		    
		    tout = new JTextArea();
	        tout.setFont(new Font("Arial", Font.PLAIN, 15));
	        tout.setSize(300, 200);
	        tout.setLocation(500, 100);
	        tout.setLineWrap(true);
	        tout.setEditable(false);
	        c.add(tout);
	        
	        label = new JLabel();
			    label.setFont(new Font("Arial", Font.PLAIN, 15));
			    label.setSize(200, 25);
			    label.setLocation(100, 350);
			    c.add(label);
			   
			    errorlabel = new JLabel();
			    errorlabel.setFont(new Font("Arial", Font.PLAIN, 15));
	 	        errorlabel.setSize(200, 20);
	 	        errorlabel.setLocation(150, 110);
	 	        c.add(errorlabel);
			    
	   
		    sub = new JButton("view");
		    sub.setFont(new Font("Arial", Font.PLAIN, 15));
		    sub.setSize(100, 20);
		    sub.setLocation(150, 250);
		    
		    sub.addActionListener(new ActionListener() {
		         public void actionPerformed(ActionEvent e) {
		        	 
		        	
		        	 if(tname.getText().isEmpty() || !valid.validatecourseName(tname.getText())) {
		        		 
		        		 System.out.println("no");
		        	 errorlabel.setText("Your course name is empty or it already exists!");
		 	        
		        	 }
		        	
		        	 
		        	 else{
		        		 
        	 
		        	 try {
		     			try(Connection connection=DriverManager.getConnection(connectionstring,user,pass)){
		     				System.out.println("done");
		     				Statement st=connection.createStatement();	
		     				st=connection.createStatement();	 
		     				ResultSet results = st.executeQuery("select * from course");
		    				
		     				int maxst=0;
		     				int nost=0;
		     				int cid=0;
		     				while (results.next()) {
		    					if(tname.getText().equals(results.getString(2)))
		    					{	
		    						cid = results.getInt(1);
		    					 String coursename = results.getString(2);
		    					  maxst=results.getInt(3);
		    					 nost=results.getInt(4);
		    					 
		    					  break;
		    					 }}
		    				String data
		                    = " Course ID : "
		                            + cid + "\n"+"Course Name : "
		                            + tname.getText() + "\n"
		                            + "Max number of students : "
		                            + maxst + "\n"+ "\n"
				                            + " number of students : "
				                            + nost + "\n";
		    				tout.setText(data); 
		     				    
		     				    
		     				    label.setText("successfuly Displayed ");
		     					
		     				connection.close();
		     				st.close();
		     				

		     				
		     				
		     			}}catch(SQLException a) {
		     				System.out.println("error");
		     			}
		        	 }
		        	 
		         }
		      });
		    c.add(sub);		    
			 

		    reset = new JButton("Reset");
		    reset.setFont(new Font("Arial", Font.PLAIN, 15));
		    reset.setSize(100, 20);
		    reset.setLocation(270, 250);
		    
			reset.addActionListener(new ActionListener() {
		         public void actionPerformed(ActionEvent e) {
		    String def = "";
          tname.setText(def);
         
          
		         }
		         });
			c.add(reset);
			
			 backb=new JButton("Back");
	 			backb.setBounds(220, 280, 90, 20);
	 			c.add(backb);

	 				backb.addActionListener(z -> {
	 			         frame.dispose();
	 			         adminmenu();
	 			       
	 			      });


	        
	        frame.setVisible(true);
	

	
		
	}

	@Override
	public void adminViewAllCourses() {
		
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
				String [][] row=new String [countrow][4];
				String[] column={"Course ID", "Course Name", "maximum number of students","number of students"};
				 results = st.executeQuery("select * from course");
				
				System.out.println("course ID \t course name\t maximum number of students \t number of students");
				int i=0;
				while (results.next()) {
					 int id = results.getInt(1);
					 row[i][0]= String.valueOf(id); 
					 String coursename = results.getString(2);
					 row[i][1]=coursename;
					 int maxst=results.getInt(3);
					 row[i][2]=String.valueOf(maxst);
					 int nost=results.getInt(4);
					 row[i][3]=String.valueOf(nost);
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
			      frame.setSize(550, 400);
			     
			      backb=new JButton("Back");
	 			backb.setBounds(50, 50, 50, 50);
	 				panel.add(backb);
	 				
	 				backb.addActionListener(e -> {
	 			         frame.dispose();
	 			         adminmenu();
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

	@Override
	public void viewFullCourses() {

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
				String [][] row=new String [countrow][4];
				String[] column={"Course ID", "Course Name", "maximum number of students","number of students"};
				 
				results = st.executeQuery("select * from course where maxstudents=numberofstudents");
				
				System.out.println("course ID \t course name\t maximum number of students \t number of students");
				int i=0;
				while (results.next()) {
					 int id = results.getInt(1);
					 row[i][0]= String.valueOf(id); 
					 String coursename = results.getString(2);
					 row[i][1]=coursename;
					 int maxst=results.getInt(3);
					 row[i][2]=String.valueOf(maxst);
					 int nost=results.getInt(4);
					 row[i][3]=String.valueOf(nost);
					 i++;
					 
					 
					 System.out.println( id + "\t\t" + coursename+ "\t\t" +maxst+ "\t\t" +nost);	
					 }
				
				
				 frame = new JFrame();
			      JPanel panel = new JPanel();

			      label = new JLabel("ALL THE FULL COURSES", SwingConstants.CENTER);
			      panel.add(label);
			      jTable = new JTable(row,column);
			      panel.add(new JScrollPane(jTable));
			      panel.setSize(600, 400);
			      frame.add(panel);
			      frame.setSize(600, 400);
			     
			      backb=new JButton("Back");
	 			backb.setBounds(50, 100, 50, 50);
	 				panel.add(backb);
	 				
	 				backb.addActionListener(e -> {
	 			         frame.dispose();
	 			         adminmenu();
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


	public void viewallst() {
		
		try {
			try(Connection connection=DriverManager.getConnection(connectionstring,user,pass)){
			
				
			 Statement st=connection.createStatement();
				int countrow=0;
				
				String query="select count(*) from student"; 
				ResultSet results = st.executeQuery(query);
				
				while(results.next()) {
					 countrow = results.getInt(1);
					 break;
				}
				String [][] row=new String [countrow][6];
				String[] column={"Student ID", "First Name", "Last Name","Gender","Registeration Date"};
				 
				results = st.executeQuery("select *from student left join registeration ON student.sid=registeration.sid");
				
				System.out.println("course ID \t course name\t maximum number of students \t number of students");
				int i=0;
				while (results.next()) {
					 int id = results.getInt(1);
					 row[i][0]= String.valueOf(id); 
					 String stfname = results.getString(2);
					 row[i][1]=stfname;
					 String stlname = results.getString(3);
					 row[i][2]=stlname;
					 String gender=results.getString(4);
					 row[i][3]=String.valueOf(gender);
					 int age=results.getInt(7);
					 row[i][4]=String.valueOf(age);
					// DateFormat dob= new SimpleDateFormat().results.getDate(9);
					 row[i][5]=String.valueOf(results.getDate(9));
					 i++;
					 
					 
					 //System.out.println( id + "\t\t" + coursename+ "\t\t" +maxst+ "\t\t" +nost);	
					 }
				
				
				 frame = new JFrame();
			      JPanel panel = new JPanel();

			      label = new JLabel("ALL THE Students", SwingConstants.CENTER);
			      panel.add(label);
			      jTable = new JTable(row,column);
			      panel.add(new JScrollPane(jTable));
			      panel.setSize(600, 400);
			      frame.add(panel);
			      frame.setSize(600, 400);
			     
			      backb=new JButton("Back");
	 			backb.setBounds(50, 100, 50, 50);
	 				panel.add(backb);
	 				
	 				backb.addActionListener(e -> {
	 			         frame.dispose();
	 			         adminmenu();
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

	




	
	
	

}
